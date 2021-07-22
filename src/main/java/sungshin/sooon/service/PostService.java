package sungshin.sooon.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sungshin.sooon.domain.post.Post;
import sungshin.sooon.domain.post.PostRepository;
import sungshin.sooon.dto.PostRequestDto;
import sungshin.sooon.dto.PostResponseDto;
import sungshin.sooon.util.exception.ResourceNotFoundException;
import sungshin.sooon.util.exception.ResultCode;

import javax.persistence.EntityExistsException;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 포스트 생성
    @Transactional
    public void create(PostRequestDto postRequestDto) throws EntityExistsException {
        Post post = postRequestDto.toPost();
        postRepository.save(post);
    }

    // 포스트 조회
    @Transactional
    public PostResponseDto readOne(Long postId) {
        return PostResponseDto.from(postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException(ResultCode.POST_NOT_FOUND)));
    }
}
