import java.util.Scanner;
public class programa_pruebas{
	 public static void main(String[] args){
		 int N;
		 Scanner N = new() Scanner(System.in);
		 int j=1;
		 while(N<0||N==0){
		 System.out.println("Ingresa un número mayor o igual a 1:");
		 Scanner N = new() Scanner(System.in); 
		 }
		 System.out.println("Los "+N+" primeros términos de la serie de Fibonacci son:");
		 if(N==2){
		 System.out.println(1);
		 }
		 if(N>2){
		 int fibo1=1;
		 int fibo2=1;
		 int fibonacci;
		 int i=0;
		 for(AST$ExpresionReferencia@29453f44;AST$ExpresionLiteral@5cad8086;AST$ExpresionReferencia@6e0be858){
		 fibonacci=fibo1+fibo2;
		 System.out.println(fibonacci);
		 fibo1=fibo2;
		 fibo2=fibonacci;
		 }
		 }
		 System.out.println("fin del programa");
	}
}