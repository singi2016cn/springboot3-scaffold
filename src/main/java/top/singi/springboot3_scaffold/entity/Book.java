package top.singi.springboot3_scaffold.entity;

import java.time.LocalDateTime;

import lombok.Data;
import top.singi.springboot3_scaffold.annotation.DateTimeAndJsonFormatAnnotation;

@Data
public class Book {
    Integer id;
    String title;
    String author;

    @DateTimeAndJsonFormatAnnotation
    LocalDateTime createdAt;
}
