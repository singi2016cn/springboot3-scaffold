package top.singi.springboot3_scaffold.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import top.singi.springboot3_scaffold.entity.Book;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
