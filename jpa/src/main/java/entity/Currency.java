package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currencyId", nullable = false)
    private Integer id;

    @Column(name = "currencyName", length = 50)
    private String currencyName;

    @Column(name = "ISO4217", length = 50)
    private String iso4217;

    @Column(name = "subCurrency", length = 50)
    private String subCurrency;

    @Column(name = "euroCost", length = 50)
    private String euroCost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getIso4217() {
        return iso4217;
    }

    public void setIso4217(String iso4217) {
        this.iso4217 = iso4217;
    }

    public String getSubCurrency() {
        return subCurrency;
    }

    public void setSubCurrency(String subCurrency) {
        this.subCurrency = subCurrency;
    }

    public String getEuroCost() {
        return euroCost;
    }

    public void setEuroCost(String euroCost) {
        this.euroCost = euroCost;
    }


}