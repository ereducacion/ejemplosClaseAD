package datos;

import java.util.Arrays;

/**
 * Clase para representar un vagón del tren
 * Formado por un array y un número.
 * Cada componente del array representa a un asiento del vagón, si la componente
 * es 0 es porque no hay billete asignado a él, sino contiene el número el billete.
 * @author Eva Royo
 *
 */
public class Vagon {

	private int numero;
	/** contendrá el número del billete que está ocupando el asiento correspondiente */
	private int[] asientos;
	/** numero de asientos que tiene un vagón **/
	final static int NUMASIENTOS = 3;
	
	
	/**
	 * Creo un vagón el número que se pasa como parámetro y preparo un array con
	 * los billetes que va a tener el vagón.
	 * @param numero
	 */
	public Vagon(int numero) {
		super();
		this.numero = numero;
		this.asientos = new int[NUMASIENTOS];
		// inicializo los asientos a 0
		for (int i = 0; i < asientos.length; i++) {
			this.asientos[i] = 0;
		}
	}

	/**
	 * Asigna un billete al asiento que se especifica en el parámetro 
	 * @param numBillete El billete a asignar
	 * @param asiento El asiento al que corresponde el billete
	 * @return falso si el asiento ya estaba ocupado, verdad si se realiza bien la acción
	 */
	public boolean asignaBillete (int numBillete, int asiento) {
		if (this.asientos[asiento -1] != 0) {
			// el asiento ya está ocupado
			return false;
		}
		this.asientos[asiento -1] = numBillete;
		return true;
	}
	
	/**
	 * Libera un asiento dentro del vagón
	 * @param asiento
	 * @return verdad si todo ha ido bien, falso si el asiento ya estaba libre
	 */
	public boolean liberaBillete (int asiento) {
		if (this.asientos[asiento -1] == 0) {
			// el asiento ya estaba libre
			return false;
		}
		this.asientos[asiento -1] = 0;
		return true;
	}

	
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	/**
	 * @return the asientos
	 */
	public int[] getAsientos() {
		return asientos;
	}
	
	
	/**
	 * @param asientos the asientos to set
	 */
	public void setAsientos(int[] asientos) {
		this.asientos = asientos;
	}


	/**
	 * Chequea si el asiento está libre en el vagón
	 * @param asiento El número de asiento
	 * @return true si no hay billete en ese asiento, false en entro caso
	 */
	public boolean asientoLibre(int asiento) {
		return this.getAsientos()[asiento-1] == 0;
	}

	/**
	 * Devuelve una lista de strings con los números de los asientos que hay libres en este vagón
	 * @return {@link String}
	 */
	public String asientosLibres() {
		
		String losAsientos = new String("");
		for (int i = 0; i < asientos.length; i++) {
			if (asientos[i] == 0) {
				losAsientos = losAsientos + " " + (i+1);
			}
		}
		return losAsientos;
	}
	
	/**
	 * Devuelve una lista de strings con los números de los asientos ocupados este vagón
	 * @return {@link String}
	 */
	public String asientosOcupados() {
		
		String losAsientos = new String("");
		for (int i = 0; i < asientos.length; i++) {
			if (asientos[i] != 0) {
				losAsientos = losAsientos + " " + (i+1);
			}
		}
		return losAsientos;
	}


	/**
	 * Devuelve una lista de strings con los números de los billetes que se han vendido en este vagón
	 * @return {@link String}
	 */
	public String billetesVendidos() {
		
		String losBilletes = new String("");
		for (int i = 0; i < asientos.length; i++) {
			if (asientos[i] != 0) {
				losBilletes = losBilletes + " " + asientos[i];
			}
		}
		return losBilletes;
	}

	/**
	 * Devuelve verdad si el vagón está lleno
	 * @return
	 */
	public boolean lleno() {
		for (int i = 0; i < asientos.length; i++) {
			if (asientos[i] == 0) {
				// en cuanto encuentra un asiento libre, ya no está lleno
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Vagon " + numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(asientos);
		result = prime * result + numero;
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
		Vagon other = (Vagon) obj;
		if (!Arrays.equals(asientos, other.asientos))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}


	
}
