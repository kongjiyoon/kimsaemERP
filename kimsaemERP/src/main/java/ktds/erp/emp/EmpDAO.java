package ktds.erp.emp;

import java.util.ArrayList;

public interface EmpDAO {
	ArrayList<MemberDTO> getTreeEmpList(String deptno);
	int insert(MemberDTO user);
	ArrayList<MemberDTO> getMemberList();
	int delete(String id);
	MemberDTO read(String id);
	ArrayList<MemberDTO> search(String column, String search,String pass);
	int update(MemberDTO user);
	LoginDTO login(MemberDTO loginUser);
	boolean idCheck(String id);
	LoginDTO findbyId(String id);
}














