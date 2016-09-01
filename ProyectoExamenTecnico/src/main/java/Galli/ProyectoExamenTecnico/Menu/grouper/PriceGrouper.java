package Galli.ProyectoExamenTecnico.Menu.grouper;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

import Galli.ProyectoExamenTecnico.Menu.MenuInformation;

/**
 * Esta es la clase que define como se agrupa una lista de menus por precios.
 * 
 * @author Galli
 *
 */
public class PriceGrouper implements Grouper {

	public Collector<MenuInformation, ?, Map<String, List<MenuInformation>>> group() {
		return groupingBy(MenuInformation::getPrice);
	}

}
