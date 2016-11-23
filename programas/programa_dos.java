import java.util.Scanner;
public class programa_dos{
	public static void main(String[] args){
 		 Scanner sc = new Scanner(System.in);
		 int i;
		 System.out.println("Ingresa un numero mayor que cero: ");
		 i = sc.nextInt();
		 int j=0;
		 while(j<i){
		 System.out.println("Numero: "+j);
		 j=j+1; 
		 }
	}
}