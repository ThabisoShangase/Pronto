package za.co.pronto.model;

import java.io.Serializable;

public enum PaymentMethod implements Serializable {

    CASH(1, "CASH"),
    CREDIT_CARD(2, "CREDIT CARD"),
    CREDIT(3, "CREDIT"),
    OTHER(4, "OTHER");

    private final int lookupId;
    private final String description;

    PaymentMethod(int lookupId, String description) {
        this.lookupId = lookupId;
        this.description = description;
    }

    public static PaymentMethod findByLookupId(int lookupId) {
        for (PaymentMethod paymentMethod: values()) {
            if (paymentMethod.lookupId == lookupId) {
                return paymentMethod;
            }
        }
        return null;
    }

    public static PaymentMethod findByDescription(String description) {
        for (PaymentMethod paymentMethod: values()) {
            if (paymentMethod.description == description) {
                return paymentMethod;
            }
        }
        return null;
    }
}
