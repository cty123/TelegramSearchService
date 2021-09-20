package com.cty123.TelegramSearchService.adapter.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PublishArticleRequestDto {
    private final Date creationDate = new Date();
    private String id;
    private String content;
    private String messageId;
    private Date publishDate;
}
