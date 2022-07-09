package com.press.article.repositories;

import com.press.article.models.Content;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends CrudRepository<Content,Long> {
    List<Content> findAllByTitleContaining(String query);
    List<Content> findAllByContentBodyContaining(String query);
}
