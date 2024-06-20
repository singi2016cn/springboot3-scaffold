package top.singi.springboot3_scaffold.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@TableName("users")
@Data
public class User {
    Integer id;
    String name;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    String email;

    @Size(min = 8, max = 31, message = "密码必须是8至31位")
    String password;
}
