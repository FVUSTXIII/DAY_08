package ola.com.booking.service.impl;

import java.util.List;

import ola.com.booking.dao.RideDao;
import ola.com.booking.dao.impl.RideDaoImpl;
import ola.com.booking.model.DetailedRide;
import ola.com.booking.model.Ride;
import ola.com.booking.service.RideService;

public class RideServiceImpl implements RideService {
	RideDao rideDao;
	@Override
	public void saveRide(Ride ride) {
		// TODO Auto-generated method stub
		rideDao = new RideDaoImpl();
		rideDao.saveRide(ride);
	}
	@Override
	public List<DetailedRide> showRides(int user_id) {
		rideDao = new RideDaoImpl();
		return rideDao.getRidesByUser(user_id);		
	}

}
