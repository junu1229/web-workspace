package grade;

public class ManagerVO {
	private int managerNumber;
	private String namagerName;
	private String managerHireDate;
	public ManagerVO() {
		// TODO Auto-generated constructor stub
	}
	public ManagerVO(int managerNumber, String namagerName, String managerHireDate) {
		this.managerNumber = managerNumber;
		this.namagerName = namagerName;
		this.managerHireDate = managerHireDate;
	}
	public int getManagerNumber() {
		return managerNumber;
	}
	public void setManagerNumber(int managerNumber) {
		this.managerNumber = managerNumber;
	}
	public String getNamagerName() {
		return namagerName;
	}
	public void setNamagerName(String namagerName) {
		this.namagerName = namagerName;
	}
	public String getManagerHireDate() {
		return managerHireDate;
	}
	public void setManagerHireDate(String managerHireDate) {
		this.managerHireDate = managerHireDate;
	}
	
}
