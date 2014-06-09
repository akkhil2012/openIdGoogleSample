package com.config;

import com.openid.service.impl.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.logging.Logger;

/**
 * Created by akhilg on 6/9/2014.
 */
@Configuration
public class FacebookConfig {

    private static Logger logger = Logger.getLogger("FacebookConfig.class");

    @Inject
    DataSource dataSource;


    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator(){
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        logger.info("before adding the consumer key and  consumer secret");

        FacebookConnectionFactory facebookConnectionFactory = new FacebookConnectionFactory("667686176613908","667686176613908|XbiKIkrfjjZkRjh8G2Nvd4Z3K8k");

        logger.info("before adding the consumer key and  consumer secret..........................");

        try{
            registry.addConnectionFactory(facebookConnectionFactory);
        }catch (Exception e){
            logger.info("Consumer Keys NOT found........................");
            e.printStackTrace();
        }
//                environment.getRequiredProperty("odvGlDrl0mjZMEmqxsudocKG6"),
//                environment.getRequiredProperty("8V8C0wtQH7BRPpikdqyU5HKbGfdLizYklOkZngFGZHP0KnXoZk")

//        );
        return registry;
    }


    @Bean
    public TextEncryptor textEncryptor(){

        return Encryptors.noOpText();
    }

    @Bean
    public UsersConnectionRepository usersConnectionRepository() {
        logger.info("prior to getting the User JDBCConnection............");

        logger.info("DATASOURCE IS---------------->>>>"+dataSource);
        logger.info("connectionFactoryLocator() returns-------------"+connectionFactoryLocator());
        logger.info("textEncrypter returns................."+textEncryptor());
        return new JdbcUsersConnectionRepository(dataSource,
                connectionFactoryLocator(),
                textEncryptor());
    }




    @Bean
    public ConnectionRepository connectionRepository() {

        CustomUserDetailsService customUserDetailsService = new CustomUserDetailsService();

        Authentication authentication = null;


        UserDetails userDetails= customUserDetailsService.loadUserByUsername("name");
        authentication= new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()) ;
        SecurityContextHolder.getContext().setAuthentication(authentication);

        logger.info("After setting the authentication Object....."+SecurityContextHolder.getContext().getAuthentication());


        authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Inside ComnnectionRepository................................................................................");
       /* if (authentication == null)
            throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");*/

        logger.info("Name for the user to be authenticated is::"+authentication);

        logger.info("Name for the Authenticated User--------------->>>>>>>"+usersConnectionRepository().createConnectionRepository(authentication.getName()));

        return usersConnectionRepository().createConnectionRepository(authentication.getName());
    }




    @Bean
    public ConnectController connectController() {
        logger.info("Inside ConnectController.................");
        ConnectController controller = new ConnectController(connectionFactoryLocator(), connectionRepository());
        // controller.setApplicationUrl(environment.getRequiredProperty("application.url"));
        return controller;
    }
}
