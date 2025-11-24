package com.example.lab10.service;

import com.example.lab10.model.JopApplication;
import com.example.lab10.model.JopPost;
import com.example.lab10.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<JopPost> getAllPosts() {
        return postRepository.findAll();
    }

    public void AddPost(JopPost jopPost) {
        postRepository.save(jopPost);

    }

    public boolean updatePost(Integer Id , JopPost jopPost) {
        JopPost oldJopPost = postRepository.getById(Id);
        if (oldJopPost == null) {
            return false;
        }
        oldJopPost.setDescription(jopPost.getDescription());
        oldJopPost.setLocation(jopPost.getLocation());
        oldJopPost.setPostingDate(jopPost.getPostingDate());
        postRepository.save(oldJopPost);
        return true;
    }


    public Boolean deletePost(Integer Id){
        JopPost jopPost = postRepository.getById(Id);
        if (jopPost == null){
            return false;
        }
        postRepository.delete(jopPost);
        return true;
    }

}
