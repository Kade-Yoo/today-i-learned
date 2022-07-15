package chapter.one.part.two;

import chapter.one.part.AppleTestCase;
import chapter.one.part.one.model.Apple;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static enums.Color.RED;
import static org.junit.jupiter.api.Assertions.*;

class AnonymousClassTest {

    @Test
    void filterRedApples() {
        List<Apple> appleInventory = AppleTestCase.createAppleInventory();
        List<Apple> apples = AnonymousClass.filterRedApples(appleInventory);
        List<Apple> redAppleInventory = AppleTestCase.createRedAppleInventory();
        Assertions.assertThat(apples).extracting("color").hasSize(redAppleInventory.size());
    }

    @Test
    void getFilterApplesForLambda() {
        List<Apple> appleInventory = AppleTestCase.createAppleInventory();
        List<Apple> apples = AnonymousClass.getFilterApples(appleInventory);
        List<Apple> redAppleInventory = AppleTestCase.createRedAppleInventory();
        Assertions.assertThat(apples).extracting("color").hasSize(redAppleInventory.size());
    }

    @Test
    @DisplayName("리스트_형식으로_추상화1")
    void 리스트_형식으로_추상화_1() {
        List<Apple> inventory = AppleTestCase.createAppleInventory();
        List<Apple> redFilter = AnonymousClass.filter(inventory, (Apple apple) -> RED.equals(apple.getColor()));
        List<Apple> redAppleInventory = AppleTestCase.createRedAppleInventory();
        Assertions.assertThat(redFilter).extracting("color").hasSize(redAppleInventory.size());
    }

    @Test
    @DisplayName("리스트_형식으로_추상화2")
    void 리스트_형식으로_추상화_2() {
        List<Integer> eventNumbers = AnonymousClass.filter(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> i % 2 == 0);
        Assertions.assertThat(eventNumbers).hasSize(2);
    }
}