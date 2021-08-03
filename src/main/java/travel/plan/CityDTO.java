package travel.plan;


//create table TBLCITY
//        (
//        CITYSEQ NUMBER         not null
//        primary key,
//        NAME    VARCHAR2(50)   not null,
//        EXPLAIN VARCHAR2(4000) not null,
//        CITYY   NUMBER         not null,
//        CITYX   NUMBER         not null
//        )
public class CityDTO {
    private String cityseq;
    private String name;
    private String explain;
    private String cityX;
    private String cityY ;
	private String days;

	public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
	
	
    public String getCityseq() {return cityseq;}

    public void setCityseq(String cityseq) {
        this.cityseq = cityseq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getCityX() {
        return cityX;
    }

    public void setCityX(String cityX) {
        this.cityX = cityX;
    }

    public String getCityY() {
        return cityY;
    }

    public void setCityY(String cityY) {
        this.cityY = cityY;
    }
}
