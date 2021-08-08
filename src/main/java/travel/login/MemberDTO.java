package travel.login;

/**
 * @author 문지원
 * 회원의 DTO 클래스 

	private String id		id를 저장한다.
	private String pw		pw를 저장한다.
	private String name		name를 저장한다.
	private String nick		nick를 저장한다.
	private String email	email를 저장한다.
	private String phone	phone를 저장한다.
	private String zip		zip를 저장한다.
	private String address	address를 저장한다.
	private String lv		lv를 저장한다.
	private String birthday	birthday를 저장한다.
	private String gender	gender를 저장한다.

 */

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
