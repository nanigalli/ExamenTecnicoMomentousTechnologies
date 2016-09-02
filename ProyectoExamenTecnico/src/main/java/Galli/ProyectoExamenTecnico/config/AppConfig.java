package Galli.ProyectoExamenTecnico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Galli.ProyectoExamenTecnico.Menu.MenuRepository;
import Galli.proyectoExamenTecnico.Menu.MockMenuRepository;

@Configuration
public class AppConfig {

    @Bean(name="menuList")
    public MenuRepository menuList() {
        return new MockMenuRepository();
    }

}
