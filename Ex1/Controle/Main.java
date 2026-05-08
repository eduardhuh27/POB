package Ex1.Controle;
import java.util.Scanner;
import java.util.Random;
import Ex1.Dominio.Moto;


public class Main
{
	public static void main(String[] args) {
		Random rand=new Random();
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Marca:");
        String marca=sc.nextLine();
        
        System.out.print("Modelo:");
        String modelo=sc.nextLine();
        
        int cc= rand.nextInt(5000)+1;
        		
		Moto moto=new Moto(modelo, marca,cc);
		
		moto.exibirDados();
		sc.close();
	}
}
