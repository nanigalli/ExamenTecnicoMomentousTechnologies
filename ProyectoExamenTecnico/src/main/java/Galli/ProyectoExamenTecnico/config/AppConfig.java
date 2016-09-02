package Galli.ProyectoExamenTecnico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Galli.ProyectoExamenTecnico.Menu.MenuRepository;
import Galli.ProyectoExamenTecnico.Menu.grouper.MenuGrouper;
import Galli.proyectoExamenTecnico.Menu.MockMenuRepository;

/**
 * Esta clase sirve para la configuracion de Spring.
 * 
 * @author Galli
 *
 */
@Configuration
public class AppConfig {

	@Bean(name = "menuRepository")
	public MenuRepository menuRepository() {
		return new MockMenuRepository();
	}

	@Bean(name = "menuGrouper")
	public MenuGrouper menuGrouper() {
		return new MenuGrouper(menuRepository());
	}

}
