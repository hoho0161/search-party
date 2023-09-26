package com.ApexParty.searchparty.domain.boards;

import com.ApexParty.searchparty.controller.dto.BoardsCreateRequestDto;
import com.ApexParty.searchparty.domain.users.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BoardsRepositoryTest {
    @Autowired
    BoardsRepository boardsRepository;

    @AfterEach
    public void cleanup() {
        boardsRepository.deleteAll();
    }

    @Test
    public void 게시글_저장() {
        //given
        String title = "title";
        String content = "contents";
        Integer dmg = 100;

        Boards b = BoardsCreateRequestDto.builder()
                .title(title).contents(content).cType(1).cMike(1).cTier(1).cDmg(dmg).build()
                        .toEntity();
        //when
        boardsRepository.save(b);
        //then
        List<Boards> boards = boardsRepository.findAll();
        assertThat(boards.get(0).getTitle()).isEqualTo(title);
        assertThat(boards.get(0).getContents()).isEqualTo(content);
        assertThat(boards.get(0).getCDmg()).isEqualTo(dmg);
    }

    @Test
    public void 게시글_검색() {
        //given
        String title = "title";
        String content = "contents";
        Integer dmg = 100;

        Boards b = BoardsCreateRequestDto.builder()
                .title(title).contents(content).cType(1).cMike(1).cTier(1).cDmg(dmg).build()
                .toEntity();
        boardsRepository.save(b);
        //when
        List<Boards> boards = boardsRepository.findAll();

        //then
        assertThat(boards.get(0).getTitle()).isEqualTo(title);
        assertThat(boards.get(0).getContents()).isEqualTo(content);
        assertThat(boards.get(0).getCDmg()).isEqualTo(dmg);
    }

}