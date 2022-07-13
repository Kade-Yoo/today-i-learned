package chapter.one.part.two;

import chapter.one.part.one.model.Apple;

import java.util.List;

/**
 * BehaviorParameterization 퀴즈
 */
public class BehaviorParameterizationQuiz {

    /**
     * 퀴즈 2-1 유연한 prettyPrintApple 메서드 구현하기
     *
     * @param inventory 사과 상자
     * @param appleFunction 출력할 내용이 담긴 함수
     */
    public static void prettypPrintApple(List<Apple> inventory, AppleFunction appleFunction) {
        for (Apple apple : inventory) {
            String output = appleFunction.execute(apple);
            System.out.println(output);
        }
    }

    public interface AppleFunction {

        String execute(Apple apple);
    }

    public static class ApplePrintWeightFunction implements AppleFunction {

        @Override
        public String execute(Apple apple) {
            return "사과의 무게는 " + apple.getWeight() + " 입니다.";
        }
    }

    public static class ApplePrintWhetherHeavyAndLighttWeightFunction implements AppleFunction {

        @Override
        public String execute(Apple apple) {
            if (apple.getWeight() < 150) {
                return "사과의 무게는 " + apple.getWeight() + "이며, 가볍습니다.";
            } else {
                return "사과의 무게는 " + apple.getWeight() + "이며, 무겁습니다.";
            }
        }
    }
}
