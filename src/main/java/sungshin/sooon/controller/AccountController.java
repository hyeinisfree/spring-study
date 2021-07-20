package sungshin.sooon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import sungshin.sooon.dto.LoginRequest;
import sungshin.sooon.dto.RegisterRequest;
import sungshin.sooon.dto.TokenDto;
import sungshin.sooon.service.AccountService;
import sungshin.sooon.util.Result;
import sungshin.sooon.util.ResultCode;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AccountController {

    private final AccountService accountService;

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<Result<TokenDto>> login(@RequestBody LoginRequest loginRequest) {
        TokenDto data = accountService.login(loginRequest);
        return Result.toResult(ResultCode.LOGIN_SUCCESS, data);
    }

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<Result<List<Map<String, String>>>> signup(@RequestBody @Valid RegisterRequest registerRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<Map<String, String>> data = new ArrayList<>();
            for(FieldError fieldError : bindingResult.getFieldErrors()) {
                Map<String, String> item = new HashMap<>();
                item.put(fieldError.getField(), fieldError.getDefaultMessage());
                data.add(item);
            }
            return Result.toResult(ResultCode.VALID_ERROR, data);
        }
        accountService.register(registerRequest);
        return Result.toResult(ResultCode.SIGNUP_SUCCESS, null);
    }

    // 이메일 중복 체크
    @GetMapping("/checkEmail/{email}")
    public ResponseEntity<Result> checkEmail(@PathVariable String email) {
        accountService.checkEmail(email);
        return Result.toResult(ResultCode.CHECK_EMAIL_SUCCESS);
    }

    // 닉네임 중복 체크
    @GetMapping("/checkNickname/{nickname}")
    public ResponseEntity<Result> checkNickname(@PathVariable String nickname) {
        accountService.checkNickname(nickname);
        return Result.toResult(ResultCode.CHECK_NICKNAME_SUCCESS);
    }
}
