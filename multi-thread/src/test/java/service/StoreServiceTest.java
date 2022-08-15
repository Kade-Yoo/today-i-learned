package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ThreadUtils;

@DisplayName("Thread Local을 사용하지 않은 동시성 테스트")
class StoreServiceTest {

    private StoreService storeService;

    @BeforeEach
    public void init() {
        this.storeService = new StoreService();
    }

    @Test
    @DisplayName("동시성이 발생하는 경우")
    void 동시성이_발생하는_경우() {
        System.out.println("동시성 로직 실행");
        Runnable productA = () -> System.out.println("productA = " + storeService.save("productA"));
        Runnable productB = () -> System.out.println("productB = " + storeService.save("productB"));

        Thread threadA = new Thread(productA);
        threadA.setName("thread - A");

        Thread threadB = new Thread(productB);
        threadB.setName("thread - B");

        threadA.start();
        ThreadUtils.sleep(10);
        threadB.start();
        ThreadUtils.sleep(1000);
        System.out.println("동시성 로직 종료");
    }

    @Test
    @DisplayName("동시성이 발생하지 않는 경우")
    void 동시성이_발생하지_않는_경우() {
        System.out.println("동시성 로직 실행");
        Runnable productA = () -> System.out.println("productA = " + storeService.save("productA"));
        Runnable productB = () -> System.out.println("productB = " + storeService.save("productB"));

        Thread threadA = new Thread(productA);
        threadA.setName("thread - A");

        Thread threadB = new Thread(productB);
        threadB.setName("thread - B");

        threadA.start();
        ThreadUtils.sleep(1000);
        threadB.start();
        ThreadUtils.sleep(1000);
        System.out.println("동시성 로직 종료");
    }
}