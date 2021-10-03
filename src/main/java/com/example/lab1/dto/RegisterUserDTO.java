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
    @NotBlank(message = "Please, enter the userName!")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 symbols")
    @Pattern(regexp = "^[A-z\\d*]{4,20}$")
    private String name;

    @NotNull
    @NotBlank(message = "Please, enter the password!")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 symbols")
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
