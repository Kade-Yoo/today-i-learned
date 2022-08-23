package chapter.one.part.testcase;

import chapter.one.part.four.model.Dish;

import java.util.ArrayList;
import java.util.List;

public class DishTestCase {

    public List<Dish> getAllDishs() {
        List<Dish> allDishes = new ArrayList<>();
        allDishes.add(new Dish("탕수육", 400));
        allDishes.add(new Dish("볶음밥", 600));
        allDishes.add(new Dish("스테이크", 300));
        allDishes.add(new Dish("파스타", 100));
        allDishes.add(new Dish("갈비찜", 500));
        allDishes.add(new Dish("삼겹살", 200));
        return allDishes;
    }

    public List<Dish> getLowCaloryOrderByCalory() {
        List<Dish> lowCaloryOrderByCalory = new ArrayList<>();
        lowCaloryOrderByCalory.add(new Dish("파스타", 100));
        lowCaloryOrderByCalory.add(new Dish("삼겹살", 200));
        lowCaloryOrderByCalory.add(new Dish("스테이크", 300));
        return lowCaloryOrderByCalory;
    }
}
