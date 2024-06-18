package top.singi.springboot3_scaffold.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import top.singi.springboot3_scaffold.entity.Book;
import top.singi.springboot3_scaffold.mapper.BookMapper;

@Service
public class BookService extends ServiceImpl<BookMapper,Book> {

}
