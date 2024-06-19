package top.singi.springboot3_scaffold.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import top.singi.springboot3_scaffold.constant.CommonConstant;

import java.time.LocalDateTime;

@Data
public class Book {
    Integer id;
    String title;
    String author;

    @JsonFormat(pattern = CommonConstant.DATE_TIME_FORMAT_PATTERN)
    LocalDateTime createdAt;
}
