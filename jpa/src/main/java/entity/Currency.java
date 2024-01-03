package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "currencyId")
    private int currencyId;
    @Column(name = "currencyName")
    private String currencyName;
    @Column(name = "ISO4217")
    private String iso4217;
    @Column(name = "subCurrency")
    private String subCurrency;
    @Column(name = "euroCost")
    private String euroCost;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        if (currencyId != currency.currencyId) return false;
        if (currencyName != null ? !currencyName.equals(currency.currencyName) : currency.currencyName != null)
            return false;
        if (iso4217 != null ? !iso4217.equals(currency.iso4217) : currency.iso4217 != null) return false;
        if (subCurrency != null ? !subCurrency.equals(currency.subCurrency) : currency.subCurrency != null)
            return false;
        if (euroCost != null ? !euroCost.equals(currency.euroCost) : currency.euroCost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = currencyId;
        result = 31 * result + (currencyName != null ? currencyName.hashCode() : 0);
        result = 31 * result + (iso4217 != null ? iso4217.hashCode() : 0);
        result = 31 * result + (subCurrency != null ? subCurrency.hashCode() : 0);
        result = 31 * result + (euroCost != null ? euroCost.hashCode() : 0);
        return result;
    }
    public String toString() {
        return  JPAUtil.Back_LithGrow+JPAUtil.ANSI_RED + currencyName +JPAUtil.ANSI_GREEN+
                " iso4217= "+JPAUtil.ANSI_RED + iso4217 +JPAUtil.ANSI_GREEN +
                " subCurrency= "+JPAUtil.ANSI_RED + subCurrency +JPAUtil.ANSI_GREEN+
                " euroCost= "+JPAUtil.ANSI_RED + euroCost +JPAUtil.ANSI_RESET;
    }
}
