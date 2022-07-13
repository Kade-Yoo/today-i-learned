package chapter.one.part.two;

import chapter.one.part.one.model.Apple;
import chapter.one.part.two.service.ApplePredicate;

import java.util.List;

import static enums.Color.RED;

public class AnonymousClass {

    /**
     * 다섯 번째 시도 : 익명 클래스 사용
     *
     * @param inventory 사과 상자
     * @return 빨간색 사과
     */
    public static List<Apple> filterRedApples(List<Apple> inventory) {
        return BehaviorParameterization.filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });
    }

    /**
     * 퀴즈 2-2 익명 클래스 문제
     *
     * 해당 퀴즈에서 말하고 싶은 것은 익명 클래스 내부에서 value를 어떤걸 사용하는 건지에 대한
     * 내용을 말하는 것 같다.
     */
    public static class MeaningOfThis {
        public final int value = 4;
        public void doIt() {
            int value = 6;
            Runnable r = new Runnable() {
                public final int value = 5;
                @Override
                public void run() {
                    int value = 10;
                    System.out.println("value = " + this.value);
                }
            };
            r.run();
        }

        public static void main(String[] args) {
            MeaningOfThis m = new MeaningOfThis();
            m.doIt();
        }
    }
}
