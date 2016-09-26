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
		if (e instanceof AST.ExpresionReferencia) this.print((AST.ExpresionReferencia)e);
	}

	private void print(AST.ExpresionLiteral e){
		String tabs = tabs();
		System.out.println(tabs+"\""+e.literal+"\"");
		nivel--;
	}

	//A partir de aqui es lo que agregue
	private void print(AST.ExpresionReferencia e){
		String tabs = tabs();
		System.out.println(tabs+"Id "+e.id+"");
		nivel--;
	}

	private void print(AST.OperacionEntrada os){
		String tabs = tabs();
		System.out.println(tabs+"[OperacionEntrada: ");
		nivel++;
		this.print(os.id);
		System.out.println("\n"+tabs+"]");
	}
}