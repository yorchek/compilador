import java.util.Scanner;
public class programa_uno{
	public static void main(String[] args){
 		 Scanner sc = new Scanner(System.in);
		 int i;
		 int j;
		 System.out.println("El primer numero:");
		 i = sc.nextInt();
		 System.out.println("El segundo numero:");
		 j = sc.nextInt();
		 if(j>i){
		 System.out.println("Es mayor el entero: "+j);
		 }
		 if(j<i){
		 System.out.println("Es mayor el entero: "+i);
		 }
	}
}