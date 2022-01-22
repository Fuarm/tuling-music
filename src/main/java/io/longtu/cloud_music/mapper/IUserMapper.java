package io.longtu.cloud_music.mapper;

import io.longtu.cloud_music.model.dto.UserCreateDto;
import io.longtu.cloud_music.model.dto.UserDto;
import io.longtu.cloud_music.model.dto.UserUpdateDto;
import io.longtu.cloud_music.model.entity.User;
import io.longtu.cloud_music.model.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    UserDto toDto(User user);

    UserVo toVo(UserDto user);

    User createEntity(UserCreateDto userCreateDto);

    User updateEntity(@MappingTarget User user, UserUpdateDto userUpdateDto);
}
