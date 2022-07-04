# BufferedReader
버퍼를 사용하는 경우 BufferedReader가 Scanner보다 더 효율이 좋다.

Scanner로 입력을 할 경우에는 SpaceEnter를 경계로 인식하여 입력한 데이터를 가공하기가 매우 쉽다.  
하지만 BufferedReader는 Enter만 경계로 인식하고 return되는 데이터가 String으로 고정되기 때문에 이를 int로 사용하기 위해서 변환을 해 주어야 한다.

## 버퍼(buffer)
* 데이터를 한 곳에서 다른 한 곳으로 전송하는 동안 일시적으로 그 데이터를 보관하는 임시 메모리 영역
* 입출력 속도 향상을 위해 버퍼를 사용
* 버퍼 플러시(buffer flush): 버퍼를 이용한 입력
* BufferedReader: 버퍼를 이용항 입력
* BufferedWriter: 버퍼를 이용한 출력

## import
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
```

```java
public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in);
    String str =  br.readLine();
    int a = Integer.parseInt(str);
  }
}
```
BufferedReader는 return 값이 String으로 고정되기 때문에 int 타입으로 입력을 받기 위해서는
Integer.parseInt(str)처럼 타입을 변환해주어야 한다.
만약 여러개의 코드를 입력해야 한다면?

## import
```java
import java.util.StringTokenizer;
```

```java
public class Main{
  public static void main(String[] args){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    System.out.println(a);
    System.out.println(b);
  }
}
