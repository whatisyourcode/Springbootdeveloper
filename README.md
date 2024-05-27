- Part 2
    
    ## RDB
    
    RDB는 Relational Database의 약자로 관계형 데이터베이스라는 뜻이다.
    
    RDB가 아닌 데이터베이스를 NoSQL 또는 NewSQL로 구분한다.
    
    관계형 데이터베이스는 데이터를 행(row)과 열(column)로 이루어진 테이블로 관리하며, 기본 키(primary key)를 사용하여 각 행을 식별한다.또한 각 테이블 간에 관계를 지을 수 있다.
    
    ## SQL
    
    ## NoSQL 이란?
    
    NoSQL의 뜻이 SQL을 안 쓴다는 의미로 사용되기도 한다.
    
    ## 백엔드 개발자의 업무
    
    과제 할당 → **과제 분석 → 개발 → 테스트** → QA → 배포 → 유지보수
    
                    (이 3단계 반복하면서 프로그램 완성도 up) 
    
    ## CI / CD
    
    CI → Continuous Intergration  , CD → Continuous Delivery & Continuous Development
    
    CI는 지속적인 통합이라는 뜻으로, 새로운 코드 변경 사항이 정기적으로 빌드 및 테스트디어 저장소에 통합되는 것을 의미한다.
    
    CD는 지속적인 배포라는 뜻이다.
    
    정리하자면 CI는 저장소에 코드가 반영되는 것을 말하고, CD는 실제 프로덕션 환경까지 변경된 코드가 반영되는 것을 의미한다.
    
    스프링 프레임워크 vs 스프링 부트 
    
    |  | 스프링 | 스프링 부트 |
    | --- | --- | --- |
    | 목적 | 엔터프라이즈 애프리케이션 개발을 더 쉽게 만들기 | 스프링의 개발을 더 빠르고 쉽게 하기 |
    | 설정 파일 | 개발자가 수동으로 설정  | 자동 구성 |
    | XML | 일부 파일은 XML을 직접 생성하고 관리 | 사용하지 않음 |
    | 인메모리 데이터베이스 지원 | 지원하지 않음 | 인메모리 데이터베이스 자동 설정 지원 |
    | 서버 | 프로젝트를 띄우는 서버(예: 톰캣,제티)를 별도로 수동 설정 | 내장형 서버를 제공해 별도의 설정이 필요없음. |
    
    ## 제어의 역전과 의존성 주입
    
    ## IoC(제어의 역전)이란?
    
    IoC는 Inversion of Control을 줄인 표현이다.
    
    기존에는 클래스 A에서 클래스 B를 사용하기 위해 내부에 클래스 B를 직접 생성하는 방식을 사용했다.
    
    ```java
    public class A {
    	b = new B();
    }
    ```
    
    제어 역전을 적용하면 아래와 같은 형태로 클래스 B 객체를 직접 생성하는 것이 아닌, 외부에서 관리하는 객체를 가져와 사용하는 형태가 된다.
    
    ```java
    public class B {
    	private B b;
    }
    ```
    
    ## DI(의존성 주입)란?
    
    스프링에서는 객체들을 관리하기 위해 앞에서 설명한 IoC(제어의 역전)을 사용한다.그리고 제어 역전을 구현하기 위해 사용하는 방법이 DI(Dependency Injection)이다.
    
    아래의 코드는 @Autowired 애너테이션을 사용해 스프링 컨테이너에 있는 빈 객체(클래스 B)를 클래스 A에 주입받아 사용하는 과정이다.(빈 객체는 런타임 떄 스프링이 빈으로 등록된 객체들을 스프링 컨테이너에 자동으로 등록 및 관리한다.)
    
    *빈은 쉽게 말해 스프링 컨테이너에서 관리하는 객체를 말한다.
    
    ```java
    public class A {
    	// A에서 B를 주입받음
    	@Autowired
    	B b;
    }
    ```
    
    ## 스프링 컨테이너란?
    
    스프링 컨테이너는 빈을 생성하고 관리한다.
    
    빈이 생성되고 소멸되기까지의 생명주기를 이 스프링 컨테이너가 관리하는 것이다.
    
    또한 개발자가 @Autowired 같은 애너테이션을 사용해 빈을 주입받을 수 있게 DI를 지원하기도 한다.
    
    ## 빈이란?
    
    앞서 설명했지만 빈은 스프링이 스프링 컨테이너가 생성하고 관리하는 객체이다.
    
    스프링은 빈을 스프링 컨테이너에 등록하기 위해 XML 파일 설정, 애너태이션 추가 등 여러 방법을 제공한다.
    
    ```java
    @Component
    public class myBean{
    }
    ```
    
    ## AOP(관점 지향 프로그래밍)
    
    AOP(Aspect Oriented Programming)을 줄인 표현으로, 직역하면 관점 지향 프로그래밍이다.
    
    프로그래밍에 대한 관심을 핵심 관점,부가 관점으로 나누어서 관심 기준으로 모듈화하는 것을 의미한다.
    
    예를 들어 계좌이체 기능인 프로그램을 만들 때 주요 계좌이체 로직 뿐만 아니라, 로깅 로직, 데이터베이스 연결 로직 등이 필요하다.
    
    이 때 핵심 관점은 계좌이체 로직이고 , 부가 관점은 로깅,데이터베이스 연결 로직이다.
    
    부가 관점 로직 코드를 핵심 관점 코드에서 분리하여 핵심 관점 코드에 집중할 수 있도록 모듈화하는 것이 AOP의 장점이다.
    
    ## PSA
    
    PSA(Portable Service Abstraction)을 줄인 표현으로서 스프링에서 제공하는 다양한 기술을 추상화해 개발자가 쉽게 사용하는 인터페이스를 의미한다.
    
    대표적인 PSA의 예는 클라이언트의 매핑과 클래스,메서드의 매핑을 위한 애너테이션이다.
    
    예를 들어 스프링에서는 데이터베이스를 접근하기 위한 기술로 JPA,MyBatis,JDBC 같은 것들이 있는데 , 여기에서 어떤 기술을 사용하던 일관된 방식으로 데이터베이스에 접근하도록 인터페이스를 지원한다.
    
    (결론)
    
    스프링 프레임워크는 Ioc/DI를 통해 객체간의 의존 관계를 설정하고, AOP를 통해 핵심관점과 부가 로직을 분리해 개발하며,PSA를 통해 추상화된 다양한 서비스를 일관된 방식으로 사용하도록 한다.
    
    - IoC : 객체의 생성과 관리를 개발자가 하는 것이 아닌 프레임워크가 대신하는 것.
    - DI : 외부에서 객체를 주입받아 사용하는 것.
    - AOP : 프로그래밍을 할 떄 핵심 관점과 부가 관점을 나누어서 개발하는 것.
    - PSA : 어느 기술을 사용하던 일관된 방식으로 처리하는 것.
    
    ## 스프링 부트 스타터
    
    스프링 부트 스타터는 의존성이 모여있는 그룹이다.스타터를 사용하면 필요한 기능을 build.gradle 파일 내에서 간편하게 설정할 수 있다.
    
    스타터는 spring-boot-starter-{작업유형} 이라는 명명규칙을 사용한다.이 규칙을 잘 기억해 두고 필요한 기능을 찾으면 스타터를 쉽게 찾을 수 있다.
    
    - spring-boot-starter-web :Spring MVC를 사용해서 RESTful 웹 서비스를 개발할 떄 필요한 의존성모음.
    - spring-boot-starter-test : 스프링 어플리케이션을 테스트하기 위해 필요한 의존성 모음
    - spring-boot-starter-validation : 유효성 검사를 위해 필요한 의존성 모음
    - spring-boot-starter-actuator : 모니터링을 위해 어플리케이션에서 제공하는 다양한 정보를 제공하기 쉽게 하는 의존성 모음.
    - spring-boot-starter-data-jpa : ORM을 사용하기 위한 인터페이스의 모음인 JPA를 더 쉽게 사용하기 위한 의존성 모음.
    
    ## 자동 구성
    
    자동 구성은 스프링 부트의 중요한 개념이다.스프링 부트에서는 애플리케이션이 최소한 설정으로도 실행되게 여러 부분을 자동으로 구성한다.
    
    스프링 부트는 서버를 시작할 때 구성 파일을 읽어와서 설정한다.이를 자동 설정이라고 한다.
    
    자동 설정은 META-INF에 있는 spring.factories 파일에 담겨져 있다.
    
    ‘돋보기 → Files 선택 → spring-boot-autoconfigure/spring.factories  입력  후 첫번째 파일 선택 ‘ 
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a44870d4-429c-440a-a7e8-d2071ad7a9c8/9204903b-d81e-4860-884f-64394de9525c/Untitled.png)
    
    스프링 부트를 시작할 때 이 파일에 설정되어 있는 클래스는 모두 불러오고 , 이후에는 프로젝트에서 사용할 것들만 자동으로 구성해 등록한다.
    
    실제로 왼쪽 프로젝트 구성에서 External Libraries 폴더에 미리 구현되어 있는 자동 설정 파일을 확인할 수 있다.
    
    이렇게 스프링 부트에서는 빈이 자동으로 등록되고 구성된다. 만약 자동 구성이 없다면 개발자가 특정 기술을 사용할 때마다 설정해야 하는 값을 모두 개발자가 직접 설정해줘야 한다.
    
    # 스프링 부트 3 코드 이해하기
    
    ## @SpringBootApplication
    
    ```jsx
    @SpringBootApplication
    public class SpringbootDeveloperApplication {
        public static void main(String[] args) {
            SpringApplication.run(SpringbootDeveloperApplication.class, args);
        }
    }
    
    ```
    
    이 클래스는 자바의 main() 메서드와 같은 역할을 하며 여기서 스프링 부트가 시작된다.
    
    - @SpringBootApplication 애너테이션을 추가하면 스프링 부트 사용에 필요한 기본 설정을 해준다.
    - SpringApplication.run() 메서드는 어플리케이션을 실행한다.
    - 첫 번째 인수로는 스프링 부트3 어플리케이션의 메인 클래스로 사용할 클래스 , 두 번째 인수는 커맨드 라인의 인수들을 전달한다.
    
    ```java
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Inherited
    @SpringBootConfiguration
    @EnableAutoConfiguration
    @ComponentScan(
        excludeFilters = {@Filter(
        type = FilterType.CUSTOM,
        classes = {TypeExcludeFilter.class}
    ), @Filter(
        type = FilterType.CUSTOM,
        classes = {AutoConfigurationExcludeFilter.class}
    )}
    )
    ```
    
    ### @SpringBootConfiguration
    
    스프링 부트 관련 설정을 나타내는 애너테이션이다.@Configuration을 상속해서 만든 애너테이션이다.
    
    ### @ComponentScan
    
    사용자가 등록한 빈을 읽고 등록하는 애너테이션이다.이 애너테이션은 @Component라는 애너테이션을 가진 클래스를 찾아 빈으로 등록하는 역할을 한다.
    
    그렇다고 모든 빈에 @Component만 사용하는게 아니다.@Component를 감싸는 애너테이션이 있는데 실제 개발을 하면 @Component 애너테이션 보다는 용도에 따라 다른 애너테이션을 사용하고 있따.(아래와 같다.)
    
    | 애너테이션명 | 설명 |
    | --- | --- |
    | @Configuration | 설정 파일 등록 |
    | @Repository | ORM 매핑 |
    | @Controller , RestController | 라우터 |
    | @Service | 비즈니스 로직 |
    |  |  |
    
    ### @EnableAutoConfiguration
    
    스프링 부트에서 자동 구성을 활성화하는 애터네이션이다.이 애너테이션은 스프링 부트 서버가 실행될 떄 스프링 부트의 메타 파일을 읽고 정의된 설정들을 자동으로 구성하는 역할을 수행한다.
    
    “자동 구성” 파트에서 보았던 spring.factories 파일에 클래스들이 모두 @EnableAutoConfiguration을 사용할 떄 자동 설정된다.
    
    ## 테스트 컨트롤러 살펴보기
    
    ```java
    @RestController
    public class TestController {
    	@GetMapping("/test")
    	public String test() {
    		return "Hello World";
    	}
    }
    ```
    
    - @RestController는 라우터 역할을 하는 애너테이션이다.
    - 라우터란 HTTP 요청과 메서드를 연결하는 장치를 말한다.(네트워크의 라우터랑은 다른 라우터 개념). 이 애너테이션이 있어야 클라이언트의 요청에 맞는 메서드를 실행할 수 있다.
    - TestController를 라우터로 지정해 /test라는 GET 요청이 왔을 떄 test() 메서드를 실행하도록 구성했다.
    - @RestContorller와 @Component는 애너테이션 용어가 다른데 어떻게 같은 @Component처럼 취급하는 걸까?
    
    ```java
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Controller
    @ResponseBody
    public @interface RestController {
        @AliasFor(
            annotation = Controller.class
        )
        String value() default "";
    }
    
    ```
    
    - 위의 RestController 클래스는 @Controller 애너테이션과 @ResponseBody 애너테이션으로 이루어져있다.
    - @Component 애너테이션을 아직 찾지 못했으니 Controller 클래스로 이동해보자.
    
    ```java
    
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Component
    public @interface Controller {
        @AliasFor(
            annotation = Component.class
        )
        String value() default "";
    }
    ```
    
    - @Component 애너테이션을 발견했다.
    - @Controller 애너테이션이 @ComponentScan을 통해 빈으로 등록되는 이유를 알았다.
    - 그 이유는 바로 @Controller 애너테이션에서 @Component 애너테이션을 가지고 있기 떄문이다.
    - 앞서 소개한 @Configuration , @Repository , @Service 애너테이션도 모두 @Component 스캔을 가지고 있다.
    - 다만 빈이 무슨 역할을 하는지 명확하게 구분하기 위해 다른 이름으로 덮어 두었을 뿐이다.
    
    ## 핵심 요약
    
    1. 스프링은 엔터프라이즈 어플리케이션을 쉽게 개발할 수 있또록 도와주는 프레임워크이다.
    2. IoC는 제어의 역전 , DI는 의존성 주입을 뜻한다.
    3. 스프링 부트는 스프링을 더 빠르게 쉽게 사용하기 위한 도구로서 스타터와 자동 구성을 제공한다.
    4. 애너테이션은 자바 소스 코드에 추가하는 표식이다. JDK 1.5 버전부터 사용 가능하며, 다양한 목적으로 사용되지만 메타 데이터(데이터에 대한 설명을 담고 있는 데이터)의 비중이 가장 크다.
    5. @SpringBootApplication은 스프링 부트 관련된 설정을 하는 @SpringBootConfiguration, 사용자가 등록한 빈을 읽고 등록하는 @ComponentScan , 자동 설정으로 등록되는 빈을 읽고 등록하는 @EnableAutoConfiguration 으로 이루어져있다.
    6. @Component 애너테이션이 있는 클래스는 빈으로 등록되며, @Controller, @RestController, @Configuration, @Repository, @Service 모두 @Component  애너테이션을 가지고 있다.
    
- Part 3
    
    # 스프링 부트 3 구조 살펴보기
    
    스프링 부트는 각 계층이 양 옆의 계층과 통신하는 구조를 따른다.
    
    ‘계층’이라는 것은 각자의 역할과 책임이 있는 어떤 소프트웨어 구성 요소를 의미하며 각 계층은 서로 소통할 수 있지만 다른 계층에 직접 간섭하거나 영향을 미치지 않는다.
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a44870d4-429c-440a-a7e8-d2071ad7a9c8/883e5b2c-26c7-4b94-95d2-005ec414433f/Untitled.png)
    
    ## 프레젠테이션 계층
    
    HTTP 요청을 받고 이 요청을 비지니스 계층으로 전송하는 역할을 한다.
    
    컨트롤러가 프레젠테이션 계층 역할을 하며 스프링 부트 내에 여러개가 있을 수 있다.
    
    컨트롤러가 이 프레젠테이션 계층의 역할을 한다.
    
    ## 비지니스 계층
    
    모든 비지니스 로직을 처리한다.비즈니스 로직이란 서비스를 만들기 위한 로직을 말한다.
    
    이를테면 주문 서비스라고 한다면 주문 개수,가격 등의 데이터를 처리하기 위한 로직, 주문을 처리하다가 발생하는 예외 처리 로직,주문을 받고 취소하는 로직 같이 프로세스를 구현하기 위한 로직이라고 생각하면 된다.
    
    서비스가 비즈니스 계층의 역할을 한다.
    
    ## 퍼시스턴스 계층
    
    모든 데이터베이스 관련 로직을 처리한다.이 과정에서 데이터베이스에 접근하는 DAO 객체를 사용할 수 있다.
    
    DAO는 데이터베이스 계층과 상호작용하기 위한 객체라고 이해하기 쉽다.
    
    리포지토리가 퍼시스턴스 계층의 역할을 한다.
    
    ## 폴더 및 파일
    
    - templates
    - static : JS , CSS 같은 정적 파일을 담는 디렉토리
    - application.yml : 이 파일은 스프링 부트 서버가 실행되면 자동으로 로딩되는 파일이며, 데이터 베이스 설정 정보,로깅 설정 정보등이 들어갈 수 있고, 직접 설정을 정의할 떄 사용되기도 한다.
    
    ## Build.gradle에 의존성 추가하기
    
    ```java
    dependencies {
    		// 스프링 데이터 JPA
    	  implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
        runtimeOnly 'com.h2database:h2' // 인메모리 데이터베이스
        compileOnly 'org.projectlombok:lombok' // 롬복
        annotationProcessor 'org.projectlombok:lombok'
    }
    ```
    
    ## 코드 작성
    
    ### 프레젠테이션 계층
    
    ```java
    @RestController
    public class TestController {
    
        @Autowired // TestService 빈 주입
        TestService testService;
    
        @GetMapping("/test")
        public List<Member> getAllMember() {
            List<Member> members = testService.getAllMembers();
            return members;
        }
    }
    
    ```
    
    ### 비즈니스 계층
    
    ```java
    @Service
    public class TestService {
    
        @Autowired
        MemberRepository memberRepository;
    
        public List<Member> getAllMembers(){
            return memberRepository.findAll();
        }
    }
    
    ```
    
    ### 퍼시스턴스 계층
    
    - DB에 접근할 때 사용할 객체인 Member DAO를 생성
    
    ```java
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
    
    ```
    
    - 실제 member 테이블과 Member 클래스를 매핑하는 코드를 작성
    
    ```java
    @Service
    public class TestService {
        @Autowired
        MemberRepository memberRepository;
    
        public List<Member> getAllMembers(){
            return memberRepository.findAll();
        }
    }
    ```
    
    ## 작동 확인하기
    
    - 지금은 결과물을 볼 수 있는 데이터가 데이터베이스에 하나도 입력되지 않은 상태이다.
    - 보통은 이런 실행 테스트를 하기 위해 어플리케이션을 실행할 떄마다 SQL 문을 실행해 데이터베이스에 직접 데이터를 넣는다.
    - 현재는 인메모리 데이터베이스(h2)를 사용하고 있기 떄문에 새로 실행할 떄마다 데이터가 사라지는 불편함이 있다.
    - 이를 해결하기 위해 더미 데이터를 넣을 SQL 파일을 생성해보았다.
    
    ```sql
    INSERT INTO member (id, name) VALUES (1, 'name 1')
    INSERT INTO member (id, name) VALUES (2, 'name 2')
    INSERT INTO member (id, name) VALUES (3, 'name 3')
    ```
    
    - application.yml 파일 설정
    - show-sql,format-sql 옵션은 애플리케이션 실행 과정에 데이터베이스에 쿼리를 할 일이 있으면 실행 구문을 모두 보여주는 옵션이다.
    - defer-datasource-intialization 옵션은 애플리케이션이 실행할 떄 테이블을 생성하고 data.sql 파일에 있는 쿼리를 실행하도록 하는 옵션이다.
    
    ```sql
    spring :
      jpa :
        # 전송 쿼리 확인
        show-sql: true
        properties:
          hibername:
            format_sql: true
    
        # 테이블 생성 후 data.sql 실행
        defer-datasource-initialization: true
    ```
    
    ## 최종 동작 과정
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a44870d4-429c-440a-a7e8-d2071ad7a9c8/a95bafb4-2b61-4680-934e-a029271b91df/Untitled.png)
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a44870d4-429c-440a-a7e8-d2071ad7a9c8/c0e026fe-a271-4e76-a0b8-ef85879b4d8b/Untitled.png)
    
    1. 포스트맨에서 톰캣에 /test GET 요청을 한다.이 요청은 스프링 부트 내로 이동한다.
    2. 이 떄 스프링 부트의 디스패처 서블릿이라는 녀석이 URL을 분석하고, 이 요청을 처리할 수 있는 컨트롤러를 찾는다.
        
        TestController가 /test 라는 path에 대한 GET 요청을 처리할 수 있는 getAllMembers() 메서드를 가지고 있으므로 디스패치 서블릿은 TestController에게 /test GET 요청을 전달한다.
        
    3. /test GET 요청을 처리할 수 있는 getAllMembers() 메서드와 이 요청이 매칭되고 , getAllMembers() 메서드에서는 비즈니스 계층과 퍼시스턴스 계츠응ㄹ 통하면서 필요한 데이터를 가져온다.
    4. 뷰 리졸버는 템플릿 엔진을 사용하여 HTML 문서를 만들거나 JSON,XML 등의 데이터를 생성한다.
    5. 그 결과 members를 return 하고 그 데이터를 포스트맨에서 볼 수 있게 된다.
- Part 4
    
    # 테스트 코드 개념 익히기
    
    테스트 코드는 작성한 코드가 의도대로 잘 작동하고 예상치 못한 문제가 없는지 확인할 목적으로 작성하는 코드이다.
    
    테스트 코드에는 다양한 패턴이 중에 사용할 패턴은 ‘given-when-then 패턴’이다.
    
    ### give-when-then
    
    - given-when-then 패턴은 테스트 코드를 세 단계로 구분해 작성하는 방식을 말한다.
        1. given은 테스트 실행을 준비하는 단계
        2. when은 테스트를 진행하는 단계
        3. then은 테스트 결과를 검증하는 단계
    - 예시
    
    ```java
    @DisplayNmae("새로운 메뉴를 저장한다.")
    @Test
    public void saveMenuTest() {
    	// given : 메뉴를 저장하기 위한 준비 과정
    	final String name="아메리카노"
    	final int price=2000;
    	
    	final Menu americano = new Menu(name, price);
    	
    	// when : 실제 메뉴를 저장
    	final long saveId = menuService.save(americano);
    	
    	// then : 메뉴가 잘 추가되어있는지 검증
    	final Menu saveedMenu = menuService.findById(saveId).get();
    	assertThat(savedMenu.getName()).isEqualTo(name);
    	assertThat(savedMenu.getPrice()).isEqualTo(price);  
    }
    ```
    
    ## 스프링 부트3와 테스트
    
    ### JUnit이란?
    
    JUnit은 자바 언어를 위한 단위 테스트 프레임워크이다.
    
    단위 테스트란, 작성된 코드가 의도대로 작동하는지 작은 단위로 검증하는 것을 의미한다.이 떄 단위는 보통 메서드가 된다.
    
    ### JUNIT 특징
    
    - 테스트 방식을 구분할 수 있는 애너테이션 제공
    - @Test 애너테이션으로 메서드를 호출할 떄마다 새 인스턴스를 생성, 독립 테스트 가능.
    - 예상 결과를 검증하는 어설션 메서드 제공
    - 자동 실행,자체 결과를 확인하고 즉각적인 피드백 제공.
    - Junit은 테스트끼리 영향을 주지 않도록 각 테스트를 실행할 떄마다 테스트를 위한 실행 객체를 만들고 테스트가 종료되면 실행 객체를 삭제한다.
    
    ```java
    public class JUnitTest {
        @DisplayName("1 + 2는 3이다") // 테스트 이름
        @Test
        public void junitTest() {
            int a = 1;
            int b = 2;
            int sum = 3;
    
            Assertions.assertEquals(sum, a + b);
        }
    }
    ```
    
    - JUnit은 각 테스트에 대해 객체를 만들어 독립적으로 실행한다고 했다.
    - 그 내용을 확인해보기 위해 테스트용 메서드를 여러개 만들어보았다.
    - 또 테스트는 애너테이션에 따라 실행 순서가 정해진다.
    
    ```java
    import org.junit.jupiter.api.*;
    
    public class JUnitCycleTest {
        @BeforeAll // 전체 테스트를 시작하기 전에 1회 실행하므로 메서드는 static으로 선언
        static void befoeAll(){
            System.out.println("@BeforeAll");
        }
    
        @BeforeEach // 테스트 케이스를 시작하기 전마다 실행
        public void beforeEach() {
            System.out.println("@BeforeEach");
        }
    
        @Test
        public void test1(){
            System.out.println("test1");
        }
    
        @Test
        public void test2(){
            System.out.println("test2");
        }
    
        @Test
        public void test3(){
            System.out.println("test3");
        }
    
        @AfterAll // 전체 테스트를 마치고 종료하기 전에 1회 실행하므로 메서드는 static으로 선언
        static void afterAll(){
            System.out.println("@AfterAll");
        }
    
        @AfterEach // 테스트 케이스를 종료하기 전마다 실행
        public void afterEach() {
            System.out.println("@AfterEach");
        }
    }
    ```
    
    - 테스트 결과
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a44870d4-429c-440a-a7e8-d2071ad7a9c8/af1b869e-2372-4c11-8b11-3affce940a05/Untitled.png)
    
    ### @BeforeAll 애너테이션
    
    - 전체 테스트를 시작하기 전에 처음으로 한번만 실행된다.
    - 예를 들어 데이터베이스를 연결해야 하거나 테스트 환경을 초기화할 떄 사용된다.
    - 이 애너테이션은 전체 테스트 실행주기에서 한 번만 호출되어야 하기 떄문에 메서드를 static으로 선언해야 한다.
    
    ### @BeforeEach 애너테이션
    
    - 테스트 케이스를 시작하기 전에 매번 실행한다.
    - 예를 들어 테스트 메서드에서 사용하는 객체를 초기화하거나 테스트에 필요한 값을 미리 넣을 떄 사용한다.
    - 각 인스턴스에 대해 메서드를 호출해야 하므로 메서드는 static이 아니어야 한다.
    
    ### @AfterAll 애너테이션
    
    - 전체 테스트를 마치고 종료하기 전에 한번만 실행된다.
    - 예를 들어 데이터베이스를 종료할 때나 공통적으로 사용하는 자원을 해제할 떄 사용된다.
    - 이 애너테이션은 전체 테스트 실행주기에서 한 번만 호출되어야 하기 떄문에 메서드를 static으로 선언해야 한다.
    
    ### @AfterEach 애너테이션
    
    - 각 테스트 케이스를 종료하기 전에 매번 실행한다.
    - 예를 들어 테스트 이후에 특정 데이터를 삭제해야하는 경우 사용된다.
    - @BeforeEach 애너테이션과 마찬가지로 메서드는 static이 아니어야 한다.
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a44870d4-429c-440a-a7e8-d2071ad7a9c8/90bbdbc7-f6a3-419d-b52f-8e90a5773706/Untitled.png)
    
    ## 실제 테스트 코드 작성
    
    ```java
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
    ```
    
    ### @SpringBootTest
    
    메인 애플리케이션 클래스에 추가하는 애너테이션인 @SpringBootApplication이 있는 클래스를 찾고 그 클래스에 포함되어 있는 빈을 찾은 다음 테스트용 애플리케이션 컨텍스트라는 것을 만든다.
    
    ### @AutoConfigureMockMvc
    
    MockMvc를 생성하고 자동으로 구성하는 애너태이션이다.
    
    MockMVc는 애플리케이션을 서버에 배포하지 않고도 테스트용  MVC 환경을 만들어 요청 및 전송,응답 기능을 제공하는 유틸리티 클래스다. 즉 , 컨트롤러를 테스트할 떄 사용되는 클래스이다.
    
    ### @BeforeEach
    
    테스트를 실행하기 전에 실행하는 메서드에 적용하는 애너테이션으로 여기서는 MockMvcSetUp() 메서드를 실행해 MockMvc를 설정하였다.
    
    ### @AfterEach
    
    테스트를 실행한 이후에 실행하는 메서드에 적용하는 애너테이션으로 여기서는 cleanUp() 메서드를 실행해 member 테이블에 있는 데이터들을 모두 삭제해주었다.
    
    ### perform()
    
    perform() 메서드는 요청을 전송하는 역할을 하는 메서드이다. 결과로 ResultActions 객체를 받으며, ResultActions 객체는 반환값을 검증하고 확인하는 andExpect() 메서드를 제공해 준다.
    
    ### accept()
    
    accpet() 메서드는 요청을 보낼 떄 무슨 타입으로 응답을 받을지 결정하는 메서드이다.
    
    ### andExpect()
    
    anddExpect() 메서드는 응답을 검증한다.TestController에서 만든 API는 응답 OK(200)을 반환하므로 이에 해당하는 메서드인 isOk를 사용해 응답 코드가 OK(200)인지 확인한다.
    
    ### jsonPath()
    
    jsonPath(”$[0].${필드명}”)은 JSON 응답값의 값을 가져오는 역할을 하는 메서드이다.위에 코드에서는 0번쨰 배열에 들어있는 객체의 id,name값을 가져오고, 저장된 값과 같은지 확인한다.
    
- Part 5
    
    # 데이터베이스
    
    ## 데이터베이스 관리자,DBMS
    
    ### 관계형 DBMS
    
    - 관계형 RDBMS는 테이블 형태로 이루어진 데이터 저장소라고 생각하면 된다.
    - 예를 들어 회원 테이블이 있다고 가정하면 각 행의 고유의 키, 즉, 아이디를 가지고 있고, 이메일, 나이와 같은 회원과 관련된 값들이 들어간다.
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a44870d4-429c-440a-a7e8-d2071ad7a9c8/5c6a44fc-f990-40f7-b596-db89d1ebcd6f/Untitled.png)
    
    ### H2 Database
    
    - H2는 자바로 작성되어 있는 RDBMS이며 스프링 부트가 지원하는 인메모리 관계형 데이터베이스이다.
    - H2는 데이터를 다른 공간에 따로 보관하는 것이 아니라 어플리케이션 자체 내부에 데이터를 저장하는 형식으로 어플리케이션을 다시 실행하면 데이터는 초기화된다.
    - 간편하게 사용하기 좋아서 테스트 용도로 많이 쓰이고 , 실제 개발 시에는 MySQL을 이용하자.
    
    ## 데이터베이스 용어
    
    ### 테이블
    
    - 테이블은 데이터베이스에서 데이터를 구성하기 위한 가장 기본적인 단위이다.테이블은 행과 열로 구성되며 행은 여러 속성으로 구성된다.
    
    ### 행
    
    - 행은 테이블의 구성 요소 중 하나이며,  테이블의 가로로 배열된 데이터 집합을 의미한다.
    - 예를 들어 회원 테이블이 있다고 할 떄 ID가 1번인 회원의 이메일, 나이 같은 정보들이 모여 있는 집합을 1번 회원에 대한의 행이라고 할 수 있다.
    - 행은 반드시 고유한 식별자인 기본 키를 가지며 행을 ‘레코드’라고 부른다.
    
    ### 열
    
    - 열은 테이블 구성 요소 중 하나이며, 행에 저장되는 유형의 데이터이다.
    - 예를 들어 회원 테이블이 있다고 할 떄, 열은 각 요소에 대한 속성을 나타내며 무결성을 보장한다.
    - 이메일 열에는 숫자가 들어가거나 나이 열에 문자열이 들어갈 수 없기 떄문에 데이터에 대한 무결성을 보장한다.
    
    ### 기본키
    
    - 기본키는 행을 구분할 수 있는 식별자이다.
    - 기본키 값은 유일해야 하며 중복 값을 가질 수 없다.
    - 보통 데이터를 수정하거나 삭제하고, 조회할 떄 사용되며 다른 테이블과 관계를 맺어 데이터를 가져올 수있다.
    - 기본키 값은 수정되서는 안 되며 유효한 값이 있어야 한다. 즉 NULL 값을 가질 수 없다.
    
    ### 쿼리
    
    - 쿼리는 데이터베이스에서 데이터를 조회하거나 생성,삭제,수정같은 처리를 하기 위해 사양하는 명령문이다.
    
    ## ORM이란?
    
    - ORM(Object-realational mapping)은 자바의 객체와 데이터베이스를 연결하는 프로그래밍 기법이다.
    - 데이터베이스의 값을 마치 객체처럼 사용할 수 있다.쉽게 말해 SQL을 전혀 몰라도 자바 언어로만 데이터베이스에 접근해서 원하는 데이터를 받아올 수 있다.
    - 즉, 객체와 데이터베이스를 연결해 자바 언어로만 데이터베이스를 다룰 수 있게 하는 도구를 ORM이라고 한다.
    - 쉽게 설명하면 우리가 흔히 사용하는 관계형 데이터베이스는 효율적인 데이터 저장 및 검색 기능을 제공하지만 복잡한 객체 지향 개념을 모델링(상속,다형성,레퍼런스,오브젝트)하는 데 적합하지 않다.
    - ORM은 객체와 DB 테이블이 매핑을 이루는 것을 의미하며 , 내가 코드 상에서 생성한 객체가 DB 상에 어떤 테이블과 연결된다는 것을 의미한다.이렇게 되면 내가 객체를 조작함으로써 DB를 조작할 수 있게 된다.
    
    ## JPA와 하이버네이트?
    
    - DBMS에서도 여러 종류가 있는 것처럼 ORM에도 여러 종류가 있다.
    - 자바에서는 JPA를 표준으로 사용한다.JPA는 자바에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스이다.
    - 인터페이스이므로 실제 사용을 위해서는 ORM 프레임워크를 추가로 선택하게 되는데 , 대표적으로 하이버네이트(hibernate)를 사용한다.
    - 하이버네이트는 JPA 인터페이스를 구현한 구현체이자 자바용 ORM 프레임워크이다.내부적으로는 JDBC API를 사용한다.
    - 하이버네이트 목표는 자바 객체를 통해 데이터베이스 종류에 상관없이 데이터베이스를 자유자재로 사용할 수 있게 하는 것이다.
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a44870d4-429c-440a-a7e8-d2071ad7a9c8/431b4eec-0b5b-4640-881d-b22ae0d820c3/Untitled.png)
    
    (정리가 잘 되어있는곳)
    
    https://suhwan.dev/2019/02/24/jpa-vs-hibernate-vs-spring-data-jpa/
    
    ## 엔티티 매니저란?
    
    ### 엔티티
    
    - 엔티티는 데이터베이스의 테이블과 매핑되는 객체를 의미한다.
    - 엔티티는 본질적으로는 자바 객체이므로 일반 객체와 다르지 않다.
    - 하지만 데이터베이스 테이블과 직접 연결된다는 아주 특별한 특징이 있어 구분지어 부른다.
    - 즉, 엔티티는 객체이긴 하지만 데이터베이스에 영향을 미치는 쿼리를 실행하는 객체이다.
    
    ### 엔티티 매니저
    
    - 엔티티 매니저는 엔티티를 관리해 데이터베이스와 어플리케이션 사이에서 객체를 생성,수정,삭제하는 등의 역할을 한다.
    - 그리고 이런 엔티티 매니저를 만드는 곳이 ‘엔티티 매니저 팩토리’ 이다.
    - 예를 들어 회원 2명이 동시에 회원 가입을 하려는 경우 엔티티 매니저는 다음과 같이 업무를 처리한다.
        - 회원 1의 요청에 대해서 가입 처리를 할 엔티티 매니저를 엔티티 매니저 팩토리가 생성하면 이를 통해 가입 처리해 데이터베이스에 회원 정보를 저장한다.(회원 2도 마찬가지)
        - 그리고 회원 1,2를 위해 생성된 엔티티 매니저는 필요한 시점에 데이터베이스와 연결한 뒤에 쿼리한다.
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a44870d4-429c-440a-a7e8-d2071ad7a9c8/b481deb0-f19e-4d52-9ab2-8c5ce2a53b08/Untitled.png)
    
    - 스프링 부트에서는 내부에서 엔티티 매니저 팩토리를 gksk만 생성해서 관리하고 @PersistenceContext 또는 @Autowired 애너테이션을 사용해서 엔티티 매니저를 사용한다.
    
    ```java
    @PersistenceContext
    EntityManager em; // 프록시 엔티티 매니저. 필요할 때 진짜 엔티티 매니저 호출
    ```
    
    - 스프링 부트는 기본적으로 빈은 하나만 생성해서 공유하므로 동시성 문제가 발생할 수 있다.
    - 그래서 실제로는 엔티티 매니저가 아닌 실제 엔티티 매니저와 연결하는 프록시(가짜) 엔티티 매니저를 사용한다.
    - 필요할 때 데이터베이스 트랜잭션과 관련된 실제 엔티티 매니저를 호출한다.
    
    ## 영속성 컨텍스트란?
    
    - 엔티티 매니저는 엔티티를 영속성 컨텍스트에 저장한다는 특징이 있다.
    - 영속성 컨텍스트는 JPA의 중요한 특징 중 하나로, 엔티티를 관리하는 가상의 공간이다.
    - 영속성 컨텍스트는 1차 캐시,쓰기 지연,변경 감지,지연 로딩 이라는 특징이 있다.
    - 기존에는 데이터 조작을 위해 쿼리를 직접 작성해야 했지만 스프링 부트에서는 이런 쿼리를 자바 코드로 작성하고 이를 JPA가 알아서 쿼리로 변경해주는 것이 매우 편리하다.
    
    ### 1차 캐시
    
    - 영속성 컨텍스트는 내부에 1차 캐시를 가지고 있다.
    - 이 때 캐시의 키는 엔티티의 @Id 애너테이션이 달린 기본키 역할을 하는 식별자이며 값은 엔티티이다.
    - 엔티티를 조회하면 1차 캐시에서 데이터를 조회하고 값이 있으면 반환한다.값이 없으면 데이터베이스에서 조회해 1차 캐시에 저장한 다음 반환한다.
    - 이를 통해 캐시된 데이트를 조회할 때에는 데이터베이스를 거치지 않아도 되므로 매우 빠르게 데이터를 조회할 수 있다.
    
    ### 쓰기 지연
    
    - 쓰기 지연은 트랜잭션을 커밋하기 전까지 데이터베이스에 실제로 질의문을 보내지 않고 쿼리를 모았다가 트랜잭션을 커밋하면 모았던 쿼리를 한번에 실행하는 것을 의미한다.
    - 예를 들어 데이터 추가 쿼리가 3개라면 영속성 컨텍스트는 트랜잭션을 커밋하는 시점에 3개의 쿼리를 한꺼번에 전송한다.
    - 이를 통해 적당한 묶음으로 쿼리를 요청할 수 있어 데이터베이스 시스템의 부담을 줄일 수 있다.
    
    ### 변경 감지
    
    - 트랜잭션을 커밋하면 1차 캐시에 저장되어 있는 엔티티의 값과 현재 엔티티의 값을 비교해서 변경된 값이 있다면 변경 사항을 감지해 변경된 값을 데이터베이스 자동으로 반영한다.-
    - 이를 통해 쓰기 지연과 마찬가지로 적당한 묶음을 쿼리로 요청할 수 있고, 데이터베이스 시스템의 부담을 줄일 수 있다.
    
    ### 지연로딩
    
    - 지연로딩은 쿼리로 요청한 데이터를 어플리케이션으로 바로 로딩하는 것이 아니라 필요할 때 쿼리를 날려 데이터를 조회하는것을 의미한다.
    - 반대로 조회할 때 쿼리를 보내 연관된 모든 데이터를 가져오는 즉시 로딩도 있다.
    
    ## 엔티티 상태
    
    - 엔티티 상태는 4가지의 상태를 가진다.
    - 영속성 컨텍스트가 관리하고 있지 않는 **분리 상태**, 영속성 컨텍스트가 관리하는 **관리 상태**,영속성 컨텍스트와 전혀 관계가 없는 **비영속 상태**, 마지막으로 **삭제된 상태**로 나뉜다.
    - 이 상태는 특정 메서드를 호출해 변경할 수 있다.필요에 따라 엔티티의 상태를 조절해 데이터를 올바르게 유지하고 관리할 수 있다.
    
    ```java
    public class EntityManagerTest {
    	@Autowired
    	EntityManager em;
    		
    	public void example() {
    		// 1.엔티티 매니저가 엔티티를 관리하지 않는 상태(비영속 상태)
    		Member member = new Member(1L, "홍길동");
    		
    		// 2.엔티티가 관리 상태가 된다.(관리 상태)
    		em.persist(member);
    		// 3.엔티티 객체가 분리된 상태가 된다.(분리 상태)
    		em.detach(member);
    		// 4.엔티티 객체가 삭제된 상태가 된다.(삭제 상태)
    		em.remove(member);
    	}
    }
    ```
    
    1. 엔티티를 처음 말든면 엔티티는 비영속 상태가 된다.
    2. persist()메서드를 사용해 엔티티를 관리 상태로 만들 수 있으며, Member 객체는 영속성 컨텍스트에서 상태가 관리된다.
    3. 만약 엔티티를 영속성 컨텍스트에서 관리하고 싶지 않다면 detach() 메서드를 사용해 분리 상태로 만들 수 있다.
    4. 또한 더 이상 객체가 필요 없다면 remove() 메서드를 사용해서 엔티티를 영속성 컨텍스트와 데이터베이스에서 삭제할 수 있다,.
    
    ## 스프링데이터와 스프링 데이터 JPA
    
    - 스프링 데이터 JPA는 스프링 데이터의 공통적인 기능에서 JPA의 유용한 기술이 추가된 기술이다.
    - 스프링 데이터 JPA에서는 스프링 데이터의 인터페이스인 PagingAndSortingRepository를 상속 받아 JpaRepository 인터페이스를 만들었으며,JPA를 더 편리하게 사용하는 메서드를 제공한다.
    
    ## 스프링 데이터와 스프링 데이터 JPA
    
    - 지금까지 배운 개념에서는 엔티티의 상태를 직접 관리하고, 필요한 시점에 커밋을 해야하는 등의 개발자가 신경 써야할 부분이 많았다.
    - 스프링 데이터는 비즈니스 로직에 더 집중할 수 있게 데이터베이스 사용 기능을 클래스 레벨에서 추상화하였다.
    - 스프링 데이터에서 제공하는 인터페이스를 통해서 스프링 데이터를 사용할 수 있다.이 인터페이스에서는 CRUD를 포함한 여러 메서드가 폿함되어 있으며, 알아서 쿼리를 만들어준다.
    - 추가로 각 데이트베이스의 특성에 맞춰 기능을 확대해 제공하는 기술도 제공한다.
    - 예를 들어 표준 스펙인 JPA는 스프링에서 구현한 데이터 JPA를,몽고디비는 스프링 데이터 몽고디비를 사용한다.
    
    ### 스프링 데이터 JPA란?
    
    - 스프링 데이터 JPA는 스프링 데이터의 공통적인 기능에서 JPA의 유용한 기술이 추가된 기술이다.
    - 스프링 데이터 JPA에서는 스프링 데이터의 인터페이스인 PagingAndSortingRepository를 상속받아 JpaRepository 인터페이스를 만들었으며, JPA를 더 편리하게 사용하는 메서드를 제공받는다.
    - 지금까지는 아래와 같이 메서드 호출로 엔티티 상태를 바꿨다.
    
    ```java
    @PersistenceContext
    EntityManager em;
    
    public void join() {
    	// 기존에 엔티티 상태를 바꾸는 방법(메서드 호출을 해서 상태 변경)
    	Member member = new Member(1L, "홍길동");
    	em.persist(member);
    }
    ```
    
    - 하지만 스프링 데이터 JPA를 사용하면 리포지터리 역할을 하는 인터페이스를 만들어 데이터베이스의 조회,수정,생성,삭제 같은 작업을 간단히 할 수 있다.
    - 다음과 같이 JpaRepository 인터페이스를 우리가 만든 인터페이스에서 상속 받고 제네릭에는 관리할 **<엔티티 이름,엔티티 기본키 타입>**을 입력하면 기본 CRUD를 위해 만든 메서드를 사용할 수 있다.
    
    ```java
    public interface MemberRepository extends JpaRepository<Meber,Long>{
    }
    ```
    
    ### 스프링 데이터 JPA에서 제공하는 메서드 사용해보기
    
    ```java
    @Service
    public class MemberService {
    
        @Autowired
        MemberRepository memberRepository;
    
        public void test(){
            // 생성(create)
            memberRepository.save(new Member(1L,"A"));
    
            // 조회(read)
            Optional<Member> member = memberRepository.findById(1L);
            List<Member> members = memberRepository.findAll();
    
            // 삭제(delete)
            memberRepository.deleteById(1L);
        }
    }
    ```
    
    ```java
    @NoArgsConstructor // 2. 기본 생성자
    @AllArgsConstructor
    @Getter
    @Entity // 1. 엔티티로 지정
    public class Member {
        @Id  // 3. id 필드를 기본키로 지정
        @GeneratedValue(strategy = GenerationType.IDENTITY) //4. 기본키 자동으로 1씩 증가
        @Column(name = "id", updatable = false)
        private Long id; // DB 테이블의 id 칼럼과 매칭
    
        @Column(name = "name", updatable = false)  // 5. name이라는 not null 컬럼과 매핑
        private String name; // DB 테이블의 name 컬럼과 매칭
    }
    ```
    
    1. @Entity 애너테이션은 Member 객체를 JPA가 관리하는 엔티티로 지정한다.즉, Member 클래스와 실제 데이터베이스의 테이블을 매핑시킨다. 
        - name 파라터를 사용하면 name의 값을 가진 테이블 이름과 매핑되고 이름을 지정하지 않으면 클래스 이름과 같은 이름의 테이블과 매핑된다.
    2. 엔티티는 반드시 기본 생성자가 있어야하고, 접근 제어자는 public 또는 protected 이어야한다.
    3. @Id는 Long 타입의 id 필드를 테이블의 기본키로 지정ㅎ나다.
    4. @GeneratedValue는 기본키의 생성 방식을 결정한다.여기서는 자동으로 기본키가 증가하도록 지정했다.
        - AUTO : 선택한 데이터베이스 방안(dialect)에 따라 방식을 자동으로 선택(기본값)
        - IDENTITY : 기본 키 생성을 데이터베이스에 위임(=AUTO_INCREMENT)
        - SEQUENCE : 데이터베이스 시퀀스를 사용해서 기본키를 할당하는 방법.오라클에서 사용.
        - TABLE : 키 생성 테이블 사용
    5. @Column 애너테이션은 데이터베이스의 컬럼과 필드를 매핑해준다.
        - name : 필드와 매핑할 컬럼 이름.설정하지 않으면 필드 이름을 짖어해준다.
        - nullable : 컬럼의 null 허용 여부. 설정하지 않으면 true(nullable)
        - unique : 컬럼의 유일한 값(unique) 여부, 설정하지 않으면 false(non-unique)
        - columnDefinition : 컬럼 정보 설정.default 값 설정 가능.
    
    ```java
    @Repository
    public interface MemberRepository extends JpaRepository<Member, Long> {
    }
    ```
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a44870d4-429c-440a-a7e8-d2071ad7a9c8/1f928088-7703-4984-ba75-72a3ee213bc9/Untitled.png)
    
    - 리포지토리는 엔티티에 있는 데이터을 조회하거나 저장,변경,삭제를 할 때 사용하는 인터페이스로,스프링 데이터 JPA에서 제공하는 인터페이스인 JpaRepository 클래스를 상속받아 간단히 구현할 수 있다.
- Part 6
    
    ## API와 REST API
    
    ### API
    
    ### REST API
    
    - REST API는 웹의 장점을 최대한 활용하는 API이다.
    - REST는 Representational State Transfer를 줄인 표현으로 자원을 이름으로 구분해 자원의 상태를 주고 받는 API 방식이다.
    - REST API는 URL 설계 방식을 말한다.
    
    ### REST API의 특징
