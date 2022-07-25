package chapter.one.part.one.model;

import enums.Color;

import static enums.Color.GREEN;

public class Apple {

    private Integer weight;
    private Color color;
    public Apple(Integer weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple() {}
    public Apple(Integer weight) {
        this.weight = weight;
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
