# StringTokenizer

StringTokenizer 클래스는 문자열을 구분자를 이용하여 분리할 때 사용  
BufferedReader 클래스의 메서드로 입력을 읽어들인다면 라인 단위로 읽어들일 수 밖에 없음  
BufferedReader 클래스만이 아니더라도, 스페이스 기준이나 컴마 혹은 공백 기분으로 문자열들을 분리한다던가, 특정 문자에 따라 여러 문자열을 나누고 싶을 때 사용  

## import
```java
import java.util.StringTokenizer;
```
## 생성자
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
## 구분자가 하나가 아닌 여러 문자일 경우
StringTokenizer는 구분자 인자에 여러 개의 구분자를 이용할 수 있게 문자열을 받는다.
```java
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args){
    String str = "https://github.com/YiBeomSeok/JAVA_Algorithms";
    StringTokenizer st = new StringTokenizer(str, ":/");
    
    while(st.hasMoreTokens()) {
      System.out.println(st.nextToken());
    }
  }
}
```

```java
https
github.com
YiBeomSeok
JAVA_Algorithms
```

## StringTokenizer 메서드
리턴값|메서드명|역할
---|---|---
boolean|hasMoreTokens()|남아있는 token이 있으면 true를 리턴, 더 이상 token이 없으면 false를 리턴
String|nextToken()|객체에서 다음 token을 반환
String|nextToken(String delim)|delim 기준으로 다음 token을 반환
boolean|hasMoreElements()|hasMoreTokens와 동일, element보다 token으로 된 메서드를 주로 사용
Object|nextElement()|nextToken 메서드와 동일, String이 아닌 객체를 return
int|countTokens()|총 token의 개수를 return

## split과의 차이
둘 다 문자열 파싱하는데 
StringTokenizer는 java.util에 포함되어 있는 클래스, split은 String 클래스에 속해있는 메소드  
StringTokenizer는 문자 또는 문자열로 문자열을 구분한다면, split은 정규표현식으로 구분  
StringTokenizer는 빈 문자열을 token으로 인식하지 않지만 split은 빈 문자열을 token으로 인식하는 차이가 있음  
StringTokenizer는 결과값이 문자열이라면 split은 결과 값이 문자열 배열  
StringTokenizer를 사용할 경우 전체 token을 보고싶다면 반복문을 이용해 하나하나 뽑을 수 밖에 없음  
