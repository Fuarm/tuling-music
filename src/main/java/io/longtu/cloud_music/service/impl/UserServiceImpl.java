package io.longtu.cloud_music.service.impl;

import io.longtu.cloud_music.model.dto.UserCreateDto;
import io.longtu.cloud_music.model.dto.UserDto;
import io.longtu.cloud_music.model.dto.UserUpdateDto;
import io.longtu.cloud_music.model.entity.User;
import io.longtu.cloud_music.exception.BizException;
import io.longtu.cloud_music.common.ResponseType;
import io.longtu.cloud_music.mapper.IUserMapper;
import io.longtu.cloud_music.repository.IUserRepository;
import io.longtu.cloud_music.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    IUserRepository repository;

    IUserMapper userMapper;

    PasswordEncoder passwordEncoder;

    @Override
    public UserDto create(UserCreateDto userCreateDto) {
        getUserByUsername(userCreateDto.getUsername());
        User user = userMapper.createEntity(userCreateDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toDto(repository.save(user));
    }

    @Override
    public UserDto get(String id) {
        return userMapper.toDto(getUserById(id));
    }

    @Override
    public UserDto update(String id, UserUpdateDto userUpdateDto) {
        return userMapper.toDto(repository.save(
                userMapper.updateEntity(getUserById(id), userUpdateDto)
        ));
    }

    @Override
    public void delete(String id) {
        repository.delete(getUserById(id));
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserByUsername(username);
    }

    private User getUserById(String id) {
        Optional<User> user = repository.findById(id);
        // TODO: 重构
        if (!user.isPresent()) {
            throw new BizException(ResponseType.USER_NOT_EXIST);
        }
        return user.get();
    }

    private User getUserByUsername(String username) {
        Optional<User> user = repository.findByUsername(username);
        // TODO: 重构
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
    public void setUserMapper(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
