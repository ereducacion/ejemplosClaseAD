import java.util.HashSet;
import java.util.Set;

public class Equipo {
	
	private String nombre;
	private String deporte;
	private Set<Jugador> jugadores;

	/**
	 * @param nombre
	 */
	public Equipo(String nombre, String deporte) {
		super();
		this.nombre = nombre;
		this.deporte = deporte;
		jugadores = new HashSet<Jugador>();
	}
	

	// getters y setters
	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public Set<Jugador> getJugadores() {
		return jugadores;
	}
	
	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public void addJugador(Jugador jugador) {
		jugadores.add(jugador);
	}
	
}
