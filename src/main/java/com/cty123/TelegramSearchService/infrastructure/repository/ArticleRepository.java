package com.cty123.TelegramSearchService.infrastructure.repository;

import com.cty123.TelegramSearchService.domain.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
    List<Article> findByContentLike(String keyword);

    @Query("{\"match\": {\"content\": {\"query\": \"?0\"}}}")
    Page<Article> queryByContentKeywords(String keywords, Pageable pageable);
}
