package chapter.one.part.one.model;

import enums.Color;
import static enums.Color.GREEN;

public class Apple {

    private Integer weight;
    private Color color;

    public Apple() {}
    public Apple(Integer weight) {
        this.weight = weight;
    }
    public Apple(String colorName) {
        this.color = Color.valueOf(colorName);
    }

    /**
     * 멤버 변수 접근이 불가한데 어떻게 멤버 변수를 직접적으로 접근을 할 수 있을까?
     */
    public Apple(Apple apple) {
        this.color = apple.color;
        this.weight = apple.weight;
    }

    public Apple(Integer weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple(Color s, Integer integer, Integer integer1) {
        this.color = s;
        this.weight = integer;
    }

    public Integer getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public String getColorName() {
        return color.name();
    }

    public static boolean isGreenApple(Apple apple) {
        return GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public String toString() {
        return "무게 : " + this.weight + ", 색상 : " + this.color;
    }
}
