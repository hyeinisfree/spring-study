package sungshin.sooon.domain.post;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import sungshin.sooon.domain.account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@EqualsAndHashCode(of = "post_comment_id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class PostComment {

    @Id @GeneratedValue
    private Long post_comment_id;

    @Column(nullable = false)
    private String comment;


    @Column(nullable = false)
    private boolean is_anonymous;

    private Long order_num;

    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;
}
