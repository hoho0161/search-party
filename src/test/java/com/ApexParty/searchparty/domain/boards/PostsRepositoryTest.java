package com.ApexParty.searchparty.domain.boards;

import com.ApexParty.searchparty.controller.dto.BoardsCreateRequestDto;
import com.ApexParty.searchparty.controller.dto.UsersJoinRequestDto;
import com.ApexParty.searchparty.domain.users.Users;
import com.ApexParty.searchparty.domain.users.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;
    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글_저장() {
        //given
        String title = "title";
        String content = "contents";
        Integer dmg = 100;

        Posts b = BoardsCreateRequestDto.builder()
                .title(title).contents(content).cType(1).cMike(1).cTier(1).cDmg(dmg).build()
                        .toEntity();

        //when
        postsRepository.save(b);
        //then
        List<Posts> boards = postsRepository.findAll();
        assertThat(boards.get(0).getTitle()).isEqualTo(title);
        assertThat(boards.get(0).getContents()).isEqualTo(content);
        assertThat(boards.get(0).getCDmg()).isEqualTo(dmg);
    }

    @Transactional
    @Test
    public void 게시글_검색() {
        //given
        String title = "title";
        String content = "contents";
        Integer dmg = 100;

        String name = "name";
        String pw = "password";
        String email = "email";

        Users u = UsersJoinRequestDto.builder().name(name).email(email).password(pw).build().toEntity();

        Posts posts = BoardsCreateRequestDto.builder()
                .title(title).users(u).contents(content).cType(1).cMike(1).cTier(1).cDmg(dmg).build()
                .toEntity();

        postsRepository.save(posts);
        //when
        List<Posts> boards = postsRepository.findAll();
        //then
        assertThat(boards.get(0).getTitle()).isEqualTo(title);
        assertThat(boards.get(0).getContents()).isEqualTo(content);
        assertThat(boards.get(0).getCDmg()).isEqualTo(dmg);
        assertThat(boards.get(0).getUsers().getName()).isEqualTo(name);
        assertThat(boards.get(0).getUsers().getPassword()).isEqualTo(pw);

    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2024,1,12,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .contents("contents")
                .cType(1).cMike(1).cTier(1).cDmg(100)
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        System.out.println(">>>>>>>>>>>>> createDate"+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }

}