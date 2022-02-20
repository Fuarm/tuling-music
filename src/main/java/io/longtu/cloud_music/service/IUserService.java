package io.longtu.cloud_music.service;

import io.longtu.cloud_music.model.dto.UserCreateDto;
import io.longtu.cloud_music.model.dto.UserDto;
import io.longtu.cloud_music.model.dto.UserUpdateDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    UserDto create(UserCreateDto userCreateDto);

    UserDto get(String id);

    UserDto update(String id, UserUpdateDto userUpdateDto);

    void delete(String id);

    UserDto getCurrentUser();
}
