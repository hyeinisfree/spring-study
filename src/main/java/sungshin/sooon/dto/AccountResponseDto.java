package sungshin.sooon.dto;

import lombok.*;
import sungshin.sooon.domain.account.Account;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseDto {

    private Long account_id;
    private String email;
    private String nickname;

    public static AccountResponseDto from(Account account) {
        return AccountResponseDto.builder()
                .account_id(account.getAccount_id())
                .email(account.getEmail())
                .nickname(account.getNickname())
                .build();
    }
}
