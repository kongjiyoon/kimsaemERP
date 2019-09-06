package ktds.erp.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ktds.erp.emp.MemberDTO;

@Controller
public class AdminController {
	@Autowired
	AdminService service;
	@RequestMapping("/admin/member/list.do")
	public ModelAndView getMemberList() {
		ArrayList<MemberDTO> memberlist = (ArrayList<MemberDTO>)service.getMemberList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberlist", memberlist);
		mav.setViewName("admin/memberlist");
		return mav;
	}
	@RequestMapping("/admin/passmodify.do")
	public String modifyPassword(String[] id) {
		int result = service.passwordChange(id);
		if(result>=1) {
			System.out.println("성공변경");
		}
		return "redirect:/admin/member/list.do";
	}
}
