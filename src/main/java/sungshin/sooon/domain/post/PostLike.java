package sungshin.sooon.domain.post;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import sungshin.sooon.domain.account.Account;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_like_id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name="account_id")
    private Account account;

    @OneToOne
    @JoinColumn(name="post_id")
    private Post post;
}
