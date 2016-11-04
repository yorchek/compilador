
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
	
	private void build(AST.Sentencia s){
		if (s instanceof AST.Declaracion) this.build((AST.Declaracion)s);
		else if (s instanceof AST.Repeticion) this.build((AST.Repeticion)s);
		else if (s instanceof AST.Iteracion) this.build((AST.Iteracion)s);
		else if (s instanceof AST.Decision) this.build((AST.Decision)s);
		else if (s instanceof AST.Operacion) this.build((AST.Operacion)s);
	}

	private void build(AST.Declaracion d){
		if (d instanceof AST.DeclaracionSimple) this.build((AST.DeclaracionSimple)d);
		else if (d instanceof AST.DeclaracionCompuesta) this.build((AST.DeclaracionCompuesta)d);
	}

	private void build(AST.DeclaracionSimple ds){
		if (symtable.lookup((String)ds.id.id) == null) { // Si el id no ha sido declarado
			symtable.add((String)ds.id.id, ds.tipo); // agregamos el nuevo con el tipo
		} else { // si ya esta debe mandar un error
			numErr++;
			String id = (String)ds.id.id;
			System.out.println("error! en la linea "+(ds.linea+1)+" ya se declaro previamente "+id);
		}
	}

	private void build(AST.DeclaracionCompuesta dc){
		if (symtable.lookup((String)dc.id.id) == null) { // Si el id no ha sido declarado
			symtable.add((String)dc.id.id, dc.tipo); // agregamos el nuevo con el tipo
		} else { // si ya esta debe mandar un error
			numErr++;
			String id = (String)dc.id.id;
			System.out.println("error! en la linea "+(dc.linea+1)+" ya se declaro previamente "+id);
		}
		this.build(dc.exp);
	}

	public int getNumErr(){
		return numErr;
	}

	private void build(AST.Repeticion r){
		this.build(r.cond);
		this.build(r.bloque);
	}

	private void build(AST.Iteracion i){
		this.build(i.id);
		this.build(i.el);
		this.build(i.cond);
		this.build(i.bloque);
	}

	private void build(AST.Decision d){
		this.build(d.cond);
		this.build(d.bloque);
	}

	private void build(AST.Expresion e){
		if (e instanceof AST.ExpresionReferencia) this.build((AST.ExpresionReferencia)e);
		else if (e instanceof AST.ExpresionLiteral) this.build((AST.ExpresionLiteral)e);
		else if (e instanceof AST.ExpresionBinaria) this.build((AST.ExpresionBinaria)e);
		else if (e instanceof AST.ExpresionUnaria) this.build((AST.ExpresionUnaria)e);
	}

	private void build(AST.ExpresionReferencia e){
		String id = (String)e.id;
		if (symtable.lookup((String)e.id) == null) { // Si el id no ha sido declarado
			numErr++;
			System.out.println("error! en la linea "+(e.linea+1)+" no se ha declarado "+id);
		}
	}

	private void build(AST.ExpresionLiteral el){}
	private void build(AST.ExpresionBinaria eb){
		this.build(eb.expi);
		this.build(eb.expd);
	}

	private void build(AST.ExpresionUnaria eu){
		this.build(eu.exp);
	}

	private void build(AST.Operacion d){
		if (d instanceof AST.Asignacion) this.build((AST.Asignacion)d);
	}

	private void build(AST.Asignacion a){
		this.build(a.id);
		this.build(a.exp);
	}

}