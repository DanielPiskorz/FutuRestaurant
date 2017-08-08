package pl.danielpiskorz.futurestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.danielpiskorz.futurestaurant.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
