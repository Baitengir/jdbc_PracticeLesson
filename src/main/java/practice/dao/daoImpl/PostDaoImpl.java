package practice.dao.daoImpl;
import practice.config.DBConfig;
import practice.dao.PostDao;
import practice.models.Post;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostDaoImpl implements PostDao {
    Connection connection = DBConfig.getConnection();
    @Override
    public void createPostTable() {
        String sql = """
                CREATE TABLE posts (
                id SERIAL PRIMARY KEY,
                image VARCHAR NOT NULL,
                description TEXT,
                date DATE NOT NULL,
                user_id INT REFERENCES users(id)
                )
                """;
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Post table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropPostTable() {
        String sql = "DROP TABLE posts";
    }

    @Override
    public void addPost(Post post) {
        String sql = """
                INSERT INTO posts (image, description, date, user_id)
                VALUES (?,?,?,?)
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, post.getImage());
            preparedStatement.setString(2, post.getDescription());
            preparedStatement.setDate(3, Date.valueOf(post.getCreatedDate()));
            preparedStatement.setLong(4, post.getUserId());
            preparedStatement.executeUpdate();
            System.out.println("post added");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Post getPostById(Long id) {
        String sql = """
                SELECT *
                FROM posts
                WHERE id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Post post = new Post();
                post.setImage(resultSet.getString("image"));
                post.setDescription(resultSet.getString("description"));
                post.setCreatedDate(resultSet.getDate("date").toLocalDate());
                post.setUserId(resultSet.getLong("user_id"));
                return post;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("error");
        return new Post();
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        String sql =

        return List.of();
    }

    @Override
    public String updatePost(Long id, Post post) {
        return "";
    }

    @Override
    public String deletePost(Long id) {
        return "";
    }

    @Override
    public int countPostsByUserId(Long id) {
        return 0;
    }
}
