package com.hibernate;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Category;
import com.hibernate.entity.User;

/**
 * Servlet implementation class InitializeHibernate
 */
@WebServlet(
		loadOnStartup=1,
		urlPatterns={"/InitializeHibernate"})
public class InitializeHibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		Configuration hibernateConfig=new Configuration();
		
	
			Properties configProperties=new Properties();
			try {
				configProperties.load(new FileInputStream("application.properties"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			configProperties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/cdac_pune");
//            configProperties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
//            configProperties.setProperty("hibernate.connection.username", "root");
//            configProperties.setProperty("hibernate.connection.password", "cdac");
//            configProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
//            configProperties.setProperty("hibernate.show_sql", "true");

          
			hibernateConfig.addProperties(configProperties);
			hibernateConfig.addAnnotatedClass(User.class);
			hibernateConfig.addAnnotatedClass(Category.class);
			
			SessionFactory hibernateFactory=hibernateConfig.buildSessionFactory();
			ServletContext application=getServletContext();
			application.setAttribute("hibernateFactory", hibernateFactory);
			System.out.println(hibernateFactory);
		
	}
       



}
