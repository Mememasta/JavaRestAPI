package tech.inno.spring_crud.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.inno.spring_crud.dto.UsersDto;
import tech.inno.spring_crud.exception.ValidationException;
import tech.inno.spring_crud.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log
@Tag(name="users", description="Create, update, delete users")
public class UsersController {
    private final UsersService usersService;

    @Operation(
            summary = "Регистрация пользователя",
            description = "Позволяет зарегистрировать пользователя"
    )
    @PostMapping("/save")
    public UsersDto saveUser(@RequestBody UsersDto usersDto) throws ValidationException {
        log.info("Handling save users:" + usersDto);
        return usersService.saveUser(usersDto);
    }

    @GetMapping("/findAll")
    public List<UsersDto> findAllUsers() {
        log.info("Handling find all users request");
        return usersService.findAll();
    }

    @GetMapping("/findByLogin")
    public UsersDto findByLogin(@RequestParam String login) {
        log.info("Handling find by login request: " + login);
        return usersService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        log.info("Handling delete user request: " + id);
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
