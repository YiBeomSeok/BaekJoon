# StringTokenizer

StringTokenizer 클래스는 문자열을 구분자를 이용하여 분리할 때 사용
BufferedReader 클래스의 메서드로 입력을 읽어들인다면 라인 단위로 읽어들일 수 밖에 없음
BufferedReader 클래스만이 아니더라도, 스페이스 기준이나 컴마 혹은 공백 기분으로 문자열들을 분리한다던가, 특정 문자에 따라 여러 문자열을 나누고 싶을 때 사용

```java
// 1. 띄어쓰기 기준으로 문자열을 분리
StringTokenizer st = new StringTokenizer(문자열);

// 2. 구분자를 기준으로 문자열을 분리
StringTokenizer st = new StringTokenizer(문자열, 구분자);

/* 3. 구분자를 기준으로 문자열을 분리할 때 구분자도 토큰으로 넣는다. (true)
 * 구분자를 분리된 문자열 토큰에 포함 시키지 않는다. (false)
 * (디폴트: false)
 * /
StringTokenizer st = new StringTokenizer(문자열, 구분자, true/false); 
```
