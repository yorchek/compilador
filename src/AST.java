
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

	//agregue los identificadores
	static class ExpresionReferencia extends Expresion{
		Object id;
		int linea;
		ExpresionReferencia(Object id, int linea){
			System.out.println("si es un id");
			this.id = id;
			this.linea = linea;
		}
	}
	
	static  class OperacionSalida extends Operacion{
		Expresion exp;
		int linea;
		OperacionSalida(Expresion exp, int linea){
			this.exp = exp;
			this.linea = linea;
		}
	}

	static  class OperacionEntrada extends Operacion{
		ExpresionReferencia id;
		int linea;
		OperacionEntrada(ExpresionReferencia id, int linea){
			System.out.println("Si reconoce la clase");
			this.id = id;
			this.linea = linea;
		}
	}

}