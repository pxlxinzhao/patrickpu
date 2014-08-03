package com.javahash.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController { 

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/hello")
    public String hello( @RequestParam(value="username", required=false) String username,  Model model) {

           Map<String, List<String>> map = new HashMap<String, List<String>>();
           List datelist;
    	
    		Configuration configuration = new Configuration().configure();  
   			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().  
   			applySettings(configuration.getProperties());  
   			SessionFactory factory = configuration.buildSessionFactory(builder.build()); 
   			Session session = factory.openSession();
//   			Session session1 = factory.openSession();
   			session.beginTransaction();
   			Query query = session.createQuery("Select username from User order by Geoinfo_id DESC");
   	
			List list = query.list();
//   			session.getTransaction().commit();
   		

			Set set = new HashSet();
   			for (Object s : list){	
   				set.add(s.toString());
   			}
   			
   			Object[] alluser = set.toArray();
   			List alluser2 = new ArrayList();
   			
   			if (username.length() > 0){
   				
   				for (Object s : alluser){
   					
   					if((boolean)!((String)s).equals(username))
   					alluser2.add((String)s);
   				}
   			}
   			
   			
   			Iterator iter = set.iterator();
   			

   		
			while (iter.hasNext()) {
			 String ss = (String) iter.next();
			 if (ss.length()>0){
   			  System.out.println(ss);
   			  Query query2 = session.createQuery("Select date from User "
							+ "where username='" + ss + "' "   +  "order by Geoinfo_id DESC");
   			  List timelist = query2.list();
   			  datelist = new ArrayList();
   			  
   			  for (Object l : timelist){
   				  
   				  if ((String) l != null){
   					  
   					  datelist.add(l);
   				  }
   			  }

   			  for (Object s : datelist){
   				  System.out.println(ss + (String) s);
   			  } 
   			  
   			  map.put(ss, datelist);
   			  
   			 model.addAttribute(ss, datelist);
			 }

   			}
			
			List usertimelist = map.get(username);
			
			session.close();
	
			
   	        model.addAttribute("user", usertimelist);
   	        model.addAttribute("alluser", alluser2);
   	     
   		   return "helloworld";
    }
    
   
}
