
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
	
	static  class OperacionSalida extends Operacion{
		Expresion exp;
		int linea;
		OperacionSalida(Expresion exp, int linea){
			this.exp = exp;
			this.linea = linea;
		}

	}

}