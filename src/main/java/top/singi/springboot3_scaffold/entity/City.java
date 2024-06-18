package top.singi.springboot3_scaffold.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import top.singi.springboot3_scaffold.annotation.DateTimeAndJsonFormatAnnotation;

@Data
public class City {
    Integer id;
    Integer province_id;
    String name;
    String no;

    @DateTimeAndJsonFormatAnnotation
    LocalDateTime createdAt;

    @DateTimeAndJsonFormatAnnotation
    LocalDateTime updatedAt;

    @TableField(exist = false)
    Province province;
}
