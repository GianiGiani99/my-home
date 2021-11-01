package com.sda.project.mapper;

import com.sda.project.dto.UserInfo;
import com.sda.project.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User map(UserInfo dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        return user;
    }

    public UserInfo map(User entity) {
        UserInfo dto = new UserInfo();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }
}
