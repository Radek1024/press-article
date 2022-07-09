package com.press.article.repositories;

import com.press.article.models.PressArticle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PressArticleRepository extends CrudRepository<PressArticle,Long>{

}
