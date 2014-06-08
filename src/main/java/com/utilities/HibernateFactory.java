package com.utilities;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 6/7/14
 * Time: 10:06 AM
 * To change this template use File | Settings | File Templates.
 */
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.dao.AcctHolderDAOImpl;

import facebook4j.internal.logging.Logger;

public class HibernateFactory {

    static Logger logg = Logger.getLogger(HibernateFactory.class);

    private static final SessionFactory sessionFactory = buildSessionFactory();


    private static SessionFactory buildSessionFactory() {
        try {
            // load from different directory
            SessionFactory sessionFactory = new Configuration().configure()
                    .buildSessionFactory();

            logg.info("after configuration for hibernate cfg XML");
            return sessionFactory;

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        logg.info("about to call session factory");
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }


}