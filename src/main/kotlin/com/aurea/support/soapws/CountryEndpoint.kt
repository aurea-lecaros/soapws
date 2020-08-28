package com.aurea.support.soapws

import com.aurea.support.samples.ws.GetCountryRequest
import com.aurea.support.samples.ws.GetCountryResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload

@Endpoint
class CountryEndpoint @Autowired constructor(private val countryRepository: CountryRepository) {

    companion object {
        private const val NAMESPACE_URI = "http://support.aurea.com/samples/ws"
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    fun getCountry(@RequestPayload request: GetCountryRequest): GetCountryResponse {
        val response = GetCountryResponse()
        response.country = countryRepository.findCountry(request.name)
        return response
    }
}