package travel.community.event;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class EventDAO {
    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    public EventDAO(){
        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //list.do get dto
    public ArrayList<EventDTO> list(HashMap<String, String> map) {
        try{
            String where = "";
            if(map.get("isSearch").equals("y")){
                if (map.get("column").equals("all")){
                    where = String.format(" and subject like '%%%s%%' or content like '%%%s%%' ", map.get("search"),
                            map.get("serach"));
                }else{
                    where = String.format(" and %s like '%%%s%%' ", map.get("column"), map.get("search"));
                }
            }

            String sql = String.format("select * from vwEventBoard where rnum between %s and %s order by thread desc"
            , map.get("begin")
            , map.get("end")
            , where);


            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();
            ArrayList<EventDTO> list = new ArrayList<EventDTO>();

            while(rs.next()){
                EventDTO dto = new EventDTO();
                dto.setSeq(rs.getString("seq"));
                dto.setName(rs.getString("name"));
                dto.setSubject(rs.getString("subject"));
                dto.setContent(rs.getString("content"));
                dto.setRegdate(rs.getString("regdate"));
                dto.setReadcount(rs.getString("readcount"));
                dto.setRecommCnt(rs.getString("recommcnt"));
                dto.setStartDate(rs.getString("startDate"));
                dto.setEndDate(rs.getString("enddate"));
                dto.setAnnounceDate(rs.getString("announcedate"));
                dto.setThread(rs.getInt("thread"));
                dto.setDepth(rs.getInt("depth"));

                list.add(dto);
            }
            return list;
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    //AddOk.do insert dto
    public int add(EventDTO dto){
        try{
            String sql = "insert into tblEventBoard values(seqEventBoard.nextval, ?, ?, ?, default, default, default," +
                    " default, default, default, default, default)";
            pstat = conn.prepareStatement(sql);

            pstat.setString(1, dto.getId());
            pstat.setString(2,dto.getSubject());
            pstat.setString(3, dto.getContent());
//            pstat.setString(4, dto.getRegdate());
//            pstat.setString(5, dto.getReadcount());
//            pstat.setString(6, dto.getRecommCnt());
//            pstat.setString(7, dto.getStartDate());
//            pstat.setString(8, dto.getEndDate());
//            pstat.setString(9, dto.getAnnounceDate());
//            pstat.setInt(10, dto.getThread());
//            pstat.setInt(11, dto.getDepth());
            return pstat.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    //List.do give to totalCount
    public int getTotalCount(HashMap<String, String> map){
        try{
            String where = "";
            if(map.get("isSearch").equals("y")){
                if(map.get("column").equals("all")){
                    where = String.format(" where subject like '%%%s%%' or content like '%%%s%%' "
                    , map.get("search"), map.get("search"));
                } else{
                    where = String.format(" where %s like '%%%s%%' ",
                            map.get("column"), map.get("search"));
                }
            }
            String sql = String.format("select count(*) as cnt from tblEventBoard %s", where);

            pstat = conn.prepareStatement(sql);

            rs = pstat.executeQuery();

            if(rs.next()){
                return rs.getInt("cnt");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    //AddOk getMaxThread
    public int getMaxThread() {
        try{
            String sql = "select nvl(max(thread), 0) + 1000 as thread from tblEventBoard";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            if(rs.next()){
                return rs.getInt("thread");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    //AddOk 답변 글쓰기 업무 위임
    public void updateThread(int parentThread, int previousThread) {
        try{
            String sql = "update tblEventBoard set thread = thread - 1 where thread > ? and thread < ?";
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, previousThread);
            pstat.setInt(2, parentThread);

            pstat.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //View 서블릿이 글번호를 줄테니 레코드 내용 전부를 DTO 담아 돌려주세요..
    public EventDTO get(String seq) {

        try {

            String sql = "select b.*, (select name from tblMember where id = b.id) as name"
                    + " from tblEventBoard b where seq=?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            rs = pstat.executeQuery();

            if (rs.next()) {

                EventDTO dto = new EventDTO();

                dto.setSeq(rs.getString("seq"));
                dto.setName(rs.getString("name"));
                dto.setSubject(rs.getString("subject"));
                dto.setContent(rs.getString("content"));
                dto.setRegdate(rs.getString("regdate"));
                dto.setReadcount(rs.getString("readcount"));
                dto.setRecommCnt(rs.getString("recommcnt"));
                dto.setStartDate(rs.getString("startDate"));
                dto.setEndDate(rs.getString("enddate"));
                dto.setAnnounceDate(rs.getString("announcedate"));
                dto.setThread(rs.getInt("thread"));
                dto.setDepth(rs.getInt("depth"));
                return dto;

            }


        } catch (Exception e) {
            System.out.println("BoardDAO.get()");
            e.printStackTrace();
        }

        return null;
    }


    //View 서블릿이 글번호를 줄테니 조회수를 +1 해달라고 요청..
    public void updateReadcount(String seq) {

        try {

            String sql = "update tblEventBoard set readcount = readcount + 1 where seq=?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            pstat.executeUpdate();

        } catch (Exception e) {
            System.out.println("BoardDAO.updateReadcount()");
            e.printStackTrace();
        }

    }


    //EditOk 서블릿이 수정할 DTO를 줄테니 update 해주세요..
    public int edit(EventDTO dto) {

        try {

            String sql = "update tblEventBoard set subject = ?, content = ? where seq = ?";

            pstat = conn.prepareStatement(sql);

            pstat.setString(1, dto.getSubject());
            pstat.setString(2, dto.getContent());
            pstat.setString(3, dto.getSeq());


            return pstat.executeUpdate();

        } catch (Exception e) {
            System.out.println("BoardDAO.edit()");
            e.printStackTrace();
        }

        return 0;
    }


    //DelOk 서블릿이 글번호를 줄테니 글을 삭제해다오..
    public int del(String seq) {

        try {

            String sql = "delete from tblEventBoard where seq = ?";

            pstat = conn.prepareStatement(sql);

            pstat.setString(1, seq);

            return pstat.executeUpdate();

        } catch (Exception e) {
            System.out.println("BoardDAO.del()");
            e.printStackTrace();
        }

        return 0;
    }


    //AddComment 서블릿이 댓글 써달라고 요청
    public int addComment(CommentDTO dto) {

        try {

            String sql = "insert into TBLEVENTCOMMENT (seq, id, content, regdate, pseq)"
                    + " values (seqEventComment.nextVal, ?, ?, default, ?)";

            pstat = conn.prepareStatement(sql);

            pstat.setString(1, dto.getId()); //?
            pstat.setString(2, dto.getContent());
            pstat.setString(3, dto.getPseq());

            return pstat.executeUpdate();

        } catch (Exception e) {
            System.out.println("BoardDAO.addComment()");
            e.printStackTrace();
        }

        return 0;
    }


    //View 서블릿이 댓글 목록 달라고 요청
    public ArrayList<CommentDTO> listComment(String seq) {

        try {

            //부모글번호를 조건으로..
            String sql = "select c.*, (select name from tblMember where id = c.id) as name from TBLEVENTCOMMENT c where " +
                    "pseq = ? order by seq desc";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            rs = pstat.executeQuery();

            ArrayList<CommentDTO> clist = new ArrayList<CommentDTO>();

            while (rs.next()) {
                //레코드 1줄 -> DTO 1개
                CommentDTO dto = new CommentDTO();

                dto.setSeq(rs.getString("seq"));
                dto.setContent(rs.getString("content"));
                dto.setId(rs.getString("id"));
                dto.setRegdate(rs.getString("regdate"));
                dto.setPseq(rs.getString("pseq"));
                dto.setName(rs.getString("name"));

                clist.add(dto);
            }

            return clist;


        } catch (Exception e) {
            System.out.println("BoardDAO.listComment()");
            e.printStackTrace();
        }

        return null;
    }


    //View 서블릿이 글번호를 줄테니 댓글을 삭제해주세요..
    public int delComment(String seq) {

        try {

            String sql = "delete from TBLEVENTCOMMENT where seq = ?";

            pstat = conn.prepareStatement(sql);

            pstat.setString(1, seq);

            return pstat.executeUpdate();

        } catch (Exception e) {
            System.out.println("BoardDAO.delComment()");
            e.printStackTrace();
        }

        return 0;
    }


    //DelOk 서블릿이 글번호를 줄테니 글번호를 부모로 하는 모든 댓글을 삭제해주세요..
    public void delAllComment(String seq) {

        try {

            String sql = "delete from TBLEVENTCOMMENT where pseq = ?";

            pstat = conn.prepareStatement(sql);

            pstat.setString(1, seq);

            pstat.executeUpdate();

        } catch (Exception e) {
            System.out.println("BoardDAO.delAllComment()");
            e.printStackTrace();
        }

    }

}
