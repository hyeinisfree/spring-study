package sungshin.sooon.util.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NicknameDuplicateException extends RuntimeException{

    private final ErrorCode errorCode;
}
