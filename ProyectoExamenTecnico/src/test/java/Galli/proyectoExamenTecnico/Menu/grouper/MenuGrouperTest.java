package Galli.proyectoExamenTecnico.Menu.grouper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import Galli.ProyectoExamenTecnico.Menu.MenuInformation;
import Galli.ProyectoExamenTecnico.Menu.MenuList;
import Galli.ProyectoExamenTecnico.Menu.grouper.MenuGrouper;
import Galli.proyectoExamenTecnico.Menu.MenuMockList;

/**
 * Esta clase prueba el MenuGrouper a la hora de agrupar los menu por precio.
 * 
 * @author Galli
 *
 */
public class MenuGrouperTest {

	private Map<String, List<MenuInformation>> menus;

	@Before
	public void setUp() {
		MenuList menuList = new MenuMockList();
		MenuGrouper menuGrouper = new MenuGrouper(menuList);
		menus = menuGrouper.getListGroupedByPrice();
	}

	/**
	 * Este metodo va a agrupar a la lista de menus por precio. Deberia dar 2
	 * elementos con precio 10, 1 con 15 y 1 con 12.
	 */
	@Test
	public void testKeysGroup() {
		NumberFormat price = NumberFormat.getCurrencyInstance(Locale.US);
		// Verifico que solo hayan 3 precios
		assertEquals(menus.keySet().size(), 3);
		// Verifico que sean los precios esperados
		assertTrue(menus.keySet().contains(price.format(10)));
		assertTrue(menus.keySet().contains(price.format(15)));
		assertTrue(menus.keySet().contains(price.format(12)));
	}

	/**
	 * Este metodo verifica que cada grupo este bien armado. Se espera que en el
	 * grupo del precio 10 este el menu1 y menu3, en el grupo del precio 15 debe
	 * estar el menu2 y en el grupo del precio 10 debe estar el menu4.
	 */
	@Test
	public void testGroup() {
		NumberFormat price = NumberFormat.getCurrencyInstance(Locale.US);
		// Verifico que en la lista del precio 10 esten los menus: 1 y 3
		List<MenuInformation> list = menus.get(price.format(10));
		assertEquals(list.size(), 2);
		assertEquals(list.get(0).getName(), "Menu1");
		assertEquals(list.get(1).getName(), "Menu3");
		// Verifico que en la lista del precio 15 este el menu: 2
		list = menus.get(price.format(15));
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getName(), "Menu2");
		// Verifico que en la lista del precio 15 este el menu: 4
		list = menus.get(price.format(12));
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getName(), "Menu4");
	}

}
