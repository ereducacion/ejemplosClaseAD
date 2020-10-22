/**
 * 
 */
package aleatorios;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Eva Royo
 *
 */
public class Registro extends Persona {

	public final static int DIM = 233;
	
	/**
	 * 
	 */
	public Registro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param edad
	 * @param nombre
	 */
	public Registro(int edad, String nombre) {
		super(edad, nombre);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Lee un registro del fichero
	 * 
	 * @param fich
	 * @throws IOException
	 */
	public void read (RandomAccessFile fich) throws IOException  {
		this.setNombre(readString(fich, 32));
		this.setEdad(fich.readInt());		
	}

	/**
	 * Lee una cadena del fichero con una dimensión determinada y lo almacena en el objeto
	 * @param fich
	 * @param dimension
	 * @return
	 * @throws IOException
	 */
	private String readString(RandomAccessFile fich, int dimension) throws IOException {
		char campo[] = new char[dimension];
		for (int i = 0; i < dimension; i++) {
			campo[i] = fich.readChar();
		}
		
		return new String(campo).replace('\0', ' ');
	}
	
	/**
	 * Escribe en el fichero el valor del objeto
	 * @param fich
	 * @throws IOException
	 */
	public void write (RandomAccessFile fich) throws IOException {
		writeString(fich,getNombre(), 32) ;
		fich.writeInt(getEdad());
	}

	/**
	 * Lee una cadena del fichero con una longitud determinada
	 * @param fich
	 * @param cadena
	 * @param dimension
	 * @throws IOException
	 */
	private void writeString(RandomAccessFile fich, String cadena, int dimension) throws IOException {
		StringBuffer buffer= new StringBuffer();
		if (cadena != null) {
			buffer.append(cadena);
		}
		
		buffer.setLength(dimension);
		fich.writeChars(buffer.toString());

	}

	@Override
	public String toString() {
		return "Registro [edad=" + edad + ", nombre=" + nombre + "]";
	}
}
