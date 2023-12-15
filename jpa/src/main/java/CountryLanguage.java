import jakarta.persistence.*;
@Entity
public class CountryLanguage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "countryLanguageId")
    private int countryLanguageId;
    @Basic
    @Column(name = "languageId")
    private Integer languageId;
    @Basic
    @Column(name = "countryId")
    private Integer countryId;
    public int getCountryLanguageId() {
        return countryLanguageId;
    }
    public void setCountryLanguageId(int countryLanguageId) {
        this.countryLanguageId = countryLanguageId;
    }
    public Integer getLanguageId() {
        return languageId;
    }
    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }
    public Integer getCountryId() {
        return countryId;
    }
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguage that = (CountryLanguage) o;
        if (countryLanguageId != that.countryLanguageId) return false;
        if (languageId != null ? !languageId.equals(that.languageId) : that.languageId != null) return false;
        if (countryId != null ? !countryId.equals(that.countryId) : that.countryId != null) return false;
        return true;
    }
    @Override
    public int hashCode() {
        int result = countryLanguageId;
        result = 31 * result + (languageId != null ? languageId.hashCode() : 0);
        result = 31 * result + (countryId != null ? countryId.hashCode() : 0);
        return result;
    }
}