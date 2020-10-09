package cosicas;

import java.util.ArrayList;

/**
 * Clase para representar los platos que van a cocinarsen en un restaurante
 * Cada plato está formado por una lista de {@link Ingrediente} y tiene un coste igual
 * al coste de cada ingrediente más 1 euro de gastos de restaurante
 * @author Eva Royo
 *
 */
public class Plato {

	private String nombre;
	private ArrayList<Ingrediente> ingredientes;
	private int precio;
	
	/**
	 * Crea un plato con el nombre indicado y asigno 1 euro de gasto fijo
	 * @param nombre el nombre del plato
	 */
	public Plato (String nombre) {
		this.nombre = nombre;
		ingredientes = new ArrayList<Ingrediente>();
		precio = 1; // cargo el euro 
	}
	
	/**
	 * Crea un plato con el nombre indicado que contendrá los ingredientes que se pasan como parámetro
	 * @param nombre El nombre del plato
	 * @param ingredientes {@link ArrayList} con los {@link Ingrediente} del {@link Plato}
	 */
	public Plato(String nombre, ArrayList<Ingrediente> ingredientes) {
		this.nombre = nombre;
		// cuidado con esto!! es necesario clonarlo?
		this.ingredientes = ingredientes;
		precio = 1;
		if (!ingredientes.isEmpty()) {
			for (Ingrediente i : ingredientes) {
				precio = precio + i.getPrecio();
			}
		}
	}
	
	/**
	 * Añade el ingrediente indicado
	 * @param i {@link Ingrediente} que se va a añadir al plato
	 * @return verdad si la lista de {@link Ingrediente} ha cambiado
	 */
	public boolean agnadeIngrediente (Ingrediente i) {
		// Controlar que no exista ya el ingrediente
		if (!ingredientes.contains(i) && ingredientes.add(i)) {
			precio = precio + i.getPrecio();
			return true;
		}
		return false;
	}
	
	/**
	 * Elimina el ingrediente indicado
	 * @param i {@link Ingrediente} que se va a eliminar del plato
	 * @return verdad si el {@link Ingrediente} existía en la lista
	 */
	public boolean retiraIngrediente (Ingrediente i) {
		if (ingredientes.remove(i) ) {
			precio = precio - i.getPrecio();
			return true;
		}
		return false;
	}

	
	/**
	 * Devuelve un {@link ArrayList} con los ingredientes del plato
	 * @return the ingredientes
	 */
	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	/**
	 * Asigna una lista de ingredientes al plato
	 * @param ingredientes the ingredientes to set
	 */
	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	/**
	 * Devuelve el precio del plato
	 * @return el precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Asigna un precio al plato
	 * @param precio el precio a asignar
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * Devuelve el nombre del plato
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna un nuevo nombre al plato
	 * @param nombre el nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el string con la lista de los ingredientes que componen el plato separadas por ,
	 * @return La lista de los ingredientes
	 */
	public String imprimeIngredientes() {
		String cadenaIngredientes = "";
		
		if (this.ingredientes == null || this.ingredientes.isEmpty()) return "";
		for (Ingrediente ingrediente : this.ingredientes) {
			cadenaIngredientes =  cadenaIngredientes + "," + ingrediente.getNombre();
		}
		return cadenaIngredientes;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredientes == null) ? 0 : ingredientes.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + precio;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plato other = (Plato) obj;
		if (ingredientes == null) {
			if (other.ingredientes != null)
				return false;
		} else if (!ingredientes.equals(other.ingredientes))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio != other.precio)
			return false;
		return true;
	}
}
