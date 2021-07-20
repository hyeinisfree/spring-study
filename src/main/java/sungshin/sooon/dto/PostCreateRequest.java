package sungshin.sooon.dto;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import sungshin.sooon.domain.account.Account;
import sungshin.sooon.domain.post.Post;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateRequest {

    private String title;

    private String content;

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
