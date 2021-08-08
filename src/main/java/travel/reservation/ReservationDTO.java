package travel.reservation;

/**
 * 예약내역에 필요한 매개변수들을 담을 DTO
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
	private String ispay;
	private String img;
	
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
	public String getIspay() {
		return ispay;
	}
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	} 
	
	
}
