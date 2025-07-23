package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.Customer;

@Controller
public class Lab5_1Sec2Controller {
	
	@GetMapping("/customer")
	public String greeting(Model model) {
		//model.addAttribute("ชื่อตัวแปร", ค่า);
		//String myName = "watthanachai bungchan";
		Customer[] customer = {
				new Customer(1L,"jhonson"),
				new Customer(2L,"mira"),
				new Customer(3L,"nana")
		};
		model.addAttribute("customers",customer);
		return "customer";
	}

}
