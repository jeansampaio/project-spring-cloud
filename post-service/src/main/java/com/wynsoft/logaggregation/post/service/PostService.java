package com.wynsoft.logaggregation.post.service;

import com.wynsoft.logaggregation.post.domain.Post;
import com.wynsoft.logaggregation.post.domain.PostWithComments;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getPosts();
    Optional<PostWithComments> getPost(Long id);
}
