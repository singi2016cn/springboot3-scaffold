package top.singi.springboot3_scaffold.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PaginationDTO {
    Object items;
    String total;

    public static PaginationDTO of(Object items, String total) {
        return new PaginationDTO(items, total);
    }
}
