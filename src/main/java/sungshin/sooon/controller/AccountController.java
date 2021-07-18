package sungshin.sooon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sungshin.sooon.dto.LoginRequest;
import sungshin.sooon.dto.RegisterRequest;
import sungshin.sooon.dto.TokenDto;
import sungshin.sooon.service.AccountService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AccountController {

    private final AccountService accountService;

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(accountService.login(loginRequest));
    }

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody @Valid RegisterRequest registerRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            bindingResult.getAllErrors()
                    .forEach(objectError-> {
                        System.err.println("code : " + objectError.getCode());
                        System.err.println("defaultMessage : " + objectError.getDefaultMessage());
                        System.err.println("objectName : " + objectError.getObjectName());
                    });
            return ResponseEntity.badRequest().body("회원가입 실패");
        }

        accountService.register(registerRequest);
        return ResponseEntity.ok("회원가입 성공");
    }

    // 이메일 중복 체크
    @GetMapping("/checkEmail/{email}")
    public ResponseEntity checkEmail(@PathVariable String email) {
        boolean check = accountService.checkEmail(email);
        if(check) {
            return ResponseEntity.badRequest().body("이미 사용 중인 이메입니다.");
        } else {
            return ResponseEntity.ok("사용 가능한 이메일임입니다.");
        }
    }

    // 닉네임 중복 체크
    @GetMapping("/checkNickname/{nickname}")
    public ResponseEntity checkNickname(@PathVariable String nickname) {
        boolean check = accountService.checkNickname(nickname);
        if(check) {
            return ResponseEntity.badRequest().body("이미 사용 중인 닉네임입니다.");
        } else {
            return ResponseEntity.ok("사용 가능한 닉네임입니다.");
        }
    }
}
