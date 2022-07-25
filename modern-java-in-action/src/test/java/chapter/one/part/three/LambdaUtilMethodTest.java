package chapter.one.part.three;

import chapter.one.part.AppleTestCase;
import chapter.one.part.one.model.Apple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LambdaUtilMethodTest {

    @Test
    @DisplayName("사과 정렬 예제")
    void sortApples() {
        List<Apple> apples = LambdaUtilMethod.sortApples(AppleTestCase.createAppleInventory());
        apples.forEach(apple -> System.out.println(apple.toString()));
    }
}