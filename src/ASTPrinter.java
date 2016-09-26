import java.util.Collections;


public class ASTPrinter{

	private int nivel = 2;
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
	}
	
	private void print(AST.Sentencia s){
		if (s instanceof AST.Operacion) this.print((AST.Operacion)s);
		if (s instanceof AST.Declaracion) this.print((AST.Declaracion)s);
	}
	
	private void print(AST.Operacion o){
		 if (o instanceof AST.OperacionSalida) this.print((AST.OperacionSalida)o);
		 if (o instanceof AST.OperacionEntrada) this.print((AST.OperacionEntrada)o);
	}
	
	private void print(AST.OperacionSalida os){
		String tabs = tabs();
		System.out.println(tabs+"[OperacionSalida: ");
		nivel++;
		this.print(os.exp);
		System.out.println("\n"+tabs+"]");
	}

	private void print(AST.Expresion e){
		if (e instanceof AST.ExpresionLiteral) this.print((AST.ExpresionLiteral)e);
		if (e instanceof AST.ExpresionReferencia) this.print((AST.ExpresionReferencia)e); // si es un identificador
	}

	// Para dibujar las literales
	private void print(AST.ExpresionLiteral e){
		String tabs = tabs();
		System.out.println(tabs+"\""+e.literal+"\"");
		nivel--;
	}

	// Para dibujar los identificadores
	private void print(AST.ExpresionReferencia e){
		String tabs = tabs();
		System.out.println(tabs+"Id "+e.id+"");
		nivel--;
	}

	// Para dibujar la operacion 'lee'
	// Se hace sobre un identificador unicamente
	private void print(AST.OperacionEntrada os){
		String tabs = tabs();
		System.out.println(tabs+"[OperacionEntrada: ");
		nivel++;
		this.print(os.id); // pintamos el identificador
		System.out.println("\n"+tabs+"]");
	}

	// Para dibujar una declaracion
	// Se hace sobre un identificador unicamente
	private void print(AST.Declaracion d){
		if (d instanceof AST.DeclaracionSimple) this.print((AST.DeclaracionSimple)d);
	}

	//Para dibujar
	private void print(AST.DeclaracionSimple ds){
		String tabs = tabs();
		System.out.println(tabs+"[Declaracion: ");
		nivel++;
		this.print(ds.id); // pintamos el identificador
		System.out.println("\n"+tabs+"]");
	}
}