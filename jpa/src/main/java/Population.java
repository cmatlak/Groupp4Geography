import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "population")
public class Population {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "populationId")
    private int populationId;

    @Column(name = "population")
    private int population;

    @Column(name = "averageAge")
    private int averageAge;

    @Column(name = "minorityPopulation")
    private String minorityPopulation;

    public int getPopulationId() {
        return populationId;
    }

    public void setPopulationId(int populationId) {
        this.populationId = populationId;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(int averageAge) {
        this.averageAge = averageAge;
    }

    public String getMinorityPopulation() {
        return minorityPopulation;
    }

    public void setMinorityPopulation(String minorityPopulation) {
        this.minorityPopulation = minorityPopulation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Population that = (Population) o;
        return populationId == that.populationId && Objects.equals(population, that.population) && Objects.equals(averageAge, that.averageAge) && Objects.equals(minorityPopulation, that.minorityPopulation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(populationId, population, averageAge, minorityPopulation);
    }

    @Override
    public String toString() {
        return "Population{" +
                "populationId=" + populationId +
                ", population=" + population +
                ", averageAge='" + averageAge + '\'' +
                ", minorityPopulation='" + minorityPopulation + '\'' +
                '}';
    }
}
