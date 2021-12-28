package io.longtu.cloud_music.controller;

import io.longtu.cloud_music.mapper.IUserMapper;
import io.longtu.cloud_music.service.IUserService;
import io.longtu.cloud_music.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    IUserService userService;

    IUserMapper userMapper;

    @GetMapping("/")
    List<UserVo> list() {
        return userService.list()
                .stream().map(userMapper::toVo)
                .collect(Collectors.toList());
    }

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier("userMapper")
    public void setUserMapper(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
