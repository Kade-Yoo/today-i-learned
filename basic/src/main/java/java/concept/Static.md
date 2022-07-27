# static keword
## 제어자
- static은 접근 제어자를 제외한 나머지 제외자 중 하나이다.
- 접근 제어자를 제외한 나머지 제어자들은 조합해서 사용할 수 있다.
- 접근 제어자는 하나의 대상에 대해 한번 만 사용할 수 있다.

## static 정의
- static은 '공통적인', '클래스의'라는 의미를 갖고 있다.

## static 사용
- static 키워드를 붙인 멤버변수 혹은 메서드는 클래스를 통해서 불러올 수 있다.
- 즉 클래스의 인스턴스를 만들지 않고 클래스에서 바로 사용이 가능하다는 것이다.
- static은 클래스, 멤버 변수, 메서드에서 사용할 수 있다.
- 클래스 변수, 클래스 메서드는 인스턴스화를 하지 않고 사용할 수 있기 때문에 빠르고 효율이 좋다.
```
public class Static {
    
    // static 멤버 변수
    public static int staticVariable;
    // static method
    public static void getStaticMethod() {}
    // static class
    public static class StaticClass {
    }
}
```

## 주의 사항
- static메서드와 일반 method의 차이는 static method내에선 일반 멤버변수를 사용할 수 없다.
- static method내에서 멤버 변수를 사용할 수 없는 이유는 static method는 프로그램이 실행될 때 메모리에 올라간다.
하지만, 멤버 변수는 메서드가 호출되었을 때 stack영역에 쌓이기 때문에 static method에서 사용한 멤버 변수가 존재하지 않을 수 있다.
그렇기 때문에 멤버 변수를 static method에서 사용할 수 없다.
- 반면에, static 변수, 메서드는 프로그램이 실행되는 시점에 로드 되기 때문에 인스턴스 변수와 메서드에서 사용이 가능하다.
- static class는 중첩 class일 때만 사용 가능하다.

## 메모리 구조
[메모리 구조](Memory.md)