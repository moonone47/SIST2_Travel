package travel.community.question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import travel.DBUtil;

/**
 * 질문게시판 DAO
 * 
 * @author 이준희
 *
 */

public class BoardDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BoardDAO() {
		try {
			conn = DBUtil.open("183.100.233.88", "sist2_travel", "java1234");
//            conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 질문게시판 게시글 추가 메소드
	 * 
	 * @param dto
	 * @return DB insert 성공 1, 실패 0
	 */

	public int add(BoardDTO dto) {
		try {
			String sql = "insert into tblquestion (questionseq , subject, content, viewcnt, recommcnt, thread, depth, regdate, id ) values (seqquestion.nextval, ?,?,default,default,?,?,default,?)";

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
	 * 질문게시판 게시글 리스트 메소드
	 * 
	 * @return list
	 */

	public ArrayList<BoardDTO> list(HashMap<String, String> map) {
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

			String sql = String.format("select * from vwquestion where rnum between %s and %s %s order by thread desc", map.get("begin"), map.get("end"), where);

			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();

			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();

				dto.setQuestionseq(rs.getString("questionseq"));
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
	 * 질문게시판 게시글 뷰 메소드
	 * 
	 * @param questionseq 게시글 번호
	 * @return dto
	 */

	public BoardDTO get(String questionseq) {
		try {

			String sql = "select q.*,(select name from tblmember where id = q.id) as name from tblquestion q where questionseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, questionseq);

			rs = pstat.executeQuery();

			if (rs.next()) {
				BoardDTO dto = new BoardDTO();

				dto.setQuestionseq(rs.getString("questionseq"));
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
	 * 질문게시판 게시글 삭제 메소드
	 * 
	 * @param questionseq 게시글 번호
	 * @return result 1, 0
	 */
	public int del(String questionseq) {

		try {
			String sql = "delete from tblQuestion where questionseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, questionseq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 질문게시판 게시글 조회수 증가 메소드
	 * 
	 * @param questionseq 게시글 번호
	 * @return result 1, 0
	 */
	public void updateReadCount(String questionseq) {
		try {

			String sql = "update tblquestion set viewcnt = viewcnt + 1 where questionseq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, questionseq);

			pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 질문게시판 게시글 수정 증가 메소드
	 * 
	 * @param dto (게시글 번호, 제목, 내용)
	 * @return result 1, 0
	 */
	public int edit(BoardDTO dto) {
		try {
			String sql = "update tblquestion set subject =?, content = ? where questionseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getQuestionseq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 질문게시판 게시글에 달린 댓글 리스트 메소드
	 * 
	 * @param 게시글 번호
	 * @return clist
	 */
	public ArrayList<CommentDTO> listcomment(String questionseq) {
		try {
			String sql = "select c.*,(select name from tblMember where id=c.id) as name from tblquestionComment c where questionseq = ? order by questioncommentseq desc";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, questionseq);

			rs = pstat.executeQuery();

			ArrayList<CommentDTO> clist = new ArrayList<CommentDTO>();

			while (rs.next()) {
				// 레코드 1줄 -> DTO
				CommentDTO dto = new CommentDTO();

				dto.setQuestioncommentseq(rs.getString("questioncommentseq"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setQuestionseq(rs.getString("questionseq"));
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
	 * 질문게시판 게시글에 댓글 추가 메소드
	 * 
	 * @param dto (내용, 부모글 seq, id)
	 * @return 1, 0
	 */
	public int addComment(CommentDTO dto) {

		try {
			String sql = "insert into tblquestioncomment (questioncommentseq, regdate, content, questionseq, id) values (seqquestioncomment.nextval, default, ?, ?,?)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getContent());
			pstat.setString(2, dto.getQuestionseq());
			pstat.setString(3, dto.getId());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 질문게시판 게시글에 댓글 삭제 메소드
	 * 
	 * @param questioncommentseq
	 * @return 1, 0
	 */

	public int delComment(String questioncommentseq) {
		try {
			String sql = "delete from tblquestioncomment where questioncommentseq =?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, questioncommentseq);

			return pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * 질문게시판 게시글 삭제시 참조 중인 댓글 삭제 메소드
	 * 
	 * @param questionseq
	 * @return 1, 0
	 */

	public void delAllComment(String questionseq) {
		try {
			String sql = "delete from tblquestioncomment where questionseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, questionseq);

			pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * 가장 큰 thread 구하기 메소드
	 * 
	 */
	public int getMaxThread() {

		try {

			String sql = "select nvl(max(thread),0) + 1000 as thread from tblquestion";

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

	public void updateThread(int parentThread, int previousThread) {
		try {
			// a. 현존 모든 게시물의 thread값을 대상으로 현재 작성 중인 답변글의 부모글의 thread값보다 작고, 이전 새글의 thread값보다
			// 큰 thread값을 찾아서 모두 -1한다
			String sql = "update tblquestion set thread = thread -1 where thread > ? and thread < ?";
			pstat = conn.prepareStatement(sql);

			pstat.setInt(1, previousThread);
			pstat.setInt(2, parentThread);

			pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getTotalCount(HashMap<String, String> map) {
		try {
			String where = "";

			if (map.get("isSearch").equals("y")) {
				// 검색
				// where name like '%홍길동%'
				// where subject list '%날씨%'
				// where all list '%날씨%'

				if (map.get("column").equals("all")) {
					where = String.format(" where subject like '%%%s%%' or content like '%%%s%%' ", map.get("column"),
							map.get("search"));

				} else {

					where = String.format(" where %s like '%%%s%%' ", map.get("column"), map.get("search"));
				}

				// sql 구문에 적용한다.
			}

			String sql = String.format("select count(*) as cnt from tblquestion %s", where);

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

	public int updateRecommcnt(String questionseq) {
		
		try {

			String sql = "update tblquestion set recommcnt = recommcnt + 1 where questionseq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, questionseq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
