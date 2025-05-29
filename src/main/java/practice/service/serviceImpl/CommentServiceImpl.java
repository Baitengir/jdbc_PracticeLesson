package practice.service.serviceImpl;
import practice.dao.CommentDao;
import practice.dao.daoImpl.CommentDaoImpl;
import practice.models.Comment;
import practice.service.CommentService;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentDao commentDao = new CommentDaoImpl();

    @Override
    public void createCommentTable() {
        commentDao.createCommentTable();
    }

    @Override
    public void dropCommentTable() {
        commentDao.dropCommentTable();
    }

    @Override
    public void addComment(Comment comment) {
        commentDao.addComment(comment);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentDao.getCommentById(id);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentDao.getAllComments();
    }

    @Override
    public String updateComment(Long id, Comment comment) {
        return commentDao.updateComment(id, comment);
    }

    @Override
    public String deleteComment(Long id) {
        return commentDao.deleteComment(id);
    }

    @Override
    public List<Comment> getRecentCommentsByPostId(Long postId, int limit) {
        return List.of();
    }
}
