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

@WebServlet("/management/wishtravel.do")
public class WishTravel extends HttpServlet {

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
