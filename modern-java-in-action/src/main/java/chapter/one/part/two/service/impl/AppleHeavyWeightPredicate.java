package chapter.one.part.two.service.impl;

import chapter.one.part.one.model.Apple;
import chapter.one.part.two.service.ApplePredicate;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
