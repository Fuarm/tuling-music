package io.longtu.cloud_music.model.vo;

import io.longtu.cloud_music.enums.Gender;
import lombok.Data;

import java.util.List;

@Data
public class UserVo extends BaseVo {

    private String username;

    private String nickname;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private List<RoleVo> roles;
}
