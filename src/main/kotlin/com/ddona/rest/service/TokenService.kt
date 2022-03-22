package com.ddona.rest.service

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*
import javax.servlet.http.HttpServletResponse

object TokenService {

    private const val EXPIRE_TIME = 86400000 //10 days
    private const val SECRET_KEY = "t3h.l2103.android"
    private const val HEADER_AUTH = "Authorization"
    private const val TOKEN_PREFIX = "Bearer "

    fun addTokenToResponse(response: HttpServletResponse, username: String) {
        val token = Jwts.builder()
            .setSubject(username)
            .setExpiration(Date(System.currentTimeMillis() + EXPIRE_TIME))
            .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
            .compact()
        response.addHeader(HEADER_AUTH, "$TOKEN_PREFIX$token")
    }
}