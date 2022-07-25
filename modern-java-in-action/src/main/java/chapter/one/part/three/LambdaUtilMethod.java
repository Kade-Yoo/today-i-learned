package chapter.one.part.three;

import chapter.one.part.one.model.Apple;

import java.util.List;

import static java.util.Comparator.comparing;

public class LambdaUtilMethod {

    public static List<Apple> sortApples(List<Apple> inventory) {
        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        return inventory;
    }
}
