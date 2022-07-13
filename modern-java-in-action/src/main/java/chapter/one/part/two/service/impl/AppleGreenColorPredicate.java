package chapter.one.part.two.service.impl;

import chapter.one.part.one.model.Apple;
import chapter.one.part.two.service.ApplePredicate;

import static enums.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
