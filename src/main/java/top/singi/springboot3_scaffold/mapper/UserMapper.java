package top.singi.springboot3_scaffold.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import top.singi.springboot3_scaffold.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    
}
