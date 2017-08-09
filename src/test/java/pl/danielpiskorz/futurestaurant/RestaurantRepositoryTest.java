package pl.danielpiskorz.futurestaurant;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import pl.danielpiskorz.futurestaurant.model.Description;
import pl.danielpiskorz.futurestaurant.model.Dish;
import pl.danielpiskorz.futurestaurant.model.Menu;
import pl.danielpiskorz.futurestaurant.model.Restaurant;
import pl.danielpiskorz.futurestaurant.repository.RestaurantRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RestaurantRepositoryTest {

    @MockBean
    RestaurantRepository restaurantRepository;

    @Test(expected = NullPointerException.class)
    public void shouldProccessAndReturnGivenRestaurant() throws Exception{
    	Restaurant givenRestaurant = new Restaurant();
    	givenRestaurant.setName("Very good restaurant");
    	givenRestaurant.setType("Junk fast-food");
    	givenRestaurant.setId(1l);
    	Description d = new Description();
    	d.setShortDescription("Welcome to this awesome restaurant");
    	d.setExtension("We have awesome food to satisfy you!");
    	givenRestaurant.setDescription(d);
    	Menu drinkMenu = new Menu();
    	drinkMenu.setName("Drinks");
    	drinkMenu.setId(1l);
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
    	mainMenu.setId(2l);
    	Dish cheeseBurger = new Dish();
    	cheeseBurger.setName("Cheeseburger");
    	cheeseBurger.setDescription("Hamburger with cheese");
    	cheeseBurger.setPrice(new BigDecimal("4.50"));
    	mainMenu.setDishes(Arrays.asList(cheeseBurger));
    	givenRestaurant.setMenus(Arrays.asList(drinkMenu, mainMenu));
    	
    	restaurantRepository.save(givenRestaurant);
    	Restaurant receivedRestaurant = restaurantRepository.findOne(0l);
    	
    	assertTrue(receivedRestaurant.equals(givenRestaurant));
    	
 
    	
    	
    }
}