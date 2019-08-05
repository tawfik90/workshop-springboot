package com.workshop.business.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 *
 * @author ahmedtawfik
 */

public class CountryInfo {

    private String name ;
    private String continent ;
    private Integer population ;
    @JsonProperty("life_expectancy")
    private Float lifeExpectancy;
    @JsonProperty("country_language")
    private String countryLanguage ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public String getCountryLanguage() {
        return countryLanguage;
    }

    public void setCountryLanguage(String countryLanguage) {
        this.countryLanguage = countryLanguage;
    }
}
