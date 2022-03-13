package io.longtu.cloud_music.model.vo;

import io.longtu.cloud_music.enums.MusicStatus;
import lombok.Data;

@Data
public class MusicVo extends BaseVo {

    private String name;

    private MusicStatus status;

    private String description;
}
