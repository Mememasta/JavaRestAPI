package tech.inno.spring_crud.service;

import org.springframework.stereotype.Component;
import tech.inno.spring_crud.dto.UsersDto;
import tech.inno.spring_crud.entity.Users;

@Component
public class UsersConverter {
    public Users fromUsersDtoToUser(UsersDto usersDto) {
//        return Users.builder()
//                .id(usersDto.getId())
//                .name(usersDto.getName())
//                .login(usersDto.getLogin())
//                .email(usersDto.getEmail())
//                .build();
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setName(usersDto.getName());
        users.setLogin(usersDto.getLogin());
        users.setEmail(usersDto.getEmail());
        return users;

    }

    public UsersDto fromUsersToUsersDto(Users users) {
        return UsersDto.builder()
                .id(users.getId())
                .name(users.getName())
                .login(users.getLogin())
                .email(users.getEmail())
                .build();
    }
}
