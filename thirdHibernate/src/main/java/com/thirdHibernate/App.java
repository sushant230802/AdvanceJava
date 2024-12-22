package com.thirdHibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.thirdHibernate.User;

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
        
        try {
			Properties configProperties=new Properties();
			configProperties.load(new FileInputStream("application.properties"));
		
			hibernateConfig.addProperties(configProperties);
			hibernateConfig.addAnnotatedClass(User.class);
			
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
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
