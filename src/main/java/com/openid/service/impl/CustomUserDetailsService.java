package com.openid.service.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by akhilg on 27/5/14.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

   // List<? extends GrantedAuthority > authorities = new ArrayList<SimpleGrantedAuthority>();

    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();




    Logger log = Logger.getLogger("CustomUserDetailsService.class");


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {


        authorities.add(new GrantedAuthorityImpl("ROLE_USER"));

        try {

            log.info("Inside loadbyusername in custom service.....");
            /*

            Yet to determine this part***************************************
             */


            User user =  new User(username, "", false,
                    false, false,
                    false,authorities);

            log.info("User is ---------------->>>"+user);


            return user;




        } catch (Exception e) {

            log.info("loadbyUsername failed in custom service.....");

            throw new UsernameNotFoundException("Error in retrieving user");


        }
    }
}
