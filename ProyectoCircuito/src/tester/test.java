/**
 * 
 */
package tester;

import java.util.HashSet;
import java.util.Set;

import EC.Component;
import EC.Node;
import EC.Terminal;
import Enums.TermType;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TermType[] ter = {TermType.IN,TermType.OUT,TermType.OUT,TermType.IN};
		Set<Terminal> h = new HashSet<Terminal>();
		Component c = new Component(28,ter);
	
		
		//Se toma una terminal especifica
		Terminal[] t = c.getTerminals();
		Terminal t2 = t[2];
		Terminal t3 = t[2];
		
		h.add(t2);
		h.add(t3);
		
		Node n = new Node(25);
		
		n.addConnection(t3);
		n.addConnection(t2);
		//La comparo con ella misma
		System.out.println(n.getConnections().size());
	}

}
