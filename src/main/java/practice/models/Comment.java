package practice.models;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    private Long id;
    private String comment;
    private LocalDate date;
    private Long postId;
    private Long userId;

    public Comment(String comment, LocalDate date, Long postId, Long userId) {
        this.comment = comment;
        this.date = date;
        this.postId = postId;
        this.userId = userId;
    }
}
