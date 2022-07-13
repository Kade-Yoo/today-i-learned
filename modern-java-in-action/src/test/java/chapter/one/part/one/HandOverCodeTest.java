package chapter.one.part.one;

import chapter.one.part.AppleTestCase;
import chapter.one.part.one.model.Apple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static enums.Color.GREEN;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("코드 가져오기 테스트")
class HandOverCodeTest {

    private final String message = "NPE가 발생하였습니다.";

    @Test
    @DisplayName("초록색 사과 필터")
    void 초록색_사과를_출력할_때() {
        List<Apple> appleInventory = AppleTestCase.createAppleInventory();
        List<Apple> greenApples = HandOverCode.filterGreenApples(appleInventory);
        assertThat(greenApples).extracting("color").contains(GREEN);
    }

    @Test
    @DisplayName("무게가 무거운 사과 필터")
    void 무게가_무거운_사과를_출력할_때() {
        List<Apple> appleInventory = AppleTestCase.createAppleInventory();
        List<Apple> heavyApples = HandOverCode.filterHeavyApples(appleInventory);
        assertThat(heavyApples).extracting("weight").hasSizeGreaterThan(1);
    }

    @Test
    @DisplayName("초록색 사과를 필터 조건으로 입력받았을 떄")
    void 초록색_사과를_출력하기위해_조건으로_입력받았을_때() {
        List<Apple> appleInventory = AppleTestCase.createAppleInventory();
        List<Apple> greenApples = HandOverCode.filteredApplesByCodition(appleInventory, Apple::isGreenApple);
        assertThat(greenApples).extracting("color").contains(GREEN);
    }

    @Test
    @DisplayName("무게가 무거운 사과를 필터 조건으로 입력받았을 떄")
    void 무게가_무거운_사과를_출력하기위해_조건으로_입력받았을_때() {
        List<Apple> appleInventory = AppleTestCase.createAppleInventory();
        List<Apple> heavyApples = HandOverCode.filteredApplesByCodition(appleInventory, Apple::isHeavyApple);
        assertThat(heavyApples).extracting("weight").hasSizeGreaterThan(1);
    }

    @Test
    @DisplayName("초록색 사과를 필터 조건(람다)으로 입력받았을 떄")
    void 초록색_사과를_출력하기위해_조건_람다_으로_입력받았을_때() {
        List<Apple> appleInventory = AppleTestCase.createAppleInventory();
        List<Apple> greenApples = HandOverCode.filteredApplesByCodition(appleInventory, (Apple a) -> GREEN.equals(a.getColor()));
        assertThat(greenApples).extracting("color").contains(GREEN);
    }

    @Test
    @DisplayName("무게가 무거운 사과를 필터 조건(람다)으로 입력받았을 떄")
    void 무게가_무거운_사과를_출력하기위해_조건_람다_으로_입력받았을_때() {
        List<Apple> appleInventory = AppleTestCase.createAppleInventory();
        List<Apple> heavyApples = HandOverCode.filteredApplesByCodition(appleInventory, (Apple a) -> a.getWeight() > 150);
        assertThat(heavyApples).extracting("weight").hasSizeGreaterThan(1);
    }
}