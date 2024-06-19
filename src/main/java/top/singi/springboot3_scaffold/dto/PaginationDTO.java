package top.singi.springboot3_scaffold.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PaginationDTO {
    Object items;
    Long total;

    public static PaginationDTO of(Object items, Long total) {
        return new PaginationDTO(items, total);
    }
}
