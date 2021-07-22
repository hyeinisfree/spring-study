package sungshin.sooon.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sungshin.sooon.domain.account.Account;
import sungshin.sooon.domain.post.Post;
import sungshin.sooon.domain.post.PostComment;
import sungshin.sooon.domain.post.PostCommentRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {

    private Long post_id;

    private String title;

    private String content;

    private boolean is_anonymous;

    private LocalDateTime created_at;

    private AccountResponseDto account;

    private List<PostComment> comments;

    public static PostResponseDto from(Post post) {
        return PostResponseDto.builder()
                .post_id(post.getPost_id())
                .title(post.getTitle())
                .content(post.getContent())
                .is_anonymous(post.is_anonymous())
                .created_at(post.getCreated_at())
                .account(AccountResponseDto.from(post.getAccount()))
                .build();
    }
}
