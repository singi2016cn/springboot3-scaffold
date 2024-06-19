package top.singi.springboot3_scaffold.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class UserDTO {
    Integer id;
    String name;
    String email;
}
