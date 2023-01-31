package com.epam.kubernetasmentoringprogram.service;

import com.epam.kubernetasmentoringprogram.entity.Post;
import com.epam.kubernetasmentoringprogram.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post create(Post post) {
        Optional<Post> postId = postRepository.findById(post.getId());
        postId.ifPresent(value -> post.setId(value.getId()));
        return postRepository.save(post);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
