package com.servletdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Vladimir Mishatkin on 07.04.2014.
 */
@Controller
@RequestMapping("/hellowing")
public class SpringController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("controllerMessage", "I am The Mighty Controller");
		return "hello";
	}
}
