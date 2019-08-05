package com.workshop.web.service;

import com.workshop.business.domain.CountryInfo;
import com.workshop.business.service.CountryInfoService;

import com.workshop.web.error.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ahmedtawfik
 */


@RestController
public class CountryInfoServiceController {

    @Autowired
    private CountryInfoService countryInfoService ;

    @RequestMapping(value = "/BHR", method = RequestMethod.GET)
    public CountryInfo getCountryByCode(String codeName) {
        CountryInfo countryInfo = countryInfoService.getCountryInfoBy(codeName) ;
        if(countryInfo == null){
            throw new CountryNotFoundException("INVALID_COUNTRY_CODE");
        }
        return countryInfo;
    }

}
