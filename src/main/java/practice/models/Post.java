package practice.models;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Post {
    private Long id;
    private String image;
    private String description;
    private LocalDate createdDate;
    private Long userId;

    public Post(String image, String description, LocalDate createdDate, Long userId) {
        this.image = image;
        this.description = description;
        this.createdDate = createdDate;
        this.userId = userId;
    }
}
