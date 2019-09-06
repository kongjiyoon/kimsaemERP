package ktds.erp.emp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ktds.erp.board.FileUploadLogic;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpDAO dao;
	@Autowired
	FileUploadLogic upload;
	ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder(256);
	@Override
	public ArrayList<MemberDTO> getTreeEmpList(String deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MemberDTO user,MultipartFile file,String realpath,String filename) {
		
		String securityPass = shaPasswordEncoder.encodePassword(user.getPass(), null);
		System.out.println(securityPass);
		user.setPass(securityPass);
		upload.upload(file, realpath, filename);
		return dao.insert(user);
	}

	@Override
	public boolean idCheck(String id) {
		// TODO Auto-generated method stub
		return dao.idCheck(id);
	}

	@Override
	public ArrayList<MemberDTO> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDTO read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MemberDTO> search(String column, String search, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(MemberDTO user) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public LoginDTO login(MemberDTO loginUser) {
		LoginDTO user = dao.login(loginUser);
		System.out.println("service:"+user);
		if(user!=null) {
			String menuPath = user.getMenupath();
			System.out.println(menuPath);
			menuPath= 
				menuPath.substring(menuPath.indexOf("/")+1,menuPath.indexOf("_"));
			user.setMenupath(menuPath);	
		}
		return user;
	}	
}
