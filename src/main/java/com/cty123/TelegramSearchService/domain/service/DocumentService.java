package com.cty123.TelegramSearchService.domain.service;

import com.cty123.TelegramSearchService.adapter.dto.PublishArticleRequestDto;
import com.cty123.TelegramSearchService.adapter.dto.SearchRequestDto;
import com.cty123.TelegramSearchService.domain.entity.Article;
import com.cty123.TelegramSearchService.infrastructure.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DocumentService {

    private final ArticleRepository articleRepository;

    public List<Article> findArticleByKeywordPrecise(String keyword) {
        return this.articleRepository.findByContentLike(keyword);
    }

    public Page<Article> findArticleByKeywords(SearchRequestDto searchRequestDto) {
        return this.articleRepository.queryByContentKeywords(searchRequestDto.getKeyword(),
                PageRequest.of(searchRequestDto.getPage(), searchRequestDto.getPageSize()));
    }

    public Article publishNewArticle(PublishArticleRequestDto articleDto) {
        Article article = Article.builder()
                .id(articleDto.getId())
                .content(articleDto.getContent())
                .messageId(articleDto.getMessageId())
                .publishDate(articleDto.getPublishDate())
                .creationDate(articleDto.getCreationDate())
                .build();
        return this.articleRepository.save(article);
    }
}
