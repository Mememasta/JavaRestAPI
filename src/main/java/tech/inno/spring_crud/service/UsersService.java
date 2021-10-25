package tech.inno.spring_crud.service;

import tech.inno.spring_crud.dto.UsersDto;
import tech.inno.spring_crud.exception.ValidationException;

import java.util.List;

public interface UsersService {
    UsersDto saveUser(UsersDto usersDto) throws ValidationException;

    void deleteUser(Integer userId);

    UsersDto findByLogin(String userLogin);

    List<UsersDto> findAll();
}
