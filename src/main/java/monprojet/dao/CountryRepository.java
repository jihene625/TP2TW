package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;
import monprojet.projection.PopulationParPays;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query(value = "SELECT SUM(population) AS population" + " FROM City" + " WHERE id=:idPays", nativeQuery = true)
    public Integer getPopulationTotale(Integer idPays);

    @Query(value = "SELECT Country.name AS name, SUM(City.population) AS population" + " FROM Country INNER JOIN City ON Country.id=City.country_id"
        + " GROUP BY Country.name", nativeQuery = true)
    public List<PopulationParPays> populationParPays();


}
