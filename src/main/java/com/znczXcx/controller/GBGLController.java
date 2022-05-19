package com.znczXcx.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/"+GBGLController.MODULE_NAME)
public class GBGLController {

	public static final String MODULE_NAME="gbgl";
	
	/**
	 * 跳转到过磅管理-磅单记录-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/bdjl/list")
	public String goBdjlList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/bdjl/list";
	}
}
