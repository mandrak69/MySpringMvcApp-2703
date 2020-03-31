package rs.engineering.javacourse.myspringmvcapp.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import rs.engineering.javacourse.myspringmvcapp.formatter.CityDtoFormatter;
import rs.engineering.javacourse.myspringmvcapp.service.CityService;

//konfigurisanje bean-ova koje koristi dispatcher servlet
//za obradu zahteva
@EnableWebMvc //autormatsko definisanje MapperHandler-a koji na osnovu URL-a poziva odgovarajuci kontroller
@ComponentScan(basePackages = {
		"rs.engineering.javacourse.myspringmvcapp.controller",
		"rs.engineering.javacourse.myspringmvcapp.service",
		"rs.engineering.javacourse.myspringmvcapp.repository",
		"rs.engineering.javacourse.myspringmvcapp.exception"
})
@Configuration
@Import(MyDatabaseConfig.class)
public class MyWebContextConfig implements WebMvcConfigurer{
	
	private CityService cityService;
	
	@Autowired
	public MyWebContextConfig(CityService cityService) {
		System.out.println("==================== MyWebContextConfig =========================");
		this.cityService = cityService;
	}
	
	/*
	@Bean
	HomeController homeController() {
		return new HomeController();
	}
	*/
	//view resolveri
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(1);
		return viewResolver;
	}
	
	//Definisanje TilesViewResolver
	@Bean
	public ViewResolver tilesViewResolver() {
		TilesViewResolver tilesViewResolver = new TilesViewResolver();
		tilesViewResolver.setOrder(0);
		return tilesViewResolver;
	}
	
	//Konfigurisanje TilesViewResolvera
	@Bean
	public TilesConfigurer tilesCongigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(
				new String[] {"/WEB-INF/views/tiles/tiles.xml"}
		);
		return tilesConfigurer;
	}
	
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		//city home
	}
//	Ovaj bean se kreira od strane IoC konetjenra preko componentscan
//	@Bean
//	CityService getCityService() {
//		return new CityServiceImpl();
//	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new CityDtoFormatter(cityService));
	}
}
