package chapter.one.part.three;

import chapter.one.part.one.model.Apple;
import enums.Color;

import java.util.function.Function;
import java.util.function.Supplier;

import static enums.Color.GREEN;

public class LambdaConstructorReference {

    public static Apple getSupplierApple() {
        Supplier<Apple> supplier = Apple::new;
        return supplier.get();
    }

    public static Apple getFunctionApple() {
        Function<Integer, Apple> function = Apple::new;
        return function.apply(100);
    }

    public static Apple getCustomFunctionalInterfaceApple() {
        AppleCustomFunction<Color, Integer, Integer, Apple> appleAppleCustomFunction = Apple::new;
        return appleAppleCustomFunction.apple(GREEN, 100, 100);
    }

    @FunctionalInterface
    public interface AppleCustomFunction<T, U, V, R> {

        R apple(T t, U u, V v);
    }
}
