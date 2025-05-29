package practice.dao.daoImpl;

import practice.config.DBConfig;
import practice.dao.CommentDao;
import practice.models.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl implements CommentDao {
    Connection connection = DBConfig.getConnection();
    @Override
    public void createCommentTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS comments (
                id SERIAL PRIMARY KEY,
                comment VARCHAR,
                date DATE,
                post_id INT REFERENCES posts(id),
                user_id INT REFERENCES users(id))
                """;
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Comment table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropCommentTable() {
        String sql = "DROP TABLE comments";
    }

    @Override
    public void addComment(Comment comment) {
        String sql = """
                INSERT INTO comments (comment, date, post_id, user_id)
                VALUES (?,?,?,?)
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, comment.getComment());
            preparedStatement.setDate(2, Date.valueOf(comment.getDate()));
            preparedStatement.setLong(3, comment.getPostId());
            preparedStatement.setLong(4, comment.getUserId());
            preparedStatement.executeUpdate();
            System.out.println("comment added");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Comment getCommentById(Long id) {
        String sql = "SELECT * FROM comments WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Comment(
                        resultSet.getLong("id"),
                        resultSet.getString("comment"),
                        resultSet.getDate("date").toLocalDate(),
                        resultSet.getLong("post_id"),
                        resultSet.getLong("user_id")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT * FROM comments";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Comment comment = new Comment(
                        resultSet.getLong("id"),
                        resultSet.getString("comment"),
                        resultSet.getDate("date").toLocalDate(),
                        resultSet.getLong("post_id"),
                        resultSet.getLong("user_id")
                );
                comments.add(comment);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return comments;
    }

    @Override
    public String updateComment(Long id, Comment comment) {
        String sql = """
                UPDATE comments
                SET comment = ?, date = ?, post_id = ?, user_id = ?
                WHERE id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, comment.getComment());
            preparedStatement.setDate(2, Date.valueOf(comment.getDate()));
            preparedStatement.setLong(3, comment.getPostId());
            preparedStatement.setLong(4, comment.getUserId());
            preparedStatement.setLong(5, id);
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0 ? "Comment updated successfully" : "Comment not found";
        } catch (SQLException e) {
            return "Error updating comment: " + e.getMessage();
        }
    }

    @Override
    public String deleteComment(Long id) {
        String sql = "DELETE FROM comments WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0 ? "Comment deleted successfully" : "Comment not found";
        } catch (SQLException e) {
            return "Error deleting comment: " + e.getMessage();
        }
    }

    @Override
    public List<Comment> getRecentCommentsByPostId(Long postId, int limit) {
        List<Comment> comments = new ArrayList<>();
        String sql = """
                SELECT * FROM comments
                WHERE post_id = ?
                ORDER BY date DESC
                LIMIT ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, postId);
            preparedStatement.setInt(2, limit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment(
                        resultSet.getLong("id"),
                        resultSet.getString("comment"),
                        resultSet.getDate("date").toLocalDate(),
                        resultSet.getLong("post_id"),
                        resultSet.getLong("user_id")
                );
                comments.add(comment);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return comments;
    }
}


