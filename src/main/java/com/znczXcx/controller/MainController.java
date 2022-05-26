package com.znczXcx.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znczXcx.service.*;
import com.znczXcx.dao.FaHuoDanWeiMapper;
import com.znczXcx.entity.*;
import com.znczXcx.util.*;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private QiYeService qiYeService;
	@Autowired
	private MainService mainService;
	@Autowired
	private YunShuShangService yunShuShangService;
	@Autowired
	private FaHuoDanWeiService faHuoDanWeiService;
	@Autowired
	private DingDanService dingDanService;
	@Autowired
	private PaiDuiJiLuService paiDuiJiLuService;
	@Autowired
	private ZhiJianJiLuService zhiJianJiLuService;
	@Autowired
	private BangDanJiLuService bangDanJiLuService;
	@Autowired
	private GuoBangJiLuService guoBangJiLuService;

	/**
	 * 跳转到登录页
	 * @return
	 */
	@RequestMapping(value="/goLogin")
	public String goLogin() {
		boolean bool=mainService.createTabByQyh("yuejiazhuang");
		
		return "login";
	}
	
	@RequestMapping(value="/goRegist")
	public String goRegist(HttpServletRequest request) {
		
		return "regist";
	}
	
	/**
	 * 注册信息处理接口
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
			plan.setMsg("注册失败");
			return JsonUtil.getJsonFromObject(plan);
		}else {
			boolean bool=mainService.createTabByQyh(qy.getQyh());
			
			plan.setStatus(0);
			plan.setMsg("注册成功");
			plan.setData(qy);
			plan.setUrl("/main/goLogin");
		}
		
		return JsonUtil.getJsonFromObject(plan);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String login(String qyh,String mm,
			String rememberMe,HttpServletRequest request) {
		System.out.println("===登录接口===");
		//返回值的json
		PlanResult plan=new PlanResult();
		HttpSession session=request.getSession();
		
		//TODO在这附近添加登录储存信息步骤，将用户的账号以及密码储存到shiro框架的管理配置当中方便后续查询
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(qyh,mm); 
			Subject currentUser = SecurityUtils.getSubject();
			if (!currentUser.isAuthenticated()){
				//使用shiro来验证  
				token.setRememberMe(true);  
				currentUser.login(token);//验证角色和权限  
			}
		}catch (Exception e) {
			e.printStackTrace();
			plan.setStatus(1);
			plan.setMsg("登陆失败");
			return JsonUtil.getJsonFromObject(plan);
		}
		QiYe qiYe=(QiYe)SecurityUtils.getSubject().getPrincipal();
		session.setAttribute("qiYe", qiYe);
		
		plan.setStatus(0);
		plan.setMsg("验证通过");
		plan.setUrl("/gbgl/bdjl/list");
		return JsonUtil.getJsonFromObject(plan);
	}

	@RequestMapping(value="/exit")
	public String exit(HttpSession session) {
		System.out.println("退出接口");
		Subject currentUser = SecurityUtils.getSubject();
	    currentUser.logout();    
		return "login";
	}

	@RequestMapping(value="/checkQyhIfExist",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String checkQyhIfExist(String qyh) {
		boolean exist=qiYeService.checkQyhIfExist(qyh);
		PlanResult plan=new PlanResult();
		String json;
		if(exist) {
			plan.setStatus(0);
			plan.setMsg("企业号已存在");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/selectPDJLListByQytb")
	@ResponseBody
	public Map<String, Object> selectPDJLListByQytb(String qyh, Integer qytb) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		boolean bool=paiDuiJiLuService.checkIfTbZt(qyh,qytb);
		if(bool) {
			List<PaiDuiJiLu> pdjlList=paiDuiJiLuService.selectListByQytb(qyh,qytb);
			paiDuiJiLuService.updateTbZtByQytb(qyh,qytb,Main.TONG_BU_ZHONG);
			
			jsonMap.put("status", "ok");
			jsonMap.put("pdjlList", pdjlList);
		}
		else {
			jsonMap.put("status", "no");
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/selectZJJLListByQytb")
	@ResponseBody
	public Map<String, Object> selectZJJLListByQytb(String qyh, Integer qytb) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		boolean bool=zhiJianJiLuService.checkIfTbZt(qyh,qytb);
		if(bool) {
			List<ZhiJianJiLu> zjjlList=zhiJianJiLuService.selectListByQytb(qyh,qytb);
			zhiJianJiLuService.updateTbZtByQytb(qyh,qytb,Main.TONG_BU_ZHONG);
			
			jsonMap.put("status", "ok");
			jsonMap.put("zjjlList", zjjlList);
		}
		else {
			jsonMap.put("status", "no");
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/updatePDJLToYtb")
	@ResponseBody
	public Map<String, Object> updatePDJLToYtb(String qyh) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=paiDuiJiLuService.updateToYtb(qyh);
		if(count==0) {
			jsonMap.put("status", "no");
		}
		else {
			jsonMap.put("status", "ok");
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/updateZJJLToYtb")
	@ResponseBody
	public Map<String, Object> updateZJJLToYtb(String qyh) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=zhiJianJiLuService.updateToYtb(qyh);
		if(count==0) {
			jsonMap.put("status", "no");
		}
		else {
			jsonMap.put("status", "ok");
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/addDDToYf")
	@ResponseBody
	public Map<String, Object> addDDToYf(String qyh, String ddJAStr) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		System.out.println("ddJAStr==="+ddJAStr);
		JSONArray ddJA = JSONArray.fromObject(ddJAStr);
		List<DingDan> ddList = JSONArray.toList(ddJA, DingDan.class);
		System.out.println("size==="+ddList.size());
		int count=dingDanService.addToYf(ddList,qyh);
		if(count==ddList.size()) {
			jsonMap.put("status", "ok");
		}
		else {
			jsonMap.put("status", "no");
		}
		return jsonMap;
	}

	@RequestMapping(value="/addBDJLToYf")
	@ResponseBody
	public Map<String, Object> addBDJLToYf(String qyh, String bdjlJAStr) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		System.out.println("bdjlJAStr==="+bdjlJAStr);
		JSONArray bdjlJA = JSONArray.fromObject(bdjlJAStr);
		List<BangDanJiLu> bdjlList = JSONArray.toList(bdjlJA, BangDanJiLu.class);
		System.out.println("size==="+bdjlList.size());
		int count=bangDanJiLuService.addToYf(bdjlList,qyh);
		if(count==bdjlList.size()) {
			jsonMap.put("status", "ok");
		}
		else {
			jsonMap.put("status", "no");
		}
		return jsonMap;
	}

	@RequestMapping(value="/addGBJLToYf")
	@ResponseBody
	public Map<String, Object> addGBJLToYf(String qyh, String gbjlJAStr) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		System.out.println("gbjlJAStr==="+gbjlJAStr);
		JSONArray gbjlJA = JSONArray.fromObject(gbjlJAStr);
		List<GuoBangJiLu> gbjlList = JSONArray.toList(gbjlJA, GuoBangJiLu.class);
		System.out.println("size==="+gbjlList.size());
		int count=guoBangJiLuService.addToYf(gbjlList,qyh);
		if(count==gbjlList.size()) {
			jsonMap.put("status", "ok");
		}
		else {
			jsonMap.put("status", "no");
		}
		return jsonMap;
	}

	@RequestMapping(value="/addYSSToYf")
	@ResponseBody
	public Map<String, Object> addYSSToYf(String qyh, String yssJAStr) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		System.out.println("yssJAStr==="+yssJAStr);
		JSONArray yssJA = JSONArray.fromObject(yssJAStr);
		List<YunShuShang> yssList = JSONArray.toList(yssJA, YunShuShang.class);
		System.out.println("size==="+yssList.size());
		int count=yunShuShangService.addToYf(yssList,qyh);
		if(count==yssList.size()) {
			jsonMap.put("status", "ok");
		}
		else {
			jsonMap.put("status", "no");
		}
		return jsonMap;
	}

	@RequestMapping(value="/addFHDWToYf")
	@ResponseBody
	public Map<String, Object> addFHDWToYf(String qyh, String fhdwJAStr) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		System.out.println("fhdwJAStr==="+fhdwJAStr);
		JSONArray fhdwJA = JSONArray.fromObject(fhdwJAStr);
		List<FaHuoDanWei> fhdwList = JSONArray.toList(fhdwJA, FaHuoDanWei.class);
		System.out.println("size==="+fhdwList.size());
		int count=faHuoDanWeiService.addToYf(fhdwList,qyh);
		if(count==fhdwList.size()) {
			jsonMap.put("status", "ok");
		}
		else {
			jsonMap.put("status", "no");
		}
		return jsonMap;
	}
	
	public static void main(String[] args) {
		//判断文件是否存在如果存在就删除，不存在就新建
	    String path = "D:/resource/ZnczXcx/111.txt";
	    File file = new File(path);
	    //判断文件或文件夹是否存在
	    boolean flag = file.exists();
	    System.out.println("flag==="+flag);
	    if(flag)
	    {
	        //文件存在就要删除文件
	        file.delete();
	    }
	    else
	    {
	        //文件不存在就要新建文件
			//file.createNewFile();
	    }
	}
}
