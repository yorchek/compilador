
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
			//System.out.println("genera ExpresionLiteral");
			this.literal = literal;
			this.linea = linea;
		}

		static boolean aBooleano(String b){
			return b.equals("verdadero");
		}
	}

	// Para los identificadores
	// es una expresion 'atomica'
	static class ExpresionReferencia extends Expresion{
		Object id;
		int linea;
		ExpresionReferencia(Object id, int linea){
			//System.out.println("genera ExpresionReferencia");
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
			//System.out.println("genera Lectura");
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
			//System.out.println("genera DeclaracionSimple");
			this.tipo = tipo;
			this.id = id;
			this.linea = linea;
		}
	}

	// Para las declaraciones 'tipo id = exp'
	static class DeclaracionCompuesta extends Declaracion{
		String tipo;
		ExpresionReferencia id;
		Expresion exp;
		int linea;
		DeclaracionCompuesta(String tipo, ExpresionReferencia id, Expresion exp, int linea){
			//System.out.println("genera DeclaracionCompuesta");
			this.tipo = tipo;
			this.id = id;
			this.exp = exp;
			this.linea = linea;
		}
	}

	// Para las repeticiones 'while'
	static class Repeticion extends Sentencia{
		Expresion cond;
		BloqueDeSentencias bloque;
		int linea;
		Repeticion(Expresion exp, BloqueDeSentencias bloque, int linea){
			//System.out.println("genera Repeticion");
			this.cond = exp;;
			this.bloque = bloque;
			this.linea = linea;
		}
	}

	// Para las expresiones binarias
	static class ExpresionBinaria extends Expresion{
		Expresion expd;
		Expresion expi;
		String op;
		int linea;
		ExpresionBinaria(Expresion expi, String op, Expresion expd, int linea){
			//System.out.println("genera ExpresionBinaria");
			this.expd = expd;
			this.op = op;
			this.expi = expi;
			this.linea = linea;
		}
	}

	// Para las expresiones unarias
	static class ExpresionUnaria extends Expresion{
		Expresion exp;
		int linea;
		ExpresionUnaria(Expresion exp, int linea){
			//System.out.println("genera ExpresionUnaria");
			this.exp = exp;
			this.linea = linea;
		}
	}

	// Para las decisiones 'if condicion bloqueSentencias', 'if condicion bloqueSentencias else bloqueSentencias'
	static class Decision extends Sentencia{
		Expresion cond;
		BloqueDeSentencias bloque;
		BloqueDeSentencias bloquesn;
		boolean sn = false;
		int linea;
		Decision(Expresion exp, BloqueDeSentencias bloque, int linea){
			//System.out.println("genera Decision");
			this.cond = exp;;
			this.bloque = bloque;
			this.linea = linea;
		}

		Decision(Expresion exp, BloqueDeSentencias bloque, BloqueDeSentencias bloquesn, int linea){
			//System.out.println("genera Decision");
			this.cond = exp;;
			this.bloque = bloque;
			this.linea = linea;
			this.sn = true;
			this.bloquesn = bloquesn;
		}
	}

	// Para las asignaciones id = exp
	static class Asignacion extends Operacion{
		ExpresionReferencia id;
		Expresion exp;
		int linea;
		Asignacion(ExpresionReferencia id, Expresion exp, int linea){
			//System.out.println("genera Asignacion");
			this.id = id;
			this.exp = exp;;
			this.linea = linea;
		}
	}

	// Para las iteracion 'for'
	static class Iteracion extends Sentencia{
		ExpresionReferencia id;
		ExpresionLiteral el;
		Expresion cond;
		BloqueDeSentencias bloque;
		int linea;
		Iteracion(ExpresionReferencia id, ExpresionLiteral el, Expresion cond, BloqueDeSentencias bloque, int linea){
			//System.out.println("genera Iteracion");
			this.id = id;
			this.el = el;
			this.cond = cond;
			this.bloque = bloque;
			this.linea = linea;
		}
	}
}