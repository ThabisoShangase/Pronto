package za.co.pronto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "CATALOGUE_PRODUCT")
public class CatalogueProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalogue_product_id")
    private Long catalogueProductId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalogue_id", nullable = false)
    private Catalogue catalogue;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public CatalogueProduct() {
    }

    public CatalogueProduct(Catalogue catalogue,
                            Product product) {
        this.catalogue = catalogue;
        this.product = product;
    }

    public Long getCatalogueProductId() {
        return catalogueProductId;
    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogueProduct that = (CatalogueProduct) o;
        return Objects.equals(catalogueProductId, that.catalogueProductId) &&
                Objects.equals(catalogue, that.catalogue) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {

        return Objects.hash(catalogueProductId, catalogue, product);
    }

    @Override
    public String toString() {
        return "CatalogueProduct{" +
                "catalogueProductId=" + catalogueProductId +
                ", catalogue=" + catalogue +
                ", product=" + product +
                '}';
    }
}
