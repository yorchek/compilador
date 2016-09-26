
import java.util.ArrayList;

class AST{


	static class Programa {
		BloqueDeSentencias bloqueDeSentencias;
		int linea;
		Programa (BloqueDeSentencias bloqueDeSentencias, int linea){
			this.bloqueDeSentencias = bloqueDeSentencias;
			this.linea = linea;
		}
	}

	static class BloqueDeSentencias{
		ArrayList<Sentencia> sentencias; 
		int linea;
		BloqueDeSentencias (ArrayList<Sentencia> sentencias, int linea){
			this.linea = linea;
			this.sentencias = sentencias;
		}
	}

	static abstract class Sentencia{
	}

	static abstract class Operacion extends Sentencia{
	}

	static abstract class Expresion{
	}
	
	static class ExpresionLiteral extends Expresion{
		Object literal;
		int linea;
		ExpresionLiteral(Object literal, int linea){
			this.literal = literal;
			this.linea = linea;
		}
	}

	// Para los identificadores
	// es una expresion 'atomica'
	static class ExpresionReferencia extends Expresion{
		Object id;
		int linea;
		ExpresionReferencia(Object id, int linea){
			this.id = id;
			this.linea = linea;
		}
	}
	
	// Para la operacion 'ecribe'
	// se hace sobre una expresion
	static  class OperacionSalida extends Operacion{
		Expresion exp;
		int linea;
		OperacionSalida(Expresion exp, int linea){
			this.exp = exp;
			this.linea = linea;
		}
	}

	// Para la operacion 'lee'
	// se hace sobre identificadores unicamente
	static  class OperacionEntrada extends Operacion{
		ExpresionReferencia id;
		int linea;
		OperacionEntrada(ExpresionReferencia id, int linea){
			this.id = id;
			this.linea = linea;
		}
	}

	// Para las declaraciones de identificadores
	static abstract class Declaracion extends Sentencia{
	}
	
	// Para las declaraciones solo con identificador
	static class DeclaracionSimple extends Declaracion{
		String tipo;
		ExpresionReferencia id;
		int linea;
		DeclaracionSimple(String tipo, ExpresionReferencia id, int linea){
			System.out.println("genera DeclaracionSimple");
			this.tipo = tipo;
			this.id = id;
			this.linea = linea;
		}
	}

	static class DeclaracionTipo {
		String tipo;
		int linea;
		DeclaracionTipo(String tipo, int linea){
			System.out.println("genera DeclaracionTipo");
			this.tipo = tipo;
			this.linea = linea;
		}
	}

}