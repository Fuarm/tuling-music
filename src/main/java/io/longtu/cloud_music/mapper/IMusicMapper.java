package io.longtu.cloud_music.mapper;

import io.longtu.cloud_music.model.dto.MusicCreateDto;
import io.longtu.cloud_music.model.dto.MusicDto;
import io.longtu.cloud_music.model.dto.MusicUpdateDto;
import io.longtu.cloud_music.model.entity.Music;
import io.longtu.cloud_music.model.vo.MusicVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IMusicMapper {

    MusicDto toDto(Music music);

    MusicVo toVo(MusicDto musicDto);

    Music createEntity(MusicCreateDto musicCreateDto);

    Music updateEntity(@MappingTarget Music music, MusicUpdateDto musicUpdateDto);
}
