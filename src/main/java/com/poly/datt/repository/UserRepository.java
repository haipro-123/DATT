package com.poly.datt.repository;

import com.poly.datt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
    User findByEmail(String email);
    @Query(value = """
                SELECT u.*
                FROM users u
                WHERE
                    u.email =:email
                    and u.password =:password
            """, nativeQuery = true)
    User loginUser(@Param("email") String email,
                   @Param("password") String password);
}
