package com.example.takahashi.springotamashi;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.takahashi.springotamashi.interceptor.CacheAnnotation;
import com.example.takahashi.springotamashi.interceptor.NoCacheAnnotation;

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
		} else {
			countService.updateCount("001");
			Integer after = countService.getCurrentCount("001");
			model.addAttribute("before", before);
			model.addAttribute("after",after);
		}
		return "countresult";
	}
	/**
	 * Post redirect Getのパターンのコントローラーサンプル。
	 * @param txt1
	 * @param model
	 * @return
	 */
	@NoCacheAnnotation
	@RequestMapping(value="/postup",method = RequestMethod.POST)
	public String postUp(@RequestParam("txt1") String txt1,Model model) {
		countService.updateCount("001",Integer.parseInt(txt1));
		// Cache for an hour - "Cache-Control: max-age=3600"
		CacheControl ccCacheOneHour = CacheControl.maxAge(1, TimeUnit.HOURS);

		// Prevent caching - "Cache-Control: no-store"
		CacheControl ccNoStore = CacheControl.noStore();

		// Cache for ten days in public and private caches,
		// public caches should not transform the response
		// "Cache-Control: max-age=864000, public, no-transform"
		CacheControl ccCustom = CacheControl.maxAge(10, TimeUnit.DAYS)
		                                    .noTransform().cachePublic();
		
		
		
		return "redirect:/count/query";
	}
	@RequestMapping(value="/query",method = RequestMethod.GET)
	public String query(Model model) {
		Integer before = countService.getCurrentCount("001");
		model.addAttribute("before", before);
		model.addAttribute("after","-");
		return "countresult";
	}
	
}
