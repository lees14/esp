package cn.most.esp.zjxx.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.most.esp.zjxx.entity.ZjxxInfo;
import cn.most.esp.zjxx.service.ZjxxService;

@Controller
@RequestMapping("zjxx")
public class ZjxxController {

	@Autowired
	private ZjxxService zjxxService;
	
	@PostMapping("saveZjxx")
	public String saveZjxx(Model model,ZjxxInfo zjxxInfo,HttpServletRequest request) {
		zjxxService.updateById(zjxxInfo);
		return "";
	}
	
	
}
