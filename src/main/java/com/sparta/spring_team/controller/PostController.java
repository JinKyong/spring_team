package com.sparta.spring_team.controller;


import com.sparta.spring_team.service.PostService;
import com.sparta.spring_team.dto.request.PostRequestDto;
import com.sparta.spring_team.dto.response.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PostController {

 private final PostService postService;

//    @RequestMapping(value = "/auth/posts", method = RequestMethod.POST)
//    public ResponseDto<?> createPost(@RequestBody @Valid PostRequestDto requestDto, HttpServletRequest request) {
//            return postService.createPost(requestDto, request);
//    }

    @RequestMapping(value = "/auth/posts", method = RequestMethod.POST)
    public ResponseDto<?> createPost(@RequestPart PostRequestDto requestDto,
                                     @RequestPart(required = false) MultipartFile multipartFile, HttpServletRequest request) {
        if(null == multipartFile) return postService.createPost(requestDto, request);
        return postService.createPost(requestDto, multipartFile, request);
    }

    @RequestMapping(value = "/auth/posts/{postid}", method = RequestMethod.PUT )
    public ResponseDto<?> updatePost(@PathVariable Long postid, @RequestBody @Valid PostRequestDto requestDto, HttpServletRequest request){
        return postService.updatePost(postid,requestDto, request);
    }

    @RequestMapping(value = "/auth/posts/{postid}", method = RequestMethod.DELETE )
    public ResponseDto<?> deletePost(@PathVariable Long postid,HttpServletRequest request){
        return postService.deletePost(postid, request);
    }

    @RequestMapping(value = "/posts/{postid}", method = RequestMethod.GET )
    public ResponseDto<?> readPost(@PathVariable Long postid){
        return postService.readPost(postid);
    }
    @RequestMapping(value = "/posts", method = RequestMethod.GET )
    public ResponseDto<?> readAllPost(){
        return postService.readAllPosts();
    }
}
