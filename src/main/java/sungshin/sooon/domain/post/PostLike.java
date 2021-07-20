package sungshin.sooon.domain.post;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import sungshin.sooon.domain.account.Account;

import javax.persistence.*;

@Entity
@Getter
@EqualsAndHashCode(of = "post_like_id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class PostLike {

    @Id
    @GeneratedValue
    private Long post_like_id;

    @OneToOne
    @JoinColumn(name="account_id")
    private Account account;

    @OneToOne
    @JoinColumn(name="post_id")
    private Post post;
}
