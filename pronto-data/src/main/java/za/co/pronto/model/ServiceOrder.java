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
@Table(name = "SERVICE_ORDER")
public class ServiceOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_provider_id", nullable = false)
    private ServiceProvider serviceProvider;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserInfo requestingUserInfo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "serviceOrder")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "serviceOrder")
    private OrderPayment orderPayment;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    public ServiceOrder() {
    }

    public ServiceOrder(Long orderId,
                        Date orderDate,
                        ServiceProvider serviceProvider,
                        UserInfo requestingUserInfo,
                        List<OrderProduct> orderProducts,
                        OrderPayment orderPayment) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.serviceProvider = serviceProvider;
        this.requestingUserInfo = requestingUserInfo;
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

    public UserInfo getRequestingUserInfo() {
        return requestingUserInfo;
    }

    public void setRequestingUserInfo(UserInfo requestingUserInfo) {
        this.requestingUserInfo = requestingUserInfo;
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
        ServiceOrder serviceOrder = (ServiceOrder) o;
        return Objects.equals(orderId, serviceOrder.orderId) &&
                Objects.equals(serviceProvider, serviceOrder.serviceProvider) &&
                Objects.equals(requestingUserInfo, serviceOrder.requestingUserInfo) &&
                Objects.equals(orderProducts, serviceOrder.orderProducts) &&
                Objects.equals(orderPayment, serviceOrder.orderPayment) &&
                Objects.equals(orderDate, serviceOrder.orderDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, serviceProvider, requestingUserInfo, orderProducts, orderPayment, orderDate);
    }

    @Override
    public String toString() {
        return "ServiceOrder{" +
                "orderId=" + orderId +
                ", serviceProvider=" + serviceProvider +
                ", requestingUserInfo=" + requestingUserInfo +
                ", orderProducts=" + orderProducts +
                ", orderPayment=" + orderPayment +
                ", orderDate=" + orderDate +
                '}';
    }
}
