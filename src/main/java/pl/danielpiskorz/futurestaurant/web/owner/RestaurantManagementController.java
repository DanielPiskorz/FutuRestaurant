package pl.danielpiskorz.futurestaurant.web.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.danielpiskorz.futurestaurant.model.Restaurant;
import pl.danielpiskorz.futurestaurant.service.OwnerService;

@RestController
@RequestMapping("/owner/restaurant")
public class RestaurantManagementController {

	@Autowired
	OwnerService ownerService;
	
	@PostMapping
	public void addNewRestaurant(@RequestBody Restaurant restaurant){
		ownerService.saveRestaurant(restaurant);
	}
	
}
