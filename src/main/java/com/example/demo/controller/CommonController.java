package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class CommonController<T> {
	@RequestMapping(method = RequestMethod.GET, path = "error")
	public String loadErrorMessage()
	{
		return "Something went wrong, please contact the admin...";
	}

	@RequestMapping(method = RequestMethod.GET, path = "welcome")
	public String loadWelcomeMessage()
	{
		return "welcome to the banking app...";
	}

	@RequestMapping(method = RequestMethod.GET, path = "dashboard")
	public String loadDashboard()
	{
		return "user dashboard view...";
	}
}
