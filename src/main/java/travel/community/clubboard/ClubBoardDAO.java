package travel.community.clubboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import travel.DBUtil;


public class ClubBoardDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public ClubBoardDAO() {
		try {
			conn = DBUtil.open("183.100.233.88", "sist2_travel", "java1234");
//            conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public int add(ClubBoardDTO dto) {
		try {
			String sql = "insert into tblTravelClubBoard (travelclubseq , subject, content, viewcnt, recommcnt, regdate, id, thread, depth ) values (seqtravelclubboard.nextval, ?,?,default,default,default,?, ?, ?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getId());
			pstat.setInt(4, dto.getThread());
			pstat.setInt(5, dto.getDepth());


			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	public ArrayList<ClubBoardDTO> list(HashMap<String, String> map) {
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

			String sql = String.format("select * from vwClubBoard where rnum between %s and %s %s order by thread desc", map.get("begin"), map.get("end"), where);

			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();

			ArrayList<ClubBoardDTO> list = new ArrayList<ClubBoardDTO>();

			while (rs.next()) {
				ClubBoardDTO dto = new ClubBoardDTO();

				dto.setSeq(rs.getString("travelclubseq"));
				dto.setName(rs.getString("name")); // 작성자
				dto.setSubject(rs.getString("subject")); // 제목
				dto.setViewCnt(rs.getString("viewcnt")); // 조회수
				//dto.setRecommCnt(rs.getString("recommcnt")); // 추천수
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

	
	public ClubBoardDTO get(String travelclubseq) {
		try {

			String sql = "select q.*,(select name from tblmember where id = q.id) as name from tblTravelClubBoard q where travelclubseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, travelclubseq);

			rs = pstat.executeQuery();

			if (rs.next()) {
				ClubBoardDTO dto = new ClubBoardDTO();

				dto.setSeq(rs.getString("travelclubseq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setViewCnt(rs.getString("viewcnt"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setRecommCnt(rs.getString("recommcnt"));
				dto.setThread(rs.getInt("thread"));
				dto.setDepth(rs.getInt("depth"));

				return dto;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public int del(String travelclubseq) {

		try {
			String sql = "delete from tblTravelClubBoard where travelclubseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, travelclubseq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public void updateReadCount(String travelclubseq) {
		try {

			String sql = "update tblTravelClubBoard set viewcnt = viewcnt + 1 where travelclubseq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, travelclubseq);

			pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public int edit(ClubBoardDTO dto) {
		try {
			String sql = "update tblTravelClubBoard set subject =?, content = ? where travelclubseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSeq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public ArrayList<ClubBoardCommentDTO> listcomment(String travelclubseq) {
		try {
			String sql = "select c.*,(select name from tblMember where id=c.id) as name from tblTravelClubComment c where travelclubseq = ? order by travelclubcommentseq desc";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, travelclubseq);

			rs = pstat.executeQuery();

			ArrayList<ClubBoardCommentDTO> clist = new ArrayList<ClubBoardCommentDTO>();

			while (rs.next()) {
				// 레코드 1줄 -> DTO
				ClubBoardCommentDTO dto = new ClubBoardCommentDTO();

				dto.setTravelclubcommentseq(rs.getString("travelclubcommentseq"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setTravelclubseq(rs.getString("travelclubseq"));
				dto.setName(rs.getString("name"));

				clist.add(dto);

			}

			return clist;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	
	public int addComment(ClubBoardCommentDTO dto) {

		try {
			String sql = "insert into tblTravelClubComment (travelclubcommentseq, regdate, content, travelclubseq, id) values (seqtravelclubcomment.nextval, default, ?, ?,?)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getContent());
			pstat.setString(2, dto.getTravelclubseq());
			pstat.setString(3, dto.getId());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}

	

	public int delComment(String travelclubcommentseq) {
		try {
			String sql = "delete from tblTravelClubComment where travelclubcommentseq =?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, travelclubcommentseq);

			return pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return 0;
	}


	public void delAllComment(String travelclubseq) {
		try {
			String sql = "delete from tblTravelClubComment where travelclubseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, travelclubseq);

			pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public int getMaxThread() {

		try {

			String sql = "select nvl(max(thread),0) + 1000 as thread from tblTravelClubBoard";

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
			String sql = "update tblTravelClubBoard set thread = thread -1 where thread > ? and thread < ?";
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

			String sql = String.format("select count(*) as cnt from tblTravelClubBoard %s", where);

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

	public int updateRecommcnt(String travelclubseq) {
		
		try {

			String sql = "update tblTravelClubBoard set recommcnt = recommcnt + 1 where travelclubseq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, travelclubseq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
