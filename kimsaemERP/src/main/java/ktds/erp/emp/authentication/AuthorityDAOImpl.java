package ktds.erp.emp.authentication;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorityDAOImpl implements AuthorityDAO{

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<MemberAuthoritysDTO> getAuthorityList(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ktds.erp.emp.authoritylist",id);
	}
	
}
