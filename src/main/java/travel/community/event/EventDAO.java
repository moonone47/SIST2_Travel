package travel.community.event;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Event table의 DB작업을 위한 클래스
 * EventDAO	DB 연결을 위한 생성자
 * ArrayList<EventDTO> list(HashMap<String, String> map)	mpa에 저장된 정보로 vwEventBoard 테이블에 where절의 조건으로 저장하고, 쿼리를 실행후 list에 저장하여 반환한다.
 * add(EventDTO dto)	dto정보를 tblEventBoard에 insert한다.
 * int getTotalCount(HashMap<String, String> map)	map에 저장된 정보로 vwEventBoard 테이블에 where절의 조건으로 저장하고, 쿼리를 실행후 글번호인 cnt값을 반환한다.
 * int getMaxThread()	tbl EventBoard의 max(thread)값을 반환한다.
 * void updateThread(int parentThread, int previousThread)	tblEventBoard의 prarentThread와 previousThread 사이(between)에 있는thread값을 update한다.
 * EventDTO get(String seq)	tblEventBoard에서 seq에 해당하는 글 내용을 EventDTO에 저장한뒤 반환한다.
 * void updateReadCount(String seq)	tblEventBoard에서 seq에 해당하는 글의 readcount(조회수)를 1 증가시킨다.
 * int edit(EventDTO dto)	dto에 저장된 정보로 tblEventBoard를 update한다.
 * int del(String seq)	tblEventBoard에서 seq에 해당하는 글을 delete하고, 작업 결과를 반환한다.
 * int addComment(CommentDTO dto)	tblEventComment에 dto정보를 insert하고 결과값을 반환한다.
 * ArrayList<CommentDTO> listComment(String seq)	tblEventComment에 seq(부모글 번호)를 서브쿼리를 이용하여 댓글 목록을 CommentDTO에 담고, ArrayList에 add하여 반환한다.
 * int delComment(String seq)	tblEventComment에서seq에 해당하는 댓글을 delete하고 결과값을 반환한다.
 * void delAllComment(String seq)	tblEventComment에서 pseq(부모글 번호)가 seq인 모든 댓글을 delete한다.
 */
public class EventDAO {
    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * DB 연결을 위한 생성자
     */
    public EventDAO(){
        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * map의 isSearch와 column을 where절의 조건으로 걸고 vwEventBoard의 rnum between begin and end로 select한 결과를 list에 add하여 list값을 전달한다.
     * @param map isSearch, column, column, bigin, end등의 정보를 가지고 있는 컬렉션이다.
     * @return select 결과값을 Eventdto에 저장한뒤, list.add로 저장한 값을 반환한다.
     */
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

    /**
     * tblEventBoard에 dto정보를 insert하는 메소드이다.
     * @param dto 추가할 정보를 가진 EventDTO
     * @return insert 결과를 반환한다.
     */
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

    /**
     * map의 isSearch, column, search 정보를 where절의 조건으로 걸고, tblEventBoard에서 select count(*)의 값을 반환한다.
     * @param map isSearch, column, search 정보를 갖는 컬렉션이다.
     * @return select count(*)인 총 게시물의 갯수를 반환한다.
     */
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

    /**
     * tblEventBoard에서 thread의 최댓값을 가져오고, 최대값이 없으면 1000을 반환하는 메소드이다.
     * @return select nvl(max(thread), 0) + 1000 의 값을 반환한다.
     */
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

    /**
     * parentThread와 previousThread 사이에 있는 thread 값을 -1 하는 메소드이다.
     * @param parentThread 답변글의 부모 글의 thread
     * @param previousThread 이전 새글의 thread
     */
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

    /**
     * tblEventBoard에 서브 쿼리를 날려 seq의 정보를 select하여 EventDTO로 반환한다.
     * @param seq 얻고 싶은 글 번호
     * @return 글 번호에 해당하는 정보를 EventDTO로 반환한다.
     */
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


    /**
     * tblEventBoard의 seq에 해당하는 글의 readcount(조회수)를 1 증가시킨다.
     * @param seq readcount를 1증가시킬 글 번호
     */
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




    /**
     * dto에 들어있는 seq의 글 번호의 subject와 content를 update한다.
     * @param dto subject, content, seq등의 정보가 들어있는 EventDTO
     * @return update의 결과값을 반환한다.
     */
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



    /**
     * tblEventBoard의 seq에 해당하는 글을 delete하는 메소드이다.
     * @param seq 삭제하고 싶은 글 번호
     * @return delete 작업의 결과를 반환
     */
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



    /**
     * tblEventComment에 dto값을 insert하는 메소드
     * @param dto id, content, pseq등의 정보를 갖는 CommentDTO
     * @return insert 작업의 결과를 반환한다.
     */
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

    /**
     * seq 글번호에 해당하는 모든 댓글을 반환하는 메소드
     * @param seq 받고싶은 댓글의 글번호로 where절의 조건으로 사용된다.
     * @return 이중쿼리의 select 결과를 clist에 add하여 반환한다.
     */
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


    /**
     * seq에 해당하는 댓글을 delete하는 메소드
     * @param seq 삭제하고 싶은 댓글의 seq값
     * @return delete 작업 결과를 반환한다.
     */
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




    /**
     * seq에 해당하는 글번호의 모든 댓글을 삭제하는 메소드
     * @param seq 모든 댓글을 삭제할 글 번호로 tblEventComment의 pseq 조건으로 사용된다.
     */
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
