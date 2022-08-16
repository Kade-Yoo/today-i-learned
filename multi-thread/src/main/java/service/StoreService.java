package service;

import static utils.ThreadUtils.sleep;

public class StoreService {

    private String productId;

    public String save(String productId) {
        this.productId = productId;
        sleep(1000);
        return this.productId;
    }
}
