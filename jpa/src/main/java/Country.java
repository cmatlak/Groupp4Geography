import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "countryId")
    private int countryId;
    @Basic
    @Column(name = "countryName")
    private String countryName;
    @Basic
    @Column(name = "countryCode")
    private String countryCode;
    @Basic
    @Column(name = "continent")
    private String continent;
    @Basic
    @Column(name = "areaInKm2")
    private Integer areaInKm2;
    @Basic
    @Column(name = "governmentType")
    private String governmentType;
    @Basic
    @Column(name = "governmentHead")
    private String governmentHead;
    @Basic
    @Column(name = "stateReligion")
    private String stateReligion;

    @OneToOne(mappedBy = "country")
    private Capital capital;

    @OneToOne
    private Language language;

    @OneToOne
    private Currency currency;

    @OneToOne
    private Population population;
    

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", continent='" + continent + '\'' +
                ", areaInKm2=" + areaInKm2 +
                ", governmentType='" + governmentType + '\'' +
                ", governmentHead='" + governmentHead + '\'' +
                ", stateReligion='" + stateReligion + '\'' +
                '}';
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Integer getAreaInKm2() {
        return areaInKm2;
    }

    public void setAreaInKm2(Integer areaInKm2) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (countryId != country.countryId) return false;
        if (countryName != null ? !countryName.equals(country.countryName) : country.countryName != null) return false;
        if (countryCode != null ? !countryCode.equals(country.countryCode) : country.countryCode != null) return false;
        if (continent != null ? !continent.equals(country.continent) : country.continent != null) return false;
        if (areaInKm2 != null ? !areaInKm2.equals(country.areaInKm2) : country.areaInKm2 != null) return false;
        if (governmentType != null ? !governmentType.equals(country.governmentType) : country.governmentType != null)
            return false;
        if (governmentHead != null ? !governmentHead.equals(country.governmentHead) : country.governmentHead != null)
            return false;
        if (stateReligion != null ? !stateReligion.equals(country.stateReligion) : country.stateReligion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryId;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (continent != null ? continent.hashCode() : 0);
        result = 31 * result + (areaInKm2 != null ? areaInKm2.hashCode() : 0);
        result = 31 * result + (governmentType != null ? governmentType.hashCode() : 0);
        result = 31 * result + (governmentHead != null ? governmentHead.hashCode() : 0);
        result = 31 * result + (stateReligion != null ? stateReligion.hashCode() : 0);
        return result;
    }

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }


}



