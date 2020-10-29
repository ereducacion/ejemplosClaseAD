import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibreriaUtilidades {
	


	/////////////////////////////////////////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	///////////CREAR VALORES AL AZAR/////////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	static public String a_letraAzar() {
		Random azar= new Random();

		String letraAzar[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S",
				"T","U","V","W","X","Y","Z"};

		return letraAzar[azar.nextInt(letraAzar.length)];
	}
	
	
	static public String a_nombreAzar() {
		Random azar= new Random();

		String nombreAzar[]={"Santiago","Sebastián","Diego","Thiago","Nicolás","Samuel","Dario","Alejandro","Mateo",
				"Ángel","Matías","Gabriel","Tomás","David","Emiliano","Andrés","Joaquín","Carlos","Alexander","Adrián","Lucas",
				"Sofía","Camila","Valentina","Isabella","Valeria","Daniela","Mariana","Sara","Victoria","Gabriela","Ximena",
				"Andrea","Natalia","Mía","Martina","Lucía","Samantha","María","Paula","Nicole"};

		return nombreAzar[azar.nextInt(nombreAzar.length)];
	}

	static public String a_apellidoAzar(){
		Random azar= new Random();

		String apellidoAzar[]={"Abadía","Abarca","Abellán","Abiego","Acorella","Baldovinos","Bandrés","Cabra","Cajal","Calasanz",
				"Samper","Latorre", "Escolano", "Cebrián", "Clemente", "Navarro","García","Hernández","Martínez","López",
				"Pérez","Fernández","Ruiz","Sánchez","Rodríguez","Gómez","González","Jiménez","Cruz","Requena","Moreno","Reyes",
				"Morillas","Cortes","Ortiz","Romero","Medialdea","Expósito","Raya","Sierra","Membrilla","Casado","Amezcua","Muñoz",
				"Santiago","Delgado","Moya","Serrano","Contreras","Hidalgo","Mesa","Pozo","Soria","Vera","Varón","Parra"};

		return apellidoAzar[azar.nextInt(apellidoAzar.length)];
	}

	static public String a_marcaAzar(){
		Random azar= new Random();
		String marcaAzar[]={"Apple","Google","Coca-Cola","Microsoft","IBM","Toyota","Samsung","GE","McDonald’s","Amazon",
				"BMW","Mercedes-Benz","Disney","Intel","Cisco","Oracle","Nike","HP","Honda","Louis Vuitton","H&M","Gillette",
				"Facebook","Pepsi","American Express","SAP","IKEA","Pampers","UPS","Zara","Budweiser","eBay","J.P. Morgan",
				"Nescafé","HSBC","Ford","Hyundai","Canon","Hermès","Accenture","L’Oréal","Audi","Citi","Goldman Sachs",
				"Philips","AXA","Nissan","Gucci","Danone","Nestlé","Siemens","Allianz","Colgate","Porsche","Cartier",
				"Sony","3M","Morgan Stanley","Visa","Adidas","Thomson Reuters","Discovery","Panasonic","Tiffany & Co.",
				"Starbucks","Adobe","Prada","Santander","Xerox","Caterpillar","Burberry","Kia","KFC","MasterCard",
				"Johnson & Johnson","Shell","Harley-Davidson","DHL","Sprite","Lego","John Deere","Jack Daniel’s",
				"Chevrolet","FedEx","Land Rover","Huawei","Heineken","MTV","Ralph Lauren","Johnnie Walker","Corona",
				"Smirnoff","Kleenex","Hugo Boss","PayPal","Mini","Moët & Chandon","Lenovo"};
		return marcaAzar[azar.nextInt(marcaAzar.length)];
	}

	static public String a_marcaCoche(){
		Random azar = new Random();
		String marcaCoche[]={"BMW","AUDI","OPEL","KIA","PORCHE","RENAULT","PEUGEOT","MERCEDES","MINI","SMART","CITROEN","FORD","SEAT","WOLSKWAGEN","VOLVO","LEXUS"};
		return marcaCoche[azar.nextInt(marcaCoche.length)];



	}

	static public String a_provinciaAzar(){
		Random azar= new Random();
		String provincia[]= {"Alava","Albacete","Alicante","Almería","Asturias","Avila","Badajoz","Barcelona","Burgos","Cáceres",
				"Cádiz","Santander","Castellón","Ciudad Real","Córdoba","La Coruña","Cuenca","Gerona","Granada","Guadalajara",
				"Guipúzcoa","Huelva","Huesca","Islas Baleares","Jaén","León","Lérida","Lugo","Madrid","Málaga","Murcia","Navarra",
				"Orense","Palencia","Las Palmas","Pontevedra","La Rioja","Salamanca","Segovia","Sevilla","Soria","Tarragona",
				"Santa Cruz de Tenerife","Teruel","Toledo","Valencia","Valladolid","Vizcaya","Zamora","Zaragoza"};
		return provincia[azar.nextInt(provincia.length)];
	}

	static public String a_comunidadAzar(){
		Random azar= new Random();

		String comunidad[] = {"Andalucía", "Aragón", "Canarias", "Cantabria", "Castilla y León", "Castilla-La Mancha", "Cataluña", "Ceuta",
				"Comunidad Valenciana", "Comunidad de Madrid", "Extremadura", "Galicia", "Islas Baleares", "La Rioja", "Melilla", "Navarra", 
				"País Vasco", "Principado de Asturias", "Región de Murcia"};

		return comunidad[azar.nextInt(comunidad.length)];
	}

	static public String a_dniAzar(){
		Random azar= new Random();
		String dni;
		String letra[]={"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
		int numero, calculo;
		numero=azar.nextInt((99999999-10000000)+1)+10000000;
		calculo=numero%23;
		dni=numero+letra[calculo];
		return dni;
	}

	static public boolean a_validaDni(String DNI){
		String dato = DNI;
		boolean estado=false;
		int num;
		String letra[]={"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
			num = Integer.parseInt(dato.substring(0, 8));
			if(dato.substring(8, 9).toUpperCase().compareTo(letra[num%23])==0){
				estado=true;
			}else{
				//System.out.println("DNI erroneo");
				estado=false;
			}
		return estado;
	}

	static public int a_enteroAzar(int desde, int hasta){
		Random azar= new Random();
		return azar.nextInt(hasta-desde+1)+desde;
	}

	static public double a_decimalAzar(int desde, int hasta){
		Random azar= new Random();
		return (azar.nextInt((int)((hasta-desde)*100+1))+desde*100) / 100.00;
	}
	
	static public String a_enfermedadAzar(){
		Random azar= new Random();

		String enfermedad[] = {"Absceso dental", "Accidente Cerebro Vascular (Ictus)", "Alcoholismo", 
				"Anemia de Fanconi", "Anemias","Anginas", "Anorexia nerviosa", "Apnea del Sueño", 
				"Asma bronquial", "Aterosclerosis", "Bronquiectasias", "Bronquitis Crónica", 
				"Brucelosis", "Bulimia", "Calambres en los Músculos", "Cálculos renales", 
				"Callos y Callosidades", "Cefaleas de Tensión", "Ciática", "Cólico de Riñón", 
				"Colitis Ulcerosa", "Colon Irritable", "Coma Etílico", "Congelación", 
				"Degeneración Macular del Ojo", "Depresión", "Deshidratación", 
				"Desmayos y Mareos", "Diarrea Clínica", "Diarrea del Viajero", 
				"Dolor de Cabeza", "Dolor de Espalda", "Dolor de Garganta", "Dolor de Oído", 
				"Embarazo en la Adolescencia", "Enfermedad de Crohn", "Enfermedad de Parkinson", 
				"Estreñimiento", "Fisura anal", "Ganglión", "Glositis", "Gota", "Gripe", "Hematémesis", 
				"Hemorroides", "Hernia Discal", "Hiperlipemias y colesterol Elevado  ", 
				"Hipertensión arterial", "Hipertensión intracraneal idiopática", "Hipocondria", "Hipotensión",
				"Hongos de la piel", "Hongos en las uñas", "Intoxicación por Alcohol", "Juanetes", 
				"Laberintitis", "Labios Agrietados", "Laringitis", "Latigazo Cervical", "Lengua Geográfica", 
				"Mareo", "Mastoiditis", "Migraña", "Obesidad", "Orinar por la noche", 
				"Parálisis Facial de Bell", "Piel seca. Xerosis", "Reflujo Gastroesofágico", "Resfriado", 
				"Ronquidos", "Rotura de Tímpano", "Sangrado Nasal", "Sangrado Rectal", "Sangre en el Esputo", 
				"Sangre en la Orina", "Síndrome de Astenia Crónica", "Síndrome de Piernas Inquietas", 
				"Síndrome hepático renal", "Síndrome nefrótico", "Sinusitis", "Talasemia", 
				"Tendinitis. Bursitis", "Tic en el Párpado", "Varices", "Vértigo"};

		return enfermedad[azar.nextInt(enfermedad.length)];
	}
	
	static public String a_medicamentoAzar(){
		Random azar= new Random();

		String medicamento[] = {"Nolotil.", "Efferalgan.", "Gelocatil.", "Adiro 100.", "Augmentine.", 
				"Orfidal Wyeth.", "Neobrufen.", "Dianben.", "Antidiabéticos orales.", "Termalgin.", 
				"Lexatin.", "Almax.", "Trankimazin.", "Flumil.", "Sintrom.", "Frenadol complex.", 
				"Aspirina adultos.", "Dalsy.", "Espidifen.", "Tranxilium.", "Omeprazol Ratiopharm.", 
				"Cardyl.", "Yasmín.", "Seguril.", "Omeprazol Cinfamed.", "Flutox.", "Zarator.", "A.A.S.", 
				"Plantaben.", "Noctamid.", "Enantyum.", "Zaldiar.", "Daflon 500.", "Tromalyt.", 
				"Hidrosaluretil.", "Prevencor.", "Carduran Neo.", "Duphalac.", "Ibuprofeno Kern.", 
				"Myolastan.", "Adiro 300.", "Algidol.", "Mucosan.", "Voltarén.", "Eutirox.", "Norvas.", 
				"Clamoxyl.", "Coropres.", "Paracetamol Kern.", "Serc.", "Idaptan.", "Lizipaina.", "Plavix.", 
				"Idalprem.", "Metformina Sandoz.", "Motilium.", "Ebastel.", "Actonel.", "Tardyferon.", 
				"Analgilasa.", "Levothroid.", "Metamizol Normon.", "Diazepan Prodes.", "Couldina.", 
				"Pantecta.", "Fortasec.", "Dogmatil.", "Fero-gradumet.", "Lorazepam Normon.", "Singulair.", 
				"Omeprazol Pensa.", "Zyloric.", "Amoxicilina Normon.", "Diane 35.", "Cozaar.", 
				"Ibuprofeno Cinfa.", "Aero-red.", "Aspirina C.", "Acfol.", "Co-Diován.", 
				"Lormetazepam Normon.", "Paracetamol Pharmagenus.", "Primperan.", 
				"Enalapril Ratiopharm efg.", "Xumadol.", "Aerius.", "Polaramine.", "Acovil.", "Zinnat.", 
				"Omeprazol Davur.", "Anagastra.", "Sutril.", "Antalgin.", "Fosamax.", "Furosemida Cinfa.", 
				"Tertensif Retard.", "Stilnox.", "Flatoril.", "Monurol.", "Airtal."};

		return medicamento[azar.nextInt(medicamento.length)];
	}

static public String a_ingredientesAzar() {
		Random azar= new Random();

		String IngredienteAzar[]={"huevos","patatas","macarrones","spaguetti","judias verdes","chorizo","jamon","coliflor","brocoli",
				"cebolla","calabacin","aceitunas","panceta","pimiento","champiñones","tofu","bacalao","merluza","salmon","gazpacho","pepino",
				"atun","tomate","remolacha","pollo","ternera","ternasco","leche","patatas a lo pobre","lechuga","albondigas","jamon york",
				"sanjacobos","salchichas","arroz","platano","piña","pizza","oregano","tomillo","guisantes"};

		return IngredienteAzar[azar.nextInt(IngredienteAzar.length)];
	}
	
	
	


	/////////////////////////////////////////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	//////////METODOS LEER POR TECLADO///////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////

	static public String t_pedirCadena(int opcion, String texto) {		
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(
				System.in));
		String dato="";

		switch(opcion){
		case 0://mientras que cometan fallo que sigan introduciendo datos
			boolean error = true;
			while (error) {
				try {
					System.out.println(texto);
					dato = dataIn.readLine();
					error=false;					
				} catch (IOException e) {
					System.out.println("Vuelve a inroducir el dato, por favor: ");
					error = true;
				}
			}
			break;
		case -1://solo una vez
			boolean er = true;
			while (er) {
				try {
					System.out.println(texto);
					dato = dataIn.readLine();
					er=false;					
				} catch (IOException e) {
					System.out.println("Error dato mal introducido");
					er = false;
				}
			}

			break;


		}
		return dato;

	}

	static public int t_pedirEnteroValidar(int opcion, String texto) {
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(
				System.in));
		int dato=0;
		switch(opcion){
		case 0://hasta que de dato correcto
			boolean error = true;
			while (error) {
				try {
					System.out.println(texto);
					dato = Integer.parseInt(dataIn.readLine());
					error=false;
				} catch (IOException e) {
					System.out.println("Vuelve a inroducir el dato, por favor");
					error = true;
				} catch(NumberFormatException e){
					System.out.println("El dato introducido no es entero");
					System.out.println("Vuelve a inroducir el dato, por favor: ");
					error=true;
				}
			}
			break;
		case -1://Un fallo y fuera
			boolean er = true;
			while (er) {
				try {
					System.out.println(texto);
					dato = Integer.parseInt(dataIn.readLine());
					er=false;
				} catch (IOException e) {
					System.out.println("Dato no correcto");
					er = false;
				} catch(NumberFormatException e){
					System.out.println("El dato introducido no es entero");
					er=false;
				}
			}
			break;
		default :
			for(int k=0; k<opcion; k++ ){
				boolean err = true;
				while (err) {
					try {
						System.out.println(texto);
						dato = Integer.parseInt(dataIn.readLine());
						err=false;
						k=opcion-1;
					} catch (IOException e) {
						System.out.println("El dato introducido no es entero");
						err = false;
						if(k==(opcion-2)){System.out.println("Ultimo intento");}
					} catch(NumberFormatException e){
						System.out.println("El dato introducido no es entero");
						err=false;
						if(k==(opcion-2)){System.out.println("Ultimo intento");}
					}
				}
			}
		}
		return dato;

	}

	/*LONG*/
	static public Long t_pedirLongValidar(int opcion, String texto) {
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(
				System.in));
		Long dato=0l;
		switch(opcion){
		case 0://hasta que de dato correcto
			boolean error = true;
			while (error) {
				try {
					System.out.println(texto);
					dato = Long.parseLong(dataIn.readLine());
					error=false;
				} catch (IOException e) {
					System.out.println("Vuelve a inroducir el dato, por favor");
					error = true;
				} catch(NumberFormatException e){
					System.out.println("El dato introducido no es entero");
					System.out.println("Vuelve a inroducir el dato, por favor: ");
					error=true;
				}
			}
			break;
		case -1://Un fallo y fuera
			boolean er = true;
			while (er) {
				try {
					System.out.println(texto);
					dato = Long.parseLong(dataIn.readLine());
					er=false;
				} catch (IOException e) {
					System.out.println("Dato no correcto");
					er = false;
				} catch(NumberFormatException e){
					System.out.println("El dato introducido no es entero");
					er=false;
				}
			}
			break;
		default :
			for(int k=0; k<opcion; k++ ){
				boolean err = true;
				while (err) {
					try {
						System.out.println(texto);
						dato = Long.parseLong(dataIn.readLine());
						err=false;
						k=opcion-1;
					} catch (IOException e) {
						System.out.println("El dato introducido no es entero");
						err = false;
						if(k==(opcion-2)){System.out.println("Ultimo intento");}
					} catch(NumberFormatException e){
						System.out.println("El dato introducido no es entero");
						err=false;
						if(k==(opcion-2)){System.out.println("Ultimo intento");}
					}
				}
			}
		}
		return dato;

	}

	static public double t_decimal(int opcion, String texto) {
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(
				System.in));
		double dato=0;

		switch(opcion){
		case 0://Repetir hasta que nos den un dato correcto
			boolean error = true;
			while (error) {			
				try {
					System.out.println(texto);
					dato = Double.parseDouble(dataIn.readLine());
					error=false;
				} catch (IOException e) {
					System.out.println("Vuelve a inroducir el dato, por favor: ");
					error = true;
				} catch(NumberFormatException e){
					System.out.println("El dato introducido no es decimal");
					System.out.println("Vuelve a inroducir el dato, por favor: ");
					error=true;
				}
			}
			break;
		case -1://Solo permite introducir un dato y si no lo meten correctamente se cierra el programa
			boolean er = true;
			while(er){
				try {
					System.out.println(texto);
					dato = Double.parseDouble(dataIn.readLine());
					er=false;
				} catch (IOException e) {
					System.out.println("El dato introducido no es decimal ");
					er = false;
				} catch(NumberFormatException e){
					System.out.println("El dato introducido no es decimal");				
					er=false;
				}
			}
			break;
		default:

			for(int k=0; k<opcion; k++ ){
				boolean err = true;
				while(err){
					try {
						System.out.println(texto);
						dato = Double.parseDouble(dataIn.readLine());
						err=false;
						k=opcion-1;
					} catch (IOException e) {
						if(k<(opcion-2)){System.out.println("El dato introducido no es decimal. \nVuelve a inroducir el dato, por favor: ");}
						err = false;
						if(k==(opcion-2)){System.out.println("Ultimo intento");}
					} catch(NumberFormatException e){
						if(k<(opcion-2)){System.out.println("El dato introducido no es decimal. \nVuelve a inroducir el dato, por favor: ");}
						err=false;
						if(k==(opcion-2)){System.out.println("El dato introducido no es decimal. \nUltimo intento");}
					}
				}
			}
			break;
		}
		return dato;

	}
	static public float t_pedirFloat(int opcion, String texto) {
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(
				System.in));
		float dato=0;
		switch(opcion){
		case 0://Sigue hasta que nos den un dato correcto
			boolean error = true;
			while (error) {
				try {
					System.out.println(texto);
					dato = Float.parseFloat(dataIn.readLine());
					error=false;
				} catch (IOException e) {
					System.out.println("Vuelve a inroducir el dato, por favor: ");
					error = true;
				} catch(NumberFormatException e){
					System.out.println("El dato introducido no es decimal");
					System.out.println("Vuelve a inroducir el dato, por favor: ");
					error=true;
				}
			}
			break;
		case -1://Un fallo y fuera
			boolean erro = true;
			while (erro) {
				try {
					System.out.println(texto);
					dato = Float.parseFloat(dataIn.readLine());
					erro=false;
				} catch (IOException e) {
					System.out.println("El dato introducido no es decimal");
					//System.out.println("Vuelve a inroducir el dato, por favor: ");
					erro = false;
				} catch(NumberFormatException e){
					System.out.println("El dato introducido no es decimal");
					//System.out.println("Vuelve a inroducir el dato, por favor: ");
					erro=false;
				}
			}
			break;
		default:
			for(int k=0; k<opcion; k++ ){
				boolean err = true;
				while (err) {
					try {
						System.out.println(texto);
						dato = Float.parseFloat(dataIn.readLine());
						err=false;
					} catch (IOException e) {
						if(k<(opcion-2)){System.out.println("El dato introducido no es decimal. \nVuelve a inroducir el dato, por favor: ");}
						if(k==(opcion-2)){System.out.println("Ultimo intento");}
						err = false;
					} catch(NumberFormatException e){
						if(k<(opcion-2)){System.out.println("El dato introducido no es decimal. \nVuelve a inroducir el dato, por favor: ");}
						if(k==(opcion-2)){System.out.println("Ultimo intento");}

						err=false;
					}
				}
			}
			break;
		}
		return dato;

	}


	static public String t_iban(int opcion, String texto) {		
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(
				System.in));
		String dato="";


		switch(opcion){
		case 0://mientras que cometan fallo que sigan introduciendo datos
			do{
				boolean error = true;
				while (error) {
					try {
						System.out.println(texto);
						dato = dataIn.readLine();
						error=false;						
					} catch (IOException e) {
						System.out.println("Vuelve a inroducir el dato, por favor: ");
						error = true;
					}
				}

				Pattern pat = Pattern.compile("^[a-zA-Z]{2}[0-9]{22}$");
				Matcher mat = pat.matcher(dato);
				if(mat.find()){
					System.out.println("IBAN Válido");

				}else{
					System.out.println("IBAN No Válido");
					dato=null;
				}
			}while(dato==null);
			break;

		case -1://solo una vez
			boolean error = true;
			while (error) {
				try {
					System.out.println(texto);
					dato = dataIn.readLine();
					error=false;						
				} catch (IOException e) {
					System.out.println("Vuelve a inroducir el dato, por favor: ");
					error = true;
				}
			}
			Pattern patr = Pattern.compile("^[a-zA-Z]{2}[0-9]{22}$");
			Matcher matc = patr.matcher(dato);
			if(matc.find()){
				System.out.println("IBAN Válido");

			}else{
				System.out.println("IBAN No Válido");
				dato=null;
			}
			break;

		}
		return dato;
	}

	static public String t_identificacion(int opcion, String texto) {		
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(
				System.in));
		String dato="";


		switch(opcion){
		case 0://mientras que cometan fallo que sigan introduciendo datos
			do{
				boolean error = true;
				while (error) {
					try {
						System.out.println(texto);
						dato = dataIn.readLine();
						error=false;						
					} catch (IOException e) {
						System.out.println("Vuelve a inroducir el dato, por favor: ");
						error = true;
					}
				}

				Pattern pat = Pattern.compile("^[klmxyzKLMXYZ\\d]{1}[0-9]{7}[a-zA-Z&&[^iouIOU]]{1}$");
				Matcher mat = pat.matcher(dato);
				if(mat.find()){
					System.out.println("Documento identificación Válido");

				}else{
					System.out.println("Documento identificación No Válido");
					dato=null;
				}
			}while(dato==null);
			break;

		case -1://solo una vez
			boolean error = true;
			while (error) {
				try {
					System.out.println(texto);
					dato = dataIn.readLine();
					error=false;						
				} catch (IOException e) {
					System.out.println("Vuelve a inroducir el dato, por favor: ");
					error = true;
				}
			}
			Pattern patr = Pattern.compile("^[klmxyzKLMXYZ\\d]?[0-9]{7}[a-zA-Z&&[^iouIOU]]{1}$");
			Matcher matc = patr.matcher(dato);
			if(matc.find()){
				System.out.println("Documento identificación Válido");

			}else{
				System.out.println("Documento identificación No Válido");
				dato=null;
			}
			break;

		}
		return dato;
	}

	static public String t_fecha(int opcion, String texto) {		
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(
				System.in));
		String dato="";


		switch(opcion){
		case 0://mientras que cometan fallo que sigan introduciendo datos
			do{
				boolean error = true;
				while (error) {
					try {
						System.out.println(texto);
						dato = dataIn.readLine();
						error=false;						
					} catch (IOException e) {
						System.out.println("Vuelve a inroducir el dato, por favor: ");
						error = true;
					}
				}

				Pattern pat = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])[-](0?[1-9]|1[012])[-][\\d]{4}$");
				Matcher mat = pat.matcher(dato);
				if(mat.find()){
					System.out.println("Fecha Válida");

				}else{
					System.out.println("Fecha No Válida");
					dato=null;
				}
			}while(dato==null);
			break;

		case -1://solo una vez
			boolean error = true;
			while (error) {
				try {
					System.out.println(texto);
					dato = dataIn.readLine();
					error=false;						
				} catch (IOException e) {
					System.out.println("Vuelve a inroducir el dato, por favor: ");
					error = true;
				}
			}
			// 
			Pattern patr = Pattern.compile("^ (0?[1-9]|[12][0-9]|3[01])[-](0?[1-9]|1[012])[-][\\d]{4}$");
			Matcher matc = patr.matcher(dato);
			if(matc.find()){
				System.out.println("Fecha Válida");

			}else{
				System.out.println("Fecha No Válida");
				dato=null;
			}
			break;

		}
		return dato;
	}

	static public String t_email(int opcion, String texto) {		
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(
				System.in));
		String dato="";


		switch(opcion){
		case 0://mientras que cometan fallo que sigan introduciendo datos
			do{
				boolean error = true;
				while (error) {
					try {
						System.out.println(texto);
						dato = dataIn.readLine();
						error=false;						
					} catch (IOException e) {
						System.out.println("Vuelve a inroducir el dato, por favor: ");
						error = true;
					}
				}

				Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				Matcher mat = pat.matcher(dato);
				if(mat.find()){
					System.out.println("Correo Válido");

				}else{
					System.out.println("Correo No Válido");
					dato=null;
				}
			}while(dato==null);
			break;

		case -1://solo una vez
			boolean error = true;
			while (error) {
				try {
					System.out.println(texto);
					dato = dataIn.readLine();
					error=false;						
				} catch (IOException e) {
					System.out.println("Vuelve a inroducir el dato, por favor: ");
					error = true;
				}
			}
			Pattern patr = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher matc = patr.matcher(dato);
			if(matc.find()){
				System.out.println("Correo Válido");

			}else{
				System.out.println("Correo No Válido");
				dato=null;
			}
			break;

		}
		return dato;
	}

	static public String t_alfanumerico(int opcion, String texto) {		
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(
				System.in));
		String dato="";


		switch(opcion){
		case 0://mientras que cometan fallo que sigan introduciendo datos
			do{
				boolean error = true;
				while (error) {
					try {
						System.out.println(texto);
						dato = dataIn.readLine();
						error=false;						
					} catch (IOException e) {
						System.out.println("Vuelve a inroducir el dato, por favor: ");
						error = true;
					}
				}

				Pattern pat = Pattern.compile("^[A-Za-z0-9]*$");
				Matcher mat = pat.matcher(dato);
				if(mat.find()){
					//System.out.println("Contraseña Válida");

				}else{
					System.out.println("Contraseña no Válida");
					dato=null;
				}
			}while(dato==null);
			break;
		}
		return dato;
	}	

	static public String mostrarEnPantalla(String mensage){
		System.out.println(mensage);
		return mensage;
	}


	/////////////////////////////////////////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	/////METODOS GUARDAR OBJETO EN FICHERO///////
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////

	public static void f_escribirFichero(Object objeto,String nombreFichero){
		ObjectOutputStream fich = null;
		try {            
			fich = new ObjectOutputStream(new FileOutputStream(nombreFichero+".dat"));                

			System.out.println("Guardamos la informacion en el fichero "+"\""+nombreFichero+".dat");
			fich.writeObject(objeto);                                
			fich.close();			
		} catch (IOException ex) {
			System.out.println("Error E/S: " + ex.getMessage());
		} finally {
			try {
				if (fich != null) {
					fich.close();
					
				}
			} catch (IOException ex) {
				System.out.println("Error al cerrar fichero: " + ex.getMessage());
			}
		}
		
	}//escribirFichero
	
	public static void f_escribirFicheroXML(Object objeto,String nombreFichero){
		ObjectOutputStream fich = null;
		try {            
			fich = new ObjectOutputStream(new FileOutputStream(nombreFichero+".xml"));                

			System.out.println("Guardamos la informacion en el fichero "+"\""+nombreFichero+".xml");
			fich.writeObject(objeto);                                
			fich.close();			
		} catch (IOException ex) {
			System.out.println("Error E/S: " + ex.getMessage());
		} finally {
			try {
				if (fich != null) {
					fich.close();
					
				}
			} catch (IOException ex) {
				System.out.println("Error al cerrar fichero: " + ex.getMessage());
			}
		}
		
	}//escribirFichero

	public static Object f_leerFichero(String nombreFichero) {
		File fich = new File (nombreFichero+".dat");
		Object objeto = new Object();
		if(fich.exists()){
			ObjectInputStream fichLeer = null;
			//System.out.println("\nLos datos de los alumnos recuperados del fichero son: ");
			try {
				fichLeer = new ObjectInputStream(new FileInputStream(nombreFichero+".dat"));
				boolean hayaDatos = true;           
				fichLeer = new ObjectInputStream(new FileInputStream(nombreFichero+".dat"));
				//System.out.println("\nLos datos recuperados del fichero son: ");
				while (hayaDatos) {
					try {
						objeto = (Object) fichLeer.readObject();
						//System.out.println(objeto);

					} catch (EOFException e) {
						hayaDatos = false; //Salimos del bucle porque ya hemos recorrido el fichero entero
					}

				}
				//System.out.println("\n");
				//System.out.println("Fichero leido correctamente.");
			} catch (ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			} finally {
				try {
					fichLeer.close();
				} catch (IOException ex) {
					System.out.println(ex.getMessage());
				}
			}//finally
		}//if file exists
		return objeto;
	}//leerFichero

}//class
