package cosicas;

/**
 * Clase para representar a un ingrediente para crear platos.
 * Se identfica por su nombre y tiene un precio
 * @author Eva Royo
 *
 */
public class Ingrediente {
	
	private String nombre;
	private int precio;

	/**
	 * Asigna nombre del ingrediente
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve el nombre del ingrediente
	 * @param nombre El nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el precio del ingrediente
	 * @return el precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Asigna un nuevo precio al ingrediente
	 * @param precio el precio a asignar
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}


	/**
	 * Crea un {@link Ingrediente} identificado por su nombre y su precio
	 * @param nombre el nombre
	 * @param precio el precio
	 */
	public Ingrediente(String nombre, int precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Ingrediente other = (Ingrediente) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		
		return true;
	}

	

}
