package Ex2.Controle;

import Ex2.Dominio.Gerente;
import java.util.Scanner;
import java.util.Random;



public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rand= new Random();
		boolean fim=true;
		Gerente g1=null;
	

		while (fim)
		{
			System.out.print("Menu\n(1)Cadastrar Gerente\n(2)Exibir Gerente\n(3)Calcular salario\nOpcao:");
			int menu=sc.nextInt();
			sc.nextLine();
			switch (menu) {
				case 1:
					System.out.print("Nome:");
					String nome=sc.nextLine();
					System.out.print("Departamento:");
					String departamento=sc.nextLine();
					double salario=rand.nextInt(10000);
					g1=new Gerente(nome,salario,departamento);					
					break;
				case 2:
					g1.exibir();
				break;
				case 3:
					double salarioCompleto=g1.calcSalario();
					System.out.println("Salario do Gerente pos as bonificacoes:"+salarioCompleto);
					break;
				default:
					fim=false;
					break;
			}			

		}
		sc.close();
	}
}
