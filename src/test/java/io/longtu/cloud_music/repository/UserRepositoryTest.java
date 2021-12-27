package io.longtu.cloud_music.repository;

import io.longtu.cloud_music.entity.User;
import io.longtu.cloud_music.enums.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    IUserRepository repository;

    @Test
    void findUserByUsername() {
        User user = new User();
        user.setUsername("TuLing");
        user.setNickname("图灵");
        user.setEnabled(true);
        user.setLocked(false);
        user.setPassword("9095115");
        user.setGender(Gender.MALE);
        user.setLastLoginIp("127.0.0.1");
        user.setLastLoginTime(new Date());

        repository.save(user);

        User result = repository.findUserByUsername("TuLing");

        System.out.println(result.toString());
    }
}