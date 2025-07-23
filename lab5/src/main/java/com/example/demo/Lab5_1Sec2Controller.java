package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Lab5_1Sec2Controller {
	
	@GetMapping("/hello")
	public String greeting(Model model) {
		//model.addAttribute("ชื่อตัวแปร", ค่า);
		String myName = "watthanachai bungchan";
		model.addAttribute("name",myName);
		return "hello";
	}

}
