package Galli.proyectoExamenTecnico.Menu;

import static org.junit.Assert.*;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

import Galli.ProyectoExamenTecnico.Menu.MenuInformation;

public class MenuListTestTest {

	private MenuListTest menuList = new MenuListTest();

	@Test
	public void testGetName() {
		List<MenuInformation> list = menuList.getList();
		assertTrue(list.get(0).getName().equals("Menu1"));
		assertTrue(list.get(1).getName().equals("Menu2"));
		assertTrue(list.get(2).getName().equals("Menu3"));
		assertTrue(list.get(3).getName().equals("Menu4"));
	}

	@Test
	public void testGetPrice() {
		List<MenuInformation> list = menuList.getList();
		NumberFormat price = NumberFormat.getCurrencyInstance(Locale.US);
		assertTrue(list.get(0).getPrice().equals(price.format(10)));
		assertTrue(list.get(1).getPrice().equals(price.format(15)));
		assertTrue(list.get(2).getPrice().equals(price.format(10)));
		assertTrue(list.get(3).getPrice().equals(price.format(12)));
	}

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
