package me.hugh.springbootdeveloper.dto;

import lombok.Getter;
import me.hugh.springbootdeveloper.domain.Article;

// GetMapping 방식으로 데이터를 반환 해줄 떄 사용하는 DTO
@Getter
public class ArticleResponse {

    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
