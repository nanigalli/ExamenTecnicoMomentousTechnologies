package Galli.ProyectoExamenTecnico.Menu.grouper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

import Galli.ProyectoExamenTecnico.Menu.MenuInformation;

/**
 * Esta interfaz la van a implementar las clases para armar los diferentes criterios de agrupamiento
 * de los menus.
 * 
 * @author Galli
 *
 */
public interface Grouper {

	public Collector<MenuInformation, ?, Map<String, List<MenuInformation>>> group();

}
