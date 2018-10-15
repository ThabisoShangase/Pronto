package za.co.pronto.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_payment")
public class OrderPayment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderPaymentId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private ServiceOrder serviceOrder;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public OrderPayment() {
    }

    public OrderPayment(ServiceOrder serviceOrder,
                        Payment payment) {
        this.serviceOrder = serviceOrder;
        this.payment = payment;
    }

    public Long getOrderPaymentId() {
        return orderPaymentId;
    }

    public ServiceOrder getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPayment that = (OrderPayment) o;
        return Objects.equals(orderPaymentId, that.orderPaymentId) &&
                Objects.equals(serviceOrder, that.serviceOrder) &&
                Objects.equals(payment, that.payment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderPaymentId, serviceOrder, payment);
    }

    @Override
    public String toString() {
        return "OrderPayment{" +
                "orderPaymentId=" + orderPaymentId +
                ", serviceOrder=" + serviceOrder +
                ", payment=" + payment +
                '}';
    }
}
