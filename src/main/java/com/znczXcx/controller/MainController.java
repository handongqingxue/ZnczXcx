package com.znczXcx.controller;

import java.io.File;
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
	private YongHuService yongHuService;
	@Autowired
	private WuZiLeiXingService wuZiLeiXingService;
	@Autowired
	private WuZiService wuZiService;
	@Autowired
	private YunShuShangService yunShuShangService;
	@Autowired
	private FaHuoDanWeiService faHuoDanWeiService;
	@Autowired
	private ShouHuoBuMenService shouHuoBuMenService;
	@Autowired
	private DingDanService dingDanService;
	@Autowired
	private ShenHeJiLuService shenHeJiLuService;
	@Autowired
	private DingDanZhuangTaiService dingDanZhuangTaiService;
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

	@RequestMapping(value="/syncYHToYf")
	@ResponseBody
	public Map<String, Object> syncYHToYf(String qyh, String yhJAStr) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		System.out.println("yhJAStr==="+yhJAStr);
		JSONArray yhJA = JSONArray.fromObject(yhJAStr);
		List<YongHu> yhList = JSONArray.toList(yhJA, YongHu.class);
		System.out.println("size==="+yhList.size());
		int count=yongHuService.syncToYf(yhList,qyh);
		if(count==yhList.size()) {
			jsonMap.put("status", "ok");
		}
		else {
			jsonMap.put("status", "no");
		}
		return jsonMap;
	}

	@RequestMapping(value="/syncDDZTToYf")
	@ResponseBody
	public Map<String, Object> syncDDZTToYf(String qyh, String ddztJAStr) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		System.out.println("ddztJAStr==="+ddztJAStr);
		JSONArray ddJA = JSONArray.fromObject(ddztJAStr);
		List<DingDanZhuangTai> ddztList = JSONArray.toList(ddJA, DingDanZhuangTai.class);
		System.out.println("size==="+ddztList.size());
		int count=dingDanZhuangTaiService.syncToYf(ddztList,qyh);
		if(count==ddztList.size()) {
			jsonMap.put("status", "ok");
		}
		else {
			jsonMap.put("status", "no");
		}
		return jsonMap;
	}

	@RequestMapping(value="/syncToYf")
	@ResponseBody
	public Map<String, Object> syncToYf(String tab, String qyh, String entityJAStr) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		int count=0;
		String status=null;
		System.out.println("entityJAStr==="+entityJAStr);
		JSONArray entityJA = JSONArray.fromObject(entityJAStr);
		if(Main.DING_DAN.equals(tab)) {
			List<DingDan> ddList = JSONArray.toList(entityJA, DingDan.class);
			System.out.println("size==="+ddList.size());
			count=dingDanService.syncToYf(ddList,qyh);
			if(count==ddList.size()) {
				status="ok";
			}
			else {
				status="no";
			}
		}
		else if(Main.SHEN_HE_JI_LU.equals(tab)) {
			List<ShenHeJiLu> shjlList = JSONArray.toList(entityJA, ShenHeJiLu.class);
			System.out.println("size==="+shjlList.size());
			count=shenHeJiLuService.syncToYf(shjlList,qyh);
			if(count==shjlList.size()) {
				status="ok";
			}
			else {
				status="no";
			}
		}
		else if(Main.BANG_DAN_JI_LU.equals(tab)) {
			List<BangDanJiLu> bdjlList = JSONArray.toList(entityJA, BangDanJiLu.class);
			System.out.println("size==="+bdjlList.size());
			count=bangDanJiLuService.syncToYf(bdjlList,qyh);
			if(count==bdjlList.size()) {
				status="ok";
			}
			else {
				status="no";
			}
		}
		else if(Main.GUO_BANG_JI_LU.equals(tab)) {
			List<GuoBangJiLu> gbjlList = JSONArray.toList(entityJA, GuoBangJiLu.class);
			System.out.println("size==="+gbjlList.size());
			count=guoBangJiLuService.syncToYf(gbjlList,qyh);
			if(count==gbjlList.size()) {
				status="ok";
			}
			else {
				status="no";
			}
		}
		else if(Main.WU_ZI_LEI_XING.equals(tab)) {
			List<WuZiLeiXing> wzlxList = JSONArray.toList(entityJA, WuZiLeiXing.class);
			System.out.println("size==="+wzlxList.size());
			count=wuZiLeiXingService.syncToYf(wzlxList,qyh);
			if(count==wzlxList.size()) {
				status="ok";
			}
			else {
				status="no";
			}
		}
		else if(Main.WU_ZI.equals(tab)) {
			List<WuZi> wzList = JSONArray.toList(entityJA, WuZi.class);
			System.out.println("size==="+wzList.size());
			count=wuZiService.syncToYf(wzList,qyh);
			if(count==wzList.size()) {
				status="ok";
			}
			else {
				status="no";
			}
		}
		else if(Main.YUN_SHU_SHANG.equals(tab)) {
			List<YunShuShang> yssList = JSONArray.toList(entityJA, YunShuShang.class);
			System.out.println("size==="+yssList.size());
			count=yunShuShangService.syncToYf(yssList,qyh);
			if(count==yssList.size()) {
				status="ok";
			}
			else {
				status="no";
			}
		}
		else if(Main.FA_HUO_DAN_WEI.equals(tab)) {
			List<FaHuoDanWei> fhdwList = JSONArray.toList(entityJA, FaHuoDanWei.class);
			System.out.println("size==="+fhdwList.size());
			count=faHuoDanWeiService.syncToYf(fhdwList,qyh);
			if(count==fhdwList.size()) {
				status="ok";
			}
			else {
				status="no";
			}
		}
		else if(Main.SHOU_HUO_BU_MEN.equals(tab)) {
			List<ShouHuoBuMen> shbmList = JSONArray.toList(entityJA, ShouHuoBuMen.class);
			System.out.println("size==="+shbmList.size());
			count=shouHuoBuMenService.syncToYf(shbmList,qyh);
			if(count==shbmList.size()) {
				status="ok";
			}
			else {
				status="no";
			}
		}
		else if(Main.PAI_DUI_JI_LU.equals(tab)) {
			List<PaiDuiJiLu> pdjlList = JSONArray.toList(entityJA, PaiDuiJiLu.class);
			System.out.println("size==="+pdjlList.size());
			count=paiDuiJiLuService.syncToYf(pdjlList,qyh);
			if(count==pdjlList.size()) {
				status="ok";
			}
			else {
				status="no";
			}
		}
		else if(Main.ZHI_JIAN_JI_LU.equals(tab)) {
			List<ZhiJianJiLu> zjjlList = JSONArray.toList(entityJA, ZhiJianJiLu.class);
			System.out.println("size==="+zjjlList.size());
			count=zhiJianJiLuService.syncToYf(zjjlList,qyh);
			if(count==zjjlList.size()) {
				status="ok";
			}
			else {
				status="no";
			}
		}
		jsonMap.put("status", status);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/checkIfWtbToQy")
	@ResponseBody
	public Map<String, Object> checkIfWtbToQy(String tab, String qyh) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		boolean bool=false;
		if(Main.YONG_HU.equals(tab)) {
			bool=yongHuService.checkIfWtbToYf(qyh);
		}
		else if(Main.DING_DAN_ZHUANG_TAI.equals(tab)) {
			bool=dingDanZhuangTaiService.checkIfWtbToYf(qyh);
		}
		else if(Main.WU_ZI_LEI_XING.equals(tab)) {
			bool=wuZiLeiXingService.checkIfWtbToYf(qyh);
		}
		else if(Main.WU_ZI.equals(tab)) {
			bool=wuZiService.checkIfWtbToYf(qyh);
		}
		else if(Main.YUN_SHU_SHANG.equals(tab)) {
			bool=yunShuShangService.checkIfWtbToYf(qyh);
		}
		else if(Main.FA_HUO_DAN_WEI.equals(tab)) {
			bool=faHuoDanWeiService.checkIfWtbToYf(qyh);
		}
		else if(Main.SHOU_HUO_BU_MEN.equals(tab)) {
			bool=shouHuoBuMenService.checkIfWtbToYf(qyh);
		}
		else if(Main.DING_DAN.equals(tab)) {
			bool=dingDanService.checkIfWtbToYf(qyh);
		}
		else if(Main.PAI_DUI_JI_LU.equals(tab)) {
			bool=paiDuiJiLuService.checkIfWtbToYf(qyh);
		}
		else if(Main.BANG_DAN_JI_LU.equals(tab)) {
			bool=bangDanJiLuService.checkIfWtbToYf(qyh);
		}
		else if(Main.ZHI_JIAN_JI_LU.equals(tab)) {
			bool=zhiJianJiLuService.checkIfWtbToYf(qyh);
		}
		else if(Main.GUO_BANG_JI_LU.equals(tab)) {
			bool=guoBangJiLuService.checkIfWtbToYf(qyh);
		}
		
		if(bool) {
			jsonMap.put("status", "ok");
		}
		else {
			jsonMap.put("status", "no");
		}
		return jsonMap;
	}

	@RequestMapping(value="/selectListByQytb")
	@ResponseBody
	public Map<String, Object> selectListByQytb(String tab, Integer qytb, String qyh) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		if(Main.YONG_HU.equals(tab)) {
			List<YongHu> yhList=yongHuService.selectListByQytb(qytb, qyh);
			if(yhList.size()==0)
				jsonMap.put("status", "no");
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("yhList", yhList);
			}
		}
		else if(Main.DING_DAN_ZHUANG_TAI.equals(tab)) {
			List<DingDanZhuangTai> ddztList=dingDanZhuangTaiService.selectListByQytb(qytb, qyh);
			if(ddztList.size()==0)
				jsonMap.put("status", "no");
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("ddztList", ddztList);
			}
		}
		else if(Main.WU_ZI_LEI_XING.equals(tab)) {
			List<WuZiLeiXing> wzlxList=wuZiLeiXingService.selectListByQytb(qytb, qyh);
			if(wzlxList.size()==0)
				jsonMap.put("status", "no");
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("wzlxList", wzlxList);
			}
		}
		else if(Main.WU_ZI.equals(tab)) {
			List<WuZi> wzList=wuZiService.selectListByQytb(qytb, qyh);
			if(wzList.size()==0)
				jsonMap.put("status", "no");
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("wzList", wzList);
			}
		}
		else if(Main.YUN_SHU_SHANG.equals(tab)) {
			List<YunShuShang> yssList=yunShuShangService.selectListByQytb(qytb, qyh);
			if(yssList.size()==0)
				jsonMap.put("status", "no");
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("yssList", yssList);
			}
		}
		else if(Main.FA_HUO_DAN_WEI.equals(tab)) {
			List<FaHuoDanWei> fhdwList=faHuoDanWeiService.selectListByQytb(qytb, qyh);
			if(fhdwList.size()==0)
				jsonMap.put("status", "no");
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("fhdwList", fhdwList);
			}
		}
		else if(Main.SHOU_HUO_BU_MEN.equals(tab)) {
			List<ShouHuoBuMen> shbmList=shouHuoBuMenService.selectListByQytb(qytb, qyh);
			if(shbmList.size()==0)
				jsonMap.put("status", "no");
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("shbmList", shbmList);
			}
		}
		else if(Main.DING_DAN.equals(tab)) {
			List<DingDan> ddList=dingDanService.selectListByQytb(qytb, qyh);
			if(ddList.size()==0)
				jsonMap.put("status", "no");
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("ddList", ddList);
			}
		}
		else if(Main.PAI_DUI_JI_LU.equals(tab)) {
			List<PaiDuiJiLu> pdjlList=paiDuiJiLuService.selectListByQytb(qytb, qyh);
			if(pdjlList.size()==0)
				jsonMap.put("status", "no");
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("pdjlList", pdjlList);
			}
		}
		else if(Main.BANG_DAN_JI_LU.equals(tab)) {
			List<BangDanJiLu> bdjlList=bangDanJiLuService.selectListByQytb(qytb, qyh);
			if(bdjlList.size()==0)
				jsonMap.put("status", "no");
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("bdjlList", bdjlList);
			}
		}
		else if(Main.ZHI_JIAN_JI_LU.equals(tab)) {
			List<ZhiJianJiLu> zjjlList=zhiJianJiLuService.selectListByQytb(qytb, qyh);
			if(zjjlList.size()==0)
				jsonMap.put("status", "no");
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("zjjlList", zjjlList);
			}
		}
		else if(Main.GUO_BANG_JI_LU.equals(tab)) {
			List<GuoBangJiLu> gbjlList=guoBangJiLuService.selectListByQytb(qytb, qyh);
			if(gbjlList.size()==0)
				jsonMap.put("status", "no");
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("gbjlList", gbjlList);
			}
		}
		return jsonMap;
	}

	@RequestMapping(value="/updateTbZtByQytb")
	@ResponseBody
	public Map<String, Object> updateTbZtByQytb(String tab, Integer qytb, Integer xtbzt, String qyh) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		String status=null;
		if(Main.YONG_HU.equals(tab)) {
			int count=yongHuService.updateTbZtByQytb(qytb,xtbzt,qyh);
			if(count==0)
				status="no";
			else {
				status="ok";
			}
		}
		else if(Main.DING_DAN_ZHUANG_TAI.equals(tab)) {
			int count=dingDanZhuangTaiService.updateTbZtByQytb(qytb,xtbzt,qyh);
			if(count==0)
				status="no";
			else {
				status="ok";
			}
		}
		else if(Main.WU_ZI_LEI_XING.equals(tab)) {
			int count=wuZiLeiXingService.updateTbZtByQytb(qytb,xtbzt,qyh);
			if(count==0)
				status="no";
			else {
				status="ok";
			}
		}
		else if(Main.WU_ZI.equals(tab)) {
			int count=wuZiService.updateTbZtByQytb(qytb,xtbzt,qyh);
			if(count==0)
				status="no";
			else {
				status="ok";
			}
		}
		else if(Main.YUN_SHU_SHANG.equals(tab)) {
			int count=yunShuShangService.updateTbZtByQytb(qytb,xtbzt,qyh);
			if(count==0)
				status="no";
			else {
				status="ok";
			}
		}
		else if(Main.FA_HUO_DAN_WEI.equals(tab)) {
			int count=faHuoDanWeiService.updateTbZtByQytb(qytb,xtbzt,qyh);
			if(count==0)
				status="no";
			else {
				status="ok";
			}
		}
		else if(Main.SHOU_HUO_BU_MEN.equals(tab)) {
			int count=shouHuoBuMenService.updateTbZtByQytb(qytb,xtbzt,qyh);
			if(count==0)
				status="no";
			else {
				status="ok";
			}
		}
		else if(Main.DING_DAN.equals(tab)) {
			int count=dingDanService.updateTbZtByQytb(qytb,xtbzt,qyh);
			if(count==0)
				status="no";
			else {
				status="ok";
			}
		}
		else if(Main.PAI_DUI_JI_LU.equals(tab)) {
			int count=paiDuiJiLuService.updateTbZtByQytb(qytb,xtbzt,qyh);
			if(count==0)
				status="no";
			else {
				status="ok";
			}
		}
		else if(Main.BANG_DAN_JI_LU.equals(tab)) {
			int count=bangDanJiLuService.updateTbZtByQytb(qytb,xtbzt,qyh);
			if(count==0)
				status="no";
			else {
				status="ok";
			}
		}
		else if(Main.ZHI_JIAN_JI_LU.equals(tab)) {
			int count=zhiJianJiLuService.updateTbZtByQytb(qytb,xtbzt,qyh);
			if(count==0)
				status="no";
			else {
				status="ok";
			}
		}
		else if(Main.GUO_BANG_JI_LU.equals(tab)) {
			int count=guoBangJiLuService.updateTbZtByQytb(qytb,xtbzt,qyh);
			if(count==0)
				status="no";
			else {
				status="ok";
			}
		}
		jsonMap.put("status", status);
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
