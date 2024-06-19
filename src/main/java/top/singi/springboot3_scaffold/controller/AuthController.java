package top.singi.springboot3_scaffold.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.singi.springboot3_scaffold.dto.ResultDTO;
import top.singi.springboot3_scaffold.dto.UserDTO;
import top.singi.springboot3_scaffold.entity.User;
import top.singi.springboot3_scaffold.exception.DataNotFoundException;
import top.singi.springboot3_scaffold.security.JwtTokenProvider;
import top.singi.springboot3_scaffold.service.UserService;
import top.singi.springboot3_scaffold.util.Util;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResultDTO login(@RequestBody @Validated User user) {
        User userByEmail = userService.getUserByEmail(user.getEmail());
        if (userByEmail == null) {
            throw new DataNotFoundException("用户不存在");
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userByEmail.getId(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResultDTO.success(jwtTokenProvider.generateToken(authentication.getName()));
    }

    @GetMapping("/me")
    public ResultDTO me(@RequestHeader("Authorization") String authorization) {
        String token = Util.bearerToken(authorization);
        String id = jwtTokenProvider.getUsername(token);
        User user = userService.getById(id);
        UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getEmail());
        return ResultDTO.success(userDTO);
    }
}
