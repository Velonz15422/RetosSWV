package co.edu.udem.isv.ejemplosoap.endpoint;

import co.edu.udem.isv.ejemplo_soap.*;
import co.edu.udem.isv.ejemplosoap.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://udem.edu.co/isv/ejemplo-soap";

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "registerCountryRequest")
    @ResponsePayload
    public RegisterCountryResponse registerCountry(@RequestPayload RegisterCountryRequest request) {
        RegisterCountryResponse response = new RegisterCountryResponse();
        countryRepository.registerCountry(request.getCountry());
        response.setMessage("Country registered successfully");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCountryRequest")
    @ResponsePayload
    public DeleteCountryResponse deleteCountry(@RequestPayload DeleteCountryRequest request) {
        DeleteCountryResponse response = new DeleteCountryResponse();
        countryRepository.deleteCountry(request.getName());
        response.setMessage("Country deleted successfully");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCountriesRequest")
    @ResponsePayload
    public GetAllCountriesResponse getAllCountries() {
        GetAllCountriesResponse response = new GetAllCountriesResponse();
        response.getCountries().addAll(countryRepository.getAllCountries());
        return response;
    }



}
