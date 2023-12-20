package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "languageId", nullable = false)
    private Integer id;


    @Column(name = "language", length = 50)
    private String language;

    @Column(name = "languageRoot", length = 50)
    private String languageRoot;

    @Column(name = "alphabet", length = 50)
    private String alphabet;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}