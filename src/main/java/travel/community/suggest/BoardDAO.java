package travel.community.suggest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import travel.DBUtil;

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

	//게시글 리스트 메소드
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

	
	//게시글 뷰 메소드
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

	
	//게시글 삭제 메소드
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

	
	//게시글 조회수 증가 메소드
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


	//게시글 수정 증가 메소드
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

	
	//게시글에 달린 댓글 리스트 메소드
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


	//게시글에 댓글 추가 메소드
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


	//게시글에 댓글 삭제 메소드
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


	//게시글 삭제시 참조 중인 댓글 삭제 메소드
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


	public int getMaxThread() {

		try {

			String sql = "select nvl(max(thread),0) + 1000 as thread from tblsuggest";

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

			String sql = "update tblsuggest set thread = thread -1 where thread > ? and thread < ?";
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
				if (map.get("column").equals("all")) {
					where = String.format(" where subject like '%%%s%%' or content like '%%%s%%' ", map.get("column"),
							map.get("search"));
				} else {
					where = String.format(" where %s like '%%%s%%' ", map.get("column"), map.get("search"));
				}
				// sql 구문에 적용한다.
			}

			String sql = String.format("select count(*) as cnt from tblsuggestBoard %s", where);

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

	public int updateRecommcnt(String suggestseq) {
		
		try {

			String sql = "update tblsuggest set recommcnt = recommcnt + 1 where suggestseq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, suggestseq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}