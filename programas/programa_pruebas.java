import java.util.Scanner;
public class programa_pruebas{
	public static void main(String[] args){
 		 Scanner sc = new Scanner(System.in);
		 int var1=10;
		 int var2=20;
		 int resultado;
		 resultado=var1+var2;
		 System.out.println("La suma es: "+resultado);
		 if(resultado>0){
		 System.out.println("Hola");
		 }else{ 
		 System.out.println("Adios");
		 }
	}
}