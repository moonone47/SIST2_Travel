package travel.management;

public class ManagementDTO {

	//---------일정 조회  tblPlan
	private String planseq;
	private String status;
	private String name; //일정 이름
	private String daystarttravel;
	private String dayendtravel;
	private String willshare;
	private String wish;
	private String theme; //일정 
	private String id; //member id
	private String cityseq;
	private String cityname;
	
	private String writernick;
	
		
	//----------------- 세부 일정 tblPlan2	
    private String address_name;   
    private String category_group_name;  
    private String place_name;
    private String place_url;
    private String road_address_name;
    private String x;
    private String y;
    private String seq;
    private String memberid;
    private String rdate; // 일정 날짜

	
	
	
	public String getAddress_name() {
		return address_name;
	}
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
	public String getCategory_group_name() {
		return category_group_name;
	}
	public void setCategory_group_name(String category_group_name) {
		this.category_group_name = category_group_name;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getPlace_url() {
		return place_url;
	}
	public void setPlace_url(String place_url) {
		this.place_url = place_url;
	}
	public String getRoad_address_name() {
		return road_address_name;
	}
	public void setRoad_address_name(String road_address_name) {
		this.road_address_name = road_address_name;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getWriternick() {
		return writernick;
	}
	public void setWriternick(String writernick) {
		this.writernick = writernick;
	}
	public String getPlanseq() {
		return planseq;
	}
	public void setPlanseq(String planseq) {
		this.planseq = planseq;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDaystarttravel() {
		return daystarttravel;
	}
	public void setDaystarttravel(String daystarttravel) {
		this.daystarttravel = daystarttravel;
	}
	public String getDayendtravel() {
		return dayendtravel;
	}
	public void setDayendtravel(String dayendtravel) {
		this.dayendtravel = dayendtravel;
	}
	public String getWillshare() {
		return willshare;
	}
	public void setWillshare(String willshare) {
		this.willshare = willshare;
	}
	public String getWish() {
		return wish;
	}
	public void setWish(String wish) {
		this.wish = wish;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCityseq() {
		return cityseq;
	}
	public void setCityseq(String cityseq) {
		this.cityseq = cityseq;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
}
