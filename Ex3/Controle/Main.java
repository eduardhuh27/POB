package Ex3.Controle;
import Ex3.Dominio.ContaP;
import Ex3.Dominio.ContaC;
import java.util.Scanner;
import java.util.Random;



public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rand= new Random();
		boolean fim=true;
		ContaP c1=null;
		ContaC c2=null;

		while (fim)
		{
			System.out.print("Menu\n(1)Criar conta poupança\n(2)Criar conta corrente\n(3)Realizar um saque\n(4)Cheque especial\nOpcao:");
			int menu=sc.nextInt();
			sc.nextLine();
			switch (menu) {
				case 1:
					System.out.print("Nome:");
					String nome=sc.nextLine();
					System.out.print("Saldo:");
					double saldo=sc.nextDouble();
					double limite=rand.nextInt(2000)+saldo;
					sc.nextLine();
					c1=new ContaP(nome,saldo,limite);					
					break;
				case 2:
					System.out.print("Nome:");
					nome=sc.nextLine();
					System.out.print("Saldo:");
					saldo=sc.nextDouble();
					int taxa=rand.nextInt(10);
					sc.nextLine();
					c2=new ContaC(nome, saldo, taxa);
				break;
				case 3:
					System.out.print("Saque:");
					double valorSaque=sc.nextDouble();
					sc.nextLine();
					c2.saque(valorSaque);
					break;
				case 4:
					System.out.print("Valor gasto:");
					int valorGasto=sc.nextInt();
					sc.nextLine();
					c1.chequeEspecial(valorGasto);
				default:
					fim=false;
					break;
			}			

		}
		sc.close();
	}
}
