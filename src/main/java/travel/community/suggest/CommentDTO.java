package travel.community.suggest;

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
