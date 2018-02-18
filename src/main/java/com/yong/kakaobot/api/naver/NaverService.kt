package com.yong.kakaobot.api.naver

import com.yong.kakaobot.api.ApiCaller
import com.yong.kakaobot.api.ApiService
import com.yong.kakaobot.api.naver.blog.BlogResponse
import com.yong.kakaobot.api.naver.dictionary.DictionaryResponse
import com.yong.kakaobot.api.naver.movie.MovieResponse
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class NaverService: ApiService {
    @Resource(name = "naverApiCaller")
    private lateinit var naverApiCaller: ApiCaller

    override fun callToApi(keyword: String): String {
        if (keyword.startsWith("영화")) {
            val response: MovieResponse = naverApiCaller.callForObject("https://openapi.naver.com/v1/search/movie.json", mapOf("query" to keyword.split(" ")[1]), MovieResponse::class.java)
            return response.toString()
        }

        if(keyword.startsWith("사전")) {
            val response: DictionaryResponse = naverApiCaller.callForObject("https://openapi.naver.com/v1/search/encyc.json", mapOf("query" to keyword.split(" ")[1]), DictionaryResponse::class.java)
            return response.toString()
        }

        if(keyword.startsWith("블로그")){
            val response: BlogResponse = naverApiCaller.callForObject("https://openapi.naver.com/v1/search/blog.json", mapOf("query" to keyword.split(" ")[1]), BlogResponse::class.java)
            return response.toString()
        }

        throw IllegalArgumentException("I don't know keyword :: " + keyword)
    }
}