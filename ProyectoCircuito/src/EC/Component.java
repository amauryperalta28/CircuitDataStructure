/**
 * 
 */
package EC;

import java.util.ArrayList;

import Enums.TermType;

/**
 * @author Amaury
 *
 */
public class Component {

	/**
	 * Identificador unico para cada componente.
	 */
	private int id; 
	
	/**
	 * Codigo de identificacion del componente
	 */
	private String ComponentCode;
	

	/**
	 * Lista de terminales del componente
	 */
	private Terminal[] terminals;
	
	
	/**
	 * Constructor dado su id y sus terminales en formato string.
	 * @param 	id		  Identificador  unico de cada componente.
	 * @param   Types     Arreglo de String de tipos de los terminales del componente
	 * 
	 */
	public Component(int id, String[] types, ArrayList<Node> nodes){
		this.id = id; 
		int in =0;
		int out = 0;
	    
		// Se verifica si el Arreglo de tipos tiene elementos
		if(types.length > 0)
		{
			/* Se determina si el componente tiene por lo menos 1 terminal
			 de salida y 1 de entrada*/
			for (int i = 0; i < types.length; i++) {
				String t = types[i];
				if(t.equals("0")){
					in++;
				}
				else
					if(t.equals("1")){
						out++;
					}
			}
			/* Se verifica que el componente tenga por lo menos 1 terminal
						 de salida y 1 de entrada*/
			if(in>0 && out>0){
				//Se crea una instancia del arrlego terminals
				terminals = new Terminal[types.length];
				
			    //Se crean las terminales
				for (int i = 0; i < types.length; i++) {
					//Se verifica si es cero o 1 se aplica TermType.IN o TermType.OUT
					if(types[i].equals("1")){
					 terminals[i]  = new Terminal(i+1,TermType.OUT,nodes.get(i),this);
					}
					else 
						if(types[i].equals("0")){
							terminals[i]  = new Terminal(i+1,TermType.IN,nodes.get(i),this);
						
					}
										
				}
			}
			
						
		}
		
	}
	/**
	 * Constructor dado su id y sus terminales en formato TermTypes.
	 * @param 	id		  Identificador  unico de cada componente.
	 * @param   Types     Arreglo de tipos de los terminales del componente
	 * 
	 */
	public Component(int id, TermType[] types)
	{
		this.id = id; 
		int in =0;
		int out = 0;
	    
		// Se verifica si el Arreglo de tipos tiene elementos
		if(types.length > 0)
		{
			/* Se determina si el componente tiene por lo menos 1 terminal
			 de salida y 1 de entrada*/
			for (int i = 0; i < types.length; i++) {
				TermType t = types[i];
				if(t.equals(TermType.IN)){
					in++;
				}
				else
					if(t.equals(TermType.OUT)){
						out++;
					}
			}
			/* Se verifica que el componente tenga por lo menos 1 terminal
						 de salida y 1 de entrada*/
			if(in>0 && out>0){
				//Se crea una instancia del arrlego terminals
				terminals = new Terminal[types.length];
				
			    //Se crean las terminales
				for (int i = 0; i < types.length; i++) {
					terminals[i] = new Terminal(i+1, types[i],this);					
				}
			}
			
						
		}
		
		}
		
		
		
		
		
	
	
	/**
	 * El metodo setId asigna un id a un componente.
	 * @param id Identificador de un componente.
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	
	/**
	 * El metodo getId retorna el id de un componente.
	 * @return id Identificador de una componente.
	 */
	public int getId()
	{
		return id;
	}

	public String getIdExpr()
	{
		String id = "(" + this.id + ")";
		
		return id;
		
	}
	/**
	 * @return the componentCode
	 */
	public String getComponentCode() {
		return ComponentCode;
	}
	/**
	 * Obtiene una expresion serializada de los terminales del componente
	 * 
	 * @return cadena con expresion serializada de los terminales del componente
	 */
	public String getTerminalExpr(){
		String t ="(";
		
		
		for (int i = 0; i < terminals.length; i++) {
			Terminal p = terminals[i];
			if(i < terminals.length-1){
				t+= p.getType()+ ",";
			}
			else
			{
				t+= p.getType();
			}
			
		}
		
		t+= ")";
		return t;
	}

	/**
	 * Obtiene la lista de terminales del componente
	 * 
	 * @return La lista de terminales que posee el componente
	 */
	public Terminal[] getTerminals() {
		return terminals;
	}
	
	/**
	 * Determina 
	 */
		

}
