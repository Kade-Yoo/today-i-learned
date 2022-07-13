package chapter.one.part.two;

import chapter.one.part.one.model.Apple;
import chapter.one.part.two.service.ApplePredicate;
import enums.Color;

import java.util.ArrayList;
import java.util.List;

import static enums.Color.GREEN;

/**
 * Behavior Parameterization
 *
 * 첫 번째 요구사항 : 녹색 사과만 필터링 해달라는 요구사항만 있다면 해당 메소드만 정의하면 된다.
 * 두 번째 요구사항 : 녹색 외에 다른 색상이 필요할 수도 있다
 * 세 번째 요구사항 : 색상 외에 다른 조건이 추가될 수 있다. -> 플래그값으로 추가를 했기 떄문에 다소 확장성이 부족하다
 * 네 번째 요구사항 : 해당 메소드는 공통으로 사용할 수 있도록 변경하는 것이 바람직하다.
 */
public class BehaviorParameterization {

    /**
     * 2.1.1 첫 번째 시도 : 녹색 사과 필터링
     *
     * @param inventory 사과 상자
     * @return 녹색 사과
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
     * 2.1.2 두 번째 시도 : 색을 파라미터화
     *
     * @param inventory 사과 상자
     * @param color 필터가 필요한 색상
     * @return 색상에 따라 필터된 사과
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color == apple.getColor()) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * 2.1.2 두 번째 시도 : 무게 파라미터화
     *
     * @param inventory 사과 상자
     * @param weight 무게
     * @return 무게로 필터한 사과
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * 2.1.3 세 번째 시도 : 가능한 모든 속성으로 필터링
     *
     * @param inventory 사과 상자
     * @param color 색상
     * @param weight 무게
     * @param flag 색상, 무게 여부
     */
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor() == color) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate applePredicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }
}
