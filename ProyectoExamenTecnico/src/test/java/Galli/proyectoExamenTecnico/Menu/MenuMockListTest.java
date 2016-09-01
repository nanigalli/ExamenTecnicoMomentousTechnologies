package Galli.proyectoExamenTecnico.Menu;

import static org.junit.Assert.*;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

import Galli.ProyectoExamenTecnico.Menu.MenuInformation;
import Galli.ProyectoExamenTecnico.Menu.MenuList;

/**
 * Esta clase sirve para probar que los mocks se crearon en la clase
 * MenuListTest.
 * 
 * @author Galli
 *
 */
public class MenuMockListTest {

	private MenuList menuList = new MenuMockList();

	/**
	 * Se prueba que tenga los menus que se crearon en la clase.
	 */
	@Test
	public void testGetName() {
		List<MenuInformation> list = menuList.getList();
		assertTrue(list.get(0).getName().equals("Menu1"));
		assertTrue(list.get(1).getName().equals("Menu2"));
		assertTrue(list.get(2).getName().equals("Menu3"));
		assertTrue(list.get(3).getName().equals("Menu4"));
	}

	/**
	 * Se prueba que se hayan almacenado bien los precios de los menus.
	 */
	@Test
	public void testGetPrice() {
		List<MenuInformation> list = menuList.getList();
		NumberFormat price = NumberFormat.getCurrencyInstance(Locale.US);
		assertTrue(list.get(0).getPrice().equals(price.format(10)));
		assertTrue(list.get(1).getPrice().equals(price.format(15)));
		assertTrue(list.get(2).getPrice().equals(price.format(10)));
		assertTrue(list.get(3).getPrice().equals(price.format(12)));
	}

	/**
	 * Se prueba que las fechas se hayan creado correctamente.
	 */
	@Test
	public void testGetFromDay() {
		List<MenuInformation> list = menuList.getList();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		try {
			assertTrue(list.get(0).getFromDay()
					.equals(date.parse("2016-03-01")));
			assertTrue(list.get(1).getFromDay()
					.equals(date.parse("2016-03-01")));
			assertTrue(list.get(2).getFromDay()
					.equals(date.parse("2016-03-01")));
			assertTrue(list.get(3).getFromDay()
					.equals(date.parse("2016-04-01")));
		} catch (ParseException e) {
			fail("Error en el parseo de la fecha, es un problema del test.");
		}
	}
}
