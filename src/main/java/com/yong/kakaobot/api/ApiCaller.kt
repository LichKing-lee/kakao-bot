package com.yong.kakaobot.api

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpRequest
import org.springframework.http.ResponseEntity
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class ApiCaller(mapper: ObjectMapper) {
    private val restTemplate: RestTemplate = RestTemplate()
    private val clientId: String = "z0z1bsbO8AeOgIZejE9P"
    private val clientSecret: String = "JT7cisjNYQ"

    init {
        val list: MutableList<ClientHttpRequestInterceptor> = mutableListOf(
                ClientHttpRequestInterceptor { request: HttpRequest, body: ByteArray?, execution: ClientHttpRequestExecution ->
                    request.headers.set("X-Naver-Client-Id", clientId)
                    request.headers.set("X-Naver-Client-Secret", clientSecret)
                    execution.execute(request, body)
                }
        )

        restTemplate.interceptors = list

        val converter: MappingJackson2HttpMessageConverter = MappingJackson2HttpMessageConverter()
        converter.objectMapper = mapper
        restTemplate.messageConverters.add(0, converter)
    }

    fun <T> callForEntity(url: String, params: Map<String, String>, tClass: Class<T>): ResponseEntity<T> =
            restTemplate.getForEntity("$url?${mapToQueryString(params)}", tClass)

    fun <T> callForObject(url: String, params: Map<String, String>, tClass: Class<T>): T =
            restTemplate.getForObject("$url?${mapToQueryString(params)}", tClass)

    private fun mapToQueryString(map: Map<String, String>): String = map.map { "${it.key}=${it.value}" }
            .joinToString(separator = "&")
}