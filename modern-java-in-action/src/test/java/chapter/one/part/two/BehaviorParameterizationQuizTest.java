package chapter.one.part.two;

import chapter.one.part.AppleTestCase;
import chapter.one.part.one.model.Apple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BehaviorParameterizationQuizTest {

    @Test
    @DisplayName("무게 출력 예제")
    void prettypPrintApple_무게() {
        List<Apple> appleInventory = AppleTestCase.createAppleInventory();
        BehaviorParameterizationQuiz.ApplePrintWeightFunction appleFunction = new BehaviorParameterizationQuiz.ApplePrintWeightFunction();
        BehaviorParameterizationQuiz.prettypPrintApple(appleInventory, appleFunction);
    }

    @Test
    @DisplayName("무게가 가벼운지 무거운지 출력 예제")
    void prettypPrintApple_가벼운지_무거운지() {
        List<Apple> appleInventory = AppleTestCase.createAppleInventory();
        BehaviorParameterizationQuiz.ApplePrintWhetherHeavyAndLighttWeightFunction appleFunction = new BehaviorParameterizationQuiz.ApplePrintWhetherHeavyAndLighttWeightFunction();
        BehaviorParameterizationQuiz.prettypPrintApple(appleInventory, appleFunction);
    }
}