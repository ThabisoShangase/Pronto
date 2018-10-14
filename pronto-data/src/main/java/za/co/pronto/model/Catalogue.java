package za.co.pronto.model;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Catalogue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catalogueId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_provider_id", unique = true)
    private ServiceProvider serviceProvider;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogue")
    private Set<CatalogueProduct> catalogueProducts = new HashSet<>();

    public Catalogue() {
    }

    public Catalogue(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
        this.catalogueProducts = catalogueProducts;
    }

    public Long getCatalogueId() {
        return catalogueId;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public Set<CatalogueProduct> getCatalogueProducts() {
        return catalogueProducts;
    }

    public void addCatalogueProduct(final CatalogueProduct catalogueProduct) {
        Objects.requireNonNull(catalogueProduct, "Can't add a null value");
        this.catalogueProducts.add(catalogueProduct);
    }

    public void setCatalogueProducts(Set<CatalogueProduct> catalogueProducts) {
        this.catalogueProducts = catalogueProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalogue catalogue = (Catalogue) o;
        return Objects.equals(catalogueId, catalogue.catalogueId) &&
                Objects.equals(serviceProvider, catalogue.serviceProvider) &&
                Objects.equals(catalogueProducts, catalogue.catalogueProducts);
    }

    @Override
    public int hashCode() {

        return Objects.hash(catalogueId, serviceProvider, catalogueProducts);
    }

    @Override
    public String toString() {
        return "Catalogue{" +
                "catalogueId=" + catalogueId +
                ", serviceProvider=" + serviceProvider +
                ", catalogueProducts=" + catalogueProducts +
                '}';
    }
}
