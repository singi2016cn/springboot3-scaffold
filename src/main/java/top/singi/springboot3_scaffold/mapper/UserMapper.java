package top.singi.springboot3_scaffold.mapper;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import top.singi.springboot3_scaffold.entity.User;

@Component
public interface UserMapper extends BaseMapper<User> {

}
