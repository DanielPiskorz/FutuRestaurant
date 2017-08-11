package pl.danielpiskorz.futurestaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.danielpiskorz.futurestaurant.model.Restaurant;
import pl.danielpiskorz.futurestaurant.repository.RestaurantRepository;

@Service
public class OwnerServiceImpl implements OwnerService{

	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Override
	public void saveRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
	}

}
