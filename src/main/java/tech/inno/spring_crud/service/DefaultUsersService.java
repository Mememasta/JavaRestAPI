package tech.inno.spring_crud.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.inno.spring_crud.dto.UsersDto;
import tech.inno.spring_crud.entity.Users;
import tech.inno.spring_crud.exception.ValidationException;
import tech.inno.spring_crud.repository.UsersRepository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultUsersService implements UsersService{

    private final UsersConverter usersConverter;
    private final UsersRepository usersRepository;

    @Override
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException {
        validateUserDto(usersDto);
        Users savedUser = usersRepository.save(usersConverter.fromUsersDtoToUser(usersDto));
        return usersConverter.fromUsersToUsersDto(savedUser);
    }

    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Obj user is null");
        } else if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UsersDto findByLogin(String userLogin) {
        Users users = usersRepository.findByLogin(userLogin);
        if (users != null) {
            return usersConverter.fromUsersToUsersDto(users);
        }
        return null;
    }

    @Override
    public List<UsersDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUsersToUsersDto)
                .collect(Collectors.toList());
    }
}
