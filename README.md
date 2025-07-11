# Point Service (포인트 서비스)

이 프로젝트는 포인트 관리 시스템을 위한 Spring Boot 기반의 마이크로서비스입니다. 사용자 포인트 충전, 사용 및 조회를 처리합니다.

## 기술 스택

*   **Java 17**: 애플리케이션 개발 언어
*   **Spring Boot 3.x**: 애플리케이션 프레임워크
*   **Spring Data JPA**: 데이터베이스 상호작용
*   **MySQL**: 관계형 데이터베이스
*   **Apache Kafka**: 비동기 메시징
*   **QueryDSL**: 타입-세이프(Type-safe) 쿼리 생성
*   **Swagger/OpenAPI**: API 문서화
*   **Spring Cloud Eureka**: 서비스 디스커버리

## 프로젝트 실행 방법

### 1. 요구 사항

*   Java 17
*   Gradle
*   Docker (선택 사항, MySQL 및 Kafka 실행용)

### 2. 설정

`src/main/resources/application.yml` 또는 `application-dev.yml` 파일을 환경에 맞게 설정합니다. 특히 데이터베이스 및 Kafka 연결 정보를 확인하세요.

### 3. Docker를 이용한 의존성 실행 (선택 사항)

MySQL 및 Kafka를 Docker로 실행하려면 다음 명령어를 사용합니다:

```bash
docker-compose -f docker-compose-point.yml up -d
```

### 4. 애플리케이션 실행

Gradle을 사용하여 애플리케이션을 실행합니다:

```bash
./gradlew bootRun
```

또는 IDE에서 `PointServiceApplication.java`를 실행합니다.

### 5. API 문서 확인

애플리케이션이 실행되면 다음 URL에서 Swagger UI를 통해 API 문서를 확인할 수 있습니다:

```
http://localhost:8080/swagger-ui.html
```
