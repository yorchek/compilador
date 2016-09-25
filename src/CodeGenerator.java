import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Hashtable;


public class CodeGenerator{

	String datos;
	MIPSResistries registros;
	private static String registro_actual;
	private boolean includeConcat;
	private int numLit =0;
	private String includes;
	
	public CodeGenerator(String includes){
		this.datos="";
		includeConcat = false;
		this.includes = includes;
		registros = new MIPSResistries();
	}

	    
		public String codeFor(AST.Programa p){
			String codigo = this.codeFor(p.bloqueDeSentencias);
			if(includeConcat){
				try{
				byte[] encoded = Files.readAllBytes(Paths.get(includes));
				  String func = new String(encoded, "UTF-8");
				  codigo+="\n"+func;
				}catch(IOException ioe){
					System.out.println("ERROR: No fue posible incluir funciones auxiliares ["+includes+"]");
					ioe.printStackTrace(System.out);
					return "";
				}
			}
			
			return ".data\n "+this.datos+"\n\n .text\n\n programa:"+codigo+"\n\t j fin_programa \n\n fin_programa:";
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
			return "";
		}

		private String codeFor(AST.ExpresionLiteral el){
			registro_actual = registros.getFreeRegister();
			String valor = "";
			String tipo = "";
			if(el.literal instanceof String){ valor ="\""+el.literal+"\""; tipo="asciiz";}
			numLit++;
			this.datos+="\n lit"+numLit+": ."+tipo+" "+valor;
			return "\n\t la "+registro_actual+", "+"lit"+numLit;
		}

		
		private String codeFor(AST.Operacion o){
			if (o instanceof AST.OperacionSalida) return this.codeFor((AST.OperacionSalida)o);
			return "";
			
		}
		
		
		private String codeFor(AST.Expresion e){
			if (e instanceof AST.ExpresionLiteral) return this.codeFor((AST.ExpresionLiteral)e);
			return "";
			
		}
		
		private String codeFor(AST.OperacionSalida os){
			String code = this.codeFor(os.exp);
			//Codigo para convertir a cadena
			code+="\n\t li $v0, 4";
			code+="\n\t move $a0, "+registro_actual;
			code+="\n\t syscall";
			return code;
		}


 private  class MIPSResistries{
	 private  Hashtable<String, Boolean> mips_registries;
	 
	 public  MIPSResistries(){
		 mips_registries = new Hashtable<String,Boolean>();
		 mips_registries.put("$t6",true);
		 mips_registries.put("$t5",true);
		 mips_registries.put("$t4",true);
		 mips_registries.put("$t3",true);
		 mips_registries.put("$t2",true);
		 mips_registries.put("$t1",true);
		 mips_registries.put("$t0",true);
	 }
	 
	 public  String getFreeRegister(){
		 Enumeration<String> enumKey = mips_registries.keys();
		 while(enumKey.hasMoreElements()) {
		     String key = enumKey.nextElement();
		     Boolean val = mips_registries.get(key);
		     mips_registries.put(key, false);
		     if(val.equals(true)){
		     return key;
		     }
		 }
		 return null;
	 }
	 
	 public  void freeRegister(String reg){
		     mips_registries.put(reg, false);
	 }
	 
	 
 }

}