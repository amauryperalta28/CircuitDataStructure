/**
 * 
 */
package EC;


import java.util.ArrayList;
import java.util.LinkedHashSet;
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
	 * @return el indice el nodo, -1 si no se encuentra
	 * 
	 */
	public int returnNodeIndex(int id)
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
	 * El metodo agregaComponente agrega un componente al circuito.
	 * @param 	id	 		Identificador de la componente.
	 * @return true, si se creo la componente. false, si no se creo.
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
	 * Obtiene una expresion serializada de los nodos en los cuales estan conectados
	 * los terminales del componente.
	 * @param c componente a analizar
	 * 
	 * @return Cadena con expresion serializada de los nodos 
	 *         conectados a los terminales
	 */
	public String getConnectionsExpr(Component c)
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
					 exp+= returnNodeIndex( te.getConnectionPoint().getId());
				}
				else{
					 exp+= returnNodeIndex( te.getConnectionPoint().getId()) + ",";
				}

			}
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
	
}
