
package com.workshop.data.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmedtawfik
 */
@Entity
@Table(name = "country_language", catalog = "", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CountryLanguage.findAll", query = "SELECT c FROM CountryLanguage c")})
public class CountryLanguage implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CountryLanguagePK countryLanguagePK;
    @Basic(optional = false)
    @Column(name = "is_official")
    private boolean isOfficial;
    @Basic(optional = false)
    @Column(name = "percentage")
    private float percentage;
    @JoinColumn(name = "country_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Country country;

    public CountryLanguage() {
    }

    public CountryLanguage(CountryLanguagePK countryLanguagePK) {
        this.countryLanguagePK = countryLanguagePK;
    }

    public CountryLanguage(CountryLanguagePK countryLanguagePK, boolean isOfficial, float percentage) {
        this.countryLanguagePK = countryLanguagePK;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public CountryLanguage(String countryCode, String language) {
        this.countryLanguagePK = new CountryLanguagePK(countryCode, language);
    }

    public CountryLanguagePK getCountryLanguagePK() {
        return countryLanguagePK;
    }

    public void setCountryLanguagePK(CountryLanguagePK countryLanguagePK) {
        this.countryLanguagePK = countryLanguagePK;
    }

    public boolean getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(boolean isOfficial) {
        this.isOfficial = isOfficial;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryLanguagePK != null ? countryLanguagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountryLanguage)) {
            return false;
        }
        CountryLanguage other = (CountryLanguage) object;
        if ((this.countryLanguagePK == null && other.countryLanguagePK != null) || (this.countryLanguagePK != null && !this.countryLanguagePK.equals(other.countryLanguagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.data.entity.CountryLanguage[ countryLanguagePK=" + countryLanguagePK + " ]";
    }
    
}
