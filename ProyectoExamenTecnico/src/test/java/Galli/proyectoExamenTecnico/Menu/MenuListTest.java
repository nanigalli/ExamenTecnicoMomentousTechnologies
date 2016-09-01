package Galli.proyectoExamenTecnico.Menu;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import org.mockito.runners.MockitoJUnitRunner;

import Galli.ProyectoExamenTecnico.Menu.MenuInformation;
import Galli.ProyectoExamenTecnico.Menu.MenuList;

/*Esta clase simula la obtencion de los menus con la informacion necesaria de cada uno de ellos.*/
@RunWith(MockitoJUnitRunner.class)
public class MenuListTest implements MenuList {

	public List<MenuInformation> getList() {
		List<MenuInformation> list = new ArrayList<MenuInformation>();
		NumberFormat price = NumberFormat.getCurrencyInstance(Locale.US);
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		try {
			list.add(createMenu("Menu1", "Papas fritas y coca",
					price.format(10), "carpet/foto1.png",
					date.parse("2016-03-01"), date.parse("2016-04-01"),
					"11 a 22", 3.5, "Lunes a viernes"));
			list.add(createMenu("Menu2", "Pancho, Papas fritas y coca",
					price.format(15), "carpet/foto2.png",
					date.parse("2016-03-01"), date.parse("2016-04-01"),
					"11 a 22", 3.7, "Lunes a viernes"));
			list.add(createMenu("Menu3", "Papas fritas y jugo",
					price.format(10), "carpet/foto3.png",
					date.parse("2016-03-01"), date.parse("2016-04-01"),
					"11 a 22", 3, "Lunes a viernes"));
			list.add(createMenu("Menu4", "Pancho y coca", price.format(12),
					"carpet/foto4.png", date.parse("2016-04-01"),
					date.parse("2016-05-01"), "11 a 22", 3.5, "Lunes a viernes"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

	private MenuInformation createMenu(String name, String description,
			String price, String addressPhoto, Date fromDate, Date untilDay,
			String effectiveTime, double ranking, String avaliableDays) {
		MenuInformation menu = mock(MenuInformation.class);
		when(menu.getName()).thenReturn(name);
		when(menu.getAddressPhoto()).thenReturn(addressPhoto);
		when(menu.getAvailableDays()).thenReturn(avaliableDays);
		when(menu.getDescription()).thenReturn(description);
		when(menu.getEffectiveTime()).thenReturn(effectiveTime);
		when(menu.getFromDay()).thenReturn(fromDate);
		when(menu.getPrice()).thenReturn(price);
		when(menu.getRanking()).thenReturn(ranking);
		when(menu.getUntilDay()).thenReturn(untilDay);
		return menu;
	}

}
