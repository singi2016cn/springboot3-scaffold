package top.singi.springboot3_scaffold.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import top.singi.springboot3_scaffold.constant.CommonConstant;

import java.time.LocalDateTime;

@Data
public class City {
    Integer id;
    Integer province_id;
    String name;
    String no;

    @JsonFormat(pattern = CommonConstant.DATE_TIME_FORMAT_PATTERN)
    LocalDateTime createdAt;

    @JsonFormat(pattern = CommonConstant.DATE_TIME_FORMAT_PATTERN)
    LocalDateTime updatedAt;

    @TableField(exist = false)
    Province province;
}
