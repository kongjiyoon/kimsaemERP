package ktds.erp.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import ktds.erp.emp.MemberDTO;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDAO dao;
	private ShaPasswordEncoder passencoder =new ShaPasswordEncoder(256);
	@Override
	public List<MemberDTO> getMemberList() {
		return dao.getMemberList();
	}
	@Override
	public int passwordChange(String[] id) {
		//1. 배열에 들어있는 모든 아이디를 ArrayList에 add하세요.
		ArrayList<String> idlist = new ArrayList<String>();
		for (int i = 0; i < id.length; i++) {
			idlist.add(id[i]);
		}
		//2. id가 add된 ArrayList를 이용해서 id에 해당하는 모든 데이터를 
		//   ArrayList<MemberDTO>의 값으로 조회할 수 있도록 dao의
		//   getCheckList메소드를 호출하세요.
		ArrayList<MemberDTO> userlist = (ArrayList<MemberDTO>) dao.getCheckList(idlist);
		
		//3. 받아온 아이디의 password를 읽어서 암호화시킨 값을 update할 수 있도록 dao이 update를 호출하세요
		int size = userlist.size();
		for (int i = 0; i < size; i++) {
			String securityPass = passencoder.encodePassword(userlist.get(i).getPass(), null);
			//System.out.println(securityPass);
			userlist.get(i).setPass(securityPass);
		}
		int result = dao.update(userlist);
		
		return result;
	}

}
