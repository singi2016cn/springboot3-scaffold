package top.singi.springboot3_scaffold.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import top.singi.springboot3_scaffold.entity.Book;

@Component
public interface BookMapper extends BaseMapper<Book> {
    Map<String, Object> bookWithAuthor(Integer bookId);
}
