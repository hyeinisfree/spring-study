package sungshin.sooon.domain.post;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import sungshin.sooon.domain.account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostComment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_comment_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String comment;


    @Column(nullable = false)
    private boolean isAnonymous;

    @Column(nullable = false)
    private Long orderNum;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;
}
