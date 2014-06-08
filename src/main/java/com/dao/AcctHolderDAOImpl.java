package com.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 6/7/14
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import com.model.Account;
import com.model.AccountHolder;
import com.utilities.HibernateFactory;

import facebook4j.internal.logging.Logger;




@Service("AcctHolderDAO")
public class AcctHolderDAOImpl implements AcctHolderDAO{

    java.util.logging.Logger logg = java.util.logging.Logger.getLogger("AcctHolderDAOImpl.class");

    private SessionFactory sessionFactory = new HibernateFactory().getSessionFactory();





    @Override
    public void enterAccountDetails(Account account) {

        logg.info("before Saving the Account Entity.............. in AcctHolderDAOExample....");

        //  Session sess = sessionFactory.getCurrentSession();

        Session session = null;

        //  if(sess==null){
        session = sessionFactory.openSession();

        session.beginTransaction();

        logg.info("retreiving session....."+session);

        //  }

        session.save(account);

        logg.info("Value for session object sess1 is:::::::::"+session.toString());

        //  logg.info("Value for session object sess is:::::::::"+sess.toString());
        session.getTransaction().commit();
        session.close();

        // sessionFactory.getCurrentSession().save(accountHolder);





    }

}