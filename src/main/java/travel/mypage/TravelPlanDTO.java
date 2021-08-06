package travel.mypage;

/**
 * travelPlan의 정보를 저장하기 위한 DTO 클래스
 * String planseq;	planseq를 저장한다.
 * String status	status 를 저장한다.
 * String name	name 을 저장한다.
 * String daystarttravel	daystarttravel을 저장한다.
 * String dayendtravel	dayendtravel을 저장한다.
 * String willshare	willshare 를 저장한다.
 * String wish	wish 를 저장한다.
 * String theme	theme 를 저장한다.
 * String id	id 를 저장한다.
 * String cityseq	cityseq 를 저장한다.
 * String cityname	cityname 을 저장한다.
 * String writernick	writernick 을 저장한다.
 */
public class TravelPlanDTO {

	private String planseq;
	private String status;
	private String name;
	private String daystarttravel;
	private String dayendtravel;
	private String willshare;
	private String wish;
	private String theme;
	private String id;
	private String cityseq;
	private String cityname;
	
	private String writernick;
	
	
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
