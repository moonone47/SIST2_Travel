package travel.community.event;

/**
 * Event table의 정보를 저장하기 위한 DTO 클래스
 * String seq	seq를 저장한다.
 * String id	id 를 저장한다.
 * String subject	subject 를 저장한다.
 * String content	content 를 저장한다.
 * String regdate	regdate 를 저장한다.
 * String readcount	readcount 를 저장한다.
 * String recommCnt	recommCnt 를 저장한다.
 * String startDate	startDate 를 저장한다.
 * String endDate	endDate 를 저장한다.
 * String announceDate	announceDate 를 저장한다.
 * int thread	thread 를 저장한다.
 * int depth	depth 를 저장한다.
 * String name	name 을 저장한다.
 * String isnew	isnew 를 저장한다.
 * String ccnt	ccnt 를 저장한다.
 */
public class EventDTO {
    private String seq;
    private String id;
    private String subject;
    private String content;
    private String regdate;
    private String readcount;
    private String recommCnt;
    private String startDate;
    private String endDate;
    private String announceDate;
    private int thread;
    private int depth;

    private String name;
    private String isnew;
    private String ccnt;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getReadcount() {
        return readcount;
    }

    public void setReadcount(String readcount) {
        this.readcount = readcount;
    }

    public String getRecommCnt() {
        return recommCnt;
    }

    public void setRecommCnt(String recommCnt) {
        this.recommCnt = recommCnt;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAnnounceDate() {
        return announceDate;
    }

    public void setAnnounceDate(String announceDate) {
        this.announceDate = announceDate;
    }

    public int getThread() {
        return thread;
    }

    public void setThread(int thread) {
        this.thread = thread;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsnew() {
        return isnew;
    }

    public void setIsnew(String isnew) {
        this.isnew = isnew;
    }

    public String getCcnt() {
        return ccnt;
    }

    public void setCcnt(String ccnt) {
        this.ccnt = ccnt;
    }
}
