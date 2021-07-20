package sungshin.sooon.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ResultCode {

    LOGIN_SUCCESS(OK, "로그인 성공"),
    SIGNUP_SUCCESS(CREATED, "회원가입 성공"),
    VALID_ERROR(BAD_REQUEST, "유효성 검사 실패"),
    CHECK_EMAIL_SUCCESS(OK, "사용가능한 이메일입니다"),
    CHECK_NICKNAME_SUCCESS(OK, "사용가능한 닉네임입니다"),
    ;

    private final HttpStatus httpStatus;
    private final String detail;
}
