package ktds.erp.emp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import ktds.erp.dept.DeptDTO;
import ktds.erp.dept.DeptService;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	@Autowired
	DeptService deptService;

	// 회원가입페이지를 보여주며 부서명을 가져온다.
	@RequestMapping("/emp/insertView.do")
	public ModelAndView insertPage() {
		ModelAndView mav = new ModelAndView();
		List<DeptDTO> deptnamelist = deptService.getDeptlist();
		mav.addObject("deptnamelist", deptnamelist);
		mav.setViewName("emp/write");
		return mav;
	}

	@RequestMapping("/emp/insert.do")
	public String insert(MemberDTO emp, HttpServletRequest req) throws Exception {
		MultipartFile file = emp.getUserImage();
		// 2. 저장될 위치
		String path = WebUtils.getRealPath(req.getSession().getServletContext(), "/WEB-INF/upload");
		String fileName = file.getOriginalFilename();
		System.out.println("컨틀롤러=>" + emp.getSsn().substring(6, 7));
		emp.setGender(emp.getSsn().substring(6, 7));
		emp.setProfile_photo(fileName);
		if (emp.getMarry() == null) {// 체크박스를 선택하지 않은 미혼이라는 의미
			emp.setMarry("0");
		}
		System.out.println("emp==>" + emp);
		service.insert(emp, file, path, fileName);
		return "redirect:/index.do";
	}
	@RequestMapping(value = "/emp/idcheck.do", 
			method = RequestMethod.GET, 
			produces = "application/text;charset=utf-8")
	public @ResponseBody String idCheck(String id) {
		String result = "";
		boolean check = service.idCheck(id);
		System.out.println(check);
		if (check) {
			result = "사용불가능한 아이디";
		} else {
			result = "사용가능한 아이디";
		}
		return result;
	}
	/*@RequestMapping(value="/emp/login.do",method=RequestMethod.POST)
	public ModelAndView login(MemberDTO loginUser,
				String member_id_save,HttpServletRequest req) 
											throws Exception {
		System.out.println("login==>"+loginUser);
		ModelAndView mav = new ModelAndView();
		LoginDTO user = service.login(loginUser);
		String viewName = "";
		if(user!=null) {
			HttpSession ses = req.getSession();
			ses.setAttribute("loginUser", user);
			viewName = user.getMenupath();
			
		}else {
			viewName = "login";
		}
		
		mav.setViewName(viewName);
		return mav;
	}*/
	/*@RequestMapping(value="/emp/logout.do")
	public String logout(HttpSession ses) throws Exception{
		if(ses!=null) {
			ses.invalidate();
		}
		return "redirect:/index.do";
	}*/
}












