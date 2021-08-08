package travel.community.suggest;

/**
 * @author 문지원
 * suggest 테이블의 정보를 저장하기 위한 DTO 클래스
 *
	private String suggestseq	suggestseq를 저장한다
	private String subject		subject를 저장한다
	private String content		content를 저장한다
	private String viewcnt		viewcnt를 저장한다
	private String recommcnt	recommcnt를 저장한다
	private int thread			thread를 저장한다
	private int depth			depth를 저장한다
	private String regdate		regdate를 저장한다
	private String id			id를 저장한다
	private String name			name를 저장한다
	private String isnew		isnew를 저장한다
	private String ccnt			ccnt를 저장한다

 */
public class BoardDTO {
		
		private String suggestseq;
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
		
		

		public String getSuggestseq() {
			return suggestseq;
		}
		public void setSuggestseq(String suggestseq) {
			this.suggestseq = suggestseq;
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
	