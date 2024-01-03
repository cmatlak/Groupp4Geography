package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "continent")
public class Continent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "continentId")
    private int continentId;
    @Column(name = "continentName")
    private String continentName;
    @Column(name = "numberOfTimezones")
    private Integer numberOfTimezones;
    @Column(name = "geoLocation")
    private String geoLocation;
    @Column(name = "numberOfCountries")
    private String numberOfCountries;

    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public Integer getNumberOfTimezones() {
        return numberOfTimezones;
    }

    public void setNumberOfTimezones(Integer numberOfTimezones) {
        this.numberOfTimezones = numberOfTimezones;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public String getNumberOfCountries() {
        return numberOfCountries;
    }

    public void setNumberOfCountries(String numberOfCountries) {
        this.numberOfCountries = numberOfCountries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Continent continent = (Continent) o;

        if (continentId != continent.continentId) return false;
        if (continentName != null ? !continentName.equals(continent.continentName) : continent.continentName != null)
            return false;
        if (numberOfTimezones != null ? !numberOfTimezones.equals(continent.numberOfTimezones) : continent.numberOfTimezones != null)
            return false;
        if (geoLocation != null ? !geoLocation.equals(continent.geoLocation) : continent.geoLocation != null)
            return false;
        if (numberOfCountries != null ? !numberOfCountries.equals(continent.numberOfCountries) : continent.numberOfCountries != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = continentId;
        result = 31 * result + (continentName != null ? continentName.hashCode() : 0);
        result = 31 * result + (numberOfTimezones != null ? numberOfTimezones.hashCode() : 0);
        result = 31 * result + (geoLocation != null ? geoLocation.hashCode() : 0);
        result = 31 * result + (numberOfCountries != null ? numberOfCountries.hashCode() : 0);
        return result;
    }
}
