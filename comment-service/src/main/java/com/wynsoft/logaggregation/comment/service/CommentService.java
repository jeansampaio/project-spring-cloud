package com.wynsoft.logaggregation.comment.service;

import com.wynsoft.logaggregation.comment.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsForPost(Long postId);
}
