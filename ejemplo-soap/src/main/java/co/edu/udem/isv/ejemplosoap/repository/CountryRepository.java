package co.edu.udem.isv.ejemplosoap.repository;

import co.edu.udem.isv.ejemplo_soap.Country;
import co.edu.udem.isv.ejemplo_soap.Currency;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);

        countries.put(spain.getName(), spain);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);

        countries.put(poland.getName(), poland);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(63705000);

        countries.put(uk.getName(), uk);
    }

    public Country findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return countries.get(name);
    }


    public void registerCountry(Country country) {
        Assert.notNull(country, "Country must not be null");
        Assert.notNull(country.getName(), "Country name must not be null");
        countries.put(country.getName(), country);
    }

    public void deleteCountry(String name) {
        Assert.notNull(name, "Country name must not be null");
        countries.remove(name);
    }
    public List<Country> getAllCountries() {
        return new ArrayList<>(countries.values());
    }


}
