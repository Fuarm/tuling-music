package io.longtu.cloud_music.controller;

import io.longtu.cloud_music.common.ServerResponse;
import io.longtu.cloud_music.model.dto.UserCreateDto;
import io.longtu.cloud_music.mapper.IUserMapper;
import io.longtu.cloud_music.model.dto.UserUpdateDto;
import io.longtu.cloud_music.service.IUserService;
import io.longtu.cloud_music.model.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    IUserService userService;

    IUserMapper userMapper;

    @PostMapping("/")
    ServerResponse<UserVo> create(@Validated @RequestBody UserCreateDto userCreateDto) {
        return ServerResponse.createBySuccess(
                "创建用户：ok",
                userMapper.toVo(userService.create(userCreateDto))
        );
    }

    @GetMapping("/{id}")
    ServerResponse<UserVo> get(@PathVariable String id) {
        return ServerResponse.createBySuccess(
                "获取用户信息：ok",
                userMapper.toVo(userService.get(id))
        );
    }

    @PutMapping("/{id}")
    ServerResponse<UserVo> update(@PathVariable String id,
                                  @Validated @RequestBody UserUpdateDto userUpdateDto) {
        return ServerResponse.createBySuccess(
                "更新用户信息：ok",
                userMapper.toVo(userService.update(id, userUpdateDto))
        );
    }

    @DeleteMapping("/{id}")
    ServerResponse delete(@PathVariable String id) {
        userService.delete(id);
        return ServerResponse.createBySuccessMessage("删除用户：ok");
    }

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserMapper(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
