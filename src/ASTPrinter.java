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
		nivel--;
	}

	private void print(AST.ExpresionLiteral e){
		String tabs = tabs();
		System.out.println(tabs+"\""+e.literal+"\"");
	}
}