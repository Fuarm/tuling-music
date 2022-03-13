package io.longtu.cloud_music.model.entity;

import io.longtu.cloud_music.enums.MusicStatus;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Music extends AbstractEntity {

    private String name;

    private MusicStatus status;

    private String description;
}
