package com.ddona.rest.filter

import com.ddona.rest.service.TokenService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTLoginFilter(
    url: String,
    authenticationManager: AuthenticationManager
) : AbstractAuthenticationProcessingFilter(AntPathRequestMatcher(url)) {
    init {
        setAuthenticationManager(authenticationManager)
    }

    override fun attemptAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse
    ): Authentication {
        //1. Lấy username và password người dùng nhập
        //2. Xác thực username
        //2.1 Nếu lỗi thì sẽ trả về response cho người dùng unsuccessfulAuthentication
        //2.2 nếu không lỗi thì phương thức successfulAuthentication sẽ được gọi
        val username = request.getParameter("username")
        val password = request.getParameter("password")
        return authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                username,
                password,
                listOf()
            )
        )
    }

    override fun successfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain,
        authResult: Authentication
    ) {
        //tạo Token và trả về cho người dùng thông qua response: HttpServletResponse
        TokenService.addTokenToResponse(response, authResult.name)
    }

    override fun unsuccessfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        failed: AuthenticationException
    ) {
        super.unsuccessfulAuthentication(request, response, failed)
        //trả về lỗi cho người
    }

}