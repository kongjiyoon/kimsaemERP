package ktds.kimsaem.erp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ktds.erp.board.BoardDTO;
import ktds.erp.board.BoardService;
import ktds.erp.emp.LoginDTO;

@Controller
public class IndexController{
	@Autowired
	BoardService service;
	@RequestMapping("/index.do")
	public ModelAndView main(){
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
	public String showjobMenu(HttpServletRequest req) throws Exception{
		String viewName = "";
		HttpSession ses = req.getSession(false);
		if(ses!=null) {
			System.out.println("기존 사용하던 세션");	
			LoginDTO user = (LoginDTO)ses.getAttribute("loginUser");
			if(user!=null) {
				System.out.println("로그인하고 작업중");	
				viewName = user.getMenupath();
			}
		}
		
		return viewName;
	}
	@RequestMapping("/admin/index.do")
	public String adminMain(){
		System.out.println("어노테이션 기반");
		return "admin/index";
	}
}
