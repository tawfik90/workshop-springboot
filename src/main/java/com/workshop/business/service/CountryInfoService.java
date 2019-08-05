package com.workshop.business.service;

import com.workshop.business.domain.CountryInfo;
import com.workshop.data.entity.Country;
import com.workshop.data.entity.CountryLanguage;
import com.workshop.data.entity.CountryLanguagePK;
import com.workshop.data.repository.CountryRepository;
import com.workshop.web.error.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 *
 * @author ahmedtawfik
 */

@Service
public class CountryInfoService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryInfoService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryInfo getCountryInfoBy (String code) {
        Country country = null ;
        if(countryRepository.existsById(code))
             country = countryRepository.getOne(code);
        else
            return null;
        CountryInfo ci = new CountryInfo();
        ci.setName(country.getName());
        ci.setContinent(country.getContinent());
        ci.setPopulation(country.getPopulation());
        ci.setLifeExpectancy(country.getLifeExpectancy());
        // Calling getMostCountryLanguageUsed to get most language used for this country (important about this language is official or not)
        CountryLanguage countryLanguage = getMostCountryLanguageUsed(country.getCountryLanguageList());
        ci.setCountryLanguage(countryLanguage.getCountryLanguagePK().getLanguage());
        return ci;
    }

    /**
     *  this method filters all country language to get the most used depends on official or not
     * @param list of CountryLanguage
     * @return CountryLanguage List
     */
    private CountryLanguage getMostCountryLanguageUsed (List<CountryLanguage> list) {
        CountryLanguage countryLanguageTemp = null;
        for(CountryLanguage cl : list){
            if(countryLanguageTemp == null) {
                countryLanguageTemp = cl;
            } else if (cl.getIsOfficial() && !countryLanguageTemp.getIsOfficial()){
                    countryLanguageTemp = cl ;
            } else if ( (countryLanguageTemp.getIsOfficial() && cl.getIsOfficial())
                    || (!countryLanguageTemp.getIsOfficial() && !cl.getIsOfficial())) {
                if(countryLanguageTemp.getPercentage() < cl.getPercentage()){
                    countryLanguageTemp = cl ;
                }
            }
        }
        return countryLanguageTemp ;
    }

}
