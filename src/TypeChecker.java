

public class TypeChecker{
private SymbolTable symtable;
private int numErr;

    public TypeChecker(SymbolTable symt){
    	symtable = symt;
    	numErr = 0;
    }
    
    
	public void check(AST.Programa p){
		this.check(p.bloqueDeSentencias);
	}
	
	private void check(AST.BloqueDeSentencias b){
		for(AST.Sentencia sentencia:b.sentencias){
			this.check(sentencia);
		}
	}
	
	private void check(AST.Sentencia s){
		if (s instanceof AST.Operacion) this.check((AST.Operacion)s);
		else if (s instanceof AST.Declaracion) this.check((AST.Declaracion)s);
		else if (s instanceof AST.Decision) this.check((AST.Decision)s);
		else if (s instanceof AST.Repeticion) this.check((AST.Repeticion)s);
		else if (s instanceof AST.Iteracion) this.check((AST.Iteracion)s);
	}
		
	private void check(AST.Operacion o){
		if (o instanceof AST.OperacionSalida) this.check((AST.OperacionSalida)o);
		else if (o instanceof AST.OperacionEntrada) this.check((AST.OperacionEntrada)o);
		else if (o instanceof AST.Asignacion) this.check((AST.Asignacion)o);
	}
	
	private void check(AST.OperacionSalida os){}
	private void check(AST.OperacionEntrada oe){}
	private void check(AST.Asignacion a){
		String id = (String)a.id.id;
		String tipoEsperado = (String)symtable.lookup((String)a.id.id); // buscamos el tipo de la variable a asignar
		String tipoExp = getTipo(a.exp);
		if (tipoEsperado == null) {
			numErr++;
			System.out.println("error! en la linea "+(a.linea+1)
				+" no se puede realizar la asignacion no ha sido declarado "+ id);
		} else if(!tipoEsperado.equals(tipoExp)){
			numErr++;
			System.out.println("error! en la linea "+(a.linea+1)
				+" declaracion se esperaba '"+tipoEsperado+"' se encontro '"+ tipoExp+"'");
		}
	}

	
	private String getTipo(AST.Expresion n){
		if(n instanceof AST.ExpresionLiteral){ 
			AST.ExpresionLiteral el = (AST.ExpresionLiteral)n;
			
			Object literal = el.literal;	
			if(literal instanceof String) return "cadena";
			else if (literal instanceof Boolean) return "logico";
			else if (literal instanceof Integer) return "entero";
			return "indefinido";
		}
		else if(n instanceof AST.ExpresionReferencia){ 
			AST.ExpresionReferencia er = (AST.ExpresionReferencia)n;
			String tipo = (String)symtable.lookup((String)er.id); // buscamos el tipo de la variable
			return tipo == null ? "indefinido" : tipo; // si fue declarada regresa su tipo si no regresa indefinido
		}
		else if(n instanceof AST.ExpresionBinaria){ // vemos el tipo resultado al hacer la operacion binaria
			AST.ExpresionBinaria eb = (AST.ExpresionBinaria)n;

			String tipoi = getTipo(eb.expi); // tomamos el tipo del lado izquierdo
			String tipod = getTipo(eb.expd); // tomamos el tipo del lado derecho
			switch(eb.op){ // vemos los casos del operador binario
				case "+":
					if(tipoi.equals("cadena") || tipod.equals("cadena")) // si alguna expresion es cadena
						return "cadena";  // va a ser otra concatenacion por lo que regresa cadena
					else if(tipoi.equals("entero") && tipod.equals("entero"))  // o se aplica solo sobre enteros
						return "entero";
					return "indefinido"; // si no cumplen regresan indefinido
				case "-": // 
				case "*": // Estos operadores solo se aplican sobre enteros y regresan un entero
				case "/": // 
				case "%": // 
					if(tipoi.equals("entero") && tipod.equals("entero"))
						return "entero";
					else { // si no cumplen imprimen el error
						System.out.println("error! en la linea "+(eb.linea+1)
							+" se esperaba 'entero - entero' se encontro '"+ tipoi+" - "+tipod+"'");
						return "indefinido";
					}
				case "o":  // Estos operadores solo se aplican sobre expresiones logicas
				case "y":  //
					if(tipoi.equals("logico") && tipod.equals("logico"))
						return "logico";
					else { // si no cumplen imprimen el error
						System.out.println("error! en la linea "+(eb.linea+1)
							+" se esperaba 'entero - entero' se encontro '"+ tipoi+" - "+tipod+"'");
						return "indefinido";
					}
				case "==":  // Este operador solo se aplica sobre expresiones del mismo tipo
					if(tipoi.equals(tipod))
						return "logico";
					else { // si no cumplen imprimen el error
						System.out.println("error! en la linea "+(eb.linea+1)
							+" se esperaban expresiones del mismo tipo se encontro '"+ tipoi+" - "+tipod+"'");
						return "indefinido";
					}
				case "<":  //
				case ">":  // Estos operadores solo se aplican sobre enteros
				case "<=": // y regresan un valor logico
				case ">=": //
					if(tipoi.equals("entero") && tipod.equals("entero"))
						return "logico";
					else { // si no cumplen imprimen el error
						System.out.println("error! en la linea "+(eb.linea+1)
							+" se esperaba 'entero - entero' se encontro '"+ tipoi+" - "+tipod+"'");
						return "indefinido";
					}

			}
		}
		else if(n instanceof AST.ExpresionUnaria){ // vemos el tipo resultado al hacer la operacion unaria
			AST.ExpresionUnaria eu = (AST.ExpresionUnaria)n;

			String tipo = getTipo(eu.exp); // guardamos en una variable para idenificar el error en la expresion
			if(tipo.equals("logico")) // si la expresion es de tipo logico
				return "logico"; // regresamos que es correcto
			//si no lo es se imprime el error
			System.out.println("error! en la linea "+(eu.linea+1) 
				+" se esperaba -- no 'expresion logica' -- se encontro -- no '"+ tipo+"' --");
		}	
		return "indefinido"; // no es una expresion correcta
	}
	
	public int getNumErr(){
		return numErr;
	}

	private void check(AST.Declaracion d){
		if (d instanceof AST.DeclaracionSimple) this.check((AST.DeclaracionSimple)d);
		else if (d instanceof AST.DeclaracionCompuesta) this.check((AST.DeclaracionCompuesta)d);
	}

	private void check(AST.DeclaracionSimple ds){}
	private void check(AST.DeclaracionCompuesta dc){
		String tipoEsperado = dc.tipo; // tomamos el tipo esperado en la declaracion
		String tipoExp = getTipo(dc.exp); // vemos el tipo de la expresion que se le asigna
		if(tipoEsperado.equals(tipoExp)) // si el tipo esperado y el el tipo de la expresion son iguales
			System.out.println("es de tipo "+tipoEsperado); // 'decimos' que si es valido
		else { // si no cumplen imprimen el error
			numErr++;
			System.out.println("error! en la linea "+(dc.linea+1)+" se esperaba expresion de tipo '"
				+tipoEsperado+"' se encontro '"+tipoExp+"'");
		}
	}

	private void check(AST.Decision d){ // si cond entonces
		String tipoExp = getTipo(d.cond); // vemos el tipo de la expresion que se le asigna
		if(tipoExp.equals("logico")) // si el tipo esperado y el el tipo de la expresion son iguales
			System.out.println("es de tipo "+tipoExp); // 'decimos' que si es valido
		else { // si no cumplen imprimen el error
			numErr++;
			System.out.println("error! en la linea "+(d.linea+1)+" se esperaba expresion de tipo 'logico' se encontro '"
				+tipoExp+"'");
		}
		this.check(d.bloque);
		if(d.sn){ // si no
			this.check(d.bloquesn);
		}
	}

	private void check(AST.Repeticion r){ // mientras cond
		String tipoExp = getTipo(r.cond); // vemos el tipo de la expresion que se le asigna
		if(tipoExp.equals("logico")) // si el tipo esperado y el el tipo de la expresion son iguales
			System.out.println("es de tipo "+tipoExp); // 'decimos' que si es valido
		else { // si no cumplen imprimen el error
			numErr++;
			System.out.println("error! en la linea "+(r.linea+1)+" se esperaba expresion de tipo 'logico' se encontro '"
				+tipoExp+"'");
		}
		this.check(r.bloque);
	}

	private void check(AST.Iteracion i){ // para id desde el hasta cond
		String tipoExp = getTipo(i.id); // vemos el tipo del id sobre el que va a iterar
		if(tipoExp.equals("entero")) // si el tipo esperado y el el tipo de la expresion son iguales
			System.out.println("es de tipo "+tipoExp); // 'decimos' que si es valido
		else { // si no cumplen imprimen el error
			numErr++;
			System.out.println("error! en la linea "+(i.linea+1)+" se esperaba una variable de tipo 'entero' se encontro '"
				+tipoExp+"'");
		}
		tipoExp = getTipo(i.el); // vemos el valor inicial de la condicional
		if(tipoExp.equals("entero")) // si el tipo esperado y el el tipo de la expresion son iguales
			System.out.println("es de tipo "+tipoExp); // 'decimos' que si es valido
		else { // si no cumplen imprimen el error
			numErr++;
			System.out.println("error! en la linea "+(i.linea+1)+" se esperaba literal de tipo 'entero' se encontro '"
				+tipoExp+"'");
		}
		tipoExp = getTipo(i.cond); // vemos el valor final de la condicional
		if(tipoExp.equals("entero")) // si el tipo esperado y el el tipo de la expresion son iguales
			System.out.println("es de tipo "+tipoExp); // 'decimos' que si es valido
		else { // si no cumplen imprimen el error
			numErr++;
			System.out.println("error! en la linea "+(i.linea+1)+" se esperaba expresion de tipo 'entero' se encontro '"
				+tipoExp+"'");
		}
		this.check(i.bloque);
	}
}