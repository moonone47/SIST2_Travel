package travel.plan;

public class PlanInfoDTO {
    //				PLANSEQ        NUMBER           not null primary key,
//				STATUS         VARCHAR2(50)     not null
//				NAME           VARCHAR2(200)    not null,
//				DAYSTARTTRAVEL DATE             not null,
//				DAYENDTRAVEL   DATE             not null,
//				WILLSHARE      VARCHAR2(20)     not null
//				WISH           NUMBER default 0 not null,
//				THEME          VARCHAR2(200),
//				ID             VARCHAR2(50)     not null
//				CITYSEQ        NUMBER
    private String planseq;
    private String name;
    private String daystarttravel;
    private String dayendtravel;
    private String willshare;
    private String wish;
    private String theme;
    private String id;
    private String cityseq;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlanseq() {
        return planseq;
    }

    public void setPlanseq(String planseq) {
        this.planseq = planseq;
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
}
