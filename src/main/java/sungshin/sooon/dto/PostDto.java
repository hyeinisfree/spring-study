package sungshin.sooon.dto;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import sungshin.sooon.domain.account.Account;
import sungshin.sooon.domain.post.Post;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private boolean is_anonymous;

    private LocalDateTime created_at;

    private Account account;

    public Post toPost() {
        return Post.builder()
                .title(title)
                .content(content)
                .is_anonymous(is_anonymous)
                .created_at(LocalDateTime.now())
                .account(account)
                .build();
    }
}
