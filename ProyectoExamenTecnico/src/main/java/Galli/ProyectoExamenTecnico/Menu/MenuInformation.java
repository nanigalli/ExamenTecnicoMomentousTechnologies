package Galli.ProyectoExamenTecnico.Menu;

import java.util.Date;

/*Esta interfaz sirve para obtener los datos de un menu.*/
public interface MenuInformation {

	public String getName();

	public String getDescription();

	public String getPrice();

	public String getAddressPhoto();

	public Date getFromDay();

	public Date getUntilDay();

	public String getEffectiveTime();

	public double getRanking();

	public String getAvailableDays();

}
