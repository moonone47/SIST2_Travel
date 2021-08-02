package travel.reservation;

//RESERVATIONSEQ NOT NULL NUMBER        
//ISCANCEL       NOT NULL VARCHAR2(50)  
//TOURSEQ        NOT NULL NUMBER        
//TOURNAME       NOT NULL VARCHAR2(100) 
//MEMBERNAME              VARCHAR2(50)  
//USE            NOT NULL VARCHAR2(300) 
//VALIDDATE      NOT NULL DATE          
//TOURPRICE      NOT NULL NUMBER        
/**
 * 예약내역 DTO
 * @author 이준희
 *
 */

public class ReservationDTO {

	private String reservationseq;
	private String iscancel;
	private String tourseq;
	private String tourname;
	private String membername;
	private String use;
	private String validdate;
	private String tourprice;
	private String id;
	private String detail;
	
	public String getReservationseq() {
		return reservationseq;
	}
	public void setReservationseq(String reservationseq) {
		this.reservationseq = reservationseq;
	}
	public String getIscancel() {
		return iscancel;
	}
	public void setIscancel(String iscancel) {
		this.iscancel = iscancel;
	}
	public String getTourseq() {
		return tourseq;
	}
	public void setTourseq(String tourseq) {
		this.tourseq = tourseq;
	}
	public String getTourname() {
		return tourname;
	}
	public void setTourname(String tourname) {
		this.tourname = tourname;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getValiddate() {
		return validdate;
	}
	public void setValiddate(String validdate) {
		this.validdate = validdate;
	}
	public String getTourprice() {
		return tourprice;
	}
	public void setTourprice(String tourprice) {
		this.tourprice = tourprice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	} 
	
	
}
