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
    public String hello( @RequestParam(value="username", required=false) String username,
    					@RequestParam(value="date", required=false) String date,  Model model) {

           Map<String, List<String>> map = new HashMap<String, List<String>>();
           List datelist;
    	
    		Configuration configuration = new Configuration().configure();  
   			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().  
   			applySettings(configuration.getProperties());  
   			SessionFactory factory = configuration.buildSessionFactory(builder.build()); 
   			Session session = factory.openSession();
   			session.beginTransaction();
   			Query query = session.createQuery("Select username from User order by Geoinfo_id DESC");
			List list = query.list();

			Set set = new HashSet();
   			for (Object s : list){	
   				set.add(s.toString());
   			}
   			
   			Object[] alluser = set.toArray();
   			
   			System.out.println("alluser length: " + String.valueOf(alluser.length) );
   			List alluser2 = new ArrayList();

   			if (username!=null){
   				
   				for (Object s : alluser){
   					
   					if((boolean)!((String)s).equals(username))
   					alluser2.add((String)s);
   				}
   				model.addAttribute("alluser", alluser2);
   			}
   			
   			else model.addAttribute("alluser", alluser);
   			
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
			List timelist = new ArrayList();
			timelist.add("");
			
			if (usertimelist!=null){
			for (Object o: usertimelist){
				timelist.add((String) o);
			}
			}
			
			Query querylat = session.createQuery("Select latitude from User "
					+ "where username='" + username + "' and date='" + date + "'");
			
			Query querylon = session.createQuery("Select longtitude from User "
					+ "where username='" + username + "' and date='" + date + "'");
			
			if (!querylat.list().isEmpty() && !querylon.list().isEmpty()){
			String latitude = (String) querylat.list().get(0);
			String longtitude = (String) querylon.list().get(0);
			model.addAttribute("latitude", latitude);
		   	model.addAttribute("longtitude", longtitude);
			System.out.println("latitude is: " + latitude + "     longtitude is: " + longtitude);
			}
			session.close();
	

	   	     model.addAttribute("user", timelist);
   	    
   		   return "helloworld";
    }
    
   
}
