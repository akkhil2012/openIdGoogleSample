package com.openid.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * Created by akhilg on 27/5/14.
 */
public class CustomSuccessHandler
    extends

        SavedRequestAwareAuthenticationSuccessHandler {

        @Override

        public void onAuthenticationSuccess(HttpServletRequest request,

                HttpServletResponse response, Authentication authentication)

        throws ServletException, IOException {

//provide implementation to set user data in session

//redirecting to landing page

            getRedirectStrategy().sendRedirect(request, response, "/welcome");

        }

      //  super.onAuthenticationSuccess(request, response, authentication);

    }

