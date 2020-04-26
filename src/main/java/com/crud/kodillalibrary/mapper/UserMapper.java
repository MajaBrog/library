package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.User;
import com.crud.kodillalibrary.domain.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getName(),
                userDto.getSurname(),
                userDto.getEmail());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getDateOfAccountCreation(),
                user.getEmail());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList){
        return userList.stream()
                .map(u->new UserDto(u.getId(),u.getName(),u.getSurname(),u.getDateOfAccountCreation(),u.getEmail()))
                .collect(Collectors.toList());
    }
}