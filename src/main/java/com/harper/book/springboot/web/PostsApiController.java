package com.harper.book.springboot.web;

import com.harper.book.springboot.service.posts.PostsService;
import com.harper.book.springboot.web.dto.PostsResponseDto;
import com.harper.book.springboot.web.dto.PostsSaveRequestDto;
import com.harper.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/*
*  RequiredArgsConstructor  : final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성해줌.
* */
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }
}
