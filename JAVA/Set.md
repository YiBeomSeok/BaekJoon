# Set
java 컬렉션에 HashSet은 Set interface의 구현 클래스

## 특징
저장 순서를 유지하지 않는다.\
중복 값을 허용하지도 않는다.\
*순서를 유지하고 싶다면 LinkedHashSet 클래스를 사용한다.*

## 객체 선언
```java
Set<String> set = new HashSet<String>();
```

## 데이터 삽입
```java
Set<String> set = new HashSet<String>();

set.add("apple");
set.add("banana");
set.add("bmsk");
```

## 데이터 삭제
```java
set.remove("appel");
```

## 데이터 출력
```java
public static void main(String[] args) {
  Set<String> set = new HashSet<>();
  
  set.add("apple");
  set.add("banana");
  set.add("bmsk");
  
  Iterator<String> iterSet = set.iterator();
  while(iterSet.hasNext()) {
    System.out.print(iterSet.next() + " ");
  }
  
  System.out.println();
  System.out.print(set.toString());
}
```
>출력\
>banana apple bmsk \
>[banana, apple, bmsk]\
Iterator는 각 데이터를 조작할 때 사용\
toString()으로는 set 안에 어떤 데이터가 포함되어있는지 확인하기에 편리함

## 값 포함 여부
```java
public static void main(String[] args) {

  set.add("apple");
  set.add("banana");
  set.add("bmsk");
    
  System.out.println(set.contains("bmsk"));
  System.out.println(set.contains("hi"));
}
```
>출력\
>true\
>false\
