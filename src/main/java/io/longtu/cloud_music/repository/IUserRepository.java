package io.longtu.cloud_music.repository;

import io.longtu.cloud_music.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, String> {

    User findUserByUsername(String username);
}
