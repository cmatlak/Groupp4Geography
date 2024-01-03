package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "countryId")
    private int countryId;
    @Column(name = "countryName")
    private String countryName;
    @Column(name = "countryCode")
    private String countryCode;
    @Column(name = "capital")
    private String capital;
    @Column(name = "governmentType")
    private String governmentType;
    @Column(name = "population")
    private Integer population;
    @Column(name = "areaInKm2")
    private Integer areaInKm2;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currencyId")
    private Currency currency;
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<Language> languages;

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (countryId != country.countryId) return false;
        if (countryName != null ? !countryName.equals(country.countryName) : country.countryName != null) return false;
        if (countryCode != null ? !countryCode.equals(country.countryCode) : country.countryCode != null) return false;
        if (capital != null ? !capital.equals(country.capital) : country.capital != null) return false;
        if (governmentType != null ? !governmentType.equals(country.governmentType) : country.governmentType != null)
            return false;
        if (population != null ? !population.equals(country.population) : country.population != null) return false;
        if (areaInKm2 != null ? !areaInKm2.equals(country.areaInKm2) : country.areaInKm2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryId;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (governmentType != null ? governmentType.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        result = 31 * result + (areaInKm2 != null ? areaInKm2.hashCode() : 0);
        return result;
    }
    public String toString() {
        return  JPAUtil.Back_LithGrow+JPAUtil.ANSI_GREEN +" Name= " +
                JPAUtil.ANSI_RED + countryName +
                JPAUtil.ANSI_GREEN +" Code= " +JPAUtil.ANSI_RED+ countryCode +
                JPAUtil.ANSI_GREEN+" Capital= " +
                JPAUtil.ANSI_RED+capital +JPAUtil.ANSI_GREEN+
                " GovernmentType= "+JPAUtil.ANSI_RED + governmentType +
                JPAUtil.ANSI_GREEN+" Population= "+
                JPAUtil.ANSI_RED+ population +JPAUtil.ANSI_GREEN+
                " AreaInKm2= "+JPAUtil.ANSI_RED + areaInKm2 +"\n"+JPAUtil.ANSI_RESET;
    }
}
