package member.model.vo;

public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String addr;

	public MemberVO() {
	}

	public MemberVO(String id, String password, String name, String address) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.addr = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return addr;
	}

	public void setAddress(String address) {
		this.addr = address;
	}

	@Override
	public String toString() {
		return "MemberVO [아이디 =" + id + ", 비밀번호 =" + password + ", 이름 =" + name + ", 주소 =" + addr + "]";
	}

}
