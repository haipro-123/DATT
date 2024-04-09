package com.poly.datt.repository;

import com.poly.datt.entity.Profile;
import com.poly.datt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    Profile findProfileByUser(User user);
    Profile findProfileById(int id);
}
