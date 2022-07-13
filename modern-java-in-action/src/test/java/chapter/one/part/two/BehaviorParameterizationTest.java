package chapter.one.part.two;

import chapter.one.part.AppleTestCase;
import chapter.one.part.one.model.Apple;
import chapter.one.part.two.service.impl.AppleGreenColorPredicate;
import chapter.one.part.two.service.impl.AppleHeavyWeightPredicate;
import enums.Color;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("BehaviorParameterization")
class BehaviorParameterizationTest {

    @Test
    @DisplayName("녹색 사과 필터링 예제")
    void filterGreenApples() {
        List<Apple> greenApples = BehaviorParameterization.filterGreenApples(AppleTestCase.createAppleInventory());
        List<Apple> greenAppleInventory = AppleTestCase.createGreenAppleInventory();
        Assertions.assertThat(greenApples).extracting("color").hasSize(greenAppleInventory.size());
    }

    @Test
    @DisplayName("색상에 따른 사과 필터링 예제(GREEN)")
    void filterApplesByColor_GREEN() {
        List<Apple> applesByColor = BehaviorParameterization.filterApplesByColor(AppleTestCase.createAppleInventory(), Color.RED);
        List<Apple> redAppleInventory = AppleTestCase.createRedAppleInventory();
        Assertions.assertThat(applesByColor).extracting("color").hasSize(redAppleInventory.size());
    }

    @Test
    @DisplayName("색상에 따른 사과 필터링 예제(RED)")
    void filterApplesByColor_RED() {
        List<Apple> applesByColor = BehaviorParameterization.filterApplesByColor(AppleTestCase.createAppleInventory(), Color.RED);
        List<Apple> greenAppleInventory = AppleTestCase.createGreenAppleInventory();
        Assertions.assertThat(applesByColor).extracting("color").hasSize(greenAppleInventory.size());
    }

    @Test
    @DisplayName("무게 따른 사과 필터링 예제")
    void filterApplesByWeight() {
        List<Apple> applesByColor = BehaviorParameterization.filterApplesByWeight(AppleTestCase.createAppleInventory(), 150);
        List<Apple> heavyAppleInventory = AppleTestCase.createHeavyAppleInventory();
        Assertions.assertThat(applesByColor).extracting("color").hasSize(heavyAppleInventory.size());
    }

    @Test
    @DisplayName("플래그를 넘겨서 색상에 따른 사과 필터링 예제")
    void filterApples_색상() {
        List<Apple> applesByColor = BehaviorParameterization.filterApples(AppleTestCase.createAppleInventory(), Color.GREEN, 0, true);
        List<Apple> greenAppleInventory = AppleTestCase.createGreenAppleInventory();
        Assertions.assertThat(applesByColor).extracting("color").hasSize(greenAppleInventory.size());
    }

    @Test
    @DisplayName("플래그를 넘겨서 무게에 따른 사과 필터링 예제")
    void filterApples_무게() {
        List<Apple> applesByColor = BehaviorParameterization.filterApples(AppleTestCase.createAppleInventory(), null, 150, false);
        List<Apple> heavyAppleInventory = AppleTestCase.createHeavyAppleInventory();
        Assertions.assertThat(applesByColor).extracting("color").hasSize(heavyAppleInventory.size());
    }

    @Test
    @DisplayName("Predicate를 넘겨서 사과 필터링 예제")
    void filterApplesByPredicate_무게() {
        List<Apple> applesByColor = BehaviorParameterization.filterApples(AppleTestCase.createAppleInventory(), new AppleHeavyWeightPredicate());
        List<Apple> heavyAppleInventory = AppleTestCase.createHeavyAppleInventory();
        Assertions.assertThat(applesByColor).extracting("color").hasSize(heavyAppleInventory.size());
    }

    @Test
    @DisplayName("Predicate를 넘겨서 사과 필터링 예제")
    void filterApplesByPredicate_색상() {
        List<Apple> applesByColor = BehaviorParameterization.filterApples(AppleTestCase.createAppleInventory(), new AppleGreenColorPredicate());
        List<Apple> greenAppleInventory = AppleTestCase.createGreenAppleInventory();
        Assertions.assertThat(applesByColor).extracting("color").hasSize(greenAppleInventory.size());
    }
}