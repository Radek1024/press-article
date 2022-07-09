package com.press.article.controllers;

import com.press.article.models.PressArticle;
import com.press.article.service.PressArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PressArticleController {
    private final PressArticleService pressArticleService;

    public PressArticleController(PressArticleService pressArticleService){
        this.pressArticleService = pressArticleService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> addArticle(@Valid @RequestBody PressArticle article){
        return new ResponseEntity<>(pressArticleService.addArticle(article), HttpStatus.CREATED);
    }

    @GetMapping(value = "/pressArticles", produces = {"application/json"})
    public ResponseEntity<List<PressArticle>> getAllArticles(){
        return ResponseEntity.ok(pressArticleService.getAllArticles());
    }

    @GetMapping(value = "/pressArticle/{id}", produces = {"application/json"})
    public ResponseEntity<PressArticle> getArticleById(@PathVariable Long id){
        return ResponseEntity.ok(pressArticleService.getArticleById(id));
    }

    @GetMapping(value = "/pressArticles/title", produces = {"application/json"})
    public ResponseEntity<List<PressArticle>> getArticleByTitle(@RequestParam String query){
        return ResponseEntity.ok(pressArticleService.getArticleByTitle(query));
    }

    @GetMapping(value = "/pressArticles/body", produces = {"application/json"})
    public ResponseEntity<List<PressArticle>> getArticleByBody(@RequestParam String query){
        return ResponseEntity.ok(pressArticleService.getArticleByBody(query));
    }

    @DeleteMapping(value = "/pressArticle/remove/{id}", produces = {"application/json"})
    public ResponseEntity<String> deleteArticle(@PathVariable Long id){
        return ResponseEntity.ok(pressArticleService.removeArticle(id));
    }

    @PutMapping(value = "/pressArticle/{id}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<String> updateArticle(@PathVariable Long id, @Valid @RequestBody PressArticle article) {
        return ResponseEntity.accepted()
                .body(pressArticleService.updateArticle(id, article));
    }


}
