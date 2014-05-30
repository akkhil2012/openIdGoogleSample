package com.openid.service.impl;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationStatus;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import org.springframework.security.core.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by akhilg on 27/5/14.
 */
public class CustomFailureHandler
    extends SimpleUrlAuthenticationFailureHandler

{


    public void onAuthenticationFailure(HttpServletRequest request,

                                        HttpServletResponse response, AuthenticationException exception)

            throws IOException, ServletException {


        if (exception instanceof UsernameNotFoundException

                && exception.getAuthentication() instanceof

                OpenIDAuthenticationToken) {

            OpenIDAuthenticationToken token = (OpenIDAuthenticationToken) exception

                    .getAuthentication();

            if (OpenIDAuthenticationStatus.SUCCESS.equals(token.getStatus())) {

                // getting attributes passed by google/openID provider

                final List<OpenIDAttribute> attrList = token.getAttributes();

                String username = (String) token.getPrincipal();

                //provide implementation to create user from information passed from

                //openID provider and save this user in database

                //then redirect to redirectURL.

                DefaultRedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

                redirectStrategy.sendRedirect(request, response, "pages/loginError.jsp");

            } else {

                super.onAuthenticationFailure(request, response, exception);

            }


        }

    }
}

