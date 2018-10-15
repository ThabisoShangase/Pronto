package za.co.pronto.model;

import javax.persistence.CascadeType;
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
@Table(name = "SERVICE_PROVIDER")
public class ServiceProvider implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_provider_id")
    private Long serviceProviderId;

    @Column(name = "provider_name", nullable = false)
    private String providerName;

    @Column(name = "provider_details")
    private String providerDetails;

    @Column(name = "provider_logo")
    private String providerLogo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "serviceProvider")
    private Catalogue catalogue;

    public ServiceProvider() {
    }

    public ServiceProvider(String providerName,
                           String providerDetails,
                           String providerLogo,
                           Catalogue catalogue) {
        this.providerName = providerName;
        this.providerDetails = providerDetails;
        this.providerLogo = providerLogo;
        this.catalogue = catalogue;
    }

    public Long getServiceProviderId() {
        return serviceProviderId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderDetails() {
        return providerDetails;
    }

    public void setProviderDetails(String providerDetails) {
        this.providerDetails = providerDetails;
    }

    public String getProviderLogo() {
        return providerLogo;
    }

    public void setProviderLogo(String providerLogo) {
        this.providerLogo = providerLogo;
    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceProvider that = (ServiceProvider) o;
        return Objects.equals(serviceProviderId, that.serviceProviderId) &&
                Objects.equals(providerName, that.providerName) &&
                Objects.equals(providerDetails, that.providerDetails) &&
                Objects.equals(providerLogo, that.providerLogo) &&
                Objects.equals(catalogue, that.catalogue);
    }

    @Override
    public int hashCode() {

        return Objects.hash(serviceProviderId, providerName, providerDetails, providerLogo, catalogue);
    }

    @Override
    public String toString() {
        return "ServiceProvider{" +
                "serviceProviderId=" + serviceProviderId +
                ", providerName='" + providerName + '\'' +
                ", providerDetails='" + providerDetails + '\'' +
                ", providerLogo='" + providerLogo + '\'' +
                ", catalogue=" + catalogue +
                '}';
    }
}