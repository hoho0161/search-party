package com.ApexParty.searchparty.controller;


import com.ApexParty.searchparty.config.auth.LoginUser;
import com.ApexParty.searchparty.config.auth.dto.SessionUser;
import com.ApexParty.searchparty.controller.dto.PostsCreateRequestDto;
import com.ApexParty.searchparty.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class PostsController {

    private final PostsService postsService;

    @GetMapping("/posts")
    public String postsWriting(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "posts";
    }

    @ResponseBody
    @PostMapping("/posts")
    public Long save(@RequestBody PostsCreateRequestDto requestDto, @LoginUser SessionUser user) {
        return postsService.save(requestDto, user.getId());
    }
}
