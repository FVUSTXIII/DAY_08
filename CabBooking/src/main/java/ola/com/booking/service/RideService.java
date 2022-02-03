package ola.com.booking.service;

import java.util.List;

import ola.com.booking.model.DetailedRide;
import ola.com.booking.model.Ride;

public interface RideService {
	public void saveRide(Ride ride);
	public List<DetailedRide> showRides(int user_id);
}
