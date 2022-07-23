package chapter.one.part.three;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("람다 메소드 참조 테스트")
class LambdaMethodReferenceTest {

    @Test
    @DisplayName("람다 클래스 static 메소드 참조 예제")
    void getStringToParseInteger() {
        int stringToParseInteger = LambdaMethodReference.getStringToParseInteger();
        assertEquals(stringToParseInteger, 4);
    }

    @Test
    @DisplayName("인스턴스를 활용한 메소드 참조")
    void isEmptyInputString() {
        boolean emptyInputString = LambdaMethodReference.isEmptyInputString();
        assertTrue(emptyInputString);
    }

    @Test
    @DisplayName("외부 인스턴스를 활용하여 메소드 참조")
    void getValueForTransaction() {
        String valueForTransaction = LambdaMethodReference.getValueForTransaction();
        assertEquals(valueForTransaction, "Hello World");
    }
}