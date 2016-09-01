package Galli.ProyectoExamenTecnico.Menu.grouper;

import java.util.List;
import java.util.Map;

import Galli.ProyectoExamenTecnico.Menu.MenuInformation;
import Galli.ProyectoExamenTecnico.Menu.MenuList;

/**
 * Esta clase devuelve los menus agrupados por alguna condicion.
 * 
 * @author Galli
 *
 */
public class MenuGrouper {

	private MenuList menuList;

	public MenuGrouper(MenuList menuList) {
		this.menuList = menuList;
	}

	/**
	 * Devuelve un mapa con los precios como claves y como valor una lista de
	 * menus.
	 * 
	 * @return conjuntos de menus agrupados por precios.
	 */
	public Map<String, List<MenuInformation>> getListGroupedByPrice() {
		return this.getListGroupedBy(new PriceGrouper());
	}

	/**
	 * Devuelve un mapa de menus agrupados por un criterio.
	 * 
	 * @param grouper
	 *            : criterio de agrupamiento de los menus.
	 * @return mapa de menus agrupados por un criterio.
	 */
	private Map<String, List<MenuInformation>> getListGroupedBy(Grouper grouper) {
		List<MenuInformation> list = menuList.getList();
		return list.stream().collect((grouper.group()));
	}
}
