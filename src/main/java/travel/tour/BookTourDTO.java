package travel.tour;
/**
 * tblBookTour 데이터 저장 클래스
 * @author 김정은
 *
 */
public class BookTourDTO {
    private String seq;
    private String id;
    private String name;
    private String regdate;
    private String personnel;
    private String contact;
    private String email;
    private String moredetail;
    private String tourseq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getPersonnel() {
        return personnel;
    }

    public void setPersonnel(String personnel) {
        this.personnel = personnel;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMoredetail() {
        return moredetail;
    }

    public void setMoredetail(String moredetail) {
        this.moredetail = moredetail;
    }

    public String getTourseq() {
        return tourseq;
    }

    public void setTourseq(String tourseq) {
        this.tourseq = tourseq;
    }
}
