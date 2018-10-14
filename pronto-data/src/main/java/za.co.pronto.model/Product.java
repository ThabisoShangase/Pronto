package za.co.pronto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name", nullable = false, length = 50)
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "cost", nullable = false, length = 5) //There's weird countries that use a bunch of decimal values
    private Double cost;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "product")
    private CatalogueProduct catalogueProduct;

    public Product() {
    }

    public Product(Long productId,
                   String productName,
                   String productDescription,
                   Double cost,
                   CatalogueProduct catalogueProduct) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.cost = cost;
        this.catalogueProduct = catalogueProduct;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public CatalogueProduct getCatalogueProduct() {
        return catalogueProduct;
    }

    public void setCatalogueProduct(CatalogueProduct catalogueProduct) {
        this.catalogueProduct = catalogueProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productDescription, product.productDescription) &&
                Objects.equals(cost, product.cost) &&
                Objects.equals(catalogueProduct, product.catalogueProduct);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productId, productName, productDescription, cost, catalogueProduct);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", cost=" + cost +
                ", catalogueProduct=" + catalogueProduct +
                '}';
    }
}
