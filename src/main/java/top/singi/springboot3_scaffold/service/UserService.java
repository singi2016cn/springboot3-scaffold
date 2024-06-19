package top.singi.springboot3_scaffold.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import top.singi.springboot3_scaffold.entity.User;
import top.singi.springboot3_scaffold.mapper.UserMapper;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    public User getUserByEmail(String email) {
        return new LambdaQueryChainWrapper<>(User.class).eq(User::getEmail, email).one();
    }
}
