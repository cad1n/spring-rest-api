package com.study.springrestfulapi.services;

import com.study.springrestfulapi.domain.Post;
import com.study.springrestfulapi.repository.PostRepository;
import com.study.springrestfulapi.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));
    }
}
