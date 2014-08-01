package com.javahash.spring.controller;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javahash.spring.Model.User;

@Controller
public class ShowMapController {
	 @RequestMapping("/map")
	    public String mapping(@RequestParam(value="user", required=true) String user,
	    					  @RequestParam(value="lat", required=false, defaultValue="35.40") String lat,
	    					  @RequestParam(value="lon", required=false, defaultValue="139.45") String lon, 
//	    					  @RequestParam(value="date", required=false, defaultValue="139.45") String date,
	    					  Model model) {
	    	model.addAttribute("user", user);
	        model.addAttribute("lat", lat);
	        model.addAttribute("lon", lon);
	        
	        Calendar c = Calendar.getInstance(); 
			Date d = c.getTime();
		    String s = d.toString().trim();
	        
	        String date = s;
	        
	        model.addAttribute("date", date);
	        
	        User user2save = new User();
	        user2save.setUsername(user);
	        user2save.setLatitude(lat);
	        user2save.setLongtitude(lon);
	        System.out.println(date);
	        user2save.setDate(date);
	        
	        Configuration configuration = new Configuration().configure();  
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().  
			applySettings(configuration.getProperties());  
			SessionFactory factory = configuration.buildSessionFactory(builder.build()); 
			Session session = factory.openSession();
			session.beginTransaction();
			session.save(user2save);
			session.getTransaction().commit();
			session.close();
			
	        return "showmap";
	    }
}
