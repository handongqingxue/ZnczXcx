package com.znczXcx.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znczXcx.service.*;
import com.znczXcx.entity.*;
import com.znczXcx.util.*;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private QiYeService qiYeService;

	/**
	 * ��ת����¼ҳ
	 * @return
	 */
	@RequestMapping(value="/goLogin")
	public String goLogin() {
		
		return "login";
	}
	
	@RequestMapping(value="/goRegist")
	public String goRegist(HttpServletRequest request) {
		
		return "regist";
	}
	
	/**
	 * ע����Ϣ����ӿ�
	 * @param qy
	 * @return
	 */
	@RequestMapping(value = "/regist" , method = RequestMethod.POST,produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String regist(QiYe qy) {
		
		PlanResult plan=new PlanResult();
		int count=qiYeService.add(qy);
		if(count==0) {
			plan.setStatus(count);
			plan.setMsg("ע��ʧ��");
			return JsonUtil.getJsonFromObject(plan);
		}else {
			plan.setStatus(0);
			plan.setMsg("ע��ɹ�");
			plan.setData(qy);
			plan.setUrl("/main/goLogin");
		}
		
		return JsonUtil.getJsonFromObject(plan);
	}
}
