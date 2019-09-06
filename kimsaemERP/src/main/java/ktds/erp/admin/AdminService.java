package ktds.erp.admin;

import java.util.List;

import ktds.erp.emp.MemberDTO;

public interface AdminService {
	List<MemberDTO> getMemberList();
	int passwordChange(String[] id);	
}
