package za.co.pronto.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ORDER")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_provider_id", nullable = false)
    private ServiceProvider serviceProvider;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "requesting_user", nullable = false)
    private User requestingUser;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "order")
    private OrderPayment orderPayment;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    public Order() {
    }

    public Order(Long orderId,
                 Date orderDate,
                 ServiceProvider serviceProvider,
                 User requestingUser,
                 List<OrderProduct> orderProducts,
                 OrderPayment orderPayment) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.serviceProvider = serviceProvider;
        this.requestingUser = requestingUser;
        this.orderProducts = orderProducts;
        this.orderPayment = orderPayment;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public User getRequestingUser() {
        return requestingUser;
    }

    public void setRequestingUser(User requestingUser) {
        this.requestingUser = requestingUser;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public void addOrderProduct(final OrderProduct orderProduct) {
        Objects.requireNonNull(orderProduct, "Can't add a null value");
    }

    public OrderPayment getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(OrderPayment orderPayment) {
        this.orderPayment = orderPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) &&
                Objects.equals(serviceProvider, order.serviceProvider) &&
                Objects.equals(requestingUser, order.requestingUser) &&
                Objects.equals(orderProducts, order.orderProducts) &&
                Objects.equals(orderPayment, order.orderPayment) &&
                Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, serviceProvider, requestingUser, orderProducts, orderPayment, orderDate);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", serviceProvider=" + serviceProvider +
                ", requestingUser=" + requestingUser +
                ", orderProducts=" + orderProducts +
                ", orderPayment=" + orderPayment +
                ", orderDate=" + orderDate +
                '}';
    }
}
