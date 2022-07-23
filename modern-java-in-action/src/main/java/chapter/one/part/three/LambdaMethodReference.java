package chapter.one.part.three;

import java.util.List;
import java.util.function.*;

/**
 * 람다 메소드 참조
 */
public class LambdaMethodReference {

    /**
     * static 클래스를 이용한 메소드 참조
     */
    public static int getStringToParseInteger() {
        Function<String, Integer> stringFunction = Integer::parseInt;
        return stringFunction.apply("4");
    }

    /**
     * 인스턴스화하여 이용한 메소드 참조
     */
    public static boolean isEmptyInputString() {
        Predicate<String> stringPredicate = String::isEmpty;
        return stringPredicate.test("");
    }

    /**
     * 인스턴스를 지역변수에 담아 메소드 참조
     */
    public static String getValueForTransaction() {
        String stringInstance = getStringInstance();
        Supplier<String> stringSupplier = stringInstance::toString;
        return stringSupplier.get();
    }

    public static String getStringInstance() {
        return new String("Hello World");
    }

    public static void quiz3_6() {
        ToIntFunction<String> stringToIntFunction = (String s) -> Integer.parseInt(s);
        BiPredicate<List<String>, String> contains = (list, element) ->list.contains(element);
        Predicate<String> starsWithNumber = getStringInstance()::startsWith;
    }
}
