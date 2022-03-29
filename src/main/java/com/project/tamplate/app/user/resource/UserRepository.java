package com.project.tamplate.app.user.resource;

import com.project.tamplate.app.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findTop1ById(Long id);

}
