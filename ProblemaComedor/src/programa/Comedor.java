package programa;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import cosicas.*;

public class Comedor {

	public Comedor() {
		
	}
	
	/**
	 * Creación de un restaurante, un comedor y carga de datos.
	 * Lista los platos del restaurante, lista de los platos del menú y 
	 * lista lo que un cliente ha pedido y lo que tiene que pagar
	 * @param args nada
	 */
	public static void main(String[] args) {
		
		Restaurante restaurante = new Restaurante("COMECOME");
		Random azar = new Random();
		int NUMPLATOSCARTA = 6;
		int NUMPLATOS = 15;
		int NUMINGREDIENTES = 30;

		// empiezo creando en Comedor
		Comedor comedor = new Comedor();
		
		// Creo una serie de 10 platos a partir de 25 ingredientes
		ArrayList<Plato> listaPlatos = comedor.creaPlatos(NUMPLATOS, NUMINGREDIENTES);
		
		// asignar los platos al restaurante
		for (Plato plato : listaPlatos) {
			restaurante.agnadePlatoLista(plato);
		}
		
		// asigno los platos para la carta DE HOY (NUMPLATOSCARTA al azar)
		
		// Voy atendiendo a una lista de clientes
		
		// listado de lo que han pedido clientes

		// listar los platos que prepara el restaurante
		
		// listar los platos de la carta
		
	}

	/**
	 * Lista los platos de la carta y espera que el usuario elija uno, en caso de introducir un número erroneo
	 * le asigna el primero plato de la carta.
	 * @param carta La carta del restaurante
	 * @param texto "Primero" o "Segundo" indicando el plato que está preguntando
	 * @return El plato elegido
	 */
	private Plato eligePlato(ArrayList<Plato> carta, String texto) {
        // IMPLEMENTAR
		return null;
	}

	/**
	 * Pregunta al cliente en qué numero de mesa está. Aceptará números de mesa repetidos
	 * @return El cliente creado o <code>null</code> si se desea salir de la pregunta
	 */
	private Cliente atiendeCliente() {
        // IMPLEMENTAR
		return null;
	}

	/**
	 * Lista los platos con un mensaje inicial
	 * @param platos {@link ArrayList} Los platos que se van a listar
	 * @param mensaje {@link String} El mensaje que encabeza los platos
	 */
	private void listaPlatos(ArrayList<Plato> platos, String mensaje) {
		
		System.out.println("------------------------------");
		System.out.println("-------" + mensaje.toUpperCase()+ "-------");
		
		int i =0;
		for (Plato plato : platos) {
			System.out.print(i + "-"+ plato.getNombre() + "(" + plato.imprimeIngredientes() + ")" + "........");
			System.out.println(plato.getPrecio());
			i++;
		}
		System.out.println("------------------------------");
		
	}

	/**
	 * Crea un {@link ArrayList} con n platos basados en una cantidad de ingredientes que se pasa
	 * como parámetro 
	 * @param numPlatos Número de platos que contendrá el arrayList
	 * @param numIngredientes Número de ingredientes que preparo para crear los platos
	 * @return el {@link ArrayList} con los platos y sus precios
	 */
	private ArrayList<Plato> creaPlatos(int numPlatos, int numIngredientes) {
        // IMPLEMENTAR
		return null;
	}

	

}
