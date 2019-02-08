package com.tts.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RestaurantController {
	
	@Autowired
	RestaurantRepository restaurantRepository;

    @GetMapping
    public String index(Restaurant restaurant) {
	return "restaurant/index";
    }
	
	// adding a comment
    @PostMapping(value = "/")
    public String addNewRestaurant(Restaurant restaurant, Model model) {
    	restaurantRepository.save(restaurant);
    	model.addAttribute("owner", restaurant.getOwner());
    	model.addAttribute("name", restaurant.getName());
    	model.addAttribute("phoneNumber", restaurant.getPhoneNumber());
    	model.addAttribute("address", restaurant.getAddress());
    	return "restaurant/result";
    }
}


