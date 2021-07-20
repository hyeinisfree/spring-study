package sungshin.sooon.util.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sungshin.sooon.util.Result;
import sungshin.sooon.util.ResultCode;
import sungshin.sooon.util.ResultCode.*;

import javax.validation.ConstraintViolationException;

import java.util.List;

import static sungshin.sooon.util.ResultCode.VALID_ERROR;
import static sungshin.sooon.util.exception.ErrorCode.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailDuplicateException.class)
    protected ResponseEntity<ErrorResponse> handleEmailDuplicateException(EmailDuplicateException e){
        log.error("handleEmailDuplicateException : {}", e.getErrorCode());
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }

    @ExceptionHandler(NicknameDuplicateException.class)
    protected ResponseEntity<ErrorResponse> handleNicknameDuplicateException(NicknameDuplicateException e){
        log.error("handleNicknameDuplicateException : {}", e.getErrorCode());
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e){
        log.error("handleException : {}" , INTER_SERVER_ERROR);
        return ErrorResponse.toResponseEntity(INTER_SERVER_ERROR);
    }

    @ExceptionHandler(value = { ConstraintViolationException.class, DataIntegrityViolationException.class})
    protected ResponseEntity<ErrorResponse> handleDataException() {
        log.error("handleDataException throw Exception : {}", DUPLICATE_RESOURCE);
        return ErrorResponse.toResponseEntity(DUPLICATE_RESOURCE);
    }

    @ExceptionHandler(value = { CustomException.class })
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }
}
