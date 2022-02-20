package io.longtu.cloud_music.model.dto;

import io.longtu.cloud_music.enums.Gender;
import io.longtu.cloud_music.model.vo.RoleVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {

    private String id;

    private String username;

    private String nickname;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private String lastLoginIp;

    private Date lastLoginTime;

    private List<RoleVo> roles;
}
