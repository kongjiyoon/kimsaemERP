package ktds.erp.emp.authentication;

public class MemberAuthoritysDTO {
	private String id;
	private String authorityname;
	public MemberAuthoritysDTO() {
		super();
	}
	public MemberAuthoritysDTO(String id, String authorityname) {
		super();
		this.id = id;
		this.authorityname = authorityname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthorityname() {
		return authorityname;
	}
	public void setAuthorityname(String authorityname) {
		this.authorityname = authorityname;
	}
	@Override
	public String toString() {
		return "MemberAuthoritysDTO [id=" + id + ", authorityname=" + authorityname + "]";
	}
	
}
