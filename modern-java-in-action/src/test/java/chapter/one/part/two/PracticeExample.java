package chapter.one.part.two;

import chapter.one.part.one.model.Apple;

import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 2.4 실전 예제
 */
public class PracticeExample {

    /**
     * 2.4.1 Comparator로 정렬하기 람다 사용 X
     * @param inventory 사과 상자
     */
    public static void sortApplesNotLambda(List<Apple> inventory) {
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
    }

    /**
     * 2.4.1 Comparator로 정렬하기 람다 사용 O
     * @param inventory 사과 상자
     */
    public static void sortApples(List<Apple> inventory) {
        inventory.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
    }

    /**
     * 2.4.2 Runnable로 코드 블록 실행하기 람다 사용 X
     */
    public static void printNotLambda() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        });
    }

    /**
     * 2.4.2 Runnable로 코드 블록 실행하기 람다 사용 O
     */
    public static void print() {
        Thread thread = new Thread(() -> System.out.println("Hello world"));
    }

    /**
     * 2.4.3 Callable을 결과로 반환하기 람다 X
     */
    public static void executeCallableNotLambda() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });
    }

    /**
     * 2.4.3 Callable을 결과로 반환하기 람다 O
     */
    public static void executeCallable() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName = executorService.submit(() -> Thread.currentThread().getName());
    }
}
