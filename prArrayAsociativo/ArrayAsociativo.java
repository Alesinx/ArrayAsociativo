package prArrayAsociativo;

import java.util.NoSuchElementException;

public class ArrayAsociativo {
	//Clases internas
	private class Nodo{
		private String clave;
		private String valor;
		private Nodo sig; //siguiente nodo
		
		public Nodo(String c, String v, Nodo s){
			clave = c;
			valor = v;
			sig = s;
		}
	}
	
	//Variables de instancia
	private Nodo primero;
	
	
	//Constructores
	public ArrayAsociativo(){
		primero = null;
	}
	
	public ArrayAsociativo(String[] claves, String[] valores){
		this();
		if (claves.length > 0){
			primero = new Nodo(claves[0], valores[0],null);
			for (int i = 1; i< claves.length; i++){
				Nodo nuevo = new Nodo(claves[i], valores[i],primero);
				primero = nuevo;
			}
		}
	}
	
	//Métodos de instancia
	public int size (){
		int res = 0;
		Nodo actual = primero;
		
		while(actual.sig != null){
			actual = actual.sig;
			res ++;
		}
		return res;
	}
	public String get(String clave){
		Nodo actual = primero;
		
		while(actual.sig != null){
			if(actual.clave == clave){
				return actual.valor; 
				// si lo encuentra antes de terminar el whiel
				// sale por aquí
			}
		}
		throw new NoSuchElementException();
		// si sale del while sin encontrarlo se lanza la exception
	}
}
