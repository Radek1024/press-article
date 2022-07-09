package com.press.article.service;

import com.press.article.exceptions.PressArticleNotFoundException;
import com.press.article.exceptions.ResourceNotFoundException;
import com.press.article.models.Content;
import com.press.article.models.PressArticle;
import com.press.article.repositories.ContentRepository;
import com.press.article.repositories.PressArticleRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PressArticleService {
    private final PressArticleRepository pressArticleRepository;
    private final ContentRepository contentRepository;

    public PressArticleService(PressArticleRepository pressArticleRepository, ContentRepository contentRepository){
        this.pressArticleRepository = pressArticleRepository;
        this.contentRepository = contentRepository;
    }

    public String addArticle(PressArticle article){
        pressArticleRepository.save(article);
        return "ok";
    }

    public List<PressArticle> getAllArticles(){
        List<PressArticle> articleList = new ArrayList<>();
        pressArticleRepository.findAll().forEach(articleList::add);
        List<PressArticle> sortedList = articleList.stream()
                .sorted(Comparator.comparing(PressArticle::getPublicationDate).reversed())
                .collect(Collectors.toList());
        return sortedList.isEmpty() ? Collections.emptyList() : sortedList;
    }

    public PressArticle getArticleById(Long id){
       return pressArticleRepository.findById(id)
               .orElseThrow(()-> new PressArticleNotFoundException(id));
    }

    public List<PressArticle> getArticleByTitle(String query){
        List<Content> byTitle = contentRepository.findAllByTitleContaining(query);
        List<PressArticle> articles = new ArrayList<>();
        if(!byTitle.isEmpty()) {
            byTitle.forEach(e->articles.add(pressArticleRepository.findById(e.getId()).get()));
        }
    return articles.isEmpty() ? Collections.emptyList() : articles;
    }

    public List<PressArticle> getArticleByBody(String query){
        List<Content> byTitle = contentRepository.findAllByContentBodyContaining(query);
        List<PressArticle> articles = new ArrayList<>();
        if(!byTitle.isEmpty()) {
            byTitle.forEach(e->articles.add(pressArticleRepository.findById(e.getId()).get()));
        }
        return articles.isEmpty() ? Collections.emptyList() : articles;
    }

    public String removeArticle(Long id) {
        PressArticle pressArticle = pressArticleRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException(id));
        pressArticleRepository.deleteById(id);

       return String.format("Removed %s ", pressArticle);
    }

    public String updateArticle(Long id, PressArticle article){
        PressArticle newArticle = pressArticleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        newArticle.setContent(article.getContent());
        newArticle.setPublicationDate(article.getPublicationDate());
        newArticle.setMagazineName(article.getMagazineName());
        newArticle.setAuthor(article.getAuthor());
        newArticle.setTimestamp(new Date());

        pressArticleRepository.save(newArticle);

        return String.format("Updated %s", newArticle);
    }

}
