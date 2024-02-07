package com.ApexParty.searchparty.controller.dto;

import com.ApexParty.searchparty.domain.boards.Posts;
import com.ApexParty.searchparty.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
public class PostsCreateRequestDto {
    private String title;
    private String contents;
    private String ctype;
    private String cmike;
    private String ctier;

    @Builder
    PostsCreateRequestDto(String title, String contents,String ctype, String cmike,String ctier) {
        this.title = title;
        this.contents = contents;
        this.ctype = ctype;
        this.cmike = cmike;
        this.ctier = ctier;
    }

    public Posts toEntity(Users users) {
        return Posts.builder()
                .title(title).contents(contents).users(users)
                .cType(ctype).cMike(cmike).cTier(ctier).build();
    }

}
