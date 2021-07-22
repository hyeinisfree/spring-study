package sungshin.sooon.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sungshin.sooon.domain.account.Account;
import sungshin.sooon.domain.account.CurrentUser;
import sungshin.sooon.dto.PostDto;
import sungshin.sooon.service.PostService;
import sungshin.sooon.util.exception.Result;
import sungshin.sooon.util.exception.ResultCode;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;
    
    @PostMapping("")
    public ResponseEntity<Result> create(@CurrentUser Account account, @RequestBody PostDto postDto) {
        if(account != null) {
            postDto.setAccount(account);
            postService.create(postDto);
            return Result.toResult(ResultCode.POST_CREATE_SUCCESS);
        }
        return Result.toResult(ResultCode.POST_CREATE_FAIL);
    }
}
