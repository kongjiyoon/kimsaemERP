package ktds.erp.emp.authentication;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//로그인 성공하면 spring security 내부에서
//AuthenticationSuccessHandler객체가 실행된다.
public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req,HttpServletResponse res, 
    							Authentication authdata)
			throws IOException, ServletException {
		//인증된 사용자의 정보를 추출
		SecurityLoginDTO dto = 
				(SecurityLoginDTO)authdata.getPrincipal();
		System.out.println("인증후=>"+dto);
		//권한리스트를 추출
		Collection<GrantedAuthority> authlist = dto.getAuthorities();
		Iterator<GrantedAuthority> authlist_it= authlist.iterator();
		String url="/kimsaemERP/index.do";
		//로그인한 사용자별로 사용자의 업무 메뉴를 보여주기 위해서
		//view파일의 정보를 수정해서 다시 셋팅
		if(dto!=null) {
			String menuPath = dto.getMenupath();
			System.out.println(menuPath);
			menuPath= 
				menuPath.substring(menuPath.indexOf("/")+1,menuPath.indexOf("_"));
			dto.setMenupath(menuPath);	
		}
		while(authlist_it.hasNext()) {
			GrantedAuthority authority= authlist_it.next();
			//설정되어 있는 권한 중 ROLE_ADMIN이 있다면
			if(authority.getAuthority().equals("admin") | 
						authority.getAuthority().equals("systemadmin")) {
				url="/kimsaemERP/admin/index.do";
			}
		}
		
		
		req.getSession().setAttribute("msg", "관리자페이지입니다.");
		res.sendRedirect(url);
	}
}