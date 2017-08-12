package pl.danielpiskorz.futurestaurant.web.owner;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import pl.danielpiskorz.futurestaurant.model.Restaurant;
import pl.danielpiskorz.futurestaurant.service.OwnerService;
import pl.danielpiskorz.futurestaurant.service.StorageService;

@RestController
@RequestMapping("/owner/restaurant")
public class RestaurantManagementController {

	@Autowired
	OwnerService ownerService;
	
	@Autowired
	StorageService storageService;
	
	@PostMapping//(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void addNewRestaurant(
			@RequestPart("restaurant") String rString,
			@RequestPart("file") MultipartFile photo,
			HttpServletRequest request)
					throws IOException
	{	
		Restaurant restaurant = new ObjectMapper().readValue(rString, Restaurant.class);
		ownerService.saveRestaurant(restaurant);
		
		String filename = restaurant.getId().toString() + restaurant.getPhotoExtension();
		storageService.store(photo, filename);
					
	}
	
}
