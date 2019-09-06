package ktds.erp.emp.authentication;

public class AuthorityDTO {
	private String authorityid;
	private String authorityname;
	public AuthorityDTO() {
		
	}
	public AuthorityDTO(String authorityid, String authorityname) {
		super();
		this.authorityid = authorityid;
		this.authorityname = authorityname;
	}
	public String getAuthorityid() {
		return authorityid;
	}
	public void setAuthorityid(String authorityid) {
		this.authorityid = authorityid;
	}
	public String getAuthorityname() {
		return authorityname;
	}
	public void setAuthorityname(String authorityname) {
		this.authorityname = authorityname;
	}
	
}
