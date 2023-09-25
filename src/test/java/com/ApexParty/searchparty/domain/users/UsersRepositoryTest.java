package com.ApexParty.searchparty.domain.users;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void 유저_저장하기() {
        //given
        String name = "테스트이름";
        String email = "test@email.com";

        usersRepository.save(Users.builder()
                .name(name)
                .email(email)
                .build());

        //when
        List<Users> UsersList = usersRepository.findAll();

        //then
        Users users = UsersList.get(0);
        assertThat(users.getName()).isEqualTo(name);
        assertThat(users.getEmail()).isEqualTo(email);
    }


    @Test
    public void 유저이름_검색하기() {
        //given
        String name = "테스트이름";
        String email = "test@email.com";

        usersRepository.save(Users.builder()
                .name(name)
                .email(email)
                .build());

        //when
        Optional<Users> usersOptional = usersRepository.findByName(name);

        //then
        assertThat(usersOptional.isPresent()).isTrue();
        Users foundUser = usersOptional.get();
        assertThat(foundUser.getName()).isEqualTo(name);
        assertThat(foundUser.getEmail()).isEqualTo(email);

    }
    
    
}