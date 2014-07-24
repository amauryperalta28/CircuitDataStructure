/**
 * 
 */
package EC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Amaury
 *
 */
public class SerializationManager {

	/**
	 * Path al archivo de entrada independiente de la plataforma. 
	 */
	public static File inPath;
	
	/**
	 * Flujo bufereado de entrada.
	 */
	public static BufferedReader inBuffer;

	/**
	 * Path al archivo de salida independiente de la plataforma. 
	 */
	public static File outPath;
	
	/**
	 * Flujo bufereado de salida.
	 */
	public static PrintStream outBuffer;
	
	/**
	 * Arreglo de enteros a ordenar.
	 */
	public static String data;
	
	/**
	 * Constructor dada la ruta del archivo a leer
	 * 
	 * @remark La ruta del archivo a leer sera la misma del archivo en donde se escribira
	 * @param inpath ruta del archivo con la expresion serializada del circuito
	 * @throws IOException
	 */
	public SerializationManager(String inPath) throws IOException{
		this(inPath,inPath);
	}
	
	/**
	 * Constructor dado una ruta de entrada y una salida.
	 * 
	 * @param inpath ruta del archivo con la expresion serializada del circuito
	 * @param outpath ruta del archivo donde se guardara la expresion serializada del circuito
	 * @throws IOException
	 */
	public SerializationManager(String inpath, String outpath) throws IOException
	{
	    inPath = new File(inpath);
	    outPath = new File(outpath);
		
		if ( !inPath.exists() ) {
			
			System.out.println("Ruta no existe");
	       
		}
		/**
		 * 3. Chequear que ese "algo" es un archivo.
		 */
		if ( !inPath.isFile() ) {
			
			System.out.println("No es un archivo");
		}
		/**
		 * 4. Chequear que el archivo se puede leer.
		 */
		if ( !inPath.canRead() ) {
			
			System.out.println("No se puede leer");
		}
		
		
		inBuffer= new BufferedReader(new FileReader(inPath));
		
	}
	
	/**
	 * Lee una línea del buffer de entrada y devuelve
	 * una cadena de caracteres.
	 * @param in Buffer de entrada
	 * @return	Cadena de caracteres o null si no hay
	 * 			o se produce in error en lectura.
	 */
	public static Integer[] readIntegerArray(BufferedReader in) {
		String line;
		try {
			line= in.readLine();
		} catch (IOException e) {
			return null;
		}
		if ( line == null ) return null;
		line= line.trim();
		String[] group= line.split("\\s+");
		Integer[] arr= new Integer[group.length];
		for ( int i= 0; i < group.length; i++ ) {
			arr[i]= Integer.decode(group[i]);
		}
		return arr;
	}
	
	/**
	 * Obtiene la expresion serializada de un circuito
	 * 
	 * @return Un cadena de caracteres con la expresion serializada
	 * @throws IOException 
	 */
	public String readCircuitSerialization() throws IOException{
		
		/**
		 * Abrir un buffer
		 */
		inBuffer= new BufferedReader(new FileReader(inPath));
		/**
		 * Variable para concatenar 
		 */
		 String exp="";
		/**
		 * Mientras no se termine de leer el archivo
		 * Concatenar cada linea del archivo
		 */		 
			 do
			 {
				 try
				 {
					 data =inBuffer.readLine();
					 exp+=   data!= null? data:"";
				 }
				 catch(IOException e){
					 System.out.println("paso");
				 }
			 }
			 while(null != data);
		
		 
			 inBuffer.close();
		return exp;
	} 

	/**
	 * Escribe en un archivo una expresion serializada de un circuito especificada
	 * @param circuito	Expresion serializada del circuito
	 * 
	 * @return no retorna nada
	 */
	public void SaveCircuit(String circuito)
	{
		try {
			outBuffer= new PrintStream(outPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outBuffer.println(circuito);
		
		outBuffer.close();
	}
	
}
