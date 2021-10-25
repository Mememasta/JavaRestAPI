package tech.inno.spring_crud.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema
public class UsersDto {
    private Integer id;
    private String name;
    private String login;
    private String email;
}
