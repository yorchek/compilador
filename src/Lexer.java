/* The following code was generated by JFlex 1.6.0 */

import java_cup.runtime.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.0
 * from the specification file <tt>/home/jorge/Documentos/Compiladores/proyecto/compilador/src/Lexer.jflex</tt>
 */
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int CADENA = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\5\1\3\1\2\1\12\1\13\1\1\16\5\4\0\1\46\1\0"+
    "\1\50\1\0\1\4\1\30\2\0\2\15\1\11\1\30\1\0\1\30"+
    "\1\0\1\10\1\6\11\7\1\0\1\47\1\33\1\31\1\33\2\0"+
    "\32\4\1\0\1\52\2\0\1\4\1\0\1\22\1\44\1\43\1\21"+
    "\1\17\1\24\1\35\1\45\1\37\2\4\1\25\1\36\1\27\1\23"+
    "\1\34\1\4\1\20\1\26\1\40\1\51\1\16\2\4\1\32\1\4"+
    "\1\41\1\0\1\42\1\0\6\5\1\14\32\5\2\0\4\4\4\0"+
    "\1\4\2\0\1\5\7\0\1\4\4\0\1\4\5\0\27\4\1\0"+
    "\37\4\1\0\u01ca\4\4\0\14\4\16\0\5\4\7\0\1\4\1\0"+
    "\1\4\21\0\160\5\5\4\1\0\2\4\2\0\4\4\10\0\1\4"+
    "\1\0\3\4\1\0\1\4\1\0\24\4\1\0\123\4\1\0\213\4"+
    "\1\0\5\5\2\0\236\4\11\0\46\4\2\0\1\4\7\0\47\4"+
    "\11\0\55\5\1\0\1\5\1\0\2\5\1\0\2\5\1\0\1\5"+
    "\10\0\33\4\5\0\3\4\15\0\4\5\7\0\1\4\4\0\13\5"+
    "\5\0\53\4\37\5\4\0\2\4\1\5\143\4\1\0\1\4\10\5"+
    "\1\0\6\5\2\4\2\5\1\0\4\5\2\4\12\5\3\4\2\0"+
    "\1\4\17\0\1\5\1\4\1\5\36\4\33\5\2\0\131\4\13\5"+
    "\1\4\16\0\12\5\41\4\11\5\2\4\4\0\1\4\5\0\26\4"+
    "\4\5\1\4\11\5\1\4\3\5\1\4\5\5\22\0\31\4\3\5"+
    "\244\0\4\5\66\4\3\5\1\4\22\5\1\4\7\5\12\4\2\5"+
    "\2\0\12\5\1\0\7\4\1\0\7\4\1\0\3\5\1\0\10\4"+
    "\2\0\2\4\2\0\26\4\1\0\7\4\1\0\1\4\3\0\4\4"+
    "\2\0\1\5\1\4\7\5\2\0\2\5\2\0\3\5\1\4\10\0"+
    "\1\5\4\0\2\4\1\0\3\4\2\5\2\0\12\5\4\4\7\0"+
    "\1\4\5\0\3\5\1\0\6\4\4\0\2\4\2\0\26\4\1\0"+
    "\7\4\1\0\2\4\1\0\2\4\1\0\2\4\2\0\1\5\1\0"+
    "\5\5\4\0\2\5\2\0\3\5\3\0\1\5\7\0\4\4\1\0"+
    "\1\4\7\0\14\5\3\4\1\5\13\0\3\5\1\0\11\4\1\0"+
    "\3\4\1\0\26\4\1\0\7\4\1\0\2\4\1\0\5\4\2\0"+
    "\1\5\1\4\10\5\1\0\3\5\1\0\3\5\2\0\1\4\17\0"+
    "\2\4\2\5\2\0\12\5\1\0\1\4\17\0\3\5\1\0\10\4"+
    "\2\0\2\4\2\0\26\4\1\0\7\4\1\0\2\4\1\0\5\4"+
    "\2\0\1\5\1\4\7\5\2\0\2\5\2\0\3\5\10\0\2\5"+
    "\4\0\2\4\1\0\3\4\2\5\2\0\12\5\1\0\1\4\20\0"+
    "\1\5\1\4\1\0\6\4\3\0\3\4\1\0\4\4\3\0\2\4"+
    "\1\0\1\4\1\0\2\4\3\0\2\4\3\0\3\4\3\0\14\4"+
    "\4\0\5\5\3\0\3\5\1\0\4\5\2\0\1\4\6\0\1\5"+
    "\16\0\12\5\11\0\1\4\7\0\3\5\1\0\10\4\1\0\3\4"+
    "\1\0\27\4\1\0\12\4\1\0\5\4\3\0\1\4\7\5\1\0"+
    "\3\5\1\0\4\5\7\0\2\5\1\0\2\4\6\0\2\4\2\5"+
    "\2\0\12\5\22\0\2\5\1\0\10\4\1\0\3\4\1\0\27\4"+
    "\1\0\12\4\1\0\5\4\2\0\1\5\1\4\7\5\1\0\3\5"+
    "\1\0\4\5\7\0\2\5\7\0\1\4\1\0\2\4\2\5\2\0"+
    "\12\5\1\0\2\4\17\0\2\5\1\0\10\4\1\0\3\4\1\0"+
    "\51\4\2\0\1\4\7\5\1\0\3\5\1\0\4\5\1\4\10\0"+
    "\1\5\10\0\2\4\2\5\2\0\12\5\12\0\6\4\2\0\2\5"+
    "\1\0\22\4\3\0\30\4\1\0\11\4\1\0\1\4\2\0\7\4"+
    "\3\0\1\5\4\0\6\5\1\0\1\5\1\0\10\5\22\0\2\5"+
    "\15\0\60\4\1\5\2\4\7\5\4\0\10\4\10\5\1\0\12\5"+
    "\47\0\2\4\1\0\1\4\2\0\2\4\1\0\1\4\2\0\1\4"+
    "\6\0\4\4\1\0\7\4\1\0\3\4\1\0\1\4\1\0\1\4"+
    "\2\0\2\4\1\0\4\4\1\5\2\4\6\5\1\0\2\5\1\4"+
    "\2\0\5\4\1\0\1\4\1\0\6\5\2\0\12\5\2\0\2\4"+
    "\42\0\1\4\27\0\2\5\6\0\12\5\13\0\1\5\1\0\1\5"+
    "\1\0\1\5\4\0\2\5\10\4\1\0\44\4\4\0\24\5\1\0"+
    "\2\5\5\4\13\5\1\0\44\5\11\0\1\5\71\0\53\4\24\5"+
    "\1\4\12\5\6\0\6\4\4\5\4\4\3\5\1\4\3\5\2\4"+
    "\7\5\3\4\4\5\15\4\14\5\1\4\17\5\2\0\46\4\12\0"+
    "\53\4\1\0\1\4\3\0\u0149\4\1\0\4\4\2\0\7\4\1\0"+
    "\1\4\1\0\4\4\2\0\51\4\1\0\4\4\2\0\41\4\1\0"+
    "\4\4\2\0\7\4\1\0\1\4\1\0\4\4\2\0\17\4\1\0"+
    "\71\4\1\0\4\4\2\0\103\4\2\0\3\5\40\0\20\4\20\0"+
    "\125\4\14\0\u026c\4\2\0\21\4\1\0\32\4\5\0\113\4\3\0"+
    "\3\4\17\0\15\4\1\0\4\4\3\5\13\0\22\4\3\5\13\0"+
    "\22\4\2\5\14\0\15\4\1\0\3\4\1\0\2\5\14\0\64\4"+
    "\40\5\3\0\1\4\3\0\2\4\1\5\2\0\12\5\41\0\3\5"+
    "\2\0\12\5\6\0\130\4\10\0\51\4\1\5\1\4\5\0\106\4"+
    "\12\0\35\4\3\0\14\5\4\0\14\5\12\0\12\5\36\4\2\0"+
    "\5\4\13\0\54\4\4\0\21\5\7\4\2\5\6\0\12\5\46\0"+
    "\27\4\5\5\4\0\65\4\12\5\1\0\35\5\2\0\13\5\6\0"+
    "\12\5\15\0\1\4\130\0\5\5\57\4\21\5\7\4\4\0\12\5"+
    "\21\0\11\5\14\0\3\5\36\4\12\5\3\0\2\4\12\5\6\0"+
    "\46\4\16\5\14\0\44\4\24\5\10\0\12\5\3\0\3\4\12\5"+
    "\44\4\122\0\3\5\1\0\25\5\4\4\1\5\4\4\1\5\15\0"+
    "\300\4\47\5\25\0\4\5\u0116\4\2\0\6\4\2\0\46\4\2\0"+
    "\6\4\2\0\10\4\1\0\1\4\1\0\1\4\1\0\1\4\1\0"+
    "\37\4\2\0\65\4\1\0\7\4\1\0\1\4\3\0\3\4\1\0"+
    "\7\4\3\0\4\4\2\0\6\4\4\0\15\4\5\0\3\4\1\0"+
    "\7\4\16\0\5\5\30\0\1\12\1\12\5\5\20\0\2\4\23\0"+
    "\1\4\13\0\5\5\5\0\6\5\1\0\1\4\15\0\1\4\20\0"+
    "\15\4\3\0\32\4\26\0\15\5\4\0\1\5\3\0\14\5\21\0"+
    "\1\4\4\0\1\4\2\0\12\4\1\0\1\4\3\0\5\4\6\0"+
    "\1\4\1\0\1\4\1\0\1\4\1\0\4\4\1\0\13\4\2\0"+
    "\4\4\5\0\5\4\4\0\1\4\21\0\51\4\u0a77\0\57\4\1\0"+
    "\57\4\1\0\205\4\6\0\4\4\3\5\16\0\46\4\12\0\66\4"+
    "\11\0\1\4\17\0\1\5\27\4\11\0\7\4\1\0\7\4\1\0"+
    "\7\4\1\0\7\4\1\0\7\4\1\0\7\4\1\0\7\4\1\0"+
    "\7\4\1\0\40\5\57\0\1\4\u01d5\0\3\4\31\0\11\4\6\5"+
    "\1\0\5\4\2\0\5\4\4\0\126\4\2\0\2\5\2\0\3\4"+
    "\1\0\132\4\1\0\4\4\5\0\51\4\3\0\136\4\21\0\33\4"+
    "\65\0\20\4\u0200\0\u19b6\4\112\0\u51cc\4\64\0\u048d\4\103\0\56\4"+
    "\2\0\u010d\4\3\0\20\4\12\5\2\4\24\0\57\4\1\5\14\0"+
    "\2\5\1\0\31\4\10\0\120\4\2\5\45\0\11\4\2\0\147\4"+
    "\2\0\4\4\1\0\2\4\16\0\12\4\120\0\10\4\1\5\3\4"+
    "\1\5\4\4\1\5\27\4\5\5\20\0\1\4\7\0\64\4\14\0"+
    "\2\5\62\4\21\5\13\0\12\5\6\0\22\5\6\4\3\0\1\4"+
    "\4\0\12\5\34\4\10\5\2\0\27\4\15\5\14\0\35\4\3\0"+
    "\4\5\57\4\16\5\16\0\1\4\12\5\46\0\51\4\16\5\11\0"+
    "\3\4\1\5\10\4\2\5\2\0\12\5\6\0\27\4\3\0\1\4"+
    "\1\5\4\0\60\4\1\5\1\4\3\5\2\4\2\5\5\4\2\5"+
    "\1\4\1\5\1\4\30\0\3\4\43\0\6\4\2\0\6\4\2\0"+
    "\6\4\11\0\7\4\1\0\7\4\221\0\43\4\10\5\1\0\2\5"+
    "\2\0\12\5\6\0\u2ba4\4\14\0\27\4\4\0\61\4\u2104\0\u012e\4"+
    "\2\0\76\4\2\0\152\4\46\0\7\4\14\0\5\4\5\0\1\4"+
    "\1\5\12\4\1\0\15\4\1\0\5\4\1\0\1\4\1\0\2\4"+
    "\1\0\2\4\1\0\154\4\41\0\u016b\4\22\0\100\4\2\0\66\4"+
    "\50\0\15\4\3\0\20\5\20\0\7\5\14\0\2\4\30\0\3\4"+
    "\31\0\1\4\6\0\5\4\1\0\207\4\2\0\1\5\4\0\1\4"+
    "\13\0\12\5\7\0\32\4\4\0\1\4\1\0\32\4\13\0\131\4"+
    "\3\0\6\4\2\0\6\4\2\0\6\4\2\0\3\4\3\0\2\4"+
    "\3\0\2\4\22\0\3\5\4\0\14\4\1\0\32\4\1\0\23\4"+
    "\1\0\2\4\1\0\17\4\2\0\16\4\42\0\173\4\105\0\65\4"+
    "\210\0\1\5\202\0\35\4\3\0\61\4\57\0\37\4\21\0\33\4"+
    "\65\0\36\4\2\0\44\4\4\0\10\4\1\0\5\4\52\0\236\4"+
    "\2\0\12\5\u0356\0\6\4\2\0\1\4\1\0\54\4\1\0\2\4"+
    "\3\0\1\4\2\0\27\4\252\0\26\4\12\0\32\4\306\0\1\4"+
    "\3\5\1\0\2\5\5\0\4\5\4\4\1\0\3\4\1\0\33\4"+
    "\4\0\3\5\4\0\1\5\40\0\35\4\203\0\66\4\12\0\26\4"+
    "\12\0\23\4\215\0\111\4\u03b7\0\3\5\65\4\17\5\37\0\12\5"+
    "\20\0\3\5\55\4\13\5\2\0\1\5\u0f42\0\u036f\4\221\0\143\4"+
    "\u0b9d\0\u042f\4\u33d1\0\u0239\4\u45c7\0\2\4\u2163\0\5\5\3\0\26\5"+
    "\2\0\7\5\36\0\4\5\224\0\3\5\u01bb\0\125\4\1\0\107\4"+
    "\1\0\2\4\2\0\1\4\2\0\2\4\2\0\4\4\1\0\14\4"+
    "\1\0\1\4\1\0\7\4\1\0\101\4\1\0\4\4\2\0\10\4"+
    "\1\0\7\4\1\0\34\4\1\0\4\4\1\0\5\4\1\0\1\4"+
    "\3\0\7\4\1\0\u0154\4\2\0\31\4\1\0\31\4\1\0\37\4"+
    "\1\0\31\4\1\0\37\4\1\0\31\4\1\0\37\4\1\0\31\4"+
    "\1\0\37\4\1\0\31\4\1\0\10\4\2\0\62\5\u2800\0\ua6d7\4"+
    "\51\0\u1035\4\13\0\336\4\u3fe2\0\u021e\4\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\u05ee\0"+
    "\1\5\36\0\140\5\200\0\360\5\uffff\0\uffff\0\ufe12\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\2\2\1\3\2\4\1\1\1\5\3\3"+
    "\1\5\4\3\2\5\2\3\1\6\1\7\2\3\1\10"+
    "\1\11\1\12\1\13\3\0\1\2\1\0\7\3\1\14"+
    "\13\3\1\15\1\3\1\0\15\3\1\0\1\3\1\16"+
    "\7\3\1\17\1\20\1\3\1\21\3\3\1\22\2\3"+
    "\1\23\1\3\1\24\2\3\1\25\1\3\1\26\3\3"+
    "\1\27\1\30\1\31";

  private static int [] zzUnpackAction() {
    int [] result = new int[104];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\53\0\126\0\201\0\126\0\254\0\126\0\327"+
    "\0\u0102\0\u012d\0\u0158\0\u0183\0\u01ae\0\254\0\u01d9\0\u0204"+
    "\0\u022f\0\u025a\0\126\0\u0285\0\u02b0\0\u02db\0\126\0\126"+
    "\0\u0306\0\u0331\0\126\0\126\0\u035c\0\126\0\u0387\0\u03b2"+
    "\0\u012d\0\u012d\0\u03dd\0\u0408\0\u0433\0\u045e\0\u0489\0\u04b4"+
    "\0\u04df\0\u050a\0\u0535\0\u0560\0\u058b\0\u05b6\0\u05e1\0\u060c"+
    "\0\u0637\0\u0662\0\u068d\0\u06b8\0\u06e3\0\u070e\0\254\0\u0739"+
    "\0\u0764\0\u078f\0\u07ba\0\u07e5\0\u0810\0\u083b\0\u0866\0\u0891"+
    "\0\u08bc\0\u08e7\0\u0912\0\u093d\0\u0968\0\u0993\0\u09be\0\u09e9"+
    "\0\254\0\u0a14\0\u0a3f\0\u0a6a\0\u0a95\0\u0ac0\0\u0aeb\0\u0b16"+
    "\0\254\0\254\0\u0b41\0\126\0\u0b6c\0\u0b97\0\u0bc2\0\254"+
    "\0\u0bed\0\u0c18\0\254\0\u0c43\0\254\0\u0c6e\0\u0c99\0\254"+
    "\0\u0cc4\0\254\0\u0cef\0\u0d1a\0\u0d45\0\254\0\254\0\254";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[104];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\2\5\1\6\1\3\1\7\1\10\1\11"+
    "\1\12\1\3\1\5\2\3\1\13\1\14\1\6\1\15"+
    "\1\6\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\16\1\24\1\25\1\6\1\26\2\6\1\27\1\30"+
    "\1\31\1\6\1\32\1\5\1\33\1\34\1\6\1\3"+
    "\1\35\2\3\45\35\1\36\1\35\1\3\55\0\1\5"+
    "\54\0\4\6\4\0\1\6\1\0\12\6\2\0\1\6"+
    "\1\0\5\6\2\0\3\6\3\0\1\6\7\0\2\10"+
    "\53\0\1\37\1\40\41\0\1\41\2\42\5\41\1\0"+
    "\1\43\3\41\1\0\35\41\4\0\4\6\4\0\1\6"+
    "\1\0\1\6\1\44\10\6\2\0\1\6\1\0\5\6"+
    "\2\0\3\6\3\0\1\6\5\0\4\6\4\0\1\6"+
    "\1\0\10\6\1\45\1\46\2\0\1\6\1\0\5\6"+
    "\2\0\3\6\3\0\1\6\5\0\4\6\4\0\1\6"+
    "\1\0\1\6\1\47\10\6\2\0\1\6\1\0\5\6"+
    "\2\0\3\6\3\0\1\6\5\0\4\6\4\0\1\6"+
    "\1\0\4\6\1\50\5\6\2\0\1\6\1\0\5\6"+
    "\2\0\3\6\3\0\1\6\5\0\4\6\4\0\1\6"+
    "\1\0\1\6\1\51\3\6\1\52\4\6\2\0\1\6"+
    "\1\0\5\6\2\0\3\6\3\0\1\6\5\0\4\6"+
    "\4\0\1\6\1\0\12\6\2\0\1\6\1\0\3\6"+
    "\1\53\1\6\2\0\3\6\3\0\1\6\5\0\4\6"+
    "\4\0\1\6\1\0\5\6\1\16\4\6\2\0\1\6"+
    "\1\0\5\6\2\0\3\6\3\0\1\54\32\0\1\23"+
    "\25\0\4\6\4\0\1\6\1\0\2\6\1\55\1\6"+
    "\1\56\5\6\2\0\1\6\1\0\5\6\2\0\3\6"+
    "\3\0\1\6\5\0\4\6\4\0\1\6\1\0\12\6"+
    "\2\0\1\6\1\0\3\6\1\57\1\6\2\0\3\6"+
    "\3\0\1\6\5\0\4\6\4\0\1\6\1\0\4\6"+
    "\1\60\5\6\2\0\1\6\1\0\5\6\2\0\3\6"+
    "\3\0\1\6\5\0\4\6\4\0\1\6\1\0\4\6"+
    "\1\61\5\6\2\0\1\6\1\0\5\6\2\0\3\6"+
    "\3\0\1\6\1\0\1\35\2\0\45\35\1\0\1\35"+
    "\1\0\1\37\1\4\1\5\7\37\3\0\36\37\11\0"+
    "\1\41\51\0\1\5\46\0\4\6\4\0\1\6\1\0"+
    "\2\6\1\62\7\6\2\0\1\6\1\0\5\6\2\0"+
    "\3\6\3\0\1\6\5\0\4\6\4\0\1\6\1\0"+
    "\12\6\2\0\1\6\1\0\5\6\2\0\1\63\2\6"+
    "\3\0\1\6\5\0\4\6\4\0\1\6\1\0\12\6"+
    "\2\0\1\6\1\0\4\6\1\64\2\0\3\6\3\0"+
    "\1\6\5\0\4\6\4\0\1\6\1\0\10\6\1\65"+
    "\1\6\2\0\1\6\1\0\5\6\2\0\3\6\3\0"+
    "\1\6\5\0\4\6\4\0\1\6\1\0\7\6\1\66"+
    "\2\6\2\0\1\6\1\0\5\6\2\0\3\6\3\0"+
    "\1\6\5\0\4\6\4\0\1\6\1\0\1\6\1\67"+
    "\10\6\2\0\1\6\1\0\5\6\2\0\3\6\3\0"+
    "\1\6\5\0\4\6\4\0\1\6\1\0\12\6\2\0"+
    "\1\6\1\0\1\6\1\70\3\6\2\0\3\6\3\0"+
    "\1\6\5\0\4\6\4\0\1\6\1\0\12\6\2\0"+
    "\1\6\1\0\5\6\2\0\3\6\1\71\2\0\1\6"+
    "\5\0\4\6\4\0\1\6\1\0\7\6\1\72\2\6"+
    "\2\0\1\6\1\0\5\6\2\0\3\6\3\0\1\6"+
    "\5\0\4\6\4\0\1\6\1\0\5\6\1\73\4\6"+
    "\2\0\1\6\1\0\5\6\2\0\3\6\3\0\1\6"+
    "\5\0\4\6\4\0\1\6\1\0\2\6\1\74\7\6"+
    "\2\0\1\6\1\0\5\6\2\0\3\6\3\0\1\6"+
    "\5\0\4\6\4\0\1\6\1\0\1\6\1\75\10\6"+
    "\2\0\1\6\1\0\5\6\2\0\3\6\3\0\1\6"+
    "\5\0\4\6\4\0\1\6\1\0\3\6\1\76\6\6"+
    "\2\0\1\6\1\0\5\6\2\0\3\6\3\0\1\6"+
    "\5\0\4\6\4\0\1\6\1\0\10\6\1\77\1\6"+
    "\2\0\1\6\1\0\5\6\2\0\3\6\3\0\1\6"+
    "\5\0\4\6\4\0\1\6\1\0\3\6\1\100\6\6"+
    "\2\0\1\6\1\0\5\6\2\0\3\6\3\0\1\6"+
    "\5\0\4\6\4\0\1\6\1\0\2\6\1\101\7\6"+
    "\2\0\1\6\1\0\5\6\2\0\3\6\3\0\1\6"+
    "\5\0\4\6\4\0\1\6\1\0\1\6\1\102\3\6"+
    "\1\103\4\6\2\0\1\6\1\0\5\6\2\0\3\6"+
    "\3\0\1\6\5\0\4\6\4\0\1\6\1\0\3\6"+
    "\1\104\6\6\2\0\1\6\1\0\5\6\2\0\3\6"+
    "\3\0\1\6\5\0\4\6\4\0\1\6\1\0\10\6"+
    "\1\105\1\6\2\0\1\6\1\0\5\6\2\0\3\6"+
    "\3\0\1\6\5\0\4\6\4\0\1\6\1\0\12\6"+
    "\2\0\1\6\1\0\3\6\1\106\1\6\2\0\3\6"+
    "\3\0\1\6\30\0\1\107\27\0\4\6\4\0\1\6"+
    "\1\0\5\6\1\16\4\6\2\0\1\6\1\0\5\6"+
    "\2\0\3\6\3\0\1\6\5\0\4\6\4\0\1\6"+
    "\1\0\12\6\2\0\1\6\1\0\1\6\1\110\3\6"+
    "\2\0\3\6\3\0\1\6\5\0\4\6\4\0\1\6"+
    "\1\0\4\6\1\111\5\6\2\0\1\6\1\0\5\6"+
    "\2\0\3\6\3\0\1\6\5\0\4\6\4\0\1\6"+
    "\1\0\11\6\1\112\2\0\1\6\1\0\5\6\2\0"+
    "\3\6\3\0\1\6\5\0\4\6\4\0\1\6\1\0"+
    "\1\6\1\113\10\6\2\0\1\6\1\0\5\6\2\0"+
    "\3\6\3\0\1\6\5\0\4\6\4\0\1\6\1\0"+
    "\12\6\2\0\1\6\1\0\4\6\1\114\2\0\3\6"+
    "\3\0\1\6\5\0\4\6\4\0\1\6\1\0\4\6"+
    "\1\115\5\6\2\0\1\6\1\0\5\6\2\0\3\6"+
    "\3\0\1\6\5\0\4\6\4\0\1\6\1\0\12\6"+
    "\2\0\1\6\1\0\3\6\1\116\1\6\2\0\3\6"+
    "\3\0\1\6\5\0\4\6\4\0\1\6\1\0\2\6"+
    "\1\117\7\6\2\0\1\6\1\0\5\6\2\0\3\6"+
    "\3\0\1\6\5\0\4\6\4\0\1\6\1\0\11\6"+
    "\1\120\2\0\1\6\1\0\5\6\2\0\3\6\3\0"+
    "\1\6\5\0\4\6\4\0\1\6\1\0\1\6\1\121"+
    "\10\6\2\0\1\6\1\0\5\6\2\0\3\6\3\0"+
    "\1\6\5\0\4\6\4\0\1\6\1\0\5\6\1\122"+
    "\4\6\2\0\1\6\1\0\5\6\2\0\3\6\3\0"+
    "\1\6\5\0\4\6\4\0\1\6\1\0\12\6\2\0"+
    "\1\6\1\0\5\6\2\0\1\123\2\6\3\0\1\6"+
    "\24\0\1\124\33\0\4\6\4\0\1\6\1\0\2\6"+
    "\1\125\7\6\2\0\1\6\1\0\5\6\2\0\3\6"+
    "\3\0\1\6\5\0\4\6\4\0\1\6\1\0\12\6"+
    "\2\0\1\6\1\0\4\6\1\126\2\0\3\6\3\0"+
    "\1\6\5\0\4\6\4\0\1\6\1\0\11\6\1\127"+
    "\2\0\1\6\1\0\5\6\2\0\3\6\3\0\1\6"+
    "\5\0\4\6\4\0\1\6\1\0\4\6\1\130\5\6"+
    "\2\0\1\6\1\0\5\6\2\0\3\6\3\0\1\6"+
    "\5\0\4\6\4\0\1\6\1\0\3\6\1\131\6\6"+
    "\2\0\1\6\1\0\5\6\2\0\3\6\3\0\1\6"+
    "\5\0\4\6\4\0\1\6\1\0\12\6\2\0\1\6"+
    "\1\0\5\6\2\0\1\6\1\132\1\6\3\0\1\6"+
    "\5\0\4\6\4\0\1\6\1\0\5\6\1\133\4\6"+
    "\2\0\1\6\1\0\5\6\2\0\3\6\3\0\1\6"+
    "\5\0\4\6\4\0\1\6\1\0\12\6\2\0\1\6"+
    "\1\0\5\6\2\0\1\134\2\6\3\0\1\6\5\0"+
    "\4\6\4\0\1\6\1\0\5\6\1\135\4\6\2\0"+
    "\1\6\1\0\5\6\2\0\3\6\3\0\1\6\5\0"+
    "\4\6\4\0\1\6\1\0\4\6\1\136\5\6\2\0"+
    "\1\6\1\0\5\6\2\0\3\6\3\0\1\6\5\0"+
    "\4\6\4\0\1\6\1\0\2\6\1\137\7\6\2\0"+
    "\1\6\1\0\5\6\2\0\3\6\3\0\1\6\5\0"+
    "\4\6\4\0\1\6\1\0\4\6\1\140\5\6\2\0"+
    "\1\6\1\0\5\6\2\0\3\6\3\0\1\6\5\0"+
    "\4\6\4\0\1\6\1\0\1\6\1\141\10\6\2\0"+
    "\1\6\1\0\5\6\2\0\3\6\3\0\1\6\5\0"+
    "\4\6\4\0\1\6\1\0\1\6\1\142\10\6\2\0"+
    "\1\6\1\0\5\6\2\0\3\6\3\0\1\6\5\0"+
    "\4\6\4\0\1\6\1\0\1\6\1\143\10\6\2\0"+
    "\1\6\1\0\5\6\2\0\3\6\3\0\1\6\5\0"+
    "\4\6\4\0\1\6\1\0\12\6\2\0\1\6\1\0"+
    "\2\6\1\144\2\6\2\0\3\6\3\0\1\6\5\0"+
    "\4\6\4\0\1\6\1\0\4\6\1\145\5\6\2\0"+
    "\1\6\1\0\5\6\2\0\3\6\3\0\1\6\5\0"+
    "\4\6\4\0\1\6\1\0\2\6\1\105\7\6\2\0"+
    "\1\6\1\0\5\6\2\0\3\6\3\0\1\6\5\0"+
    "\4\6\4\0\1\6\1\0\10\6\1\146\1\6\2\0"+
    "\1\6\1\0\5\6\2\0\3\6\3\0\1\6\5\0"+
    "\4\6\4\0\1\6\1\0\4\6\1\147\5\6\2\0"+
    "\1\6\1\0\5\6\2\0\3\6\3\0\1\6\5\0"+
    "\4\6\4\0\1\6\1\0\10\6\1\150\1\6\2\0"+
    "\1\6\1\0\5\6\2\0\3\6\3\0\1\6\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3440];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\1\1\1\11\1\1\1\11\13\1\1\11"+
    "\3\1\2\11\2\1\2\11\1\1\1\11\3\0\1\1"+
    "\1\0\25\1\1\0\15\1\1\0\14\1\1\11\24\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[104];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
  StringBuffer cadena = new StringBuffer();
  int numErr = 0;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2612) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;           
    int totalRead = 0;
    while (totalRead < requested) {
      int numRead = zzReader.read(zzBuffer, zzEndRead + totalRead, requested - totalRead);
      if (numRead == -1) {
        break;
      }
      totalRead += numRead;
    }

    if (totalRead > 0) {
      zzEndRead += totalRead;
      if (totalRead == requested) { /* possibly more input available */
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      return false;
    }

    // totalRead = 0: End of stream
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 1: 
          { numErr++;return new Symbol(sym.error, yyline, yycolumn,yytext());
          }
        case 26: break;
        case 2: 
          { 
          }
        case 27: break;
        case 3: 
          { return new Symbol(sym.ID, yyline, yycolumn);
          }
        case 28: break;
        case 4: 
          { return new Symbol(sym.LITERAL_ENTERA, yyline, yycolumn, new Integer(yytext()));
          }
        case 29: break;
        case 5: 
          { return new Symbol(sym.OPERADOR, yyline, yycolumn);
          }
        case 30: break;
        case 6: 
          { return new Symbol(sym.LLAVE_IZQ, yyline, yycolumn);
          }
        case 31: break;
        case 7: 
          { return new Symbol(sym.LLAVE_DER, yyline, yycolumn);
          }
        case 32: break;
        case 8: 
          { return new Symbol(sym.MARCADOR_FIN_SENTENCIA, yyline, yycolumn);
          }
        case 33: break;
        case 9: 
          { cadena.setLength(0);yybegin(CADENA);
          }
        case 34: break;
        case 10: 
          { cadena.append(yytext());
          }
        case 35: break;
        case 11: 
          { yybegin(YYINITIAL);return new Symbol(sym.LITERAL_CADENA, yyline, yycolumn,cadena.toString());
          }
        case 36: break;
        case 12: 
          { return new Symbol(sym.SI, yyline, yycolumn);
          }
        case 37: break;
        case 13: 
          { return new Symbol(sym.OP_LECTURA, yyline, yycolumn);
          }
        case 38: break;
        case 14: 
          { return new Symbol(sym.PARA, yyline, yycolumn);
          }
        case 39: break;
        case 15: 
          { return new Symbol(sym.DESDE, yyline, yycolumn);
          }
        case 40: break;
        case 16: 
          { return new Symbol(sym.LITERAL_BOOLEANA, yyline, yycolumn, yytext().toString());
          }
        case 41: break;
        case 17: 
          { return new Symbol(sym.SI_NO, yyline, yycolumn);
          }
        case 42: break;
        case 18: 
          { return new Symbol(sym.HASTA, yyline, yycolumn);
          }
        case 43: break;
        case 19: 
          { return new Symbol(sym.ENTERO, yyline, yycolumn);
          }
        case 44: break;
        case 20: 
          { return new Symbol(sym.LOGICO, yyline, yycolumn);
          }
        case 45: break;
        case 21: 
          { return new Symbol(sym.CADENA, yyline, yycolumn);
          }
        case 46: break;
        case 22: 
          { return new Symbol(sym.OP_ESCRITURA, yyline, yycolumn);
          }
        case 47: break;
        case 23: 
          { return new Symbol(sym.ENTONCES, yyline, yycolumn);
          }
        case 48: break;
        case 24: 
          { return new Symbol(sym.PROGRAMA, yyline, yycolumn);
          }
        case 49: break;
        case 25: 
          { return new Symbol(sym.MIENTRAS, yyline, yycolumn);
          }
        case 50: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {     return new Symbol(sym.EOF);
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
