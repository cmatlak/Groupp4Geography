import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "countryId")
    private int id;

    @Column(name = "countryName")
    private String countryName;

    @Column(name = "countryCode")
    private String countryCode;

    @Column(name= "continent")
    private String continent;

    @Column(name = "areaInKm2")
    private String areaInKm2;

    @Column(name="governmentType")
    private String governmentType;

    @Column(name = "governmentHead")
    private String governmentHead;

    @Column(name = "stateReligion")
    private String stateReligion;


    
    public int getId() {
        return id;
    }

    public Country setId(int id) {
        this.id = id;
        return this;
    }

    public String getCountryName() {
        return countryName;
    }

    public Country setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Country setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }


    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getAreaInKm2() {
        return areaInKm2;
    }

    public void setAreaInKm2(String areaInKm2) {
        this.areaInKm2 = areaInKm2;
    }

    public String getGovernmentType() {
        return governmentType;
    }

    public void setGovernmentType(String governmentType) {
        this.governmentType = governmentType;
    }

    public String getGovernmentHead() {
        return governmentHead;
    }

    public void setGovernmentHead(String governmentHead) {
        this.governmentHead = governmentHead;
    }

    public String getStateReligion() {
        return stateReligion;
    }

    public void setStateReligion(String stateReligion) {
        this.stateReligion = stateReligion;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Country country = (Country) o;
        return Objects.equals(getId(), country.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", continent='" + continent + '\'' +
                ", areaInKm2='" + areaInKm2 + '\'' +
                ", governmentType='" + governmentType + '\'' +
                ", governmentHead='" + governmentHead + '\'' +
                ", stateReligion='" + stateReligion + '\'' +
                '}';
    }
}
