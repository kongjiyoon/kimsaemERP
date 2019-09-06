package ktds.erp.emp.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomAuthenticationProvider implements
						AuthenticationProvider{
	@Autowired
	UserDetailsService securityService;
	ShaPasswordEncoder ShaPasswordEncoder = 
			new ShaPasswordEncoder(256);
	@Override
	public Authentication authenticate(Authentication data) throws AuthenticationException {
		System.out.println("CustomAuthenticationProvider===>"+data);
		//사용자 정보 출력하기
		String id = data.getName();
		String pass = (String)data.getCredentials();
		Object principal = data.getPrincipal();
		
		System.out.println(id+","+pass+","+principal);
		
		//UserDetao;sService의 loadUserByUsername을 호출하여
		//DB에서 조회한 데이터와 인증할 수 있도록 한다.
		SecurityLoginDTO loginUser = 
				(SecurityLoginDTO)securityService.loadUserByUsername(id);
		System.out.println("provider==>"+loginUser);
		
		//db에서 조회한 데이터와 입력한 데이터를 비교
		boolean state = 
				ShaPasswordEncoder.isPasswordValid(loginUser.getPass(),
				pass, null);
		System.out.println("패스워드비교=>"+state);
		//인증결과를 리턴 - UsernamePasswordAuthenticationToken으로 리턴
		//principal은 인증된 사용자정보
		UsernamePasswordAuthenticationToken token = null;
		if(state) {
			token = new UsernamePasswordAuthenticationToken(
					loginUser,pass, loginUser.getAuthorities());
		}else {
			
		}
		return token;
	}
	//로그인 아이디와 패스워드를 이용해서 인증하려면
	//supports가 true여야 한다.
	//supports -> authenticate순으로 실행되며
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
