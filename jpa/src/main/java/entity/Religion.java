package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "religion")
public class Religion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "religionId", nullable = false)
    private Integer id;

    @Column(name = "religionName", length = 50)
    private String religionName;

    @Column(name = "holyBook", length = 50)
    private String holyBook;

    @Column(name = "countryOfOrigin", length = 50)
    private String countryOfOrigin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
    }

    public String getHolyBook() {
        return holyBook;
    }

    public void setHolyBook(String holyBook) {
        this.holyBook = holyBook;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

}