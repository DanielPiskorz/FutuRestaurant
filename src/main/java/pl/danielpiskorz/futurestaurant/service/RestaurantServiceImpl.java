package pl.danielpiskorz.futurestaurant.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.danielpiskorz.futurestaurant.model.Description;
import pl.danielpiskorz.futurestaurant.model.Dish;
import pl.danielpiskorz.futurestaurant.model.Menu;
import pl.danielpiskorz.futurestaurant.model.Restaurant;
import pl.danielpiskorz.futurestaurant.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Override
	public List<Restaurant> getRestaurantsAsList() {
		List<Restaurant> list = restaurantRepository.findAll();
		return list;
	}

	
}
