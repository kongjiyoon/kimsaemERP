package ktds.erp.admin;

import java.util.ArrayList;
import java.util.List;

import ktds.erp.emp.MemberDTO;

public interface AdminDAO {
	List<MemberDTO> getMemberList();
	List<MemberDTO> getCheckList(ArrayList<String> idlist);
	int update(List<MemberDTO> userlist);
}
