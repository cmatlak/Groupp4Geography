package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "continent")
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "continentId", nullable = false)
    private Integer id;

    @Column(name = "continentName", length = 50)
    private String continentName;

    @Column(name = "numberOfTimezones")
    private Integer numberOfTimezones;

    @Column(name = "geoLocation", length = 50)
    private String geoLocation;

    @Column(name = "numberOfCountries", length = 50)
    private String numberOfCountries;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}