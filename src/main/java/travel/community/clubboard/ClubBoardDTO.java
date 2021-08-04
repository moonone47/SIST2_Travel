package travel.community.clubboard;
public class ClubBoardDTO {

	private String travelclubseq;
	private String id;
	private String subject;
	private String content;
	private String regdate;
	private String tag;
	private String viewcnt;
	private String recommcnt;

	
	private String name; //추가 멤버
	private String isnew; //새글 표시
	private String ccnt; //댓글 개수
	
	private int thread;
	private int depth;
	
	
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
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getViewCnt() {
		return viewcnt;
	}
	public void setViewCnt(String viewCnt) {
		this.viewcnt = viewCnt;
	}
	public String getRecommCnt() {
		return recommcnt;
	}
	public void setRecommCnt(String recommCnt) {
		this.recommcnt = recommCnt;
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
	public String getSeq() {
		return travelclubseq;
	}
	public void setSeq(String travelclubseq) {
		this.travelclubseq = travelclubseq;
	}
	
	
	
	
}
