# 🛵 Delivery Service Backend

Spring Boot 기반 배달 서비스 API 프로젝트(백엔드)입니다.

## ✅ 초기 세팅 내역

- [x] Gradle 멀티모듈 구성 (service -> api, db)
- [x] ObjectMapper 설정 -> SnakeCase JSON 직렬화 외
- [x] DB 연동 및 JPA 설정
- [x] Swagger 설정
- [x] 공통 application.yml 구성

## ✅ 프로젝트 베이스 개발

- [x] API 요청/응답 Filter 기반 로깅 적용
- [x] API 공통 응답 스펙 통일 (Api<T> 구조)
- [x] ErrorCode 구조화 (Enum 기반 에러 코드 관리)
- [x] 전역 Exception Handler 구현
  - 서버 전체 예외 및 커스텀 예외 (ApiException) 대응
- [x] Interceptor 기반 인증 처리
  - Header 토큰 인증 구조 구현

