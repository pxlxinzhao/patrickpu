package com.javahash.spring.controller;

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
public class HelloWorldController { 

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "helloworld";
    }
    
    @RequestMapping("/map")
    public String mapping(@RequestParam(value="user", required=true) String user,
    					  @RequestParam(value="lat", required=false, defaultValue="35.40") String lat,
    					  @RequestParam(value="lon", required=false, defaultValue="139.45") String lon, Model model) {
    	model.addAttribute("user", user);
        model.addAttribute("lat", lat);
        model.addAttribute("lon", lon);
        
        User user2save = new User();
        user2save.setUsername(user);
        user2save.setLatitude(lat);
        user2save.setLongtitude(lon);
        
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
