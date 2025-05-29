package practice;

import practice.models.Post;
import practice.models.User;
import practice.service.PostService;
import practice.service.UserService;
import practice.service.serviceImpl.PostServiceImpl;
import practice.service.serviceImpl.UserServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserService userService = new UserServiceImpl();
        PostService postService = new PostServiceImpl();
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
        Post post = new Post();
        post.setId(1L);
        post.setImage("wefrtg");
        post.setDescription("good photo");
        post.setCreatedDate(LocalDate.of(2025, 4, 11));
        post.setUserId(2L);
//        postService.createPostTable();
//        postService.addPost(post);

    }
}
