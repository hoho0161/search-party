package com.ApexParty.searchparty.controller.dto;

import com.ApexParty.searchparty.domain.boards.Boards;
import com.ApexParty.searchparty.domain.users.Users;
import lombok.Builder;

public class BoardsCreateRequestDto {
    private String title;
    private String contents;
    private int cType;
    private int cMike;
    private int cTier;
    private int cDmg;

    @Builder
    BoardsCreateRequestDto(String title, String contents, int cType, int cMike, int cTier, int cDmg) {
        this.title = title;
        this.contents = contents;
        this.cType = cType;
        this.cMike = cMike;
        this.cTier = cTier;
        this.cDmg = cDmg;
    }

    public Boards toEntity() {
        return Boards.builder()
                .title(title).contents(contents)
                .cType(cType).cMike(cMike).cTier(cTier).cDmg(cDmg).build();
    }

}
