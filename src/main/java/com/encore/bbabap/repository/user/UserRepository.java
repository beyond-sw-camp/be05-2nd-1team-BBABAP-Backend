package com.encore.bbabap.repository.user;

import com.encore.bbabap.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Optional<User> findByUserId(String userId);
    User findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findUsersByDeletedYnFalse();
}
