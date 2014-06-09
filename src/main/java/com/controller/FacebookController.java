package com.controller;
/*

  Location for the Database to Store the Spring-Social COnnection :

  https://github.com/spring-projects/spring-social/blob/master/spring-social-core/src/main/resources/org/springframework/social/connect/jdbc/JdbcUsersConnectionRepository.sql


 */
import com.openid.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.Page;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.social.facebook.api.PageOperations.*;
//import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.facebook.api.Reference;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.inject.Inject;
import javax.sql.DataSource;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by akhilg on 6/4/2014.
 */

@Controller
@RequestMapping(value = "/social/facebook")
public class FacebookController extends /*ConnectController*/ MultiActionController{



    private  Facebook facebook;

    @Autowired
    private ConnectionRepository connectionRepository;

    FacebookController(){

    }

/*
    @Inject
    FacebookController(Facebook facebook){

        this.facebook = facebook;
        //FacebookController(connectionFactoryLocator,connectionRepository);
    }
*/


/*    @Autowired
    public FacebookController(ConnectionFactoryLocator connectionFactoryLocator,
                              ConnectionRepository connectionRepository){

      //  super(connectionFactoryLocator,connectionRepository);
           this.connectionFactoryLocator = connectionFactoryLocator;
           this.connectionRepository = connectionRepository;
    }*/

/*
    @Autowired
    public FacebookController(ConnectionFactoryLocator connectionFactoryLocator,
                              ConnectionRepository connectionRepository) {

        super(connectionFactoryLocator, connectionRepository);

        this.connectionRepository = connectionRepository;

    }

*/


    protected String connectedView(String providerId) {

        return "redirect:/connect/" + providerId + "/response";
    }

    //private final Facebook facebook;

  //  @Autowired

    /*ConnectionFactoryLocator connectionFactoryLocator;

    public FacebookController(ConnectionFactoryLocator connectionFactoryLocator){

          this.connectionFactoryLocator = connectionFactoryLocator;
    }*/

    //Facebook facebook;





/*   @Inject
    public FacebookController(FacebookTemplate facebook){
       this.facebook = facebook;
   }*/

  //  @Inject


/*    public FacebookController(Facebook facebook){

        this.facebook = facebook;
    }*/




        public Facebook facebook() {
        logger.info("Instantiating FaceBook Instance>>>>>>>>>>>>....................");
     //   Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
        //Connection<Facebook> connection = connectionFactoryLocator.getConnectionFactory("facebook")

           // Facebook facebook = new FacebookTemplate();


            logger.info("Connection Repository for FaceBook is==============="+connectionRepository);

           Connection<Facebook> facebookConnection = connectionRepository.findPrimaryConnection(Facebook.class);
             // Connection<Facebook> facebookConnection = connectionRepository();


        //    logger.info("FaceBook Instance being retreived is..........."+facebookConnection);

            //FacebookTemplate facebook = new FacebookTemplate();


             facebook = facebookConnection != null ? facebookConnection.getApi() : new FacebookTemplate();


            logger.info("getting the FB Connection------------------------>>>"+facebook);


            return facebook;


//
   //     connectionFactoryLocator.getConnectionFactory("facebook").createConnection()
        //Connection<Facebook> connection = connectionRepository.getConnectionFactory("facebook").createConnection(facebook.friendOperations().getFriendList(""))
            // facebook = connection != null ? connection.getApi() : new FacebookTemplate();
      //    return facebook;
    }


    @RequestMapping(value = "/getFreindsList", method = RequestMethod.GET)
    public ModelAndView getFreindsList(Model model) {

        logger.info("Entered getFreindsList method....................");

     facebook();

   /*     if (!facebook.isAuthorized()) {
            return "redirect:/connect/facebook";
        }


        model.addAttribute(facebook.userOperations().getUserProfile());

        FacebookProfile userProfile = facebook.userOperations().getUserProfile();


        model.addAttribute("profile_user", userProfile);

        return "userProfile";*/




         List<Reference> friends = listOfFriends();

        logger.info("After fetchiing the freinds list.............");
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("freindsList",friends);

        modelAndView.setViewName("friendsList");




        return  modelAndView;

}


    List<Reference> listOfFriends(){

        logger.info("Inside get Freinds list method.................................");

        return facebook.friendOperations().getFriendLists();
    }


}