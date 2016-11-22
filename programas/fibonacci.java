import java.util.Scanner;
public class fibonacci{
	public static void main(String[] args){
 		 Scanner sc = new Scanner(System.in);
		 int N;
		 N = sc.nextInt();
		 while(N<0||N==0){
		 System.out.println("Ingresa un número mayor o igual a 1:");
		 N = sc.nextInt(); 
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
		 for(i=3;i<=N;i++){
		 fibonacci=fibo1+fibo2;
		 System.out.println(fibonacci);
		 fibo1=fibo2;
		 fibo2=fibonacci;
		 }
		 }
		 System.out.println("fin del programa");
	}
}