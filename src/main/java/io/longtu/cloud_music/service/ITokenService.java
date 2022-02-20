package io.longtu.cloud_music.service;

import io.longtu.cloud_music.model.dto.TokenCreateDto;

public interface ITokenService {

    String create(TokenCreateDto tokenCreateDto);
}
