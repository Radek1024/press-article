package com.press.article.repositories;

import com.press.article.models.Content;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ContentRepositoryTest {

    @Autowired
    ContentRepository underTestContentRepository;

    @AfterEach
    void tearDown() {
        underTestContentRepository.deleteAll();
    }

    @Test
    void should_find_articles_by_query_in_title(){
        //given
        Content content = new Content(1L,"content title","content body");
        String query = "title";
        underTestContentRepository.save(content);
        //when
        List<Content> contentList = underTestContentRepository.findAllByTitleContaining(query);
        //then
        assertEquals(1,contentList.size());
    }

    @Test
    void should_not_find_articles_by_query_in_title(){
        //given
        Content content = new Content(1L,"content title","content body");
        String query = "random query";
        underTestContentRepository.save(content);
        //when
        List<Content> contentList = underTestContentRepository.findAllByTitleContaining(query);
        //then
        assertEquals(0,contentList.size());
    }

    @Test
    void should_find_articles_by_query_in_content_body(){
        //given
        Content content = new Content(1L,"content title","Lorem ipsum dolor sit amet");
        String query = "ipsum";
        underTestContentRepository.save(content);
        //when
        List<Content> contentList = underTestContentRepository.findAllByContentBodyContaining(query);
        //then
        assertEquals(1,contentList.size());
    }

    @Test
    void should_not_find_articles_by_query_in_content_body(){
        //given
        Content content = new Content(1L,"content title","Lorem ipsum dolor sit amet");
        String query = "content";
        underTestContentRepository.save(content);
        //when
        List<Content> contentList = underTestContentRepository.findAllByContentBodyContaining(query);
        //then
        assertEquals(0,contentList.size());
    }
}