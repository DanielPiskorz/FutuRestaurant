package pl.danielpiskorz.futurestaurant.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
 
	@Value("${filestorage.absolutepath}")
	private String path;
	
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {

       registry.addResourceHandler("/photo/**") //
                 .addResourceLocations("file:" + path).setCachePeriod(31556926);
        
   }
 
    
   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
   }
 
}