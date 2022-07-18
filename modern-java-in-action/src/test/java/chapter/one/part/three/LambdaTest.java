package chapter.one.part.three;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LambdaTest {

    @Test
    @DisplayName("퀴즈3-1")
    void quiz3_1() throws Exception {
        Lambda.quiz3_1();
    }

    @Test
    @DisplayName("퀴즈3-2")
    void quiz3_2() {
        Lambda.quiz3_3();
    }

    @Test
    @DisplayName("람다 동작 파라미터화")
    void lambdaBehaviorParameterization() throws IOException {
        String readLineStr = Lambda.processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }

    @Test
    @DisplayName("Predicate")
    void predicate() {
        boolean b = Lambda.testPredicate();
        assertTrue(b);
    }
}