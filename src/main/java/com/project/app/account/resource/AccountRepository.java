package com.project.app.account.resource;

import com.project.app.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUserId(String userId);

    List<Account> findAllByGenderAndIsDelete(boolean gender, boolean isDelete);

    boolean existsByUserId(String userId);

}
