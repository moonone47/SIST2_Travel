package travel.service;

/*
 * 서비스 DTO 
 * tblService 속성들 
 * @author 이준희
 * */
public class ServiceDTO {
	
	private String serviceseq; 
	private String travelspot;
	private String daystarttravel;
	private String dayendtravel;
	private String purpose;
	private String numberpeople;
	private String id;
	private String name;
	
	public String getServiceseq() {
		return serviceseq;
	}
	public void setServiceseq(String serviceseq) {
		this.serviceseq = serviceseq;
	}
	public String getTravelspot() {
		return travelspot;
	}
	public void setTravelspot(String travelspot) {
		this.travelspot = travelspot;
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
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getNumberpeople() {
		return numberpeople;
	}
	public void setNumberpeople(String numberpeople) {
		this.numberpeople = numberpeople;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
