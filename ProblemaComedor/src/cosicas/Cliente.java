package cosicas;

import java.util.ArrayList;

/**
 * Clase para representar a los clientes del restaurante
 * @author Eva Royo
 *
 */
public class Cliente {

	private ArrayList<Plato> menu;
	private int numeroMesa = 0;
	private int gasto = 0;
	
	/**
	 * Crea un cliente asignándole ya un menú, y un número de mesa. El precio del menú se carga automáticamente 
	 * @param menu {@link ArrayList} con el menú elegido
	 * @param numeroMesa número de mesa en el que está sentado
	 */
	public Cliente(ArrayList<Plato> menu, int numeroMesa) {
		this.menu = menu;
		this.numeroMesa = numeroMesa;
		if (menu != null) {
			for (Plato plato : menu) {
				gasto = gasto + plato.getPrecio();
			}
		}
	}
	
	/**
	 * Crea un cliente a partir de su número de mesa, sin menú ni gasto asociado.
	 * @param numeroMesa Número de mesa donde está el cliente
	 */
	public Cliente(int numeroMesa) {
		this.numeroMesa = numeroMesa;
		this.menu = new ArrayList<Plato>();
	}

	/**
	 * Añade un plato al menú del cliente, calcula el gasto. Sólo permite asingar 2 platos por cliente
	 * @param plato {@link Plato} que se añade al menú del cliente
	 * @return verdad si se ha podido añadir el plato al menu, falso si ya lo  había pedido o intenta pedir más de 2
	 */
	public boolean agnadePlato(Plato plato) {
		if (menu.contains(plato) || menu.size() >= 2) {
			return false;
		}
		gasto = gasto + plato.getPrecio();
		return menu.add(plato);
	}
	
	/**
	 * Retira un plato al menú del cliente
	 * @param plato {@link Plato} que se retira del menú
	 * @return verdad si se ha podido retirar el plato al menu, falso en otro caso
	 */
	public boolean retiraPlato(Plato plato) {
		if (menu.remove(plato)) {
			gasto = gasto - plato.getPrecio();
			return true;
		}
		return false;
	}

	/**
	 * Devuelve el número de mesa en el que está el cliente
	 * @return el número de mesa
	 */
	public int getNumeroMesa() {
		return numeroMesa;
	}

	/**
	 * Asigna un nuevo número de mesa al cliente
	 * @param numeroMesa el numero de mesa
	 */
	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	/**
	 * {@link ArrayList} con los platos del menú del cliente
	 * @return el menu
	 */
	public ArrayList<Plato> getMenu() {
		return menu;
	}

	/**
	 * Asigna un nuevo menú al cliente
	 * @param menu el menú
	 */
	public void setMenu(ArrayList<Plato> menu) {
		this.menu = menu;
	}

	/**
	 * Obtiene el gasto del menú del cliente.
	 * @return the gasto
	 */
	public int getGasto() {
		return gasto;
	}

	/**
	 * Asinga un nuevo gasto al cliente
	 * @param gasto el gasto del cliente
	 */
	public void setGasto(int gasto) {
		this.gasto = gasto;
	}


	/**
	 * Imprime la información del menú elegido del cliente, su nombre y lo que tiene que pagar
	 */
	@Override
	public String toString() {
		if (menu.size() >= 2) {
			return ("Primer plato =" + menu.get(0).getNombre() + "; Segundo plato =" + menu.get(1).getNombre() + " servido en la mesa " + numeroMesa +
				"\nA PAGAR=" + this.gasto);
		} else {
			return ("Primer plato =" + menu.get(0).getNombre() + "; servido en la mesa " + numeroMesa +
					"\nA PAGAR=" + this.gasto);
		}
			
	}

}
