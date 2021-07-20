package sungshin.sooon.domain.post;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import sungshin.sooon.domain.account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@EqualsAndHashCode(of = "post_id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Post {

    @Id @GeneratedValue
    private Long post_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean is_anonymous;

    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
