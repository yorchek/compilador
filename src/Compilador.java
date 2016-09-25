
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import java_cup.runtime.Symbol;

public class Compilador{

	static HashMap mapa_symbolos = new HashMap();// Elementos léxicos del lenguaje javanol

	private static void init(){
		Field [] fields =  sym.class.getDeclaredFields();
		for (Field field:fields){
			try{
				mapa_symbolos.put(field.get(sym.class),field.getName());
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}

	
	public static void main(String args[]){

		init();
		int etapa = 0;
		String fase = args[2];
		if(fase.equals("alexico"))
			etapa = 0;
		else if(fase.equals("as"))
				etapa = 1;
		else if(fase.equals( "asemantico"))
				etapa = 2;
		else if(fase.equals( "gcodigo"))
				etapa = 3;
		else if(fase.equals( "execasm"))
				etapa = 4;
		else{
				System.out.println("Opción de compilación inválida");
				System.exit(1);
		}
				
		int ERROR = 0;
		
		if(etapa!=4){ //Compilación
		String fuente = args[1];
		String src = args[0]+"/"+fuente;
		
		System.out.println("\n\n* Programa fuente: "+fuente);
		System.out.println("\n\n* INICIANDO ANALISIS LEXICO:");
		try{
			FileInputStream stream=new FileInputStream(src);
			Reader reader=new InputStreamReader(stream, "UTF-8");
			Lexer lexer= new Lexer(reader);
			Symbol symbol  = lexer.next_token();

			while(symbol.sym!=sym.EOF){ 
				if(symbol.sym==sym.error){
					System.out.println("\t  ERROR:Token \""+symbol.value+"\" DESCONOCIDO encontrado en línea: "+symbol.left+", columna: "+symbol.right);

				}else{
					System.out.println("\t\tToken "+mapa_symbolos.get(symbol.sym)+(symbol.value!=null?" con valor: "+symbol.value:"")+" encontrado en línea: "+symbol.left+", columna: "+symbol.right);
				}
				symbol  = lexer.next_token();
			}
			
			if(lexer.numErr>0){
				ERROR = 1;
			}
		}catch(Exception e){
			ERROR = 1;
		}
			System.out.println("\n\n* TERMINA ANALISIS LEXICO (estado "+ERROR+")");
			AST.Programa programa = null;
			if(etapa>0){ //Análisis léxico
				if(ERROR!=0){
					System.out.println("* NO ES POSIBLE CONTINUAR CON LA COMPILACION DEBIDO A ERRORES ANTERIORES");
					return;
				}
				try{
			System.out.println("\n\n* INICIANDO ANALISIS SINTACTICO:");
			parser parser=new parser(new Lexer(new InputStreamReader(new FileInputStream(src), "UTF-8")));
			programa = (AST.Programa)parser.parse().value;
			ASTPrinter astprinter = new ASTPrinter();
			System.out.println("\t\tÁrbol de Sintaxis Abstracta (AST):\n");
			astprinter.print(programa);
				}catch(Exception e){
					System.out.println(e.getMessage());
					ERROR = 1;
				}
				
			
			
			System.out.println("\n\n* TERMINA ANALISIS SINTACTICO (estado "+ERROR+")");
			}
			
			if(etapa>1){ //Análisis sintáctico
				if(ERROR!=0){
					System.out.println("* NO ES POSIBLE CONTINUAR CON LA COMPILACION DEBIDO A ERRORES ANTERIORES");
					return;
				}
				try{
			System.out.println("* INICIANDO ANALISIS SEMANTICO:");
			SymbolTableBuilder stb =new SymbolTableBuilder();
			SymbolTable tabla_simbolos = stb.build(programa);
			if(stb.getNumErr()!=0){
				ERROR = 1;
			}
			System.out.println("* CREANDO TABLA DE SIMBOLOS:");
			System.out.println("\t\t"+tabla_simbolos);
			TypeChecker tchecker =new TypeChecker(tabla_simbolos);
			System.out.println("* EJECUTANDO CHEQUEO DE TIPOS:");
			tchecker.check(programa);
			if(tchecker.getNumErr()>0) ERROR = 1;
				}catch(Exception e){
					ERROR = 1;
				}
				
				System.out.println("\n\n* TERMINA ANALISIS SEMANTICO (estado "+ERROR+")");
				
			}
			
			
			if(etapa>2){ //Análisis semántico
				if(ERROR!=0){
					System.out.println("* NO ES POSIBLE CONTINUAR CON LA COMPILACION DEBIDO A ERRORES ANTERIORES");
					return;
				}
				try{
			System.out.println("* GENERANDO CODIGO");
			CodeGenerator codeg = new CodeGenerator(args[0]+"/ensamblador/lib/funciones");
			String codigo = codeg.codeFor(programa); 
					String objeto = fuente.replace(".javanol",".asm");
					PrintWriter file = new PrintWriter(args[0]+"/ensamblador/"+objeto);
					file.print(codigo);
					file.close();
					
					System.out.println("* EL CODIGO GENERADO HA SIDO GUARDADO EN: programas/"+objeto);
				}catch(Exception e){
					System.out.println(e.getMessage());
					ERROR = 1;
				}
				
				System.out.println("\n\n* COMPILACION FINALIZADA (estado "+ERROR+")");
				
			}
		} else{ // Ejecución del programa ensamblador
		System.out.println("* EJECUTANDO "+args[1]);
		String[] argumentos = {args[0]+"/ensamblador/"+args[1]};
		Mars.main(argumentos);
		return;
	}

	}
}

