import java.util.Collections;


public class ASTPrinter{

	private int nivel = 1;
	private String tabs = "";
	private String tabs(){
		tabs = "";
		for(int i=0;i<nivel;i++){
			tabs +="\t";
		}
		return tabs;
	}
    
    
	public void print(AST.Programa p){
		String tabs = tabs();
		System.out.println(tabs+"[Programa:");
		nivel++;
		this.print(p.bloqueDeSentencias);
		System.out.println(tabs+"]");
	}
	
	private void print(AST.BloqueDeSentencias b){
		String tabs = tabs();
		Collections.reverse(b.sentencias);
		System.out.println(tabs+"[BloqueDeSentencias:");
		nivel++;
		for(AST.Sentencia sentencia:b.sentencias){
			this.print(sentencia);
		}
		System.out.println(tabs+"]");
		nivel--;
	}
	
	private void print(AST.Sentencia s){
		if (s instanceof AST.Operacion) this.print((AST.Operacion)s);
		else if (s instanceof AST.Declaracion) this.print((AST.Declaracion)s);
		else if (s instanceof AST.Repeticion) this.print((AST.Repeticion)s);
		else if (s instanceof AST.Decision) this.print((AST.Decision)s);
		else if (s instanceof AST.Iteracion) this.print((AST.Iteracion)s);
	}
	
	private void print(AST.Operacion o){
		 if (o instanceof AST.OperacionSalida) this.print((AST.OperacionSalida)o);
		 else if (o instanceof AST.OperacionEntrada) this.print((AST.OperacionEntrada)o);
		 else if (o instanceof AST.Asignacion) this.print((AST.Asignacion)o);
	}
	
	// Para dibujar 'escribe exp;'
	private void print(AST.OperacionSalida os){
		String tabs = tabs();
		System.out.println(tabs+"[OperacionSalida: ");
		nivel++;
		this.print(os.exp);
		System.out.println("\n"+tabs+"]");
		nivel--;
	}

	// Para dibujar la operacion 'lee id;'
	private void print(AST.OperacionEntrada os){
		String tabs = tabs();
		System.out.println(tabs+"[OperacionEntrada: ");
		nivel++;
		this.print(os.id); // pintamos el identificador
		System.out.println("\n"+tabs+"]");
		nivel--;
	}

	private void print(AST.Expresion e){
		if (e instanceof AST.ExpresionLiteral) this.print((AST.ExpresionLiteral)e);
		else if (e instanceof AST.ExpresionReferencia) this.print((AST.ExpresionReferencia)e); // si es un identificador
		else if (e instanceof AST.ExpresionBinaria) this.print((AST.ExpresionBinaria)e); // si es una expresion binaria
		else if (e instanceof AST.ExpresionUnaria) this.print((AST.ExpresionUnaria)e); // si es una expresion unaria
	}

	// Para dibujar las literales
	private void print(AST.ExpresionLiteral e){
		String tabs = tabs();
		if(e.literal instanceof Integer)
			System.out.println(tabs+e.literal); // Pintamos un entero
		else if(e.literal instanceof String)
				System.out.println(tabs+"\""+e.literal+"\""); // Pintamos una cadena
		else
			if((Boolean) e.literal) System.out.println(tabs+"verdadero"); // Pintamos un true
			else System.out.println(tabs+"falso"); // Pintamos un false
	}

	// Para dibujar los identificadores
	private void print(AST.ExpresionReferencia e){
		String tabs = tabs();
		System.out.println(tabs+"Id "+e.id+"");
	}

	// Para dibujar una declaracion
	// Se hace sobre un identificador unicamente
	private void print(AST.Declaracion d){
		if (d instanceof AST.DeclaracionSimple) this.print((AST.DeclaracionSimple)d);
		else if (d instanceof AST.DeclaracionCompuesta) this.print((AST.DeclaracionCompuesta)d);
	}

	//Para dibujar declaracion 'tipo id'
	private void print(AST.DeclaracionSimple ds){
		String tabs = tabs();
		System.out.println(tabs+"[Declaracion"+ds.tipo+": ");
		nivel++;
		this.print(ds.id); // pintamos el identificador
		System.out.println("\n"+tabs+"]");
		nivel--;
	}

	//Para dibujar declaracion 'tipo id = exp'
	private void print(AST.DeclaracionCompuesta dc){
		String tabs = tabs();
		System.out.println(tabs+"[Declaracion"+dc.tipo+"ConAsignacion: ");
		nivel++;
		this.print(dc.id); // pintamos el identificador
		System.out.println(tabs+"=");
		this.print(dc.exp); // pintamos el valor (expresion)
		System.out.println("\n"+tabs+"]");
		nivel--;
	}

	// Para dibujar una repeticion
	private void print(AST.Repeticion r){
		String tabs = tabs();
		System.out.println(tabs+"[Repeticion: ");
		nivel++;
		this.print(r.cond); // pintamos la condicion
		this.print(r.bloque); // pintamos el bloque de sentencias
		System.out.println("\n"+tabs+"]");
		nivel--;
	}

	// Para dibujar una expresion binaria
	private void print(AST.ExpresionBinaria eb){
		String tabs = tabs();
		System.out.println(tabs+"[ExpresionBinaria: ");
		nivel++;
		this.print(eb.expi); // pintamos el identificador
		System.out.println(tabs+eb.op);
		this.print(eb.expd); // pintamos el identificador
		System.out.println("\n"+tabs+"]");
		nivel--;
	}

	// Para dibujar una expresion unaria
	private void print(AST.ExpresionUnaria eb){
		String tabs = tabs();
		System.out.println(tabs+"[ExpresionUnaria: ");
		nivel++;
		System.out.println(tabs+"no");
		this.print(eb.exp); // pintamos la expresion
		System.out.println("\n"+tabs+"]");
		nivel--;
	}

	// Para dibujar un if
	private void print(AST.Decision d){
		String tabs = tabs();
		System.out.println(tabs+"[Decision: ");
		nivel++;
		System.out.println(tabs+"si");
		this.print(d.cond); // pintamos la condicion
		System.out.println(tabs+"entonces");
		this.print(d.bloque); // pintamos el bloque de sentencias
		if (d.sn) {
			System.out.println(tabs+"si no");
			this.print(d.bloquesn); // pintamos el bloque de sentencias
		}
		System.out.println("\n"+tabs+"]");
		nivel--;
	}

	// Para dibujar una asignacion
	private void print(AST.Asignacion a){
		String tabs = tabs();
		System.out.println(tabs+"[Asignacion: ");
		nivel++;
		this.print(a.id); // pintamos el id
		System.out.println(tabs+"=");
		this.print(a.exp); // pintamos la expresion
		System.out.println("\n"+tabs+"]");
		nivel--;
	}

	// Para dibujar una iteracion
	private void print(AST.Iteracion i){
		String tabs = tabs();
		System.out.println(tabs+"[Iteracion: ");
		nivel++;
		System.out.println(tabs+"para");
		this.print(i.id); // pintamos el id
		System.out.println(tabs+"desde");
		this.print(i.el); // pintamos la literal
		System.out.println(tabs+"hasta");
		this.print(i.cond); // pintamos el id
		this.print(i.bloque); // pintamos la expresion
		System.out.println("\n"+tabs+"]");
		nivel--;
	}
}