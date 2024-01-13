package com.ApexParty.searchparty.domain.users;


import com.ApexParty.searchparty.controller.dto.UsersJoinRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UsersRepositoryTest {
    
    @Autowired
    UsersRepository usersRepository;
    
    @AfterEach
    public void cleanup() {
        usersRepository.deleteAll();
    }

    @Test
    public void 유저_저장() {
        //given
        String name = "name";
        String pw = "password";
        String email = "email";
        Users users = new UsersJoinRequestDto(name,pw,email).toEntity();
        //when
        usersRepository.save(users);

        //then
        List<Users> UsersList = usersRepository.findAll();
        Users foundusers = UsersList.get(0);
        assertThat(foundusers.getName()).isEqualTo(name);
        assertThat(foundusers.getPassword()).isEqualTo(pw);
        assertThat(foundusers.getEmail()).isEqualTo(email);
    }


    @Test
    public void 유저이름_검색() {
        //given
        String name = "name";
        String pw = "password";
        String email = "email";
        Users users = new UsersJoinRequestDto(name,pw,email).toEntity();
        usersRepository.save(users);

        //when
        Optional<Users> usersOptional = usersRepository.findByName(name);
        //then
        assertThat(usersOptional.isPresent()).isTrue();
        Users foundUser = usersOptional.get();
        assertThat(foundUser.getName()).isEqualTo(name);
        assertThat(foundUser.getPassword()).isEqualTo(pw);
        assertThat(foundUser.getEmail()).isEqualTo(email);

    }




    
}