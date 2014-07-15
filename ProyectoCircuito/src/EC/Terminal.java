/**
 * @file Terminal.java
 * @brief Fuente de la clase Terminal
 */
package EC;

import Enums.TermType;

/**
 * @author Amaury
 *
 */
public class Terminal {

	/**
	 * Identificador de la terminal
	 */
	private int id;
	
	/**
	 * Referencia al componente al que pertenecen.
	 */
	private Component sourceComponent;
	
	/**
	 * Tipo de terminal
	 */
	private TermType type;
		
	
	/**
	 * Referencia a un nodo
	 */
	
	private Node connectionPoint = null;
		
	/**
	 * Constructor de clase Terminal
	 * @param id    El identificador de la terminal
	 * @param type  El tipo de la terminal
	 * @param s     Referencia al componente que pertenecera la terminal
	 * @remark      No crean objetos de esta clase sin la correspondiente
	 *       		referencia al componente al que pertenecen.     
	 * 
	 * @return      nada
	 */
	public Terminal(int id, TermType type, Component s) {
		
		// Se verifica si la referencia al componente es null
		// Se verifica si el id esta en los rangos correctos			
		// Se verifica si el tipo de terminal es correcto
		if( (s != null) || 	(id > 0) || 
			(type == TermType.IN ||type == TermType.OUT))
		{
			this.id =id;
			this.type = type;
			this.sourceComponent = s;
			
		}
		
		
		
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the type
	 */
	public TermType getType() {
		return type;
	}
	
	/**
	 * Se obtiene el tipo de terminal en una cadena de caracteres
	 *  
	 * @return tipo de terminal en formato cadena
	 */
	public String getType1()
	{
		return type.toString();
	}

	/**
	 * Desconecta una terminal de un nodo
	 * 
	 * @return no retorna nada
	 */
	public void disconnect()
	{
		// Se verifica si la terminal esta conectada a un nodo
		if(connectionPoint != null){
								
			// Se busca  y se elimina la terminal de la lista de conexiones al nodo
			connectionPoint.removeConnection(this);
	   	// Se desconecta el punto de conexion de la terminal
			connectionPoint = null;
			
			
		}
		
	}

	/**
	 * Determina si la terminal esta conectada
	 * 
	 * @return true si esta conectada, false de lo contrario
	 */
	public boolean isConnected()
	{
		
		return (connectionPoint!= null?true:false);
	}
/**
 * Obtiene el nodo donde esta conectada la terminal
 * @return referencia al nodo
 */
	public Node getConnectionPoint() {
		return connectionPoint;
	}

	public void setConnectionPoint(Node connectionPoint) {
		this.connectionPoint = connectionPoint;
	}
	/**
	 * Determina si la terminal es igual a otra dada
	 * @param t Terminal con la que se comparara
	 * 
	 * @return True si son iguales, false de lo contrario
	 */
	public boolean equals( Object t ) {
		if (t == null) return false; 

		Terminal ter = (Terminal)t; 
		if ((this.getId() == ter.getId()) &&
			 this.getSourceComponent().getId() == ter.getSourceComponent().getId())
		return true;

		return false;
		}
	public int hashCode() {
		String id = String.valueOf(this.id);
		return id.hashCode();
		}

	/**
	 * @return the sourceComponent
	 */
	public Component getSourceComponent() {
		return sourceComponent;
	} 
	
}
