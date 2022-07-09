package chapter.one.part.one;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 동적 파라미터화 예시 테스트
 *
 * 1. 정렬 로직을 Java8 이전, Java8 이후로 구분하여 테스트 진행
 * 2. 테스트가 중점이 아니기 때문에 케이스별 테스트는 TODO 작업으로 진행
 * 3. 케이스별 테스트 이전엔 입력받은 customerIds와 정렬된 customerIds는 불변 리스트로 사용
 */
class BehaviorParameterizationTest {

    private BehaviorParameterization behaviorParameterization;
    private final String errorMessage = "List가 null입니다. 다시 확인해주세요.";
    private final List<String> customerIds = new ArrayList<>(Arrays.asList("A12349", "A12346", "A12347", "A12348", "A12345"));
    private final List<String> customerIdsSortByAsc = new ArrayList<>(Arrays.asList("A12345", "A12346", "A12347", "A12348", "A12349"));

    @BeforeEach
    void setUp() {
        behaviorParameterization = new BehaviorParameterization(createCustomerIds());
    }

    @Test
    @DisplayName("Java8 이전 정렬 방식으로 구현한 CustomerId 결과")
    void getCustomerIdBySortBeforeJava8() {
        List<String> customerIdBySortBeforeJava8 = behaviorParameterization.getCustomerIdBySortBeforeJava8();
        assertIterableEquals(customerIdBySortBeforeJava8, createCustomerIdsSortedByAsc(), errorMessage);
    }

    @Test
    @DisplayName("Java8 이후 정렬 방식으로 구현한 CustomerId 결과")
    void getCustomerIdBySortAfterJava8() {
        List<String> customerIdBySortAfterJava8 = behaviorParameterization.getCustomerIdBySortAfterJava8();
        assertIterableEquals(customerIdBySortAfterJava8, createCustomerIdsSortedByAsc(), errorMessage);
    }

    List<String> createCustomerIds() {
        return customerIds;
    }

    List<String> createCustomerIdsSortedByAsc() {
        return customerIdsSortByAsc;
    }
}