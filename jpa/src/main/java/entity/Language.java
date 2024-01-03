package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "languageId", nullable = false)
    private int languageId;
    @Column(name = "language")
    private String language;
    @Column(name = "languageRoot")
    private String languageRoot;
    @Column(name = "alphabet")
    private String alphabet;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "languageCountryId")
    private Country country;

    public int getLanguageId() {
        return languageId;
    }


    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguageRoot() {
        return languageRoot;
    }

    public void setLanguageRoot(String languageRoot) {
        this.languageRoot = languageRoot;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language1 = (Language) o;
        return languageId == language1.languageId && Objects.equals(language, language1.language) && Objects.equals(languageRoot, language1.languageRoot) && Objects.equals(alphabet, language1.alphabet) && Objects.equals(country, language1.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageId, language, languageRoot, alphabet, country);
    }

    public String toString() {
        return JPAUtil.Back_LithGrow + JPAUtil.ANSI_RED + language + JPAUtil.ANSI_GREEN +
                " languageRoot= " + JPAUtil.ANSI_RED + languageRoot + JPAUtil.ANSI_GREEN +
                " alphabet= " + JPAUtil.ANSI_RED + alphabet + "\n";
    }
}
