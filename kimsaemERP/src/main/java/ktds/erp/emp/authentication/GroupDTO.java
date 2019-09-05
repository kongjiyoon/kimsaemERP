package ktds.erp.emp.authentication;
//그룹테이블의 값을 모델링한 dto로 job테이블
public class GroupDTO {
	private String job_id;
	private String job_name;
	private String job_category;
	private String menupath;
	public GroupDTO() {
		
	}
	public GroupDTO(String job_id, String job_name, String job_category, String menupath) {
		super();
		this.job_id = job_id;
		this.job_name = job_name;
		this.job_category = job_category;
		this.menupath = menupath;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_category() {
		return job_category;
	}
	public void setJob_category(String job_category) {
		this.job_category = job_category;
	}
	public String getMenupath() {
		return menupath;
	}
	public void setMenupath(String menupath) {
		this.menupath = menupath;
	}
	@Override
	public String toString() {
		return "GroupDTO [job_id=" + job_id + ", job_name=" + job_name + ", job_category=" + job_category
				+ ", menupath=" + menupath + "]";
	}
	
}
