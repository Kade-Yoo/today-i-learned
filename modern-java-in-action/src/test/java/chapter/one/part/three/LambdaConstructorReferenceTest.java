package chapter.one.part.three;

import chapter.one.part.one.model.Apple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static enums.Color.GREEN;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("람다 생성자 참조 테스트 예제")
class LambdaConstructorReferenceTest {

    @Test
    @DisplayName("람다 생성자 참조 파라미터가 없을 때")
    void getSupplierApple() {
        Apple supplierApple = LambdaConstructorReference.getSupplierApple();
        assertNull(supplierApple.getWeight());
    }

    @Test
    @DisplayName("람다 생성자 참조 파라미터가 한 개 존재할 때")
    void getFunctionApple() {
        Apple functionApple = LambdaConstructorReference.getFunctionApple();
        assertEquals(functionApple.getWeight(), 100);
    }

    @Test
    @DisplayName("람다 생성자 참조 파라미터가 세 개 존재할 때")
    void getCustomFunctionalInterfaceApple() {
        Apple customFunctionalInterfaceApple = LambdaConstructorReference.getCustomFunctionalInterfaceApple();
        assertEquals(customFunctionalInterfaceApple.getColor(), GREEN);
    }
}