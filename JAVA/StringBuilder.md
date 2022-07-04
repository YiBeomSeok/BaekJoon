# StringBuilder
문자열이 1개 이상 있어서 이것들을 더해야 한다고 하면
```java
public class Main{
  public static void main(String[] args){
    String str1 = "자바";
    String str2 = "프로그래밍";
    String str3 = str1 + str2;
  }
}
```
위의 방법을 쓸 수 있다.  

그런데 이 String 객체끼리 더하는 방법이 메모리 할당과 해제를 발생시켜, 덧셈 연산이 많아질수록 성능적으로 좋지 않다고 한다.  
즉, 많은 문자열을 연결할수록 많은 중간 문자열 객체가 생성되고 비효율적인 코드가 된다.  

자바에서 String 객체는 변경 불가능하고, 한 번 생성되면 내용을 바꿀 수 없다.  
하나의 문자열을 다른 문자열과 연결하면 새 문자열이 생성되고, 이전 문자열은 가비지 컬렉터로 들어간다.  

이러한 경우 StringBuilder를 사용하면 String은 변경 불가능한 문자열을 생성하는데 비해  
StringBuilder는 변경 가능한 문자열을 만들어 String을 합치는 작업 시 하나의 대안이 된다.  

## 사용
java.lang 패키지라 따로 선언은 필요없다.
```java
public class Main{
  public static void main(String[] args){
    StringBuilder stringBuilder = new StringBuilder();
    StringBuilder.append("문자열 ").append("연결");
    
    String str = stringBuilder.toString();
    System.out.println(stringBuilder);
    System.out.println(str);
  }
}
```
먼저 StringBuilder의 객체를 생성한 후 append()의 인자로 연결하고자 하는 문자열을 넣어서 StringBuilder의 객체를 통해 호출한다.
출력 시에는 toString()을 붙여야 하며 String변수에 넣을 때에도 마찬가지이다.
