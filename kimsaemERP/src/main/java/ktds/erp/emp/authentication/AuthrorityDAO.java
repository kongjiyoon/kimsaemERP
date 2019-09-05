package ktds.erp.emp.authentication;

import java.util.List;

public interface AuthrorityDAO {
	//사용자별권한을 리턴하는 메소드
	List<MemberAuthoritysDTO> getAuthorityList(String id);
}
