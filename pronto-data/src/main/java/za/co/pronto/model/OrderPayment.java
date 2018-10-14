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
    private Order order;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public OrderPayment() {
    }

    public OrderPayment(Order order,
                        Payment payment) {
        this.order = order;
        this.payment = payment;
    }

    public Long getOrderPaymentId() {
        return orderPaymentId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
                Objects.equals(order, that.order) &&
                Objects.equals(payment, that.payment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderPaymentId, order, payment);
    }

    @Override
    public String toString() {
        return "OrderPayment{" +
                "orderPaymentId=" + orderPaymentId +
                ", order=" + order +
                ", payment=" + payment +
                '}';
    }
}
