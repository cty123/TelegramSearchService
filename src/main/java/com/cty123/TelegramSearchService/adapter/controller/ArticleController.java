package com.cty123.TelegramSearchService.adapter.controller;

import com.cty123.TelegramSearchService.adapter.dto.PublishArticleRequestDto;
import com.cty123.TelegramSearchService.adapter.dto.SearchRequestDto;
import com.cty123.TelegramSearchService.domain.entity.Article;
import com.cty123.TelegramSearchService.domain.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@AllArgsConstructor
public class ArticleController {

    private final DocumentService documentService;

    @GetMapping("/search")
    public Page<Article> searchArticle(SearchRequestDto searchRequestDto) {
        return documentService.findArticleByKeywords(searchRequestDto);
    }

    @PostMapping("/publish")
    @ResponseBody
    public Article postArticle(@RequestBody PublishArticleRequestDto articleDto) {
        return documentService.publishNewArticle(articleDto);
    }
}
