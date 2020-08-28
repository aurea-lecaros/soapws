package com.aurea.support.soapws

import com.aurea.support.samples.ws.Country
import com.aurea.support.samples.ws.Currency
import org.springframework.stereotype.Component
import org.springframework.util.Assert
import java.util.*
import javax.annotation.PostConstruct

@Component
class CountryRepository {

    companion object {
        private val countries: MutableMap<String, Country> = HashMap()
    }

    @PostConstruct
    fun initData() {
        val spain = Country()
        spain.name = "Spain"
        spain.capital = "Madrid"
        spain.currency = Currency.EUR
        spain.population = 46704314
        countries[spain.name] = spain
        val poland = Country()
        poland.name = "Poland"
        poland.capital = "Warsaw"
        poland.currency = Currency.PLN
        poland.population = 38186860
        countries[poland.name] = poland
        val uk = Country()
        uk.name = "United Kingdom"
        uk.capital = "London"
        uk.currency = Currency.GBP
        uk.population = 63705000
        countries[uk.name] = uk
    }

    fun findCountry(name: String): Country? {
        Assert.notNull(name, "The country's name must not be null")
        return countries[name]
    }
}