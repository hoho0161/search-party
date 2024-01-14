package com.ApexParty.searchparty.service;


import com.ApexParty.searchparty.controller.dto.PostsListResponseDto;
import com.ApexParty.searchparty.domain.boards.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllByOrderByIdDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

}
