package practice.service.serviceImpl;

import practice.dao.PostDao;
import practice.dao.daoImpl.PostDaoImpl;
import practice.models.Post;
import practice.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {
    PostDao postDao = new PostDaoImpl();

    @Override
    public void createPostTable() {
        postDao.createPostTable();
    }

    @Override
    public void dropPostTable() {
        postDao.dropPostTable();
    }

    @Override
    public void addPost(Post post) {
postDao.addPost(post);
    }

    @Override
    public Post getPostById(Long id) {
        return postDao.getPostById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return postDao.getAllPosts();
    }

    @Override
    public String updatePost(Long id, Post post) {
        return postDao.updatePost(id, post);
    }

    @Override
    public String deletePost(Long id) {
        return postDao.deletePost(id);
    }

    @Override
    public int countPostsByUserId(Long id) {
        return postDao.countPostsByUserId(id);
    }
}
