package service;

import static utils.ThreadUtils.sleep;

public class ThreadLocalStoreService {

    private ThreadLocal<String> productId = new ThreadLocal<>();

    public String save(String productId) {
        this.productId.set(productId);
        sleep();
        return this.productId.get();
    }
}
