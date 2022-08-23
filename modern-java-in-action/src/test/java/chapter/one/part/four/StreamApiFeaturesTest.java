package chapter.one.part.four;

import chapter.one.part.four.model.Dish;
import chapter.one.part.testcase.DishTestCase;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class StreamApiFeaturesTest {

    private DishTestCase dishTestCase;
    private StreamApiFeatures streamApiFeatures;

    @BeforeEach
    void init() {
        dishTestCase = new DishTestCase();
        streamApiFeatures = new StreamApiFeatures();
    }

    @Test
    @DisplayName("낮은 칼로리이면서 칼로리로 정렬했을 때(Java 8 이전 로직)")
    void getLowCaloriesOrderByCaloryBeforeJava8() {
        List<Dish> allDishs = dishTestCase.getAllDishs();
        List<Dish> lowCaloriesOrderByCaloryBeforeJava8 = streamApiFeatures.getLowCaloriesOrderByCaloryBeforeJava8(allDishs);
        Assertions.assertThat(lowCaloriesOrderByCaloryBeforeJava8)
                .extracting(Dish::getDishName, Dish::getCalory)
                .containsAll(getTupleLowCaloriesOrderByCalory());
    }

    @Test
    @DisplayName("낮은 칼로리이면서 칼로리로 정렬했을 때(Java 8 이후 로직 Standard Stream)")
    void getLowCaloriesOrderByCaloryAfterJava8() {
        List<Dish> allDishs = dishTestCase.getAllDishs();
        List<Dish> lowCaloriesOrderByCaloryAfterJava8 = streamApiFeatures.getLowCaloriesOrderByCaloryAfterJava8(allDishs);
        Assertions.assertThat(lowCaloriesOrderByCaloryAfterJava8)
                .extracting(Dish::getDishName, Dish::getCalory)
                .containsAll(getTupleLowCaloriesOrderByCalory());
    }

    @Test
    @DisplayName("낮은 칼로리이면서 칼로리로 정렬했을 때(Java 8 이후 로직 Parallel Stream)")
    void getParallelLowCaloriesOrderByCaloryAfterJava8() {
        List<Dish> allDishs = dishTestCase.getAllDishs();
        List<Dish> lowCaloriesOrderByCaloryAfterJava8 = streamApiFeatures.getParallelLowCaloriesOrderByCaloryAfterJava8(allDishs);
        Assertions.assertThat(lowCaloriesOrderByCaloryAfterJava8)
                .extracting(Dish::getDishName, Dish::getCalory)
                .containsAll(getTupleLowCaloriesOrderByCalory());
    }

    private Iterable<Tuple> getTupleLowCaloriesOrderByCalory() {
        return  dishTestCase.getLowCaloryOrderByCalory()
                .stream()
                .map(dish -> tuple(dish.getDishName(), dish.getCalory()))
                .collect(Collectors.toList());
    }
}