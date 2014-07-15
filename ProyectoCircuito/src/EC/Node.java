/**
 * Clase representativa de un board
 */
package EC;

import java.util.ArrayList;
import java.util.HashSet;



/**
 * @author Amaury
 *
 */
public class Node  {

	/**
	 * Identificador del nodo
	 */
	private int id;
	
	/**
	 * Lista de puntos de conexion
	 */
	private HashSet<Terminal> connections = new HashSet<Terminal>();
	
	/**
	 * Constructor de la clase.
	 * @param id Identificador que tendra el nodo
	 * 
	 */
	public Node(int id)
	{
		
		this.id = id;
	}
	
	/**
	 * Agrega la conexion de una terminal al nodo.
	 * @param t  Referencia a la terminal que se conectara
	 * 
	 * @return   true si no se pudo conectar, false de lo contrario
	 */
	public boolean addConnection(Terminal t)
	{
		if(t == null){
			return true;
		}
		else{
			// Se conecta la terminal con el nodo
			t.setConnectionPoint(this);
		    // Se conecta el nodo con la terminal
			
			connections.add(t);
			return false;
		}
		
	}
	
	
		
	/**
	 * Se obtiene la lista de conexiones al nodo
	 * 
	 * @return La lista de conexiones al nodo
	 */
	
	public HashSet<Terminal> getConnections() {
		return connections;
	}

	/**
	 * Proporciona la cantidad de conexiones existentes en el nodo
	 * 
	 * @return cantidad de nodos
	 */
	public int getNodeCount()
	{
		return connections.size();
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Remueve una conexion de una terminal dada
	 * @param t  Terminal a desconectar
	 * @return true si no se puedo desconectar, false de lo contrario
	 */
	public boolean removeConnection(Terminal t){
		return connections.remove(t);
	}

	

	
}
