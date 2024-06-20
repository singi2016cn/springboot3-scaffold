package top.singi.springboot3_scaffold.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CustomExceptionEnum {
    DATA_NOT_FOUND(10000, "数据未找到");

    final Integer code;
    final String message;
}
