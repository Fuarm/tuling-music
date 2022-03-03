package io.longtu.cloud_music.controller;

import io.longtu.cloud_music.common.ServerResponse;
import io.longtu.cloud_music.model.dto.UserCreateDto;
import io.longtu.cloud_music.mapper.IUserMapper;
import io.longtu.cloud_music.model.dto.UserUpdateDto;
import io.longtu.cloud_music.service.IUserService;
import io.longtu.cloud_music.model.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;


@RestController
@RequestMapping("/users")
@Api(tags = "用户管理")
public class UserController {

    IUserService userService;

    IUserMapper userMapper;


    @GetMapping
    @ApiOperation("用户检索")
    @RolesAllowed({"ROLE_ADMIN"})
    ServerResponse<Page<UserVo>> search(@PageableDefault(sort = {"createdTime"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return ServerResponse.createBySuccess(
                "用户检索：ok",
                userService.search(pageable).map(userMapper::toVo)
        );
    }

    @PostMapping()
    @ApiOperation("创建用户")
    @RolesAllowed({"ROLE_ADMIN"})
    public ServerResponse<UserVo> create(@Validated @RequestBody UserCreateDto userCreateDto) {
        return ServerResponse.createBySuccess(
                "创建用户：ok",
                userMapper.toVo(userService.create(userCreateDto))
        );
    }

    @GetMapping("/{id}")
    @ApiOperation("获取用户信息")
    @RolesAllowed({"ROLE_ADMIN"})
    public ServerResponse<UserVo> get(@PathVariable String id) {
        return ServerResponse.createBySuccess(
                "获取用户信息：ok",
                userMapper.toVo(userService.get(id))
        );
    }

    @PutMapping("/{id}")
    @ApiOperation("更新用户信息")
    @RolesAllowed({"ROLE_ADMIN"})
    public ServerResponse<UserVo> update(@PathVariable String id,
                                  @Validated @RequestBody UserUpdateDto userUpdateDto) {
        return ServerResponse.createBySuccess(
                "更新用户信息：ok",
                userMapper.toVo(userService.update(id, userUpdateDto))
        );
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除用户")
    @RolesAllowed({"ROLE_ADMIN"})
    public ServerResponse delete(@PathVariable String id) {
        userService.delete(id);
        return ServerResponse.createBySuccess("删除用户：ok");
    }

    @GetMapping("/me")
    @ApiOperation("获取当前登录用户信息")
    public ServerResponse<UserVo> me() {
        return ServerResponse.createBySuccess(
                "获取信息：ok",
                userMapper.toVo(userService.getCurrentUser())
        );
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
