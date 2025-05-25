package com.app.backend.controller;

import com.app.backend.config.jwt.JwtTokenUtil;
import com.app.backend.config.jwt.JwtUserDetails;
import com.app.backend.config.jwt.JwtUserDetailsService;
import com.app.backend.config.rest.ResponseFactory;
import com.app.backend.model.User;
import com.app.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping("/")
    public String index() throws Exception {
        return "OK";
    }
    @PostMapping("/user/register")
    public ResponseEntity register(@RequestBody User user) throws Exception {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        user.setPassword(password);
        return ResponseFactory.clone(authenticate(user));
    }
    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody User user) throws Exception {
        return ResponseFactory.clone(authenticate(user));
    }
    private User authenticate(User user) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final JwtUserDetails userDetails = (JwtUserDetails) userDetailsService.loadUserByUsername(user.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        userDetails.getUser().setPassword("");
        userDetails.getUser().setToken(token);
        return userDetails.getUser();
    }
    @PostMapping("/private/user/password")
    public ResponseEntity password(@RequestBody HashMap params) throws Exception {
        final JwtUserDetails userDetails = (JwtUserDetails) userDetailsService.loadUserByUsername(params.get("username").toString());
        if(!bCryptPasswordEncoder.matches(params.get("password").toString(),userDetails.getPassword())){
            throw new Exception("PASSWORD_DOES_NOT_MATCH");
        }
        User user = userDetails.getUser();
        user.setPassword(bCryptPasswordEncoder.encode(params.get("newPassword").toString()));
        userRepository.save(user);
        userDetails.getUser().setPassword("");
        return ResponseFactory.clone(user);
    }
}
