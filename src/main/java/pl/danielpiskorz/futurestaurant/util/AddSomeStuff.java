package pl.danielpiskorz.futurestaurant.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import pl.danielpiskorz.futurestaurant.model.Description;
import pl.danielpiskorz.futurestaurant.model.Dish;
import pl.danielpiskorz.futurestaurant.model.Menu;
import pl.danielpiskorz.futurestaurant.model.Restaurant;
import pl.danielpiskorz.futurestaurant.repository.RestaurantRepository;

//@Component
public class AddSomeStuff{
	
	//@Autowired
	RestaurantRepository restaurantRepository;
	
	//@PostConstruct
	public void addSomeStuff(){
		for(int i=0; i< 8; i++){
		Restaurant restaurant = new Restaurant();
		Description description = new Description();
		description.setShortDescription("A brilliant pizzeria in the center.");
		description.setExtension("Come and enjoy our italian menu.");
		Dish dish = new Dish();
		dish.setName("Pizza");
		dish.setDescription("Cheese");
		dish.setPrice(new BigDecimal("12.30"));
		Menu menu = new Menu();
		menu.setName("Main Dishes");
		menu.setDishes(Arrays.asList(dish));
		menu.setRestaurantId(restaurant.getId());
		List<Menu> menus = Arrays.asList(menu);
		restaurant.setName("Margarita");
		restaurant.setType("Italian");
		restaurant.setDescription(description);
		restaurant.setMenus(menus);
		
    	Restaurant givenRestaurant = new Restaurant();
    	givenRestaurant.setName("Very good restaurant");
    	givenRestaurant.setType("Junk fast-food");
    	Description d = new Description();
    	d.setShortDescription("Welcome to this awesome restaurant");
    	d.setExtension("We have awesome food to satisfy you!");
    	givenRestaurant.setDescription(d);
    	Menu drinkMenu = new Menu();
    	drinkMenu.setName("Drinks");
    	Dish cola = new Dish();
    	cola.setName("Coca-cola");
    	cola.setDescription("Can 330ml");
    	cola.setPrice(new BigDecimal("1.50"));
    	Dish juice = new Dish();
    	juice.setName("Orange juice");
    	juice.setDescription("Bottle 500ml");
    	juice.setPrice(new BigDecimal("3.00"));
    	drinkMenu.setDishes(Arrays.asList(cola, juice));
    	Menu mainMenu = new Menu();
    	mainMenu.setName("Main menu");
    	Dish cheeseBurger = new Dish();
    	cheeseBurger.setName("Cheeseburger");
    	cheeseBurger.setDescription("Hamburger with cheese");
    	cheeseBurger.setPrice(new BigDecimal("4.50"));
    	mainMenu.setDishes(Arrays.asList(cheeseBurger));
    	givenRestaurant.setMenus(Arrays.asList(drinkMenu, mainMenu));
    	
    	restaurantRepository.save(restaurant);
    	restaurantRepository.save(givenRestaurant);
		}
	}
	
}
