package travel.search;

/**
 * 일정 정보들을 담을 DTO  
 * @author 이준희
 *
 */
public class SearchPlanDTO {
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
    private String cityy;
    private String cityx;

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

    public String getCityy() {
        return cityy;
    }

    public void setCityy(String cityy) {
        this.cityy = cityy;
    }

    public String getCityx() {
        return cityx;
    }

    public void setCityx(String cityx) {
        this.cityx = cityx;
    }
}
