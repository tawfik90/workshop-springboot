
package com.workshop.data.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ahmedtawfik
 */
@Embeddable
public class CountryLanguagePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "country_code")
    private String countryCode;
    @Basic(optional = false)
    @Column(name = "language")
    private String language;

    public CountryLanguagePK() {
    }

    public CountryLanguagePK(String countryCode, String language) {
        this.countryCode = countryCode;
        this.language = language;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryCode != null ? countryCode.hashCode() : 0);
        hash += (language != null ? language.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountryLanguagePK)) {
            return false;
        }
        CountryLanguagePK other = (CountryLanguagePK) object;
        if ((this.countryCode == null && other.countryCode != null) || (this.countryCode != null && !this.countryCode.equals(other.countryCode))) {
            return false;
        }
        if ((this.language == null && other.language != null) || (this.language != null && !this.language.equals(other.language))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.data.entity.CountryLanguagePK[ countryCode=" + countryCode + ", language=" + language + " ]";
    }
    
}
