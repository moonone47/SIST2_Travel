package travel.community.event;

/**
 * Comment 정보를 저장하기 위한 DTO 클래스 멤버 변수들과 getter setter로 구성되어있다.
 * String seq	seq를 저장한다.
 * String id	id 를 저장한다.
 * String content	content 를 저장한다.
 * String regdate	regdate 를 저장한다.
 * String pseq	pseq(부모의 글번호) 를 저장한다.
 * String name	name 을 저장한다.
 */
public class CommentDTO {
    private String seq;
    private String id;
    private String content;
    private String regdate;
    private String pseq;
    private String name;

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

    public String getPseq() {
        return pseq;
    }

    public void setPseq(String pseq) {
        this.pseq = pseq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
