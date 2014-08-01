package com.javahash.spring.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController { 

    @SuppressWarnings("rawtypes")
	@RequestMapping("/hello")
    public String hello( Model model) {

            Configuration configuration = new Configuration().configure();  
   			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().  
   			applySettings(configuration.getProperties());  
   			SessionFactory factory = configuration.buildSessionFactory(builder.build()); 
   			Session session = factory.openSession();
   			session.beginTransaction();
   			Query query = session.createQuery("Select username from User order by Geoinfo_id DESC");
   	
			List list = query.list();
   			session.getTransaction().commit();
   			session.close();

			Set set = new HashSet();
   			for (Object s : list){	
   				set.add(s.toString());
   			}
   			
   			Iterator iter = set.iterator();
   			while (iter.hasNext()) {
   			  System.out.println(iter.next());
   			}
            
//   			String[] alluser = (String[]) set.toArray();
   			
//   			System.out.println(String.valueOf(alluser.length));
   			
   			
   	        model.addAttribute("alluser", set);
   			
   		   return "helloworld";
    }
    
   
}
