package com.raftel.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

	
	@GetMapping("")
	public String no() { return "Welcome"; }
	 
	
	@GetMapping("/cus")
	public String user() {
		return "Welcome User";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Welcome Admin";
	}
	
}