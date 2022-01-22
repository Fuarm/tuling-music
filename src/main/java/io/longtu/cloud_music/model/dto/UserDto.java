package io.longtu.cloud_music.model.dto;

import io.longtu.cloud_music.model.vo.RoleVo;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String id;

    private String username;

    private String nickname;

    private List<RoleVo> roles;
}
