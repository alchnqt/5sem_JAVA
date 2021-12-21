package com.example.lab1.dto;

import com.example.lab1.model.User;
import lombok.Data;
import javax.validation.constraints.*;
import java.util.UUID;

@Data
public class RegisterUserDTO {
    @Null
    private int userId;

    @NotNull
    private String name;

    @NotNull
    private String password;

    private boolean isAdmin;

    public static RegisterUserDTO fromUser(User user) {
        RegisterUserDTO registerUserDto = new RegisterUserDTO();
        registerUserDto.setUserId(user.getId());
        registerUserDto.setName(user.getUserLogin());
        return registerUserDto;
    }

    public User toUser() {
        User user = new User();
        user.setUserLogin(this.name);
        user.setUserPassword(this.password);
        user.setAdmin(isAdmin);
        return user;
    }
}
