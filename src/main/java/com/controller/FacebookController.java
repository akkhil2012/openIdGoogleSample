package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

import javax.inject.Inject;
import javax.sql.DataSource;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by akhilg on 6/4/2014.
 */

@Controller
@RequestMapping(value = "/social/facebook")
public class FacebookController /*extends ConnectController*/{

    @Inject
    private DataSource dataSource;


    @Autowired
    private ConnectionRepository connectionRepository;
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

    private static Logger logger = Logger.getLogger("FacebookController.class");



/*   @Inject
    public FacebookController(FacebookTemplate facebook){
       this.facebook = facebook;
   }*/

  //  @Inject
    Facebook facebook;

/*    public FacebookController(Facebook facebook){

        this.facebook = facebook;
    }*/



   //    @Bean
        public Facebook facebook() {
        logger.info("Instantiating FaceBook Instance>>>>>>>>>>>>....................");
     //   Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
        //Connection<Facebook> connection = connectionFactoryLocator.getConnectionFactory("facebook")

           // Facebook facebook = new FacebookTemplate();

            Connection<Facebook> facebookConnection = connectionRepository.findPrimaryConnection(Facebook.class);

            //FacebookTemplate facebook = new FacebookTemplate();

         return facebook;
         //    return facebook != null ? facebookConnection.getApi() : new FacebookTemplate();
//
   //     connectionFactoryLocator.getConnectionFactory("facebook").createConnection()
        //Connection<Facebook> connection = connectionRepository.getConnectionFactory("facebook").createConnection(facebook.friendOperations().getFriendList(""))
            // facebook = connection != null ? connection.getApi() : new FacebookTemplate();
      //    return facebook;
    }



    @Bean
    public ConnectionRepository connectionRepository() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Inside ComnnectionRepository................................................................................");
       /* if (authentication == null)
            throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");*/

        logger.info("Name for the user to be authenticated is::"+authentication);

        logger.info("Name for the Authenticated User--------------->>>>>>>"+usersConnectionRepository().createConnectionRepository(authentication.getName()));

        return usersConnectionRepository().createConnectionRepository(authentication.getName());
    }

    @Bean
    @Scope(value="singleton",proxyMode= ScopedProxyMode.INTERFACES)
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
    public ConnectionFactoryLocator connectionFactoryLocator(){

        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        logger.info("before adding the consumer key and  consumer secret");

        try{
            registry.addConnectionFactory(new FacebookConnectionFactory("667686176613908","667686176613908|XbiKIkrfjjZkRjh8G2Nvd4Z3K8k"));
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