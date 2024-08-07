package com.pratikesh.prod_ready_features.prodReadyFeatures.controllers;

import com.pratikesh.prod_ready_features.prodReadyFeatures.DTO.PostDTO;
import com.pratikesh.prod_ready_features.prodReadyFeatures.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDTO> getAllPosts(){
        return postService.getAllPost();
    }

    @GetMapping(path = "/{postId}")
    public PostDTO getPOstById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @PostMapping
    public PostDTO createNewPost(@RequestBody PostDTO postDTO){
        return postService.createNewPost(postDTO);
    }

}
