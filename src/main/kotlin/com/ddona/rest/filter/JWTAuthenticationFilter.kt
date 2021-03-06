package com.ddona.rest.filter

import com.ddona.rest.service.TokenService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class JWTAuthenticationFilter : GenericFilterBean() {
    override fun doFilter(
        request: ServletRequest,
        response: ServletResponse,
        filter: FilterChain
    ) {
        val auth = TokenService.checkTokenFromRequest(request as HttpServletRequest)
        SecurityContextHolder.getContext().authentication = auth
        filter.doFilter(request, response)
    }
}