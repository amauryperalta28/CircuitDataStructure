/**
 * 
 */
package tester;

import java.io.IOException;

import EC.Circuit;
import EC.Component;
import EC.Node;
import EC.SerializationManager;
import Enums.TermType;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Node nodo = new Node(25);
//		Node nodo1 = new Node(26);
//		Circuit circuito = new Circuit();
//		circuito.nodes.add(nodo);
//		circuito.nodes.add(nodo1);
//		TermType[] ter = {TermType.IN,TermType.OUT,TermType.OUT,TermType.IN};
//		
//		//Conecto una terminal a un nodo
//		
//		Component c = new Component(28,ter);
//		Component c1 = new Component(25,ter);
//		c.getTerminals()[0].connect(nodo);
//		c1.getTerminals()[0].connect(nodo);
//		circuito.circuit.add(c);
//		circuito.circuit.add(c1);
//
//       		
//		String F ="la,vida es,linda";
//		
//		String[] r = F.split("\\,");
//		
//		for (int i = 0; i < r.length; i++) {
//			System.out.println(r[i]);
//		}
//		
//		String [] str = {"0","1","4","-1"};
//		System.out.println(circuito.nodes.size());
//		System.out.println(circuito.getNodeList(str).get(3));
//		
		Circuit c = new Circuit();
		
		c.buildCircuit("circuito.txt");
	    System.out.println(c.circuit.get(0).getId());
	   
	}

}
