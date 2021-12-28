package io.longtu.cloud_music.mapper;

import io.longtu.cloud_music.dto.UserDto;
import io.longtu.cloud_music.entity.User;
import io.longtu.cloud_music.vo.UserVo;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
@Qualifier("userMapper")
public interface IUserMapper {

    UserDto toDto(User user);

    UserVo toVo(UserDto user);
}
