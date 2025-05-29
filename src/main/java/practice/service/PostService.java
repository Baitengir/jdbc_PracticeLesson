package practice.service;

import practice.models.Post;

import java.util.List;

public interface PostService {
    void createPostTable();
    void dropPostTable();

    void addPost(Post post);
    Post getPostById(Long id);
    List<Post> getAllPosts();
    String updatePost(Long id, Post post);
    String deletePost(Long id);
    int countPostsByUserId(Long id);
}
