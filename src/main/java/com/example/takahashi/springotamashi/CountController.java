package com.example.takahashi.springotamashi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/count")
public class CountController {
	@Autowired
	CountService countService;
	@Autowired
	HeadService headSercvice;
	/**
	 * カウントアップのメソッド.
	 * http://localhost:8080/count/up?flag=true 
	 * でエラーが発生する.
	 * http://localhost:8080/count/up?flag=nest
	 * でトランザクション（req_new&requiedでエラー発生→req_newだけ成功、そのあとはロールバックするが前者はコミット済みのため戻らないケース）
	 * @param model
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="/up",method = RequestMethod.GET)
	public String countup(Model model,@RequestParam(defaultValue="false") String flag) {
		Integer before = countService.getCurrentCount("001");
		if("true".equals(flag)) {
			countService.updateCountFail("001");
		} else if("nest".equals(flag)) {
			headSercvice.nestService("001");
		}else {
			countService.updateCount("001");
			Integer after = countService.getCurrentCount("001");
			model.addAttribute("before", before);
			model.addAttribute("after",after);
		}
		return "countresult";
	}
	
	@RequestMapping(value="/query",method = RequestMethod.GET)
	public String query(Model model) {
		Integer before = countService.getCurrentCount("001");
		model.addAttribute("before", before);
		model.addAttribute("after","-");
		return "countresult";
	}
	
}
