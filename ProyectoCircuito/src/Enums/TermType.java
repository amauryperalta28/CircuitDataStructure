/**
 * @file PinType.java
 * @brief Enum representativo de los tipos de pines
 */
package Enums;

/**
 * @author Amaury
 *
 */
public enum TermType {
	IN(0), // Pines de entrada
	OUT(1); // Pines de salida
	
	private TermType(int value) {
                this.value = value;
        }
	
	private int value;
	
	public int getValue(){
		return value;
	}
	
	};
