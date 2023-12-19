import jakarta.persistence.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = "currency")
public class Currency {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "currencyId")
    private int  currencyId;

    @Column(name = "currencyName")
    private String currencyName;

    @Column(name = "ISO4217")
    private int ISO4217;

    @Column(name= "subCurrency")
    private String subCurrency;

    @Column(name = "euroCost")
    private int euroCost;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "currencyId", referencedColumnName = "countryId")
    private Country country;

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public int getISO4217() {
        return ISO4217;
    }

    public void setISO4217(int ISO4217) {
        this.ISO4217 = ISO4217;
    }

    public String getSubCurrency() {
        return subCurrency;
    }

    public void setSubCurrency(String subCurrency) {
        this.subCurrency = subCurrency;
    }

    public int getEuroCost() {
        return euroCost;
    }

    public void setEuroCost(int euroCost) {
        this.euroCost = euroCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return currencyId == currency.currencyId && Objects.equals(currencyName, currency.currencyName) && Objects.equals(ISO4217, currency.ISO4217) && Objects.equals(subCurrency, currency.subCurrency) && Objects.equals(euroCost, currency.euroCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyId, currencyName, ISO4217, subCurrency, euroCost);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyId=" + currencyId +
                ", currencyName='" + currencyName + '\'' +
                ", ISO4217='" + ISO4217 + '\'' +
                ", subCurrency='" + subCurrency + '\'' +
                ", euroCost='" + euroCost + '\'' +
                '}';
    }
}

