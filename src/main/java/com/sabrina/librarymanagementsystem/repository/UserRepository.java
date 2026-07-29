package com.sabrina.librarymanagementsystem.repository;

import com.sabrina.librarymanagementsystem.entity.Role;
import com.sabrina.librarymanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<User> findByRole(Role role);
}
