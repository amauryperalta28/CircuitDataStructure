/**
 * 
 */
package EC;


import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * @author Amaury
 *
 */
public class Circuit {

	/**
	 * Lista de componentes del circuito
	 */
	public LinkedList <Component> circuit; 
	
	
	/**
	 * Lista de conexiones del circuito
	 */
	
	public ArrayList<Node> nodes = new ArrayList<Node>();
	
	
	
	/*
	 * El constructor por default crea una lista de tipo <Componentes> y un nuevo nodo.
	 */
	public Circuit()
	{
		circuit = new LinkedList <Component>();
		
				
		
			  
	}
	
	/**
	 * El metodo posicionCompt determina si existe un componente retornando su posicion en
	 * el Linked List.
	 * posicion de la componente en el Linked List.
	 * @param 	id  Identificador de la componente
	 * @return  p, la posicion del componente o -1 si no existe.
	 */
	public int findComponent(String id)
	{
		return 1;
	}
	/**
	 * Busca un nodo por su id especificado
	 * @param id	id del nodo a buscar
	 * 
	 * @return el indice del nodo, -1 si no se encuentra
	 * 
	 */
	public int getNodeIndex(int id)
	{
		int r = -1;
		for (int i = 0; i < nodes.size() ; i++) {
			int id1 = nodes.get(i).getId();
			
			if(id== id1)
			{
				r= i;
			}
			
		}
		
		return r;
	}
	
	
	
	/**
	 *Agrega un componente al circuito.
	 * @param 	id	 		Identificador de la componente.
	 * @return true si se creo la componente, false, si no se creo.
	 */
	public boolean addComponent(String id)
	{
		 
		return true;
	}
	
	/**
	 * El metodo conectarComponente conecta un componente en dos nodos del circuito  (conexion no serie).
	 * @param 	id 		Identificador del componente.
	 * @param 	nodo1 	nodo 1
	 * @param 	nodo2 	nodo 2
	 * @return true, si se pudo agregar, false, si no se pudo agregar.
	 */
	public boolean connectComponent(String id)
	{
		return true;
	}
	
	
		
	/**
	 * Desconecta un componente de los nodos a los cuales este conectado
	 * @param 	id  Identificador del componente.
	 * @return true, si se pudo retirar. false si no se pudo.
	 */
	public boolean disconnectComponent(String id)
	{   
		return true;
	}
	
	/**
	 * El metodo reconectComponente Cambia los nodos en cual el componente de id
	 * esta conectado, primero lo retira del circuito y luego lo reconecta en otra 
	 * parte deseada del circuito.
	 * @param 	id  	Identificador del componente
	 * @param 	nNodo1	Nuevo nodo 2.
	 * @param 	nNodo2 	Nuevo nodo 2.
	 * @return true, si se pudo realizar el cambio. false, si no se realiz�.
	 */
	public boolean reconectComponente()
	{
		return true;
		
	}
	
	/**
	 * El metodo elimComponente retira un componente deseado del circuito y luego lo 
	 * elimina.
	 * @param 	id	Identificador de la componente
	 * @return true, si fue eliminado, false si no lo fue.
	 */
	public boolean deleteComponent(String id)
	{
				
		return false;
	}
	
	/**
	 * El metodo getEnumComponentes retorna la cantidad de componentes del circuito.
	 * @return cantidad de componentes del circuito.
	 */
	public int getComponentCount()
	{
		return 1;
	}
	/**
	 * Obtiene la expresion serializada del id, las terminales y sus conexiones de un
	 * componente indicado
	 * @param c  Componente especificado
	 * @return   Cadena con la expresion serializada
	 */
	private String getComponentExpr(Component c){
		String s ="{";
		//Si el componente dado no es null analizo
		if(c!= null){
			// Concateno el id, las terminales y sus conexiones separados por guion			
			s+= c.getIdExpr()+"-"+ c.getTerminalExpr() +"-"+ getConnectionsExpr(c);
		}
		s+= "}";
	
		return s;
	}
	/**
	 * Obtiene la expresion serializada de los nodos agregados al circuito
	 * 
	 * @return  Una cadena con la expresion serializada de los nodos existentes
	 */
	private String getNodeExpr(){
		
		//Inicio cadena con caracter {
		String s = "{";
		//Recorro todos los nodos,
		for (int i = 0; i < nodes.size(); i++) {
			//Tomo sus id los concateno a la cadena con una coma 
			if(i < nodes.size()-1){
				
				s+= nodes.get(i).getId()+",";
			}
			else{
				s+= nodes.get(i).getId();
			}
			
		}
		//Termino cadena con caracter }
		s+="}";
		
		return s;
	}
	/**
	 * Obtiene una expresion serializada de los nodos en los cuales estan conectados
	 * los terminales de un componente especificado.
	 * @param c componente a analizar
	 * 
	 * @return Cadena con expresion serializada de los nodos 
	 *         conectados a los terminales
	 */
	private String getConnectionsExpr(Component c)
	{
		// Se crea variable donde se guardara expresion
		String exp= "(";
	    Terminal t[] = c.getTerminals();
		// Se recorre la lista de terminales
		for (int i = 0; i < t.length; i++) {
			Terminal te = t[i];
			// Se verifica si la terminal esta conectada
			if(te.isConnected())
			{
			// Si esta conectada
				// Se concatena a una variable la posicion del nodo si es
				if(i == t.length-1){
					 exp+= getNodeIndex( te.getConnectionPoint().getId());
				}
				else{
					 exp+= getNodeIndex( te.getConnectionPoint().getId()) + ",";
				}
			}
			//Si no esta conectada
			else{
				if(i == t.length-1){
					 exp+= "-1";
				}
				else{
					 exp+= "-1"+ ",";
				}
			}
		} 
		exp+=")";	
		 
		return exp;
	}

	/**
	 * Obtiene una expresion serializada de los componentes, nodos y conexiones
	 * existentes en el circuito
	 * 
	 * @return Una cadena con la expresion serializada
	 */
	public String getCircuitSerialization(){
		//Agrego a la cadena expresion de los nodos
		String s= getNodeExpr()+"|";
		//Recorro la lista de componentes
		for (int i = 0; i < circuit.size(); i++) {
			Component c = circuit.get(i);
			
			//Concateno las expresiones serializadas(terminales y sus conexiones) de los componentes  separados por |
			if(i < circuit.size()-1)
				s+= getComponentExpr(c)+"|";
			else
				s+= getComponentExpr(c);
		}
		
		return s;
	}
	
	/**
	 * Verifica si los indices de los nodos en un arreglo especificado existen
	 * 
	 * @param a array de indices a nodos a examinar
	 * @return  true si estan todos, false si alguno no esta 
	 */
	private boolean existNodes(String[] a){
		int p=0;
		//Si el numero de nodos especificados es mayor que el numero de nodos creados
		if(a.length > nodes.size()){
			return false;
		}
		
		int mayor = Integer.parseInt(a[0]);
		//Se recorreo el arreglo de indices
		for (int i = 0; i < a.length; i++) {
			int n = Integer.parseInt(a[i]);
			
			if(n >mayor){
				mayor = n;
			}
					
		}
		//Se compara el indice analizado para ver si es el mayor indice
		//Si el indice mayor, es mayor que el numero de nodos existentes
		//Retorna false
				
		return mayor>=nodes.size()?false:true;
	}
	
	/**
	 * Recibe una arreglo de indices a nodos y devuelve una lista con las 
	 * referencias de los nodos
	 * @remark Se asume que todos los nodos estan presentes
	 * @param a  Arreglo de indices
	 * @return   Lista de referencias a nodos
	 */
	public ArrayList<Node> getNodeList(String[] a){
		
		//Se crea una lista
		ArrayList<Node> n = new ArrayList<Node>();
		// Se recorre el arreglo de indices
		
		for (int i = 0; i < a.length; i++) {
			int index = Integer.parseInt(a[i]);
			
			if(index >=0 && index < nodes.size()){
				Node nod = nodes.get(index);
				if(nodes.contains(nod))
					n.add(nodes.get(index));
			}
			else{
				n.add(null);
			}
			//Inserta la referencia del nodo en la lista creada
			
		}
		
		return n;
	}
	/**
	 * Agrega una listado de nodos al circuito
	 * @param n arreglo de identificadores de los nodos
	 * @return  nada
	 */
	public void addNodeArray(String []n){
		
		//Se recorre el arreglo de id
		for (int i = 0; i < n.length; i++) {
			// Se crea una instancia y se agrega a la lista de nodos
			nodes.add(new Node(Integer.parseInt(n[i]) ));
		}
		
	}
	/**
	 * Reconstruye un circuito a partir de una expresion serializada
	 * de un circuito contenida en un archivo de texto
	 * @param infilePath  Archivo del cual se leera la expresion
	 * @return true si se puedo reconstruir, false de lo contrario
	 */
	public boolean buildCircuit(String inFilePath){
		String c;
		LinkedList<Component> compACrear = new LinkedList<Component>();
		
		/*Leer archivo y guardar circuito serializado en una variable cadena*/
		try {
			SerializationManager s = new SerializationManager(inFilePath);
			c = s.readCircuitSerialization();
		 	c = c.replace("{", "");
			c = c.replace("}", "");
			//Dividir la cadena en partes en los elementos separados por el carácter “|”
			String[]el = c.split("\\|");
			
			//Se guarda la expresion que representa a los nodos
			// y se le remueve las commas y llaves
			String n = el[0].replace("{", "");
			 n = n.replace("}", "");
			 
			 String[]nodos = n.split("\\,");
			 
			//Se crean los nodos del circuito
		 	addNodeArray(nodos);
			
			//Se recorre el resto del arreglo de {el}
		 	for (int i = 1; i < el.length; i++) {
		 		
		 		//Se toma el elemento en la posicion evaluada y se separa la cadena por el caracter guion(-)
		 		String []expr = el[i].split("\\*");
		 		//Obtengo el id de la expresion
		 		String id = expr[0].replace("(", "");
		 		       id = id.replace(")", "").replace("{", "");
		 		//Obtengo la lista de terminales
		 	    String t = expr[1].replace("(", "");
		 	           t = t.replace(")", "");
		 	    String []terminales = t.split("\\,");
		 	    
		 		//Obtengo la lista de conexiones de las terminales
		 	   String con = expr[2].replace("(", "");
		 	   		  con = con.replace(")", "");
 	           String []conexiones = t.split("\\,");
 	           
 	           
 	           
 	        	   //Agrego el componente a la lista de componentes
 	            Component comp = new Component(Integer.parseInt(id),terminales, getNodeList(conexiones));
 	            //compACrear.add(comp);
 	            circuit.add(comp);
 	            
 	          
 	           
			}
			//Se le quita los parentesis y las commas a la expresion del id, los las terminales y sus conexiones
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//circuit = compACrear;
        
        return true;
	}
}
