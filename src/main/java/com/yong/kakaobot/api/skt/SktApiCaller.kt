package com.yong.kakaobot.api.skt

import com.fasterxml.jackson.databind.ObjectMapper
import com.yong.kakaobot.api.ApiCaller
import com.yong.kakaobot.api.ApiUtils
import org.springframework.http.HttpRequest
import org.springframework.http.ResponseEntity
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class SktApiCaller(mapper: ObjectMapper): ApiCaller {

    companion object {
        const val APP_KEY: String = "576f26d3-9623-4790-979d-d7f2f8185308"
    }

    private val restTemplate: RestTemplate = RestTemplate()

    init {
        val list: MutableList<ClientHttpRequestInterceptor> = mutableListOf(
                ClientHttpRequestInterceptor { request: HttpRequest, body: ByteArray?, execution: ClientHttpRequestExecution ->
                    request.headers.set("appKey", APP_KEY)
                    execution.execute(request, body)
                }
        )

        restTemplate.interceptors = list

        val converter: MappingJackson2HttpMessageConverter = MappingJackson2HttpMessageConverter()
        converter.objectMapper = mapper
        restTemplate.messageConverters.add(0, converter)
    }

    override fun <T> callForEntity(url: String, params: Map<String, String>, tClass: Class<T>): ResponseEntity<T> =
            restTemplate.getForEntity("$url?${ApiUtils.mapToQueryString(params)}", tClass)

    override fun <T> callForObject(url: String, params: Map<String, String>, tClass: Class<T>): T =
            restTemplate.getForObject("$url?${ApiUtils.mapToQueryString(params)}", tClass)
}