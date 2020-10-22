package datos;
import java.time.LocalDateTime;

public class Billete {

	private int numero;
	private LocalDateTime fecha;
	private Tren tren;
	private Vagon vagon;
	private int precio;
	private int asiento;
	
	

	/**
	 * @param numero
	 * @param fecha
	 * @param tren
	 * @param vagon
	 * @param precio
	 * @param asiento
	 */
	public Billete(int numero, LocalDateTime fecha, Tren tren, Vagon vagon, int precio, int asiento) {
		this.numero = numero;
		this.fecha = fecha;
		this.tren = tren;
		this.vagon = vagon;
		this.precio = precio;
		this.asiento = asiento;
	}
	
	
	/**
	 * @return the asiento
	 */
	public int getAsiento() {
		return asiento;
	}


	/**
	 * @param asiento the asiento to set
	 */
	public void setAsiento(int asiento) {
		this.asiento = asiento;
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
	 * @return the fecha
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the tren
	 */
	public Tren getTren() {
		return tren;
	}
	/**
	 * @param tren the tren to set
	 */
	public void setTren(Tren tren) {
		this.tren = tren;
	}
	/**
	 * @return the vagon
	 */
	public Vagon getVagon() {
		return vagon;
	}
	/**
	 * @param vagon the vagon to set
	 */
	public void setVagon(Vagon vagon) {
		this.vagon = vagon;
	}
	/**
	 * @return the precio
	 */
	public int getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + numero;
		result = prime * result + precio;
		result = prime * result + ((tren == null) ? 0 : tren.hashCode());
		result = prime * result + ((vagon == null) ? 0 : vagon.hashCode());
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
		Billete other = (Billete) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (numero != other.numero)
			return false;
		if (precio != other.precio)
			return false;
		if (tren == null) {
			if (other.tren != null)
				return false;
		} else if (!tren.equals(other.tren))
			return false;
		if (vagon == null) {
			if (other.vagon != null)
				return false;
		} else if (!vagon.equals(other.vagon))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Billete [numero=" + numero + ", fecha=" + fecha + ", tren=" + tren + ", vagon=" + vagon + ", precio="
				+ precio + "]";
	}

	/**
	 * Compara por orden ascendente de fecha
	 * @param bil Billete a compara
	 * @return 1 si el billete a comparar es posterior en fecha, -1 si anterior y 0 si es la misma fecha.
	 */
	public int comparaPorFecha(Billete bil) {
		if (this.fecha.isAfter(bil.getFecha())) {
			return 1;
		} else if (this.fecha.isBefore(bil.getFecha())) {
			return -1;
		} else {
			return 0;
		}
	}
	
	/**
	 * Compara de menor numeración a mayor numeración
	 * @param bil Billete a compara
	 * @return 1 si el billete a comparar tiene una numeración menor, -1 si es mayor y 0 si es igual
	 */
	public int comparaPorNumBillete(Billete bil) {
		if (this.getNumero() > bil.getNumero()) {
			return 1;
		} else if (this.getNumero() < bil.getNumero()) {
			return -1;
		} else {
			return 0;
		}
	}

}
