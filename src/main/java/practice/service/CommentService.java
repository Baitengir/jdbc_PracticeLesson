package practice.service;

import practice.models.Comment;

import java.util.List;

public interface CommentService {
    //todo table methods
    void createCommentTable();
    void dropCommentTable();
    // todo crud
    void addComment(Comment comment);
    Comment getCommentById(Long id);
    List<Comment> getAllComments();
    String updateComment(Long id, Comment comment);
    String deleteComment(Long id);
    List<Comment> getRecentCommentsByPostId(Long postId, int limit);
}
