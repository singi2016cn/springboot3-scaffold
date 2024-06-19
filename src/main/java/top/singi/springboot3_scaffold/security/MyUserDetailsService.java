package top.singi.springboot3_scaffold.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import top.singi.springboot3_scaffold.constant.CommonConstant;
import top.singi.springboot3_scaffold.entity.User;
import top.singi.springboot3_scaffold.service.UserService;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String id) {
        //调用repository的findByEmail方法,来获取用户信息,如果存在则返回,如果不存在则抛出异常
        log.info("id:{}", id);
        User user = userService.getById(id);
        if (user == null) {
            throw new UsernameNotFoundException("User not exists by id");
        }

        Set<GrantedAuthority> authorities = Stream
                .of(new SimpleGrantedAuthority(CommonConstant.GRANTED_AUTHORITY_ROLE_ADMIN))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                id,
                user.getPassword(),
                authorities);
    }
}
