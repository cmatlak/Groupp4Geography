import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "language")
public class Language {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LanguageId")
    private int languageId;
    @Basic
    @Column(name = "language")
    private String language;
    @Basic
    @Column(name = "languageRoot")
    private String languageRoot;
    @Basic
    @Column(name = "alphabet")
    private String alphabet;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language1 = (Language) o;
        return languageId == language1.languageId && Objects.equals(language, language1.language) && Objects.equals(languageRoot, language1.languageRoot) && Objects.equals(alphabet, language1.alphabet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageId, language, languageRoot, alphabet);
    }

    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", language='" + language + '\'' +
                ", languageRoot='" + languageRoot + '\'' +
                ", alphabet='" + alphabet + '\'' +
                '}';
    }
}
