package cn.most.esp.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.most.esp.common.ResultUtil;
import cn.most.esp.common.ResultVO;
import cn.most.esp.user.entity.UserInfo;
import cn.most.esp.user.service.UserService;
import cn.most.esp.utils.CheckExcelFileTypeUtil;
import cn.most.esp.utils.FileUtil;
import cn.most.esp.utils.MbUtil;
import cn.most.esp.utils.UserUtil;

@Controller
@RequestMapping("user")
public class UserController {

	private static final Logger loger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	private UserService userservice;

	@Autowired
	private Environment erm;

	@RequiresRoles({ "admins" })
	@RequestMapping("userList")
	public String userList(Model model,@ModelAttribute(value="userInfo") UserInfo userInfo,
			@RequestHeader(value = "X-Requested-With", required = false) String requested) {
		if(StringUtils.equalsIgnoreCase("XMLHttpRequest", requested)) {
			initOrderList(model);
			ResultVO resultVO = getUserInfo();
			model.addAttribute("result", resultVO);
			userInfo = userservice.getOneById(UserUtil.getUserId());
			model.addAttribute("userInfo", userInfo);
			
			return "user/userList :: Tuser";
		}
		model.addAttribute("userInfo",userInfo);
		initOrderList(model);
		model.addAttribute("result", new ResultVO());
		return "user/userList";
	}

	private void initOrderList(Model model) {
		model.addAttribute("hdlxList",MbUtil.getMbInfo("t_m_hdlx"));
	}
	
	@RequestMapping("getUserInfo")
	@ResponseBody
	public ResultVO getUserInfo() {
		List<UserInfo> lists = userservice.getAll();
		ResultVO resultVO = ResultUtil.getSuccess("查询成功！", lists);
		return resultVO;
	}

	@RequiresRoles({ "admins" })
	@RequestMapping("userIndex")
	public ModelAndView userIndex() {
		return new ModelAndView("user/userIndex");
	}

	@PostMapping("userIndex")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		String fileType = CheckExcelFileTypeUtil.getFileType(file);
		if(fileType != "docx" && fileType != "doc" ) {
			redirectAttributes.addFlashAttribute("message",
					"You uploaded " + file.getOriginalFilename() + "failed!");
			return "redirect:userIndex";
		}
		
		boolean flag = FileUtil.Upload(file, "ls.docx",
				erm.getProperty("file.path"));
		if (!flag) {
			redirectAttributes.addFlashAttribute("message",
					"You uploaded " + file.getOriginalFilename() + "failed!");
		} else {
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded " + file.getOriginalFilename()
							+ "!");
		}
		return "redirect:userIndex";
	}

	@RequestMapping("userDownLoad")
	public void downLoad(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			FileUtil.downLoad(erm.getProperty("file.path") + "ls.docx",
					"lis.docx", response, request);
		} catch (Exception e) {
			loger.debug("下载出现异常：" + e.getMessage());
		}
	}

	@GetMapping("userForm")
	public String userForm(Model model,@ModelAttribute(value="userInfo") UserInfo userInfo) {
		userInfo = userservice.getOneById(UserUtil.getUserId());
		model.addAttribute("userInfo", userInfo);
		return "user/userForm";
	}
	
	@RequestMapping("saveUser")
	@ResponseBody
	public ResultVO saveUser(@Valid @ModelAttribute UserInfo userInfo,BindingResult bresult) {
		if(bresult.hasErrors()) {
			for(ObjectError error : bresult.getAllErrors()) {
				return ResultUtil.getFail(error.getDefaultMessage());
			}
		}
		int result = userservice.updateById(userInfo);
		if(result > 0 ) {
			ResultVO resultVO = ResultUtil.getSuccess("保存成功！");
			return resultVO;
		}else {
			ResultVO resultVO = ResultUtil.getFail("保存失败！");
			return resultVO;
		}
		
	}
}
