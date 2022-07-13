package chapter.one.part;

import chapter.one.part.one.model.Apple;
import enums.Color;

import java.util.ArrayList;
import java.util.List;

import static enums.Color.GREEN;
import static enums.Color.RED;

public class AppleTestCase {

    public static List<Apple> createAppleInventory() {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(130, GREEN));
        apples.add(new Apple(140, RED));
        apples.add(new Apple(160, RED));
        apples.add(new Apple(180, GREEN));
        apples.add(new Apple(150, GREEN));
        return apples;
    }

    public static List<Apple> createRedAppleInventory() {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(140, RED));
        apples.add(new Apple(160, RED));
        return apples;
    }

    public static List<Apple> createGreenAppleInventory() {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(130, GREEN));
        apples.add(new Apple(180, GREEN));
        apples.add(new Apple(150, GREEN));
        return apples;
    }

    public static List<Apple> createHeavyAppleInventory() {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(160, RED));
        apples.add(new Apple(180, GREEN));
        return apples;
    }
}
