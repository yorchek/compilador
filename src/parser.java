
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20141202 (SVN rev 60)
//----------------------------------------------------

import java_cup.runtime.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20141202 (SVN rev 60) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\011\000\002\002\004\000\002\003\006\000\002\004" +
    "\003\000\002\004\004\000\002\005\004\000\002\006\003" +
    "\000\002\010\004\000\002\011\003\000\002\012\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\020\000\004\004\005\001\002\000\004\002\022\001" +
    "\002\000\004\005\006\001\002\000\004\007\011\001\002" +
    "\000\004\010\ufffc\001\002\000\004\006\021\001\002\000" +
    "\004\011\017\001\002\000\006\006\uffff\007\011\001\002" +
    "\000\004\010\014\001\002\000\006\006\ufffd\007\ufffd\001" +
    "\002\000\004\006\ufffe\001\002\000\004\010\ufffa\001\002" +
    "\000\004\010\ufff9\001\002\000\004\010\ufffb\001\002\000" +
    "\004\002\000\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\020\000\004\003\003\001\001\000\002\001\001\000" +
    "\002\001\001\000\012\004\007\005\011\006\012\010\006" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\011" +
    "\017\012\015\001\001\000\012\004\014\005\011\006\012" +
    "\010\006\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public void report_error(String message, Object info) {
        StringBuilder m = new StringBuilder(message);
        if (info instanceof java_cup.runtime.Symbol) {
            java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);
            if (s.left >= 0) {
                m.append(" en linea "+(s.left+1));
                if (s.right >= 0)
                    m.append(", columna "+(s.right+1));
            }
        }
        System.err.println(m);
 }
    public void report_fatal_error(String message, Object info) {
        report_error(message, info);
        System.exit(1);
    }
    
    public void syntax_error(Symbol s){
        report_error("ERROR de sintaxis", s);
    }
    public void unrecovered_syntax_error(Symbol s)throws Exception{
        report_fatal_error("El analizador sintactico no puede continuar",null);
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= programa EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		AST.Programa start_val = (AST.Programa)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // programa ::= PROGRAMA LLAVE_IZQ bloqueDeSentencias LLAVE_DER 
            {
              AST.Programa RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String p = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		AST.BloqueDeSentencias b = (AST.BloqueDeSentencias)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT= new AST.Programa(b,pleft);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("programa",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // bloqueDeSentencias ::= sentencia 
            {
              AST.BloqueDeSentencias RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		AST.Sentencia s = (AST.Sentencia)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		ArrayList bloque = new ArrayList();bloque.add(s);RESULT= new AST.BloqueDeSentencias(bloque, sleft);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("bloqueDeSentencias",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // bloqueDeSentencias ::= sentencia bloqueDeSentencias 
            {
              AST.BloqueDeSentencias RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		AST.Sentencia s = (AST.Sentencia)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int bloqueleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bloqueright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		AST.BloqueDeSentencias bloque = (AST.BloqueDeSentencias)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		bloque.sentencias.add(s); RESULT= bloque;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("bloqueDeSentencias",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // sentencia ::= operacion MARCADOR_FIN_SENTENCIA 
            {
              AST.Sentencia RESULT =null;
		int opleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		AST.Operacion op = (AST.Operacion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT= op;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("sentencia",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // operacion ::= operacionSalida 
            {
              AST.Operacion RESULT =null;
		int osleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int osright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		AST.OperacionSalida os = (AST.OperacionSalida)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT=os;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("operacion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // operacionSalida ::= OP_ESCRITURA expresion 
            {
              AST.OperacionSalida RESULT =null;
		int oeleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int oeright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String oe = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int expresionleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int expresionright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		AST.Expresion expresion = (AST.Expresion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT= new AST.OperacionSalida(expresion,oeleft);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("operacionSalida",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // expresion ::= expresionLiteral 
            {
              AST.Expresion RESULT =null;
		int elleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int elright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		AST.ExpresionLiteral el = (AST.ExpresionLiteral)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT= el;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // expresionLiteral ::= LITERAL_CADENA 
            {
              AST.ExpresionLiteral RESULT =null;
		int lcleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int lcright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String lc = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new AST.ExpresionLiteral(lc,lcleft);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresionLiteral",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
