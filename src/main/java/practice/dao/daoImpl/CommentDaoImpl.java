package practice.dao.daoImpl;

import practice.dao.CommentDao;
import practice.models.Comment;
import practice.service.CommentService;

import java.util.List;

public class CommentDaoImpl implements CommentDao {
    @Override
    public void createCommentTable() {

    }

    @Override
    public void dropCommentTable() {

    }

    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public Comment getCommentById(Long id) {
        return null;
    }

    @Override
    public List<Comment> getAllComments() {
        return List.of();
    }

    @Override
    public String updateComment(Long id, Comment comment) {
        return "";
    }

    @Override
    public String deleteComment(Long id) {
        return "";
    }

    @Override
    public List<Comment> getRecentCommentsByPostId(Long postId, int limit) {
        return List.of();
    }
}
