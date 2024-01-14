package com.ApexParty.searchparty.controller.dto;

import com.ApexParty.searchparty.domain.users.Users;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UsersJoinRequestDto {
    private String name;
    private String password;
    private String email;

    @Builder
    public UsersJoinRequestDto(String name,String password,String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Users toEntity() {
        return Users.builder()
                .name(name)
                .password(password)
                .email(email)
                .build();
    }

}
