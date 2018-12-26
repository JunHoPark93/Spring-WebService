package com.jaytech.webservice.service;

import com.jaytech.webservice.domain.posts.Posts;
import com.jaytech.webservice.domain.posts.PostsRepository;
import com.jaytech.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void DTO데이터가_posts테이블에_저장() {
        // given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("test author")
                .content("test content")
                .title("test title")
                .build();

        // when
        postsService.save(dto);

        // then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }
}
