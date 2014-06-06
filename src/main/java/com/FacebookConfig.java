
package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
//import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.core.env.Environment;
import org.springframework.social.connect.ConnectionRepository;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.logging.Logger;



/***
 * Created by akhilg on 6/4/2014.
 *//*




*/

/*@Configuration
//@EnableSocial
public  class FacebookConfig {


    private static Logger logger = Logger.getLogger("FacebookConfig.class");

   // @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();

        registry.addConnectionFactory(new FacebookConnectionFactory(
                environment.getProperty("667686176613908"),
                environment.getProperty("667686176613908|XbiKIkrfjjZkRjh8G2Nvd4Z3K8k")));

        logger.info("Inside FacebookConfig................"+registry.registeredProviderIds());


        return registry;
    }

    @Inject
    private Environment environment;

}*/
   /*

        logger.info("Inside connection to faceBook..................................");
*//*


           Environment environment;

    */
/*    @Bean
        public ConnectionFactoryLocator connectionFactoryLocator() {
            ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
            registry.addConnectionFactory(new FacebookConnectionFactory(
                    environment.getProperty("facebook.clientId"),
                    environment.getProperty("facebook.clientSecret")));
            return registry;
    //    }

    *//*
*/
/*    cfConfig.addConnectionFactory(new FacebookConnectionFactory(
                env.getProperty("667686176613908"),
                env.getProperty("667686176613908|XbiKIkrfjjZkRjh8G2Nvd4Z3K8k")
        ));*//*
*/
/*
    }*//*






 */
/*   public UserIdSource getUserIdSource() {

        logger.info("Getting the resource ID..........................");

        return new UserIdSource() {
            @Override
            public String getUserId() {
                return "testuser";
            }
        };
    }
*//*


}
*/
