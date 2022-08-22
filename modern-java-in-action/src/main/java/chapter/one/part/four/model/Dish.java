package chapter.one.part.four.model;


import lombok.Getter;

@Getter
public class Dish {
    private String dishName;
    private int calory;

    public Dish(String dishName, int calory) {
        this.dishName = dishName;
        this.calory = calory;
    }
}
