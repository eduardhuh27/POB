package Ex4.Controle;

import Ex4.Dominio.Animal;
import Ex4.Dominio.Cachorro;
import Ex4.Dominio.Gato;
import Ex4.Dominio.Vaca;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> zoo=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        boolean fim=true;
        
        while(fim)
            {
                System.out.print("(1)Adicionar cachorro a petshop\n(2)Adicionar gato a petshop\n(3)Adicionar vaca a petshop\n(4)Exibir os sons dos animais\nOpcao:");
                int menu=sc.nextInt();
                sc.nextLine();
                switch (menu) {
                    case 1:
                        System.out.print("Raca:");
                        String raca=sc.nextLine();
                        System.out.print("Som de animal:");
                        String som=sc.nextLine();
                        Cachorro c1=new Cachorro(som, raca);
                        zoo.add(c1);
                        break;
                    case 2:
                        System.out.print("Cor:");
                        String cor=sc.nextLine();
                        System.out.print("Som de animal:");
                        som=sc.nextLine();
                        Gato g1=new Gato(som, cor);
                        zoo.add(g1);
                        
                        break;
                    case 3:
                        System.out.print("Tipo:");
                        String tipo=sc.nextLine();
                        System.out.print("Som de animal:");
                        som=sc.nextLine();
                        Vaca v1=new Vaca(som, tipo);
                        zoo.add(v1);
                        break;
                    case 4:
                        for(int i=0;i<zoo.size();i++)
                        {
                            zoo.get(i).exibir();
                        }
                        
                        break;
                

                    default:
                        fim=false;
                        break;
                }
            }
            sc.close();
        }
}
