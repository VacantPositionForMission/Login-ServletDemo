package Servlet;

public class User {

	private int id;//���
	private String account;//�ֻ�����
	private String name;//�ǳ�
	private String password;//����
	private String sex;//�Ա�
	private String birth;//����
	
	public User(){
		
	}
	
	public String Setuser(){
	
		return "id:"+id+",�˻���"+account+",�ǳƣ�"+name+",���룺"+password+",�Ա�"+sex+",���գ�"+birth;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	
}
