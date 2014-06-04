package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.logging.Logger;
/*import org.springframework.social.config.annotation
import org.springframework.social.facebook
*//***
 * Created by akhilg on 6/4/2014.
 */



/*@EnableFacebook(appId="667686176613908", appSecret="667686176613908|XbiKIkrfjjZkRjh8G2Nvd4Z3K8k")
@EnableInMemoryConnectionRepository*/
@Configuration
@EnableSocial
public abstract  class FacebookConfig implements SocialConfigurer {


    private static Logger logger = Logger.getLogger("FacebookConfig");

    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {

        logger.info("Inside connection to faceBook..................................");


        cfConfig.addConnectionFactory(new FacebookConnectionFactory(
                env.getProperty("667686176613908"),
                env.getProperty("667686176613908|XbiKIkrfjjZkRjh8G2Nvd4Z3K8k")
        ));
    }


    public UserIdSource getUserIdSource() {

        logger.info("Getting the resource ID..........................");

        return new UserIdSource() {
            @Override
            public String getUserId() {
                return "testuser";
            }
        };
    }











}
