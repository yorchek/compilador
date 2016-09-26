

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
		
	}
		
	private void check(AST.Operacion o){
		if (o instanceof AST.OperacionSalida) this.check((AST.OperacionSalida)o);
		if (o instanceof AST.OperacionEntrada) this.check((AST.OperacionEntrada)o);
	}
	
	private void check(AST.OperacionSalida os){}
	private void check(AST.OperacionEntrada os){}

	
	private String getTipo(AST.Expresion n){
		if(n instanceof AST.ExpresionLiteral){ 
			AST.ExpresionLiteral el = (AST.ExpresionLiteral)n;
			
			Object literal = el.literal;
			if(literal instanceof String) return "cadena";
			else if (literal instanceof Boolean) return "logico";
			else if (literal instanceof Integer){System.out.println("Si es un entero"); return "entero";}
			return "indefinido";
			
		}
		if(n instanceof AST.ExpresionReferencia) {return "identificador";}
		return "indefinido";
	}
	
	public int getNumErr(){
		return numErr;
	}
}
	
