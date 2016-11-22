import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Hashtable;


public class CodeGenerator{

    String nombreClase;
    SymbolTable table;
	
    public CodeGenerator(String nombreClase, SymbolTable table){
		this.nombreClase = nombreClase;
		this.table = table;
    }

    public String codeFor(AST.Programa p){
		String codigo = this.codeFor(p.bloqueDeSentencias);
		String imp = "import java.util.Scanner;\n";
		return imp+"public class "+nombreClase+"{\n\t public static void main(String[] args){"+codigo+"\n\t}\n}";
    }
		
    private String codeFor(AST.BloqueDeSentencias b){
		String code = "";		
		for(AST.Sentencia sentencia:b.sentencias){
	    	code+="\n"+this.codeFor(sentencia);
		}
		return code;
    }
		
    private String codeFor(AST.Sentencia s){
		if (s instanceof AST.Operacion) return this.codeFor((AST.Operacion)s);
		else if (s instanceof AST.Declaracion) return this.codeFor((AST.Declaracion)s);
		else if (s instanceof AST.Repeticion) return this.codeFor((AST.Repeticion)s);
		else if (s instanceof AST.Decision)  return this.codeFor((AST.Decision)s);
		else if (s instanceof AST.Iteracion) return this.codeFor((AST.Iteracion)s);
		return "";
    }

    private String codeFor(AST.Decision d){
    	String codigo = this.codeFor(d.bloque);
		if(d instanceof AST.Decision) return "\t\t if("+d.cond+"){\n\t\t\t "+codigo+"\n\t\t }";
		return "";
    }

    private String codeFor(AST.Iteracion i){
    	String codigo = this.codeFor(i.bloque);
		if(i instanceof AST.Iteracion) return "\t\t for("+i.id+";"+i.el+";"+i.cond+ "){"+codigo+"\n}";
		return "";
    }

    private String codeFor(AST.Repeticion r){
    	String codigo = this.codeFor(r.bloque);
		if(r instanceof AST.Repeticion) return "\t\t while("+r.cond+"){\n \t\t\t"+codigo+"\n\t\t }";
		return "";
    }
    
    private String codeFor(AST.Declaracion d){
    	if(d instanceof AST.DeclaracionSimple) return this.codeFor((AST.DeclaracionSimple)d);
		else if (d instanceof AST.DeclaracionCompuesta) return this.codeFor((AST.DeclaracionCompuesta)d);
    	return "";
    }		  

    private String codeFor(AST.DeclaracionSimple ds){
    	if(ds.tipo.equals("entero")) return "\t\t int "+ds.id.id+";";
    	else if(ds.tipo.equals("cadena")) return "\t\t String "+ds.id.id+";";
    	else if(ds.tipo.equals("logico")) return "\t\t boolean "+ds.id.id+";";
		return "";    			
    }

    private String codeFor(AST.DeclaracionCompuesta dc){
		if(dc.tipo.equals("entero")) return "\t\t int "+dc.id.id+"="+dc.exp+";";
		else if(dc.tipo.equals("cadena")) return "\t\t String "+dc.id.id+"="+dc.exp+";";
		else if(dc.tipo.equals("logico")) return "\t\t boolean "+dc.id.id+"="+dc.exp+";";
		return "";    			
    }

    private String codeFor(AST.Expresion e){
		if (e instanceof AST.ExpresionLiteral) return this.codeFor((AST.ExpresionLiteral)e);
		else if (e instanceof AST.ExpresionReferencia) return this.codeFor((AST.ExpresionReferencia)e);
		else if (e instanceof AST.ExpresionBinaria) return this.codeFor((AST.ExpresionBinaria)e); 
		else if (e instanceof AST.ExpresionUnaria) return this.codeFor((AST.ExpresionUnaria)e); 
		return "";
    }

    private String codeFor(AST.ExpresionBinaria eb){	
		return ""+eb.expi+""+eb.op+""+eb.expd;
    }

    private String codeFor(AST.ExpresionUnaria eu){	
		return "!"+eu.exp+";";
    }

    private String codeFor(AST.ExpresionReferencia er){	
		return ""+er.id;
    }

    private String codeFor(AST.ExpresionLiteral el){       	
		if(el.literal instanceof String) return "\""+el.literal+"\"";
    	else if(el.literal instanceof Integer) return ""+el.literal;
		else if(el.literal instanceof Boolean) return ""+el.literal;
		return "";
    }
		
    private String codeFor(AST.Operacion o){
		if (o instanceof AST.OperacionSalida) return this.codeFor((AST.OperacionSalida)o);
		else if (o instanceof AST.OperacionEntrada) return this.codeFor((AST.OperacionEntrada)o);
		else if (o instanceof AST.Asignacion) return this.codeFor((AST.Asignacion)o);
		return "";		
    }

    private String codeFor(AST.Asignacion a){
		return ""+a.id.id+ "="+a.exp+";";
    }				

    private String codeFor(AST.OperacionEntrada oe){
	return "\t\t Scanner "+oe.id.id+" = new() Scanner(System.in);";
    }
    
    private String codeFor(AST.OperacionSalida os){
	return "\t\t System.out.println("+codeFor(os.exp)+");";
    }    
}
