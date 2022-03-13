package io.longtu.cloud_music.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MusicUpdateDto {

    @NotBlank(message = "歌曲名不能为空")
    private String name;

    private String description;
}
