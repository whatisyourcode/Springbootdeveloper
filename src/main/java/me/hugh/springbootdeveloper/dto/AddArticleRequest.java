package me.hugh.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.hugh.springbootdeveloper.domain.Article;

@NoArgsConstructor // 기본 생성자 추가
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
// PostMapping 방식으로 데이터를 DB에 저장할 떄 사용하는 DTO
public class AddArticleRequest {
    private String title;
    private String content;

    // Builder 패턴으로 객체 생성 후 반환
    public Article toEntity(){
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
