package javaproject.portfolio.DTO;

public class Pmember {
	private int pmember_idx;
	private String id;
	private String pass;
	private String name;
	private int phone;
	private String email;
	private String regdate;
	
	public int getPmember_idx() {
		return pmember_idx;
	}
	public void setPmember_idx(int pmember_idx) {
		this.pmember_idx = pmember_idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
