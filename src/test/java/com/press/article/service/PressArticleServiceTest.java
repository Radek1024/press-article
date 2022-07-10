package com.press.article.service;

import com.press.article.models.Author;
import com.press.article.models.Content;
import com.press.article.models.PressArticle;
import com.press.article.repositories.ContentRepository;
import com.press.article.repositories.PressArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PressArticleServiceTest {

    @Mock
    private PressArticleRepository pressArticleRepository;
    private ContentRepository contentRepository;
    private PressArticleService underTest;

    @BeforeEach
    void setUp() {
        underTest = new PressArticleService(pressArticleRepository, contentRepository);
    }

    @Test
    void can_add_article() {
        //given
        Content content = new Content(1L,"just title","Just some content body");
        Author author = new Author(1L,"John","Doe");
        Date publicationDate = new Date();
        String magazineName = "The Programmer";
        PressArticle pressArticle = new PressArticle();
        pressArticle.setContent(content);
        pressArticle.setAuthor(author);
        pressArticle.setMagazineName(magazineName);
        pressArticle.setPublicationDate(publicationDate);

        //when
        underTest.addArticle(pressArticle);

        //then
        ArgumentCaptor<PressArticle> pressArticleArgumentCaptor =
                ArgumentCaptor.forClass(PressArticle.class);

        Mockito.verify(pressArticleRepository).save(pressArticleArgumentCaptor.capture());
        PressArticle capturedPressArticle = pressArticleArgumentCaptor.getValue();
        assertEquals(capturedPressArticle,pressArticle);
    }

    @Test
    void can_get_all_articles() {
        //when
        underTest.getAllArticles();
        //then
        Mockito.verify(pressArticleRepository).findAll();
    }

    @Test
    void getArticleById() {

    }

    @Test
    void getArticleByTitle() {
    }

    @Test
    void getArticleByBody() {
    }

    @Test
    void removeArticle() {
    }

    @Test
    void updateArticle() {
    }
}