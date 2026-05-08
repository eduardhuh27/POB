package Ex5.Controle;

import Ex5.Dominio.Gerente;
import Ex5.Dominio.Cliente;
import java.util.Scanner;
import java.util.Random;



public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rand= new Random();
		boolean fim=true;
		Gerente g1=null;
        Cliente c1=null;

		while (fim)
		{
			System.out.print("Menu\n(1)Cadastrar Gerente\n(2)Exibir Gerente\n(3)Calcular salario\n(4)Exibir id do gerente\n(5)Cadatrar cliente\n(6)Exibir id do cliente\nOpcao:");
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
                case 4:
                    g1.exibirId();
                    break;
                case 5:
                        System.out.print("Nome:");
                        nome=sc.nextLine();
                        int id=rand.nextInt(25);
                        c1=new Cliente(nome, id);
                        break;
                case 6:
                    c1.exibirId();
                    break;        

                default:

					fim=false;
					break;
			}			

		}
		sc.close();
	}
}
