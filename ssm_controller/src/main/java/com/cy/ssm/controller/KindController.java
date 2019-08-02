package com.cy.ssm.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.ssm.pojo.Category;
import com.cy.ssm.service.KindService;
import com.cy.ssm.utils.UUIDUtils;
import com.github.pagehelper.PageInfo;





@Controller
public class KindController {
	
	@Autowired
	private KindService kindService;
	
	//查询全部分类信息
	@RequestMapping("/adminkind")
	public String selectkind(Model model,@RequestParam(name="page",required=true,defaultValue="1")int page,@RequestParam(name="size",required=true,defaultValue="10")int size) {	
		PageInfo<Category> pageinfo = kindService.selectkind(page,size);
		model.addAttribute("pageinfo", pageinfo);
		return "admin/kind";
	}
	
	//添加分类页面跳转
	@RequestMapping("/adminkindadd")
	public String adminaddkind() {
		return "admin/kind-add";
	}
	
	//添加分类页面
	@RequestMapping("/kindadd")
	public String addkind(Category category,Model model) {
		if(category.getCname()!=null&&category.getCname()!="") {
			category.setCid(UUIDUtils.getId());
			kindService.addkind(category);
			return "redirect:adminkind.action";
		}else {
			model.addAttribute("msg", "分类名称不能为空");
			return "admin/kind-add";
		}
			
		
	}

	//模糊搜索
	@RequestMapping("/adminkindfind")
	public String adminkindfind(Category category,Model model,@RequestParam(name="page",required=true,defaultValue="1")int page,@RequestParam(name="size",required=true,defaultValue="10")int size) {
		
		PageInfo<Category> pageinfo = kindService.adminkindfind(category,page,size);
		model.addAttribute("pageinfo", pageinfo);	
		return "admin/kind";
	}
	
	//删除分类
	@RequestMapping("/adminkinddel")
	public String adminkinddel(HttpServletRequest req) {
		String cid =req.getParameter("cid");
		kindService.delkind(cid);
		return "redirect:adminkind.action";
		
	}
	
	//跳转到编辑页面
	@RequestMapping("/kindup")
	public String kindup(Model model,HttpServletRequest req) {
		model.addAttribute("cname", req.getParameter("cname"));
		model.addAttribute("cid", req.getParameter("cid"));
		return "admin/kind-update";
	}
	//更新分类
	@RequestMapping("/adminkindup")
	public String adminkindup(Category category) {
		kindService.upkind(category);
		return "redirect:adminkind.action";		
	}
	
	//检查添加分类时是否存在此分类
	@RequestMapping("/findkindajax")
	@ResponseBody
	public void findkindajax(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		String cname = req.getParameter("cname");
		Category category = kindService.findkindajax(cname);
		if(category==null)
		{
			 resp.getWriter().println(1);
		}else {
			 resp.getWriter().println(2);		
		}
	}
}
