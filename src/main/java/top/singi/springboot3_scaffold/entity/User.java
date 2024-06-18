package top.singi.springboot3_scaffold.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import jakarta.validation.constraints.Email;
import lombok.Data;

@TableName("users")
@Data
public class User {
    Integer id;
    String name;

    @Email
    String email;
    String password;
}
