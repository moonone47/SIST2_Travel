package travel.tour;

public class TourDTO {
    //    TOURSEQ   NUMBER         not null
//    NAME      VARCHAR2(100)  not null,
//    DETAIL    VARCHAR2(4000) not null,
//    USE       VARCHAR2(300)  not null,
//    VALIDDATE DATE           not null,
//    TOURPRICE NUMBER         not null,
//    IMG       VARCHAR2(1000)
    private String tourseq;
    private String name;
    private String detail;
    private String use;
    private String validdate;
    private String tourprice;
    private String img;

    public String getTourseq() {
        return tourseq;
    }

    public void setTourseq(String tourseq) {
        this.tourseq = tourseq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
