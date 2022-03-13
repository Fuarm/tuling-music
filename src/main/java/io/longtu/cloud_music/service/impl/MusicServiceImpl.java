package io.longtu.cloud_music.service.impl;

import io.longtu.cloud_music.common.ResponseType;
import io.longtu.cloud_music.enums.MusicStatus;
import io.longtu.cloud_music.exception.BizException;
import io.longtu.cloud_music.mapper.IMusicMapper;
import io.longtu.cloud_music.model.dto.MusicCreateDto;
import io.longtu.cloud_music.model.dto.MusicDto;
import io.longtu.cloud_music.model.dto.MusicUpdateDto;
import io.longtu.cloud_music.model.entity.Music;
import io.longtu.cloud_music.repository.IMusicRepository;
import io.longtu.cloud_music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicServiceImpl implements IMusicService {

    private IMusicRepository musicRepository;

    private IMusicMapper musicMapper;

    @Override
    public MusicDto create(MusicCreateDto musicCreateDto) {
        Music music = musicMapper.createEntity(musicCreateDto);
        music.setStatus(MusicStatus.DRAFT);
        return musicMapper.toDto(musicRepository.save(music));
    }

    @Override
    public MusicDto update(String id, MusicUpdateDto musicUpdateDto) {
        Music music = musicMapper.updateEntity(findMusicById(id), musicUpdateDto);
        return musicMapper.toDto(musicRepository.save(music));
    }

    @Override
    public void publish(String id) {
        Music music = findMusicById(id);
        music.setStatus(MusicStatus.PUBLISH);
        musicRepository.save(music);
    }

    @Override
    public void recycle(String id) {
        Music music = findMusicById(id);
        music.setStatus(MusicStatus.RECYCLE);
        musicRepository.save(music);
    }

    private Music findMusicById(String id) {
        Optional<Music> musicOptional = musicRepository.findById(id);
        if (!musicOptional.isPresent()) {
            throw new BizException(ResponseType.MUSIC_NOT_FOUND);
        }
        return musicOptional.get();
    }

    @Autowired
    public void setMusicRepository(IMusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Autowired
    public void setMusicMapper(IMusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }
}
