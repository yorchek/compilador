
public class SymbolTableBuilder{
	private SymbolTable symtable;
	private int numErr;

    public SymbolTableBuilder(){
    	symtable = new SymbolTable();
    	numErr = 0;
    }
    
    
	public SymbolTable build(AST.Programa p){
		this.build(p.bloqueDeSentencias);
		return symtable;
	}
	
	private void build(AST.BloqueDeSentencias b){
		for(AST.Sentencia sentencia:b.sentencias){
			this.build(sentencia);
		}
	}
	
	private void build(AST.Sentencia s){}
			
	
	public int getNumErr(){
		return numErr;
	}

}