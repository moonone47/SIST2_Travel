package travel.community.suggest;

/**
 * @author 문지원
 * 댓글 정보를 저장하기 위한 DTO 클래스
 
	private String suggestCommentSeq	suggestCommentSeq를 저장한다
	private String id					id를 저장한다
	private String content				content를 저장한다
	private String regdate				regdate를 저장한다
	private String suggestseq			suggestseq를 저장한다
	private String name					name를 저장한다
 
 */
public class CommentDTO {
	
	private String suggestCommentSeq;
	private String content;
	private String regdate;
	private String suggestSeq;
	private String id;
	private String name;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuggestCommentSeq() {
		return suggestCommentSeq;
	}
	public void setSuggestCommentSeq(String suggestCommentSeq) {
		this.suggestCommentSeq = suggestCommentSeq;
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
	public String getSuggestSeq() {
		return suggestSeq;
	}
	public void setSuggestSeq(String suggestSeq) {
		this.suggestSeq = suggestSeq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
