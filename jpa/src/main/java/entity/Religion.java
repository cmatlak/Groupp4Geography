package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "religion")
public class Religion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "religionId")
    private int religionId;
    @Column(name = "religionName")
    private String religionName;
    @Column(name = "holyBook")
    private String holyBook;
    @Column(name = "countryOfOrigin")
    private String countryOfOrigin;

    public int getReligionId() {
        return religionId;
    }

    public void setReligionId(int religionId) {
        this.religionId = religionId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Religion religion = (Religion) o;

        if (religionId != religion.religionId) return false;
        if (religionName != null ? !religionName.equals(religion.religionName) : religion.religionName != null)
            return false;
        if (holyBook != null ? !holyBook.equals(religion.holyBook) : religion.holyBook != null) return false;
        if (countryOfOrigin != null ? !countryOfOrigin.equals(religion.countryOfOrigin) : religion.countryOfOrigin != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = religionId;
        result = 31 * result + (religionName != null ? religionName.hashCode() : 0);
        result = 31 * result + (holyBook != null ? holyBook.hashCode() : 0);
        result = 31 * result + (countryOfOrigin != null ? countryOfOrigin.hashCode() : 0);
        return result;
    }
}
