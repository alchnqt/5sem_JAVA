package com.example.lab1.controller;

import com.example.lab1.forms.LoginForm;
import com.example.lab1.forms.RegistrationForm;
import com.example.lab1.logging.Loggable;
import com.example.lab1.model.User;
import com.example.lab1.repository.UserRepository;
import com.example.lab1.security.jwt.JwtTokenProvider;
import com.example.lab1.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/account")
public class AccountController {

    private final UserService userRepository;
    AuthenticationManager authenticationManager;
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AccountController(UserService usersService,
                             AuthenticationManager authenticationManager,
                             JwtTokenProvider jwtTokenProvider) {
        this.userRepository = usersService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("/login")
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView registerPage(){
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    @Loggable
    public ResponseEntity<Map<Object, Object>> register(RegistrationForm registrationForm) throws URISyntaxException {
        try
        {
            User user = new User();
            user.setUserLogin(registrationForm.getLogin());
            user.setUserPassword(registrationForm.getPassword());
            user.setAdmin(registrationForm.getRole() == "admin");
            userRepository.add(user);
        }
        catch (Exception e)
        {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("ErrorMessage",e.getMessage());
            return new ResponseEntity<>(httpHeaders,HttpStatus.BAD_REQUEST);
        }
        URI login = new URI("http://localhost:8080/api/account/login");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(login);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    @PostMapping("/login")
    @Loggable
    public ResponseEntity<Map<Object, Object>> login(LoginForm loginForm) throws Exception {
        try {
            String username = loginForm.getLogin() ;
            Optional<User> user = userRepository.getByName(username);
            if (user.isEmpty()) {
                throw new UsernameNotFoundException("user with username: " + username + " not found");
            }
            List<SimpleGrantedAuthority> listAuth = new ArrayList<String>(Collections.singleton(user.get().isAdmin() ? "ROLE_ADMIN" : "ROLE_USER")).stream()
                    .map(role ->
                            new SimpleGrantedAuthority(role)
                    ).collect(Collectors.toList());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.get().getUserLogin(),
                    loginForm.getPassword()));
            String token = jwtTokenProvider.createToken(username);
            List<String> roleNames = Collections.singletonList(user.get().isAdmin() ? "ROLE_ADMIN" : "ROLE_USER");
            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);
            response.put("roles", roleNames);
            response.put("id", user.get().getId());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception("Invalid username or password");
        }
    }
}
