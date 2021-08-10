package travel.community.freeboard;
/**
 * tblFreeBoardComment 데이터 저장 클래스
 * @author 김정은
 *String freecommentseq 댓글seq를 저장하는 변수
String regdate 등록날짜를 저장하는 변수
String content 댓글 내용을 저장하는 변수
freeboardseq 게시글 seq를 저장하는 변수
String id 작성자id를 저장하는 변수
String nick 작성자 닉네임을 저장하는 변수
String isnew 최신 여부를 저장하는 변수


 */
public class FreeBoardCommentDTO {

	private String freecommentseq;
	private String regdate;
	private String content;
	private String freeboardseq;
	private String id;
	private String nick;
	private String isnew;
	
	
	public String getFreecommentseq() {
		return freecommentseq;
	}
	public void setFreecommentseq(String freecommentseq) {
		this.freecommentseq = freecommentseq;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFreeboardseq() {
		return freeboardseq;
	}
	public void setFreeboardseq(String freeboardseq) {
		this.freeboardseq = freeboardseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	
	
}
