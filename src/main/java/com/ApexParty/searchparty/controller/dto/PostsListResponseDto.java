package com.ApexParty.searchparty.controller.dto;

import com.ApexParty.searchparty.domain.boards.Posts;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostsListResponseDto {
    private Long id;
    private String title;
    private String time;
    private String users_name;

    public PostsListResponseDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.time = posts.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.users_name = posts.getUsers().getName();

    }
}
