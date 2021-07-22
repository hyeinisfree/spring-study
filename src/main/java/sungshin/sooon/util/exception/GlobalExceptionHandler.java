package sungshin.sooon.util.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailDuplicateException.class)
    protected ResponseEntity<Result> handleEmailDuplicateException(EmailDuplicateException e){
        log.error("handleEmailDuplicateException : {}", e.getResultCode());
        return Result.toResult(e.getResultCode());
    }

    @ExceptionHandler(NicknameDuplicateException.class)
    protected ResponseEntity<Result> handleNicknameDuplicateException(NicknameDuplicateException e){
        log.error("handleNicknameDuplicateException : {}", e.getResultCode());
        return Result.toResult(e.getResultCode());
    }

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
       return new ResponseEntity<>(ex.getBindingResult().getAllErrors().get(0).getCode(), HttpStatus.BAD_REQUEST);
    }
}
