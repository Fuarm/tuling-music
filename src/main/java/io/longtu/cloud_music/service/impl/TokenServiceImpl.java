package io.longtu.cloud_music.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.longtu.cloud_music.common.ResponseType;
import io.longtu.cloud_music.config.SecurityConfig;
import io.longtu.cloud_music.exception.BizException;
import io.longtu.cloud_music.model.dto.TokenCreateDto;
import io.longtu.cloud_music.model.entity.User;
import io.longtu.cloud_music.repository.IUserRepository;
import io.longtu.cloud_music.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TokenServiceImpl implements ITokenService {

    IUserRepository repository;

    PasswordEncoder passwordEncoder;

    @Override
    public String create(TokenCreateDto tokenCreateDto) {
        User user = getUserByUsername(tokenCreateDto.getUsername());

        if (!passwordEncoder.matches(tokenCreateDto.getPassword(), user.getPassword())) {
            throw new BizException(ResponseType.USER_PASSWORD_NOT_MATCH);
        }

        if (!user.isEnabled()) {
            throw new BizException(ResponseType.USER_NOT_ENABLED);
        }

        if (!user.isAccountNonLocked()) {
            throw new BizException(ResponseType.USER_LOCKED);
        }

        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConfig.SECRET_KEY.getBytes()));
    }

    private User getUserByUsername(String username) {
        Optional<User> user = repository.findByUsername(username);
        if (!user.isPresent()) {
            throw new BizException(ResponseType.USER_NOT_EXIST);
        }
        return user.get();
    }

    @Autowired
    public void setRepository(IUserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
