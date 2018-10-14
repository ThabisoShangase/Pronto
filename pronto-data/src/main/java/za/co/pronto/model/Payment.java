package za.co.pronto.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PAYMENT")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "payment_amount", length = 8, nullable = false)
    private Double paymentAmount;

    @Column(name = "currency_code", length = 6)
    private String currencyCode;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", length = 15)
    private PaymentMethod paymentMethod;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "payment")
    private OrderPayment orderPayment;

    public Payment() {
    }

    public Payment(Double paymentAmount,
                   String currencyCode,
                   Date paymentDate,
                   PaymentMethod paymentMethod) {
        this.paymentAmount = paymentAmount;
        this.currencyCode = currencyCode;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paymentId, payment.paymentId) &&
                Objects.equals(paymentAmount, payment.paymentAmount) &&
                Objects.equals(currencyCode, payment.currencyCode) &&
                Objects.equals(paymentDate, payment.paymentDate) &&
                Objects.equals(paymentMethod, payment.paymentMethod);
    }

    @Override
    public int hashCode() {

        return Objects.hash(paymentId, paymentAmount, currencyCode, paymentDate, paymentMethod);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentAmount=" + paymentAmount +
                ", currencyCode='" + currencyCode + '\'' +
                ", paymentDate=" + paymentDate +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
