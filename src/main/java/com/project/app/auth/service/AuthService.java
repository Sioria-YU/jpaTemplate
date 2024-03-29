package com.project.app.auth.service;

import com.project.app.account.dto.AccountDto;
import com.project.app.account.entity.Account;
import com.project.app.account.resource.AccountMapper;
import com.project.app.account.resource.AccountRepository;
import com.project.secure.controller.JwtAuthenticationProvider;
import com.project.secure.dto.TokenDto;
import com.project.secure.dto.TokenRequestDto;
import com.project.secure.entity.RefreshToken;
import com.project.secure.resource.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtAuthenticationProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public AccountDto.Response signup(AccountDto.Request accountDto) {
        if (accountRepository.existsByUserId(accountDto.getUserId())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }

        String password = passwordEncoder.encode(accountDto.getPassword());
        accountDto.setPassword(password);

        Account account = AccountMapper.mapper.toEntity(accountDto);
        accountRepository.save(account);
        return account.toResponse();
    }

    @Transactional
    public TokenDto login(AccountDto.Request accountDto) throws Exception{
        // 1. Login ID/PW 를 기반으로 AuthenticationToken 생성
//        Account account = accountRepository.findByUserId(accountDto.getUserId()).orElseThrow(NullPointerException::new);
//        if(passwordEncoder.matches(accountDto.getPassword(), account.getPassword())){
//            accountDto.setPassword(account.getPassword());
//            System.out.println("accountDto.getPassword : account.getPassword :::::::::::::>>> " + accountDto.getPassword() + " : " + account.getPassword());
//        }

//        accountDto.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        UsernamePasswordAuthenticationToken authenticationToken = accountDto.toAuthentication();

        // 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
        //    authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메서드가 실행됨
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

        // 4. RefreshToken 저장
        RefreshToken refreshToken = RefreshToken.builder()
                .rtKey(authentication.getName())
                .rtValue(tokenDto.getRefreshToken())
                .build();

        refreshTokenRepository.save(refreshToken);

        // 5. 토큰 발급
        return tokenDto;
    }

    @Transactional
    public TokenDto reissue(TokenRequestDto tokenRequestDto) {
        // 1. Refresh Token 검증
        if (!tokenProvider.validateToken(tokenRequestDto.getRefreshToken())) {
            throw new RuntimeException("Refresh Token 이 유효하지 않습니다.");
        }

        // 2. Access Token 에서 Member ID 가져오기
        Authentication authentication = tokenProvider.getAuthentication(tokenRequestDto.getAccessToken());

        // 3. 저장소에서 Member ID 를 기반으로 Refresh Token 값 가져옴
        RefreshToken refreshToken = refreshTokenRepository.findByRtKey(authentication.getName())
                .orElseThrow(() -> new RuntimeException("로그아웃 된 사용자입니다."));

        // 4. Refresh Token 일치하는지 검사
        if (!refreshToken.getRtValue().equals(tokenRequestDto.getRefreshToken())) {
            throw new RuntimeException("토큰의 유저 정보가 일치하지 않습니다.");
        }

        // 5. 새로운 토큰 생성
        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

        // 6. 저장소 정보 업데이트
        RefreshToken newRefreshToken = refreshToken.updateValue(tokenDto.getRefreshToken());
        refreshTokenRepository.save(newRefreshToken);

        // 토큰 발급
        return tokenDto;
    }
}
