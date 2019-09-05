package ktds.erp.emp.authentication;

public class MemberAuthoritysDTO {
	private String id;
	private String authorityid;
	public MemberAuthoritysDTO() {
		
	}
	public MemberAuthoritysDTO(String id, String authorityid) {
		super();
		this.id = id;
		this.authorityid = authorityid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthorityid() {
		return authorityid;
	}
	public void setAuthorityid(String authorityid) {
		this.authorityid = authorityid;
	}
	
	
}
