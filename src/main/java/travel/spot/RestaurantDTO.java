package travel.spot;

/**
 * tblRestaurant 데이터 저장 클래스
 * @author 김정은
 *
 *String restaurantSeq tblrestaurant 의 PK 
String name 음식점 이름 
String explain 음식점 설명
String address 음식점 주소
String image 음식점 이미지 url
String grade 음식점 평점 
String wish 찜
String theme 테마
String restaurantX x좌표
String restaurantY y좌표
String plandate 일정날짜
String budget 예산
String seq seq
String url url
String planseq 여행일정 seq
String id 멤버 id


 */
public class RestaurantDTO {
//    restaurantseq name explain address image grade wish theme restaurantx restauranty plandate budget seq url planseq id
    private String restaurantSeq;
    private String name;
    private String explain;
    private String address;
    private String image;
    private String grade;
    private String wish;
    private String theme;
    private String restaurantX;
    private String restaurantY;
    private String plandate;
    private String budget;
    private String seq;
    private String url;
    private String planseq;
    private String id;

    public String getRestaurantSeq() {
        return restaurantSeq;
    }

    public void setRestaurantSeq(String restaurantSeq) {
        this.restaurantSeq = restaurantSeq;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public String getRestaurantX() {
        return restaurantX;
    }

    public void setRestaurantX(String restaurantX) {
        this.restaurantX = restaurantX;
    }

    public String getRestaurantY() {
        return restaurantY;
    }

    public void setRestaurantY(String restaurantY) {
        this.restaurantY = restaurantY;
    }

    public String getPlandate() {
        return plandate;
    }

    public void setPlandate(String plandate) {
        this.plandate = plandate;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlanseq() {
        return planseq;
    }

    public void setPlanseq(String planseq) {
        this.planseq = planseq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}