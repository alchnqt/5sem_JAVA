package com.example.lab1.security.jwt;

import com.example.lab1.logging.Loggable;
import com.example.lab1.model.User;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public final class JwtUserFactory {

    @Loggable
    public static JwtUser create(User user) {
        ArrayList<String> authorities = new ArrayList<>();
        authorities.add(user.isAdmin() ? "ROLE_ADMIN" : "ROLE_USER");
        return new JwtUser(
                user.getId(),
                user.getUserLogin(),
                user.getUserPassword(),
                mapToGrantedAuthorities(authorities),
                true
        );
    }

    @Loggable
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> userRoles) {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role)
                ).collect(Collectors.toList());
    }
}
