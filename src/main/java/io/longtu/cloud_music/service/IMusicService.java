package io.longtu.cloud_music.service;

import io.longtu.cloud_music.model.dto.MusicCreateDto;
import io.longtu.cloud_music.model.dto.MusicDto;
import io.longtu.cloud_music.model.dto.MusicUpdateDto;

public interface IMusicService {

    MusicDto create(MusicCreateDto musicCreateDto);

    MusicDto update(String id, MusicUpdateDto musicUpdateDto);

    void publish(String id);

    void recycle(String id);
}
