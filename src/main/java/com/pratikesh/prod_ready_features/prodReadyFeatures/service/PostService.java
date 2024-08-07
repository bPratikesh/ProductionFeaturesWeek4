package com.pratikesh.prod_ready_features.prodReadyFeatures.service;

import com.pratikesh.prod_ready_features.prodReadyFeatures.DTO.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPost();
    PostDTO createNewPost(PostDTO postDTO);

    PostDTO getPostById(Long postId);
}
