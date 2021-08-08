package travel.community.suggest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import travel.DBUtil;

/**
 * @author 문지원
 * suggest 테이블의 DB작업을 위한 클래스

	BoardDAO		DB연결을 위한 생성자 
	int add(BoardDTO dto)		dto정보를 tblSuggestBoard에 insert한다.
	 ArrayList<BoardDTO> list( HashMap<String, String> map)		map에 저장된 정보로 vwsuggestBoard 테이블에 where 절 조건으로 저장하고, 쿼리를 실행 후에 글 번호 cnt를 반환한다.
	BoardDTO get(String suggestseq)		tblsuggestBoard에서 suggestseq에 해당하는 글 내용을 BoardDTO에 저장한 뒤에 반환한다.
	int del(String suggestseq)		tblsuggestBoard에서 suggestseq에 해당하는 글을 delete하고 작업 결과를 반환한다.
	void updateReadCount(String suggestseq)		tblsuggestBoard에서 suggestseq에 해당하는 글의 조회수를 1 증가시킨다. 
	int edit(BoardDTO dto)		BoardDTO에 저장된 정보로 tblsuggestBoard를 update한다
	ArrayList<CommentDTO> listcomment(String suggestseq)		tblsuggestComment에 suggestseq를 서브쿼리를 이용하여 댓글 목록을 CommentDTO에 담고, ArrayList에 add하여 반환
	int delComment(String suggestcommentseq)		tblsuggestcomment에서 suggestcommentseq에 해당하는 댓글을 delete하고 결과값을 반환한다.
	void delAllComment(String suggestseq)		tblsuggestcomment에서 suggestseq가 seq인 모든 댓글을 delete한다.
	int getMaxThread()		tblsuggestBoard의 max(thread) 값을 반환한다.
	void updateThread(int parentThread, int previousThread)		tblsuggestBoard의 parentThread와 previousThread 사이에 있는 thread 값을 update한다. 
	int getTotalCount(HashMap<String, String> map)		map에 저장된 정보로 vwsuggestBoard에 wherer절의 조건으로 저장하고, 쿼리를 실행 후 글번호를 반환한다.  
	int updateRecommcnt(String suggestseq)		tblsuggestBoard의 테이블에 suggestseq를 조건으로 추천수를 1증가시키고 결과값을 반환한다.
 */


/**
 * @author 문지원
 *
 */
public class BoardDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BoardDAO() {
		try {
            conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	//게시글 추가 메소드
	/**
	 * dto정보를 tblSuggestBoard에 insert한다.
	 * @param dto
	 * @return insert의 결과값을 반환한다
	 */
	public int add(BoardDTO dto) {
		try {
			String sql = "insert into tblsuggestBoard (suggestseq , subject, content, viewcnt, recommcnt, thread, depth, regdate, id ) "
					+ "values (seqsuggestBoard.nextval, ?,?,default,default,?,?,default,?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setInt(3, dto.getThread());
			pstat.setInt(4, dto.getDepth());

			pstat.setString(5, dto.getId());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	/**
	 * map에 저장된 정보로 vwsuggestBoard 테이블에 where 절 조건으로 저장하고, 
	 * 쿼리를 실행 후에 글 번호 cnt를 반환한다.
	 * @param map
	 * @return 글 번호 반환
	 */
	public ArrayList<BoardDTO> list( HashMap<String, String> map) {
		try {

			String where = "";
			if (map.get("isSearch").equals("y")) {

				if (map.get("column").equals("all")) {
					where = String.format(" and subject like '%%%s%%' or content like '%%%s%%' ", map.get("column"),
							map.get("search"));
				} else {
					where = String.format(" and %s like '%%%s%%' ", map.get("column"), map.get("search"));
				}
			}

			String sql = String.format("select * from vwsuggestBoard where rnum between %s and %s %s order by thread desc", 
					map.get("begin"), map.get("end"), where);

			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();

			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setSuggestseq(rs.getString("suggestseq"));
				dto.setName(rs.getString("name")); // 작성자
				dto.setSubject(rs.getString("subject")); // 제목
				dto.setViewcnt(rs.getString("viewcnt")); // 조회수
				dto.setRecommcnt(rs.getString("recommcnt")); // 추천수
				dto.setRegdate(rs.getString("regdate")); // 작성일
				dto.setIsnew(rs.getString("isnew")); // 글쓰고 난 뒤 시간이 얼마나 지났는지
				dto.setCcnt(rs.getString("ccnt")); // 현재 댓글에 달린 갯수

				dto.setThread(rs.getInt("thread"));
				dto.setDepth(rs.getInt("depth"));

				list.add(dto);

			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	
	/**
	 * tblsuggestBoard에서 suggestseq에 해당하는 글 내용을 BoardDTO에 저장한 뒤에 반환한다.
	 * @param suggestseq
	 * @return 글 번호에 해당하는 정보를 BoardDTO로 반환한다.
	 */
	public BoardDTO get(String suggestseq) {
		try {

			String sql = "select q.*,(select name from tblmember where id = q.id) as name from tblsuggestBoard q where suggestseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, suggestseq);

			rs = pstat.executeQuery();

			if (rs.next()) {
				BoardDTO dto = new BoardDTO();

				dto.setSuggestseq(rs.getString("suggestseq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setViewcnt(rs.getString("viewcnt"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setRecommcnt(rs.getString("recommcnt"));
				dto.setThread(rs.getInt("thread"));
				dto.setDepth(rs.getInt("depth"));

				return dto;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	/**
	 * tblsuggestBoard에서 suggestseq에 해당하는 글 내용을 BoardDTO에 저장한 뒤에 반환한다.
	 * @param suggestseq
	 * @return delete의 결과값을 반환한다
	 */
	public int del(String suggestseq) {

		try {
			String sql = "delete from tblsuggestBoard where suggestseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, suggestseq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	
	/**
	 * tblsuggestBoard에서 suggestseq에 해당하는 글의 조회수를 1 증가시킨다. 
	 * @param suggestseq
	 */
	public void updateReadCount(String suggestseq) {
		try {

			String sql = "update tblsuggestBoard set viewcnt = viewcnt + 1 where suggestseq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, suggestseq);

			pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	
	/**
	 * BoardDTO에 저장된 정보로 tblsuggestBoard를 update한다
	 * @param dto
	 * @return update의 결과값을 반환한다.
	 */
	public int edit(BoardDTO dto) {
		try {
			String sql = "update tblsuggestBoard set subject =?, content = ? where suggestseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSuggestseq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	
	/**
	 * tblsuggestComment에 suggestseq를 서브쿼리를 이용하여 댓글 목록을 CommentDTO에 담고, 
	 * ArrayList에 add하여 반환
	 * @param suggestseq
	 * @return clist를 반환한다.
	 */
	public ArrayList<CommentDTO> listcomment(String suggestseq) {
		try {
			String sql = "select c.*,(select name from tblMember where id=c.id) as name "
					+ "from tblsuggestComment c where suggestseq = ? order by suggestcommentseq desc";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, suggestseq);

			rs = pstat.executeQuery();

			ArrayList<CommentDTO> clist = new ArrayList<CommentDTO>();

			while (rs.next()) {
				// 레코드 1줄 -> DTO
				CommentDTO dto = new CommentDTO();

				dto.setSuggestCommentSeq(rs.getString("suggestcommentseq"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setSuggestSeq(rs.getString("suggestseq"));
				dto.setName(rs.getString("name"));

				clist.add(dto);

			}

			return clist;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}


	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public int addComment(CommentDTO dto) {

		try {
			String sql = "insert into tblsuggestcomment (suggestcommentseq, regdate, content, suggestseq, id) "
					+ "values (seqsuggestcomment.nextval, default, ?, ?,?)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getContent());
			pstat.setString(2, dto.getSuggestSeq());
			pstat.setString(3, dto.getId());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	/**
	 * tblsuggestcomment에서 suggestcommentseq에 해당하는 댓글을 delete하고 결과값을 반환한다.
	 * @param suggestcommentseq
	 * @return delete의 결과값을 반환한다.
	 */
	public int delComment(String suggestcommentseq) {
		try {
			String sql = "delete from tblsuggestcomment where suggestcommentseq =?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, suggestcommentseq);

			return pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return 0;
	}


	
	/**
	 * tblsuggestcomment에서 suggestseq가 seq인 모든 댓글을 delete한다.
	 * @param suggestseq
	 */
	public void delAllComment(String suggestseq) {
		try {
			String sql = "delete from tblsuggestcomment where suggestseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, suggestseq);

			pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * tblsuggestBoard의 max(thread) 값을 반환한다.
	 * @return select nvl(max(thread), 0) + 1000 의 값을 반환한다.
	 */
	public int getMaxThread() {

		try {

			String sql = "select nvl(max(thread),0) + 1000 as thread from tblsuggestBoard";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			if (rs.next()) {
				return rs.getInt("thread");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * tblsuggestBoard의 parentThread와 previousThread 사이에 있는 thread 값을 update한다. 
     * @param parentThread 답변글의 부모 글의 thread
     * @param previousThread 이전 새글의 thread
	 */
	public void updateThread(int parentThread, int previousThread) {
		try {

			String sql = "update tblsuggestBoard set thread = thread -1 where thread > ? and thread < ?";
			pstat = conn.prepareStatement(sql);

			pstat.setInt(1, previousThread);
			pstat.setInt(2, parentThread);

			pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

    /**
     * map의 isSearch, column, search 정보를 where절의 조건으로 걸고, 
     * tblSuggesrBoard에서 select count(*)의 값을 반환한다.
     * @param map isSearch, column, search 정보를 갖는 컬렉션이다.
     * @return select count(*)인 총 게시물의 갯수를 반환한다.
     */
	public int getTotalCount(HashMap<String, String> map) {
		try {
			String where = "";

			if (map.get("isSearch").equals("y")) {
				if (map.get("column").equals("all")) {
					where = String.format(" where subject like '%%%s%%' or content like '%%%s%%' ", map.get("column"),
							map.get("search"));
				} else {
					where = String.format(" where %s like '%%%s%%' ", map.get("column"), map.get("search"));
				}
				// sql 구문에 적용한다.
			}

			String sql = String.format("select count(*) as cnt from vwsuggestBoard %s", where);

			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

    /**
     * tblsuggestBoard의 테이블에 suggestseq를 조건으로 추천수를 1증가시키고 결과값을 반환한다.
     * @param suggestseq 
     */
	public int updateRecommcnt(String suggestseq) {
		
		try {

			String sql = "update tblsuggestBaord set recommcnt = recommcnt + 1 where suggestseq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, suggestseq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}