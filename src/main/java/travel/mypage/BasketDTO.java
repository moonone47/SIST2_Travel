package travel.mypage;

/**
 * 장바구니 정보를 저장하기 위한 BasketDTO 클래스
 * private String basketseq;	tblBasket을 식별하기 위한 Primary Key이다.
 * private String id;	사용자의 id를 저장한다.
 * private String tourseq;	Foreign key를 저장한다.
 * private String validdate;	유효기간을 저장한다.
 * private String membername	회원의 이름을 저장한다.
 * private String tourname	투어의 이름을 저장한다.
 * private String use	사용처의 이름을 저장한다.
 * private String tourprice	투어의 가격을 저장한다.
 * private String ispay	결제 여부를 저장한다.
 * private String img	투어 이미지의 주소를 저장한다.
 * private String detail	투어의 상세 설명을 저장한다.
 */
public class BasketDTO {

	private String basketseq;
	private String id;
	private String tourseq;
	private String validdate;
	private String membername;
	private String tourname;
	private String use;
	private String tourprice;
	private String ispay;
	private String img;
	private String detail;
	
	public String getBasketseq() {
		return basketseq;
	}
	public void setBasketseq(String basketseq) {
		this.basketseq = basketseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTourseq() {
		return tourseq;
	}
	public void setTourseq(String tourseq) {
		this.tourseq = tourseq;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getTourname() {
		return tourname;
	}
	public void setTourname(String tourname) {
		this.tourname = tourname;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getTourprice() {
		return tourprice;
	}
	public void setTourprice(String tourprice) {
		this.tourprice = tourprice;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getValiddate() {
		return validdate;
	}
	public void setValiddate(String validdate) {
		this.validdate = validdate;
	}
	
	
	
	


	
	
}
