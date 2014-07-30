package com.javahash.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController { 

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "helloworld";
    }
    
    @RequestMapping("/map")
    public String mapping(@RequestParam(value="user", required=false, defaultValue="tester") String user,
    					  @RequestParam(value="lat", required=false, defaultValue="35.40") String lat,
    					  @RequestParam(value="lon", required=false, defaultValue="139.45") String lon, Model model) {
    	model.addAttribute("user", user);
        model.addAttribute("lat", lat);
        model.addAttribute("lon", lon);
        return "showmap";
    }
}
