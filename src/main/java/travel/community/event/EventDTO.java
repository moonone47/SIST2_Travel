package travel.community.event;

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
    private String thread;
    private String depth;

    private String nick;
    private String isnew;
    private String ccnt;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }
}
