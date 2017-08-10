package pl.danielpiskorz.futurestaurant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pl.danielpiskorz.futurestaurant.security.SecurityConfig;
import pl.danielpiskorz.futurestaurant.service.RestaurantService;
import pl.danielpiskorz.futurestaurant.web.RestaurantController;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
@Import(SecurityConfig.class)
public class RestaurantControllerTest {
 
    @Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private RestaurantService service;
    
    @Test
    public void shouldReturnRestaurantsAsJson() throws Exception {
        mockMvc.perform(get("/restaurants").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }
 
}