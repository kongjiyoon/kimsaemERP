package ktds.kimsaem.erp;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ktds.erp.board.BoardDTO;
import ktds.erp.board.BoardService;
import ktds.erp.emp.authentication.SecurityLoginDTO;

@Controller
public class IndexController{
	@Autowired
	BoardService service;
	@RequestMapping("/index.do")
	public ModelAndView main(Principal principal){
		System.out.println("인증된사용자===>"+principal);
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> boardlist=  service.boardList("게시판");
		mav.addObject("boardlist", boardlist);
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping("/menu/board.do")
	public String showjdbcMenu(){
		System.out.println("ERP게시판");
		return "menu/board";
	}
	@RequestMapping("/menu/insa.do")
	public String showmybatisMenu(){
		System.out.println("인사관리");
		return "menu/insa";
	}
	@RequestMapping(value="/emp/login",method=RequestMethod.GET)
	public String showadvancedMenu(){
		System.out.println("login화면");
		return "login";
	}
	@RequestMapping(value="/menu/job.do",method=RequestMethod.GET)
	public String showjobMenu(Principal principal) throws Exception{
		String viewName="";
		SecurityLoginDTO loginUser = 
				(SecurityLoginDTO)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
		viewName = loginUser.getMenupath();
		return viewName;
	}
	@RequestMapping("/admin/index.do")
	public String adminMain(){
		System.out.println("어노테이션 기반");
		return "admin/index";
	}
}
