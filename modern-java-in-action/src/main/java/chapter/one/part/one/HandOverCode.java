package chapter.one.part.one;

import chapter.one.part.one.model.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static enums.Color.GREEN;

/**
 * 코드 넘겨주기
 */
public class HandOverCode {

    /**
     * 그린색 사과 조회
     *
     * @param inventory 사과 상자
     * @return 그린색 사과
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * 무게가 무거운 사과 조회
     *
     * @param inventory 사과 상자
     * @return 무게가 무거운 사과
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * 조건에 맞는 사과 조회
     *
     * @param inventory 사과 상자
     * @return 조건에 부합한 사과
     */
    public static List<Apple> filteredApplesByCodition(List<Apple> inventory, Predicate<Apple> isCondition) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (isCondition.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }
}
