package io.longtu.cloud_music.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserUpdateDto {

    @NotBlank(message = "用户名不能为空")
    @Size(min = 4, max = 64, message = "用户名长度范围：4-64个字符")
    private String username;

    private String nickname;

    private String gender;
}
