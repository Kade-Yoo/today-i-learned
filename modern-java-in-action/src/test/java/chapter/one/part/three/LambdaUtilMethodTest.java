package chapter.one.part.three;

import chapter.one.part.AppleTestCase;
import chapter.one.part.one.model.Apple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("3.8 람다 표현식을 조합할 수 있는 유용한 메소드")
class LambdaUtilMethodTest {

    @Test
    @DisplayName("사과 정렬 예제")
    void sortApples() {
        List<Apple> apples = LambdaUtilMethod.sortApples(AppleTestCase.createAppleInventory());
        apples.forEach(apple -> System.out.println(apple.toString()));
    }

    @Test
    @DisplayName("녹색 사과가 아닐 때 filter")
    void predicateNegativeApples() {
        List<Apple> apples = LambdaUtilMethod.predicateNegativeApples(AppleTestCase.createAppleInventory());
        apples.forEach(apple ->  System.out.println(apple.toString()));
    }

    @Test
    @DisplayName("녹색 사과이면서 무게가 150이상 일 때 filter")
    void predicateAndPredicateApples() {
        List<Apple> apples = LambdaUtilMethod.predicateAndPredicateApples(AppleTestCase.createAppleInventory());
        apples.forEach(apple ->  System.out.println(apple.toString()));
    }

    @Test
    @DisplayName("녹색 사과이거나 무게가 150이상 인 경우 filter")
    void predicateOrPredicateApples() {
        List<Apple> apples = LambdaUtilMethod.predicateOrPredicateApples(AppleTestCase.createAppleInventory());
        apples.forEach(apple ->  System.out.println(apple.toString()));
    }

    @Test
    @DisplayName("g(f(x))")
    void composeApples() {
        List<String> apples = LambdaUtilMethod.composeApples(AppleTestCase.createAppleInventory());
        apples.forEach(System.out::println);
    }

    @Test
    @DisplayName("f(g(x))")
    void thenApples() {
        List<Apple> apples = LambdaUtilMethod.thenApples(AppleTestCase.createAppleInventory());
        apples.forEach(apple ->  System.out.println(apple.toString()));
    }
}