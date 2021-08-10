package travel.management;

import travel.spot.RestaurantDTO;
import travel.spot.RoomDTO;
import travel.spot.SightDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

/**
 * 찜 여행을 클릭했을 때 호출되는 클래스
 */
@WebServlet("/management/wishtravel.do")
public class WishTravel extends HttpServlet {
	/**
	 * 식당, 숙박, 명소등의 정보를 모두 가져와 Restaurantdto, Roomdto, Sightdto에저장하여 wishtravel.jsp에 전달한다.
	 * WishDAO dao	Wish 정보의 DB 작업을 위한 DAO 객체
	 * LinkedList<RetaurantDTO> Restaurantdto	식당 정보를 저장하기 위한 컬렉션
	 * LinkedList<RoomDTO> Roomdto	숙박 정보를 저장하기 위한 컬렉션
	 * LinkedList<SightDTO> Sightdto	명소 정보를 저장하기 위한 컬렉션
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		WishDAO dao = new WishDAO();

		LinkedList<RestaurantDTO> Restaurantdto = new LinkedList<RestaurantDTO>();
		LinkedList<RoomDTO> Roomdto = new LinkedList<RoomDTO>();
		LinkedList<SightDTO> Sightdto = new LinkedList<SightDTO>();

		Restaurantdto = dao.getAllRestaurant();
		Roomdto = dao.getAllRoom();
		Sightdto = dao.getAllSight();


		req.setAttribute("Resdto", Restaurantdto);
		req.setAttribute("Roomdto", Roomdto);
		req.setAttribute("Sdto", Sightdto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/management/wishtravel.jsp");
		dispatcher.forward(req, resp);

	}//doGet

}//class
