package ola.com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ola.com.booking.ConectionManager;
import ola.com.booking.dao.RideDao;
import ola.com.booking.model.DetailedRide;
import ola.com.booking.model.Ride;
import ola.com.booking.model.Route;

public class RideDaoImpl implements RideDao {
	Connection conn = ConectionManager.getConnection();
	@Override
	public void saveRide(Ride ride) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement s = conn.prepareStatement("INSERT INTO ride (userId, routeId, dateTime) values (? ,?, ?)");
			s.setInt(1, ride.getUserId());
			s.setInt(2, ride.getRouteId());
			s.setObject(3, ride.getDateTime());
			System.out.println("estamos a punto de guardar: " + ride.getUserId());
			s.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Override
	public List<DetailedRide> getRidesByUser(Integer user_id) {
		// TODO Auto-generated method stub
		List<DetailedRide> rideList = new ArrayList<DetailedRide>();
		try {
			PreparedStatement s = conn.prepareStatement("SELECT name, source, destination, duration, dateTime FROM ride INNER JOIN user " +
		"ON ride.userId = user.userId JOIN route ON ride.routeId = route.routeId WHERE user.userId = ?");
			s.setInt(1, user_id);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				DetailedRide r = new DetailedRide();
				r.setUser_name(rs.getString("name"));
				r.setSource(rs.getString("source"));
				r.setDestination(rs.getString("duration"));
				r.setDuration(rs.getDouble("duration"));
				r.setDate_time(rs.getDate("dateTime").toString());
				rideList.add(r);
			}
			return rideList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
