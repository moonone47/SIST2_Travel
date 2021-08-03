package travel.mypage;

public class BasketDTO {

	private String basketseq;
	private String id;
	private String tourseq;
	private String name;
	private String validDate;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
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
	
	
}
