package com.example.takahashi.springotamashi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calc")
public class CalcController {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(method = RequestMethod.POST)
	public String calc(@RequestParam("txt1") String txt1,@RequestParam("txt2") String txt2,
	        Model model) {
		logger.info("txt1 : "+txt1);
		logger.info("txt2 : "+txt2);
		Integer ans = Integer.parseInt(txt1) + Integer.parseInt(txt2);
		model.addAttribute("ans", "答えは:" + ans.toString() + "です！！");
		return "ans";
	}
}
