package me.hugh.springbootdeveloper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id; // DB 테이블의 id 칼럼과 매칭

    @Column(name = "name", updatable = false)
    private String name; // DB 테이블의 name 컬럼과 매칭
}
