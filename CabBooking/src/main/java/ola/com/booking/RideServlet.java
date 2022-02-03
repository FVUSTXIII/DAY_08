package ola.com.booking;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ola.com.booking.model.Ride;
import ola.com.booking.model.User;
import ola.com.booking.service.RideService;
import ola.com.booking.service.impl.RideServiceImpl;

@WebServlet("/rides")
public class RideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RideService rideService = new RideServiceImpl();
	
	public RideServlet() {
		super();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getParameter("routeId"));
		Integer user_id = Integer.parseInt(req.getParameter("userId"));
		Ride ride = new Ride();
		ride.setUserId(user_id);
		ride.setRouteId(Integer.parseInt(req.getParameter("routeId")));
		ride.setDateTime(LocalDateTime.now());
		rideService.saveRide(ride);
		req.setAttribute("rideList", rideService.showRides(user_id));
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/bookedrides.jsp");
        rd.forward(req, resp);
	}
	
}
