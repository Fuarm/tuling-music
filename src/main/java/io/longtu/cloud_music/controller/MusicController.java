package io.longtu.cloud_music.controller;

import io.longtu.cloud_music.common.ServerResponse;
import io.longtu.cloud_music.mapper.IMusicMapper;
import io.longtu.cloud_music.model.dto.MusicCreateDto;
import io.longtu.cloud_music.model.dto.MusicUpdateDto;
import io.longtu.cloud_music.model.vo.MusicVo;
import io.longtu.cloud_music.service.IMusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/music")
@Api(tags = "歌曲管理")
public class MusicController {

    private IMusicService musicService;

    private IMusicMapper musicMapper;

    @PostMapping()
    @ApiOperation("新建歌曲")
    @RolesAllowed({"ROLE_ADMIN"})
    public ServerResponse<MusicVo> create(@RequestBody MusicCreateDto musicCreateDto) {
        return ServerResponse.createBySuccess(
            "新增歌曲：OK",
                musicMapper.toVo(musicService.create(musicCreateDto))
        );
    }

    @PutMapping("/{id}")
    @RolesAllowed({"ROLE_ADMIN"})
    public ServerResponse<MusicVo> update(@PathVariable String id, @Validated @RequestBody MusicUpdateDto musicUpdateDto) {
        return ServerResponse.createBySuccess(
                "更新歌曲：OK",
                musicMapper.toVo(musicService.update(id, musicUpdateDto))
        );
    }

    @PutMapping("/{id}/publish")
    @RolesAllowed({"ROLE_ADMIN"})
    @ApiOperation("上架歌曲")
    public ServerResponse publish(@PathVariable String id) {
        musicService.publish(id);
        return ServerResponse.createBySuccessMessage("上架歌曲：Ok");
    }

    @PutMapping("/{id}/recycle")
    @RolesAllowed({"ROLE_ADMIN"})
    @ApiOperation("下架歌曲")
    public ServerResponse recycle(@PathVariable String id) {
        musicService.recycle(id);
        return ServerResponse.createBySuccessMessage("上架歌曲：Ok");
    }

    @Autowired
    public void setMusicService(IMusicService musicService) {
        this.musicService = musicService;
    }

    @Autowired
    public void setMusicMapper(IMusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }
}
