package kafka.sample.springKafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kafka.sample.springKafka.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;
	
	@RequestMapping(path = "/register/user", method = RequestMethod.POST)
	public String register(@RequestBody String username) {
		service.registerUser(username);
		return username;
	}
}
