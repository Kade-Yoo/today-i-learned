package chapter.one.part.one;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 동작 파라미터화
 */
public class BehaviorParameterization {

    private final List<String> customerIds;

    public BehaviorParameterization(List<String> customerIds) {
        this.customerIds = new ArrayList<>(customerIds);
    }

    /**
     * Java8 이전 정렬 로직으로 구현한 CustomerId 조회
     * @return 정렬된 CustomerId
     */
    public List<String> getCustomerIdBySortBeforeJava8() {
        customerIds.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        return customerIds;
    }

    /**
     * Java8 이후 정렬 로직으로 구현한 CustomerId 조회
     * @return 정렬된 CustomerId
     */
    public List<String> getCustomerIdBySortAfterJava8() {
        customerIds.sort(Comparator.comparing(String::new));
        return customerIds;
    }
}
