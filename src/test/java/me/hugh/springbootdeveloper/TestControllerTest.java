package me.hugh.springbootdeveloper;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // 테스트용 애플리케이션 컨텍스트 작성
@AutoConfigureMockMvc // MockMVC 생성
class TestControllerTest {

    @Autowired
    protected MockMvc mocMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach // 테스트 실행 전 실행하는 메서드
    public void mockMvcSetup() {
        this.mocMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach // 테스트 실행 후 실행하는 메서드
    public void cleanUp() {
        memberRepository.deleteAll();
    }

    @DisplayName("getAllMembers: 아티클 조회에 성공한다.")
    @Test
    public void getAllMembers() throws Exception {
        //given : 멤버를 저장한다.
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "홍길동"));
        //when : 멤버 리스트를 조회하는 API를 호출한다.
        final ResultActions result = mocMvc.perform(get(url)
                .accept(MediaType.APPLICATION_JSON));
        //then : 응답 코드가 200 OK이고, 반환 받은 값 중에 0번쨰 요소의 id와 name이 저장된 값과 같은지 확인한다.
        result
                .andExpect(status().isOk())
                // 응답의 0번쨰 값이 DB에서 저장한 값과 같은지 확인
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }
}