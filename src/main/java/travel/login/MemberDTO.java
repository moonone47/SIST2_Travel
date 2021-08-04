package travel.login;

/**
 * 회원 정보 DTO
 * @author 이준희 
 *
 */

//ID       NOT NULL VARCHAR2(50)  
//PW       NOT NULL VARCHAR2(100) 
//NAME     NOT NULL VARCHAR2(50)  
//NICK     NOT NULL VARCHAR2(50)  
//EMAIL    NOT NULL VARCHAR2(200) 
//PHONE    NOT NULL VARCHAR2(50)  
//ZIP      NOT NULL VARCHAR2(50)  
//ADDRESS  NOT NULL VARCHAR2(500) 
//LV       NOT NULL NUMBER        
//BIRTHDAY NOT NULL DATE          
//GENDER   NOT NULL VARCHAR2(10)  
public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	private String nick;
	private String email;
	private String phone;
	private String zip;
	private String address;
	private String lv;
	private String birthday;
	private String gender;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLv() {
		return lv;
	}
	public void setLv(String lv) {
		this.lv = lv;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
