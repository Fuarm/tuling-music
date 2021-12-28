package io.longtu.cloud_music.service;

import io.longtu.cloud_music.dto.UserDto;
import io.longtu.cloud_music.mapper.IUserMapper;
import io.longtu.cloud_music.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    IUserRepository repository;

    IUserMapper userMapper;

    @Override
    public List<UserDto> list() {
        return repository.findAll()
                .stream().map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Autowired
    public void setRepository(IUserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setUserMapper(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
