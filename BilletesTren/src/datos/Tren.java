package datos;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Clase para representar un Tren en el problema de los billetes de tren
 * IMPLEMENTO LA CLASE PARA GESTIONAR LOS VAGONES CON EL ÍNDICE QUE CORRESPONDE A LA 
 * COMPRA/VENTA, ASÍ ABSTRAIGO QUE LO ESTOY GESTIONANDO CON UN ARRAYLIST
 * @author Eva Royo
 *
 */
public class Tren {

	private int numero;
	private LocalDateTime horaSalida;
	private String estacionLlegada;
	private String estacionSalida;
	private ArrayList<Vagon> vagones;



	/**
	 * Construye un tren y crea una lista de vagones vacía
	 * @param numero El número de tren
	 * @param horaSalida La hora de salida del tren
	 * @param estacionLlegada La estación de llegada
	 * @param estacionSalida La estación de salida
	 */
	public Tren(int numero, LocalDateTime horaSalida, String estacionLlegada, String estacionSalida) {
		super();
		this.numero = numero;
		this.horaSalida = horaSalida;
		this.estacionLlegada = estacionLlegada;
		this.estacionSalida = estacionSalida;
		this.vagones = new ArrayList<Vagon>();
	}

	/**
	 * Comprueba si el tiene tiene los vagones llenos
	 * @return
	 */
	public boolean lleno() {
		boolean lleno = true;
		for (Vagon vagon : vagones) {
			lleno = lleno &vagon.lleno(); // si todos están llenos devolverá true, si alguno no lo está devolverá false;
		}
		return lleno;
	}
	/** 
	 * Añade un vagón más al tren.
	 * @param elvagon
	 * @return
	 */
	public boolean agnadeVagon(Vagon elvagon) {
		if (elvagon != null && !vagones.contains(elvagon)) {
			return vagones.add(elvagon);
		}
		return false;
	}
	
	/**
	 * @return the vagones
	 */
	public ArrayList<Vagon> getVagones() {
		return vagones;
	}

	/**
	 * @param vagones the vagones to set
	 */
	public void setVagones(ArrayList<Vagon> vagones) {
		this.vagones = vagones;
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
	 * @return the horaSalida
	 */
	public LocalDateTime getHoraSalida() {
		return horaSalida;
	}

	/**
	 * @param horaSalida the horaSalida to set
	 */
	public void setHoraSalida(LocalDateTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	/**
	 * @return the estacionLlegada
	 */
	public String getEstacionLlegada() {
		return estacionLlegada;
	}

	/**
	 * @param estacionLlegada the estacionLlegada to set
	 */
	public void setEstacionLlegada(String estacionLlegada) {
		this.estacionLlegada = estacionLlegada;
	}

	/**
	 * @return the estacionSalida
	 */
	public String getEstacionSalida() {
		return estacionSalida;
	}

	/**
	 * @param estacionSalida the estacionSalida to set
	 */
	public void setEstacionSalida(String estacionSalida) {
		this.estacionSalida = estacionSalida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estacionLlegada == null) ? 0 : estacionLlegada.hashCode());
		result = prime * result + ((estacionSalida == null) ? 0 : estacionSalida.hashCode());
		result = prime * result + ((horaSalida == null) ? 0 : horaSalida.hashCode());
		result = prime * result + numero;
		result = prime * result + ((vagones == null) ? 0 : vagones.hashCode());
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
		Tren other = (Tren) obj;
		if (estacionLlegada == null) {
			if (other.estacionLlegada != null)
				return false;
		} else if (!estacionLlegada.equals(other.estacionLlegada))
			return false;
		if (estacionSalida == null) {
			if (other.estacionSalida != null)
				return false;
		} else if (!estacionSalida.equals(other.estacionSalida))
			return false;
		if (horaSalida == null) {
			if (other.horaSalida != null)
				return false;
		} else if (!horaSalida.equals(other.horaSalida))
			return false;
		if (numero != other.numero)
			return false;
		if (vagones == null) {
			if (other.vagones != null)
				return false;
		} else if (!vagones.equals(other.vagones))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tren [numero=" + numero + ", horaSalida=" + horaSalida + ", estacionLlegada=" + estacionLlegada
				+ ", estacionSalida=" + estacionSalida + ", nºvagones=" + this.getVagones().size() + "]";
	}

	
}
