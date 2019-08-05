package com.workshop.data.repository;

import com.workshop.data.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ahmedtawfik
 */

public interface CountryRepository  extends JpaRepository<Country, String> {


}
