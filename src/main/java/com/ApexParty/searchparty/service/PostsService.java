package com.ApexParty.searchparty.service;


import com.ApexParty.searchparty.controller.dto.PostsCreateRequestDto;
import com.ApexParty.searchparty.controller.dto.PostsListResponseDto;
import com.ApexParty.searchparty.domain.boards.PostsRepository;
import com.ApexParty.searchparty.domain.users.Users;
import com.ApexParty.searchparty.domain.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final UsersRepository usersRepository;
    private final PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllByOrderByIdDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public Long save(PostsCreateRequestDto requestDto,Long userId) {
        Optional<Users> u = usersRepository.findById(userId);

        if(u.isPresent()) {
            return postsRepository.save(requestDto.toEntity(u.get())).getId();
        }

        return 0L;
    }
}
