package practice;

import practice.models.Comment;
import practice.models.Post;
import practice.models.User;
import practice.service.CommentService;
import practice.service.PostService;
import practice.service.UserService;
import practice.service.serviceImpl.CommentServiceImpl;
import practice.service.serviceImpl.PostServiceImpl;
import practice.service.serviceImpl.UserServiceImpl;

import java.time.LocalDate;

public class App 
{
    public static void main( String[] args )
    {
        UserService userService = new UserServiceImpl();
        PostService postService = new PostServiceImpl();
        CommentService commentService = new CommentServiceImpl();

        // todo check methods (user)
//        userService.createUserTable();
//        userService.addUser(new User(1L, "Junus", "j@gmail.com", "1234"));
//        userService.addUser(new User(1L, "Jenish", "jj@gmail.com", "1122"));
//        System.out.println(userService.getUserById(1L));
//        System.out.println(userService.getAllUsers());
//        User user = new User(3L, "Mairam", "MMm@gmail.com", "3422");
//        System.out.println(userService.updateUserById(1L, user));
//        System.out.println(userService.deleteUserById(1L));
//        userService.addUser(new User(3L, "Guli", "wej@gmail.com", "1122"));
//        userService.addUser(new User(4L, "meerim", "vrj@gmail.com", "234r3g"));
//        userService.addUser(new User(4L, "meerim", "vrj@gmail.com", "23rer"));
//        System.out.println(userService.searchUserByName("meerim"));

        // todo post
//        Post post2 = new Post();
//        post2.setId(4L);
//        post2.setImage("shadow");
//        post2.setDescription("wjqvhu");
//        post2.setCreatedDate(LocalDate.of(2025, 4, 13));
//        post2.setUserId(3L);
//        postService.createPostTable();
//        postService.addPost(post2);
//        System.out.println(postService.getAllPosts());
//        System.out.println(postService.updatePost(2L, post2));
//        System.out.println(postService.deletePost(1L));
//        System.out.println(postService.countPostsByUserId(3L));

        // todo comment
//        commentService.createCommentTable();
//        Comment upCom = new Comment(1L, "updated comment", LocalDate.now(), 2L, 3L);
//        Comment comment2 = new Comment(2L, "Second comment", LocalDate.now(), 2L, 4L);
//        commentService.addComment(comment1);
//        commentService.addComment(comment2);
//        System.out.println(commentService.getAllComments());
//        System.out.println(commentService.updateComment(3L, upCom));
//        System.out.println(commentService.deleteComment(4L));
//        System.out.println(commentService.getRecentCommentsByPostId(2L, 1));

    }
}
