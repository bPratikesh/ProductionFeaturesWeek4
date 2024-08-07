package com.pratikesh.prod_ready_features.prodReadyFeatures.service;

import com.pratikesh.prod_ready_features.prodReadyFeatures.DTO.PostDTO;
import com.pratikesh.prod_ready_features.prodReadyFeatures.config.AppConfig;
import com.pratikesh.prod_ready_features.prodReadyFeatures.entities.PostEntity;
import com.pratikesh.prod_ready_features.prodReadyFeatures.exceptions.ResourceNotFoundException;
import com.pratikesh.prod_ready_features.prodReadyFeatures.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPost() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostById(Long postId) {
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post not found with id: "+postId));
        return modelMapper.map(postEntity, PostDTO.class);
    }

    @Override
    public PostDTO createNewPost(PostDTO postDTO) {
        PostEntity postEntity = modelMapper.map(postDTO, PostEntity.class);
        PostEntity savedEntity = postRepository.save(postEntity);
        return modelMapper.map(savedEntity, PostDTO.class);
    }
}
