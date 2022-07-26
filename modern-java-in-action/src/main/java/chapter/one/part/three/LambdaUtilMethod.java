package chapter.one.part.three;

import chapter.one.part.one.model.Apple;
import enums.Color;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class LambdaUtilMethod {

    public static List<Apple> sortApples(List<Apple> inventory) {
        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        return inventory;
    }

    /**
     * Predicate Negative
     */
    public static List<Apple> predicateNegativeApples(List<Apple> inventory) {
        Predicate<Apple> applePredicate = Apple::isGreenApple;
        return inventory.stream().filter(applePredicate.negate()).collect(Collectors.toList());
    }

    /**
     * Predicate And Predicate
     */
    public static List<Apple> predicateAndPredicateApples(List<Apple> inventory) {
        Predicate<Apple> greenApple = Apple::isGreenApple;
        Predicate<Apple> heavyApple = Apple::isHeavyApple;
        return inventory.stream().filter(greenApple.and(heavyApple)).collect(Collectors.toList());
    }

    /**
     * Predicate or Predicate
     */
    public static List<Apple> predicateOrPredicateApples(List<Apple> inventory) {
        Predicate<Apple> greenApple = Apple::isGreenApple;
        Predicate<Apple> heavyApple = Apple::isHeavyApple;
        return inventory.stream().filter(greenApple.or(heavyApple)).collect(Collectors.toList());
    }

    /**
     * g(f(x))
     */
    public static List<String> composeApples(List<Apple> inventory) {
        Function<Apple, String> appleFunction = Apple::toString;
        Function<Apple, Apple> copyFunction = Apple::new;
        return inventory.stream().map(appleFunction.compose(copyFunction)).collect(Collectors.toList());
    }

    /**
     * f(g(x))
     */
    public static List<Apple> thenApples(List<Apple> inventory) {
        Function<Apple, String> appleFunction = Apple::getColorName;
        Function<String, Apple> copyFunction = Apple::new;
        return inventory.stream().map(appleFunction.andThen(copyFunction)).collect(Collectors.toList());
    }
}
