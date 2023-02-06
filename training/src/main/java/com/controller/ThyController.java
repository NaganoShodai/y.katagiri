package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.City;
import com.repository.CityRepository;

@Controller
public class ThyController {
	@Autowired private CityRepository cityRep;
	
	private static final String PAGE_NAME = "thy";
    /* @GetMapping("/thy")
    public String hello(Model model) {
        model.addAttribute("text", "山田");
        model.addAttribute("name", "佐藤");
        model.addAttribute("num", 5);
        model.addAttribute("test", false);
        model.addAttribute("size", "small");
        model.addAttribute("num2", 10);
        //テンプレートファイルが探索される
        return "thy";
    } */
    @RequestMapping("/thy")
    public String disp(Model model, HttpServletRequest req) {
    	
    	List<String> list = new ArrayList<String>();
    	list.add("a");
    	list.add("b");
    	
    	List<City> cityList = cityRep.findByCountrycode("AFG");
    	model.addAttribute("city_list", cityList);
    	model.addAttribute("test2", list);
    	return PAGE_NAME;
    }
}