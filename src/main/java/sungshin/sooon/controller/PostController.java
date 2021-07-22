package sungshin.sooon.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sungshin.sooon.domain.account.Account;
import sungshin.sooon.domain.account.CurrentUser;
import sungshin.sooon.domain.post.Post;
import sungshin.sooon.dto.PostRequestDto;
import sungshin.sooon.service.PostService;
import sungshin.sooon.util.exception.Result;
import sungshin.sooon.util.exception.ResultCode;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;
    
    @PostMapping("")
    public ResponseEntity<Result> create(@CurrentUser Account account, @RequestBody @Valid PostRequestDto postRequestDto) {
        if(account != null) {
            postRequestDto.setAccount(account);
            postService.create(postRequestDto);
            return Result.toResult(ResultCode.POST_CREATE_SUCCESS);
        }
        return Result.toResult(ResultCode.POST_CREATE_FAIL);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Result<Post>> readOne(@PathVariable Long postId) {
        Post data = postService.readOne(postId);
        return Result.toResult(ResultCode.POST_READ_SUCCESS, data);
    }

//    @PatchMapping("/{postId}")
//    public ResponseEntity<Result> update(@CurrentUser Account account, @PathVariable Long postId) {
//
//    }
}
