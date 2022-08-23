package chapter.one.part.four;

import chapter.one.part.four.model.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiFeatures {

    /**
     * 저칼로리의 요리명을 반환하고, 칼로리를 기준으로 요리를 정렬하는 로직 구현 (Java 8 이전)
     * @param dishes 저칼로리의 요리명을 반환하고, 칼로리를 기준으로 요리를 정렬한 결과
     */
    public List<Dish> getLowCaloriesOrderByCaloryBeforeJava8(List<Dish> dishes) {
        long begin = System.currentTimeMillis();
        List<Dish> lowCaloriesDishes = new ArrayList<>();

        for (Dish dish : dishes) {
            if (dish.getCalory() < 400) {
                lowCaloriesDishes.add(dish);
            }
        }

        Collections.sort(lowCaloriesDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalory(), o2.getCalory());
            }
        });

        System.out.println("Java 8 이전 : " + (System.currentTimeMillis() - begin));
        return lowCaloriesDishes;
    }

    /**
     * 저칼로리의 요리명을 반환하고, 칼로리를 기준으로 요리를 정렬하는 로직 구현 (Java 8 이후 Standard Stream)
     * @param dishes 저칼로리의 요리명을 반환하고, 칼로리를 기준으로 요리를 정렬한 결과
     */
    public List<Dish> getLowCaloriesOrderByCaloryAfterJava8(List<Dish> dishes) {
        long begin = System.currentTimeMillis();
        List<Dish> result = dishes.stream()
                .filter(dish -> dish.getCalory() < 400)
                .sorted(Comparator.comparingInt(Dish::getCalory))
                .collect(Collectors.toList());
        System.out.println("Java 8 이후(Standard Stream) : " + (System.currentTimeMillis() - begin));
        return result;
    }

    /**
     * 저칼로리의 요리명을 반환하고, 칼로리를 기준으로 요리를 정렬하는 로직 구현 (Java 8 이후 Parallel Stream)
     * @param dishes 저칼로리의 요리명을 반환하고, 칼로리를 기준으로 요리를 정렬한 결과
     */
    public List<Dish> getParallelLowCaloriesOrderByCaloryAfterJava8(List<Dish> dishes) {
        long begin = System.currentTimeMillis();
        List<Dish> result = dishes.parallelStream()
                .filter(dish -> dish.getCalory() < 400)
                .sorted(Comparator.comparingInt(Dish::getCalory))
                .collect(Collectors.toList());
        System.out.println("Java 8 이후(Parallel Stream) : " + (System.currentTimeMillis() - begin));
        return result;
    }
}
