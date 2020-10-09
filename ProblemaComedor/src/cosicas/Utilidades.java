package cosicas;
import java.util.Random;


public class Utilidades {

	public Utilidades() {
		// TODO Auto-generated constructor stub
	}


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

		String letraAzar[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","á","O","P","Q","R","S",
				"T","U","V","W","X","Y","Z"};

		return letraAzar[azar.nextInt(letraAzar.length)];
	}


	static public String a_nombreAzar() {
		Random azar= new Random();

		String nombreAzar[]={"Santiago","Sebastián","Diego","Thiago","Nicolás","Samuel","Dario","Alejandro","Mateo",
				"ángel","Matáas","Gabriel","Tomás","David","Emiliano","András","Joaquán","Carlos","Alexander","Adrián","Lucas",
				"Sofáa","Camila","Valentina","Isabella","Valeria","Daniela","Mariana","Sara","Victoria","Gabriela","Ximena",
				"Andrea","Natalia","Máa","Martina","Lucáa","Samantha","Maráa","Paula","Nicole"};

		return nombreAzar[azar.nextInt(nombreAzar.length)];
	}

	static public String a_apellidoAzar(){
		Random azar= new Random();

		String apellidoAzar[]={"Abadáa","Abarca","Abellán","Abiego","Acorella","Baldovinos","Bandrás","Cabra","Cajal","Calasanz",
				"Samper","Latorre", "Escolano", "Cebrián", "Clemente", "Navarro","Garcáa","Hernández","Martánez","Lápez",
				"Párez","Fernández","Ruiz","Sánchez","Rodráguez","Gámez","González","Jimánez","Cruz","Requena","Moreno","Reyes",
				"Morillas","Cortes","Ortiz","Romero","Medialdea","Expásito","Raya","Sierra","Membrilla","Casado","Amezcua","Muáoz",
				"Santiago","Delgado","Moya","Serrano","Contreras","Hidalgo","Mesa","Pozo","Soria","Vera","Varán","Parra"};

		return apellidoAzar[azar.nextInt(apellidoAzar.length)];
	}

	static public String a_marcaAzar(){
		Random azar= new Random();
		String marcaAzar[]={"Apple","Google","Coca-Cola","Microsoft","IBM","Toyota","Samsung","GE","McDonaldás","Amazon",
				"BMW","Mercedes-Benz","Disney","Intel","Cisco","Oracle","Nike","HP","Honda","Louis Vuitton","H&M","Gillette",
				"Facebook","Pepsi","American Express","SAP","IKEA","Pampers","UPS","Zara","Budweiser","eBay","J.P. Morgan",
				"Nescafá","HSBC","Ford","Hyundai","Canon","Hermás","Accenture","LáOráal","Audi","Citi","Goldman Sachs",
				"Philips","AXA","Nissan","Gucci","Danone","Nestlá","Siemens","Allianz","Colgate","Porsche","Cartier",
				"Sony","3M","Morgan Stanley","Visa","Adidas","Thomson Reuters","Discovery","Panasonic","Tiffany & Co.",
				"Starbucks","Adobe","Prada","Santander","Xerox","Caterpillar","Burberry","Kia","KFC","MasterCard",
				"Johnson & Johnson","Shell","Harley-Davidson","DHL","Sprite","Lego","John Deere","Jack Danielás",
				"Chevrolet","FedEx","Land Rover","Huawei","Heineken","MTV","Ralph Lauren","Johnnie Walker","Corona",
				"Smirnoff","Kleenex","Hugo Boss","PayPal","Mini","Moát & Chandon","Lenovo"};
		return marcaAzar[azar.nextInt(marcaAzar.length)];
	}

	static public String a_marcaCoche(){
		Random azar = new Random();
		String marcaCoche[]={"BMW","AUDI","OPEL","KIA","PORCHE","RENAULT","PEUGEOT","MERCEDES","MINI","SMART","CITROEN","FORD","SEAT","WOLSKWAGEN","VOLVO","LEXUS"};
		return marcaCoche[azar.nextInt(marcaCoche.length)];



	}

	static public String a_provinciaAzar(){
		Random azar= new Random();
		String provincia[]= {"Alava","Albacete","Alicante","Almeráa","Asturias","Avila","Badajoz","Barcelona","Burgos","Cáceres",
				"Cádiz","Santander","Castellán","Ciudad Real","Cárdoba","La Coruáa","Cuenca","Gerona","Granada","Guadalajara",
				"GuipÃºzcoa","Huelva","Huesca","Islas Baleares","Jaán","Leán","Lárida","Lugo","Madrid","Málaga","Murcia","Navarra",
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
				"Anemia de Fanconi", "Anemias","Anginas", "Anorexia nerviosa", "Apnea del Sueáo", 
				"Asma bronquial", "Aterosclerosis", "Bronquiectasias", "Bronquitis Cránica", 
				"Brucelosis", "Bulimia", "Calambres en los Másculos", "Cálculos renales", 
				"Callos y Callosidades", "Cefaleas de Tensián", "Ciática", "Cálico de Riáán", 
				"Colitis Ulcerosa", "Colon Irritable", "Coma Etálico", "Congelacián", 
				"Degeneracián Macular del Ojo", "Depresián", "Deshidratacián", 
				"Desmayos y Mareos", "Diarrea Clánica", "Diarrea del Viajero", 
				"Dolor de Cabeza", "Dolor de Espalda", "Dolor de Garganta", "Dolor de Oádo", 
				"Embarazo en la Adolescencia", "Enfermedad de Crohn", "Enfermedad de Parkinson", 
				"Estreáimiento", "Fisura anal", "Ganglián", "Glositis", "Gota", "Gripe", "Hematámesis", 
				"Hemorroides", "Hernia Discal", "Hiperlipemias y colesterol Elevado  ", 
				"Hipertensián arterial", "Hipertensián intracraneal idiopática", "Hipocondria", "Hipotensián",
				"Hongos de la piel", "Hongos en las uáas", "Intoxicacián por Alcohol", "Juanetes", 
				"Laberintitis", "Labios Agrietados", "Laringitis", "Latigazo Cervical", "Lengua Geográfica", 
				"Mareo", "Mastoiditis", "Migraáa", "Obesidad", "Orinar por la noche", 
				"Parálisis Facial de Bell", "Piel seca. Xerosis", "Reflujo Gastroesofágico", "Resfriado", 
				"Ronquidos", "Rotura de Támpano", "Sangrado Nasal", "Sangrado Rectal", "Sangre en el Esputo", 
				"Sangre en la Orina", "Sándrome de Astenia Cránica", "Sándrome de Piernas Inquietas", 
				"Sándrome hepático renal", "Sándrome nefrático", "Sinusitis", "Talasemia", 
				"Tendinitis. Bursitis", "Tic en el Párpado", "Varices", "Vártigo"};

		return enfermedad[azar.nextInt(enfermedad.length)];
	}

	static public String a_medicamentoAzar(){
		Random azar= new Random();

		String medicamento[] = {"Nolotil.", "Efferalgan.", "Gelocatil.", "Adiro 100.", "Augmentine.", 
				"Orfidal Wyeth.", "Neobrufen.", "Dianben.", "Antidiabáticos orales.", "Termalgin.", 
				"Lexatin.", "Almax.", "Trankimazin.", "Flumil.", "Sintrom.", "Frenadol complex.", 
				"Aspirina adultos.", "Dalsy.", "Espidifen.", "Tranxilium.", "Omeprazol Ratiopharm.", 
				"Cardyl.", "Yasmán.", "Seguril.", "Omeprazol Cinfamed.", "Flutox.", "Zarator.", "A.A.S.", 
				"Plantaben.", "Noctamid.", "Enantyum.", "Zaldiar.", "Daflon 500.", "Tromalyt.", 
				"Hidrosaluretil.", "Prevencor.", "Carduran Neo.", "Duphalac.", "Ibuprofeno Kern.", 
				"Myolastan.", "Adiro 300.", "Algidol.", "Mucosan.", "Voltarán.", "Eutirox.", "Norvas.", 
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
				"cebolla","calabacin","aceitunas","panceta","pimiento","chamiñones","tofu","bacalao","merluza","salmon","gazpacho","pepino",
				"atun","tomate","remolacha","pollo","ternera","ternasco","leche","patatas a lo pobre","lechuga","albondigas","jamon york",
				"sanjacobos","salchichas","arroz","platano","piña","pizza","oregano","tomillo","guisantes"};

		return IngredienteAzar[azar.nextInt(IngredienteAzar.length)];
	}

}
