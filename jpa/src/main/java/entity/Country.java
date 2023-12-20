package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "countryId", nullable = false)
    private Integer id;

    @Column(name = "countryName", length = 50)
    private String countryName;

    @Column(name = "countryCode", length = 5)
    private String countryCode;

    @Column(name = "capital", length = 50)
    private String capital;

    @Column(name = "governmentType", length = 50)
    private String governmentType;

    @Column(name = "population")
    private Integer population;

    @Column(name = "areaInKm2")
    private Integer areaInKm2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "languageId")
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currencyId")
    private Currency currency;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getGovernmentType() {
        return governmentType;
    }

    public void setGovernmentType(String governmentType) {
        this.governmentType = governmentType;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getAreaInKm2() {
        return areaInKm2;
    }

    public void setAreaInKm2(Integer areaInKm2) {
        this.areaInKm2 = areaInKm2;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", capital='" + capital + '\'' +
                ", governmentType='" + governmentType + '\'' +
                ", population=" + population +
                ", areaInKm2=" + areaInKm2 +
                ", language=" + language +
                ", currency=" + currency +
                '}';
    }
}