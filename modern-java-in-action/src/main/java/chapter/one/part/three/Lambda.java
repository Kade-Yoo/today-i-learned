package chapter.one.part.three;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.*;
import java.util.stream.Stream;

public class Lambda {

    public static void quiz3_1() throws Exception {
        Runnable runnable = () -> {};
        Callable<String> stringCallable = () -> "Runnable";
        Callable<String> stringCallable1 = () -> { return "Mario"; };
//      (Integer i) -> return "allla" + i; -> expression ("alla" + i)와 키워드 (return)으로 이루어져 있기 때문에 statements에 해당하여 {}를 넣어줘야한다.
        Function<String, String> stringStringFunction = (String s) -> { return "Iron Man"; };

        runnable.run();
        System.out.println(stringCallable.call());
        System.out.println(stringCallable1.call());
        stringStringFunction.apply("T");
    }

    public static void quiz3_3() {
        Adder adder = Integer::sum;
        int add = adder.add(1, 2);
        System.out.println("add = " + add);
    }
    @FunctionalInterface
    public interface Adder {
        int add(int a, int b);
    }

    /**
     * FunctionalInterface의 조건은 한개의 추상 메소드가 존재할 때 이다.
     *
     * SmartAdder는 추상 메소드가 상속받은 Adder의 add메소드 하나, 그리고 SmartAdder에 하나. 총 2개이므로 FunctionalInterface가 될 수 없다.
     * Error Message : Multiple non-overriding abstract methods found in interface chapter.one.part.three.Lambda.SmartAdder
     *
     * Nothing는 추상 메소드가 한개 존재해야하지만 없기 때문에 FunctionalInterface가 될 수 없다.
     * No target method found
     */
    public interface SmartAdder extends Adder {
        int add(double a, double b);
    }

    public interface Nothing { }

    /**
     * 실행 어라운드 패턴에 필요한 예제
     *
     * @return 파일에서 읽은 내용 한줄
     * @throws IOException
     */
    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(""))) {
            return br.readLine();
        }
    }

    /**
     * 동작 파라미터화
     *
     * @return 파일에서 읽은 내용 한줄
     * @throws IOException
     */
    public static String processFile(BefferedReaderProcessor brp) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(""))) {
            return brp.process(br);
        }
    }

    @FunctionalInterface
    public interface BefferedReaderProcessor {
        String process(BufferedReader br) throws IOException;
    }

    /**
     * Predicate
     *
     * 활용 방안
     * - 같은 리스트에서 다른 조건으로 필터링을 하고 싶을 때
     * 사용처
     * - stream.filter
     * - stream.anyMatch
     */
    public static boolean testPredicate() {
        Predicate<String> predicate = String::isEmpty;
        Predicate<String> or = predicate.or(String::isEmpty);
        return predicate.or(or).or(or).or(or).test("");
    }

    /**
     * Consumer
     *
     * 활용 방안
     * - 루프를 돌면서 각 엘리먼트 별로 다른 set을 적용하고 싶을 때
     * - 서로 다른 print를 찍어주고 싶을 떄
     * - 서로 다른 log를 찍어주고 싶을 때
     * 사용처
     * - stream.forEach
     * - ArrayList
     * - Iterator
     */
    public static void acceptConsumer() {
        Consumer<String> consumer = (String str) -> System.out.println(str.toLowerCase());
        consumer.accept("Test");
    }

    /**
     * Function
     *
     * 활용 방안
     * - A to B로 변환할 때
     */
    public static void applyFunction() {
        Function<String, String> stringStringFunction = (String str) -> str.toLowerCase();
        stringStringFunction.apply("TesTTTTe");
    }

    /**
     * 기본형을 박싱하지 않고 함수형 인터페이스에서 사용하는 예제
     */
    public static void examplePrimitiveFunctionalInterface() {
        IntPredicate intPredicate = (int a) -> a > 0;
        DoublePredicate doublePredicate = (double d) -> d < 0;
        ToIntFunction<String> toIntFunction = (String str) -> str.length();
        Supplier<String> supplier = () -> "Supplire는 반환 값만 갖는다.";
    }
}
