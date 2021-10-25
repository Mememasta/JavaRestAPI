package tech.inno.spring_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.inno.spring_crud.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByLogin(String login);
}
