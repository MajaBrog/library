package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.UserDto;
import com.crud.kodillalibrary.mapper.UserMapper;
import com.crud.kodillalibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    private List<UserDto> getUsers(){
        return userMapper.mapToUserDtoList(userService.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{userId}")
    public UserDto getUser(@PathVariable Long userId) throws RecordNotFoundException {
        return userMapper.mapToUserDto(userService.getUser(userId).orElseThrow(RecordNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userService.saveUser(userMapper.mapToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userMapper.mapToUser(userDto));
    }

}
