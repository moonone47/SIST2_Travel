package travel.community.question;

/**
 * 질문 게시판 DTO
 * @author 이준희
 *
 */


public class BoardDTO {
	private String questionseq;
	private String subject;
	private String content;
	private String viewcnt;
	private String recommcnt;
	private int thread;
	private int depth;
	private String regdate;
	private String id;
	private String name; //view를 위한 추가멤버 
	private String isnew;
	private String ccnt;
	
	
	public String getQuestionseq() {
		return questionseq;
	}
	public void setQuestionseq(String questionseq) {
		this.questionseq = questionseq;
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
	public String getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(String viewcnt) {
		this.viewcnt = viewcnt;
	}
	public String getRecommcnt() {
		return recommcnt;
	}
	public void setRecommcnt(String recommcnt) {
		this.recommcnt = recommcnt;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
