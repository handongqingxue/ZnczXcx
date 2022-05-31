package com.znczXcx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Controller
@RequestMapping("/"+XCXController.MODULE_NAME)
public class XCXController {

	@Autowired
	private DingDanService dingDanService;
	@Autowired
	private PaiDuiJiLuService paiDuiJiLuService;
	@Autowired
	private ZhiJianJiLuService zhiJianJiLuService;
	public static final String MODULE_NAME="xcx";

	@RequestMapping(value="/newPaiDuiJiLu")
	@ResponseBody
	public Map<String, Object> newPaiDuiJiLu(PaiDuiJiLu pdjl) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		Integer ddId = pdjl.getDdId();
		String qyh = pdjl.getQyh();
		boolean exist=paiDuiJiLuService.checkIfExist(ddId,qyh);
		int count=0;
		if(exist)
			count=paiDuiJiLuService.updatePhdByDdId(ddId,qyh);
		else {
			pdjl.setQyh(qyh);
			count=paiDuiJiLuService.add(pdjl);
		}
		
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建排队记录成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建排队记录失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/newZhiJianJiLu")
	@ResponseBody
	public Map<String, Object> newBangDanJiLu(ZhiJianJiLu zjjl) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=zhiJianJiLuService.add(zjjl);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建质检记录成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建质检记录失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/getDingDanByDdh")
	@ResponseBody
	public Map<String, Object> getDingDanByDdh(String ddh, String qyh, HttpServletRequest request) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		DingDan dingDan = dingDanService.selectByDdh(ddh, qyh);
		if(dingDan!=null) {
			jsonMap.put("message", "ok");
			jsonMap.put("dingDan", dingDan);
			jsonMap.put("dzjDdztMc", DingDanZhuangTai.DAI_ZHI_JIAN_TEXT);
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "没有找到相关订单！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/getPaiDuiXinXiByDdId")
	@ResponseBody
	public Map<String, Object> getPaiDuiXinXiByDdh(Integer ddId, String qyh) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		PaiDuiJiLu paiDuiJiLu=paiDuiJiLuService.selectByDdId(ddId, qyh);
		if(paiDuiJiLu!=null) {
			jsonMap.put("message", "ok");
			jsonMap.put("paiDuiJiLu", paiDuiJiLu);
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "没有找到相关排队信息！");
		}
		return jsonMap;
	}
}
