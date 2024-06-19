package top.singi.springboot3_scaffold.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DataNotFoundException extends RuntimeException {
    private String massage;
}
