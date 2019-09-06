package ktds.erp.emp;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class EmpDAOImpl implements EmpDAO {
	@Autowired
	SqlSession sqlSession;
	@Override
	public ArrayList<MemberDTO> getTreeEmpList(String deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MemberDTO user) {
		return sqlSession.update("ktds.erp.emp.insert", user);
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
		return sqlSession.selectOne("ktds.erp.emp.login", loginUser) ;
	}

	@Override
	public boolean idCheck(String id) {
		boolean result = false;
		MemberDTO user=  sqlSession.selectOne("ktds.erp.emp.idcheck",id);
		if(user!=null) {
			result = true;
		}
		return result;
	}

	@Override
	public LoginDTO findbyId(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ktds.erp.emp.securityLogin",id);
	}

}
