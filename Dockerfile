# 기반 이미지 선택
FROM openjdk:17

# 애플리케이션 파일 복사
# ARG 지시어는 해당 dockerfile로 이미지를 생성할 때 `--build-arg` 옵션이랑 대응되는 것이다.
# 즉, 외부에서 JAR_FILE에다가 프로젝트의 빌드 산출물인 .jar파일을 이미지 생성 시에 `--build-arg ${실제 아티팩트 이름}` 명령어를 이용해 dockerfile로 가져오는 것
# keystore.p12 파일 경로를 위한 ARG 추가

ARG KEYSTORE_FILE=keystore.p12
COPY ${KEYSTORE_FILE} keystore.p12
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# 포트 열기
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java","-jar","/app.jar"]