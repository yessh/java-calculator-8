# java-calculator-precourse

# 요구사항 :

1. 쉼표, 콜론 구분자로 구분된 숫자 -> 구분자 기준 분리

2. 커스텀 구분자 지정 가능.

3. 잘못된 값 입력(덧셈식의 유효성, 음수 입력)시 `IllegalArgumentException` 발생시키고 애플리케이션 종료.

# 기능 구현

입출력 로직 (`Input.class`, `Output.class`)
- [x] 문자열 입력
- [x] 숫자 합 출력

정규표현식 로직 (`Delimiter.class`)
- [x] 입력에 커스텀 구분자 생성이 포함됐는지 판별
- [x] 커스텀 구분자 생성시, 구분자에 추가
- [x] 덧셈식의 유효성 판별
- [x] 구분자로 분류된 값을 Integer List로 변환


숫자 관련 로직 (`Calculator.class`)
- [x] 입력값에 음수의 포함 여부 판단
- [x] 합 계산


의존성 주입 (`AppConfig.class`)
- [x] 의존성을 외부에서 주입하도록 함


애플리케이션 흐름 제어 (`CalculatorController.class`)
- [x] domain 이용하여 애플리케이션 흐름 구현