package com.utilities;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 6/7/14
 * Time: 10:06 AM
 * To change this template use File | Settings | File Templates.
 */

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




import facebook4j.internal.logging.Logger;
import org.springframework.core.ExceptionDepthComparator;



public class HibernateFactory {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();

         /*   return new AnnotationConfiguration()
                    .configure()
                    .buildSessionFactory();
*/

        }
        catch (Throwable ex) {

            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}


/*
public class HibernateFactory {

    static Logger logg = Logger.getLogger(HibernateFactory.class);




    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            //return new Configuration().configure().buildSessionFactory();

            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {

          throw new Exception();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

  */
/*  private static SessionFactory buildSessionFactory() throws Exception{
        try {
            // load from different directory

                SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

            logg.info("after configuration for hibernate cfg XML");


        } catch (HibernateException ex) {
            // Make sure you log the exception, as it might be swallowed

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        logg.info("about to call session factory");
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
*//*


}*/
