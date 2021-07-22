package sungshin.sooon.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sungshin.sooon.domain.post.Post;
import sungshin.sooon.domain.post.PostRepository;
import sungshin.sooon.dto.PostDto;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 포스트 생성
    @Transactional
    public void create(PostDto postDto) {
        Post post = postDto.toPost();
        postRepository.save(post);
    }
}
