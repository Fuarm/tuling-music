package io.longtu.cloud_music.service;

import io.longtu.cloud_music.model.dto.UserCreateDto;
import io.longtu.cloud_music.model.dto.UserDto;
import io.longtu.cloud_music.model.dto.UserUpdateDto;
import io.longtu.cloud_music.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    @Override
    User loadUserByUsername(String username);

    Page<UserDto> search(Pageable pageable);

    UserDto create(UserCreateDto userCreateDto);

    UserDto get(String id);

    UserDto update(String id, UserUpdateDto userUpdateDto);

    void delete(String id);

    UserDto getCurrentUser();
}
