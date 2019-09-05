package ktds.erp.emp.authentication;

public class GroupAuthroityDTO {
	private String groupid;
	private String authorityname;
	public GroupAuthroityDTO() {
		
	}
	public GroupAuthroityDTO(String groupid, String authorityname) {
		super();
		this.groupid = groupid;
		this.authorityname = authorityname;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getAuthorityname() {
		return authorityname;
	}
	public void setAuthorityname(String authorityname) {
		this.authorityname = authorityname;
	}

}
