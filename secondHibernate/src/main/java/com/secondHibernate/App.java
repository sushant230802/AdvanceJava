package com.secondHibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Configuration hibernateConfig=new Configuration();
        hibernateConfig.configure("first.config.xml");
        
        try (SessionFactory hibernateFactory = hibernateConfig.buildSessionFactory();
				Session hibernateSession = hibernateFactory.openSession()) {
			User objUser=hibernateSession.get(User.class,"admin");
			System.out.println(objUser.getUserName());
			System.out.println(objUser.getName());
			System.out.println(objUser.getEmail());
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
