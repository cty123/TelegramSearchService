package com.cty123.TelegramSearchService.adapter.dto;

import lombok.Data;

@Data
public class SearchRequestDto {
    private String keyword;
    private String requesterId;
    private int page;
    private int pageSize = 10;
}
