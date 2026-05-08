package Ex6.Controle;

import java.util.Scanner;
import java.util.ArrayList;

import Ex6.Dominio.*;

public class ControleFuncionario {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Funcionario> contratados =new ArrayList<>();

        int opcao;

        do
        {  System.out.println("\n===== MENU FUNCIONÁRIOS =====");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Listar funcionários");
            System.out.println("3 - Buscar funcionário por CPF");
            System.out.println("4 - Atualizar funcionário");
            System.out.println("5 - Remover funcionário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario(sc, contratados);
                    break;
                case 2:
                    listarFuncionarios(contratados);
                    break;
                case 3:
                    buscarFuncionario(sc, contratados);
                    break;
                case 4:
                    atualizarFuncionario(sc, contratados);
                    break;
                case 5:
                    removerFuncionario(sc, contratados);
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }

    public static void cadastrarFuncionario(Scanner sc,ArrayList<Funcionario> contratados)
    {
        System.out.print("CPF:");
        String cpf = sc.nextLine();
        System.out.print("Salario:");
        double salario = sc.nextDouble();
        
        System.out.print("(1)Diretor\n(2)Vendedor \n(3)Funcionario\nTipo:");
        int opcao=sc.nextInt();
        sc.nextLine();
        switch (opcao) {
            case 1:
                System.out.print("Bonificacao:");
                double bonus=sc.nextDouble();
                contratados.add(new Diretor(cpf,salario,bonus));
                break;
            case 2:
                 System.out.print("Bonificacao:");
                double comissao=sc.nextDouble();
                contratados.add(new Diretor(cpf,salario,comissao));
                break;
            case 3:
                contratados.add(new Funcionario(cpf,salario));
                break;
        
            default:
                System.out.println("Opção invalida!");
                break;
        }
        System.out.println("Funcionário cadastrado com sucesso.");
    }

     public static void listarFuncionarios(ArrayList<Funcionario> contratados)
     {
        if(contratados.isEmpty()){
            System.out.println("Lista vazia");
            return;
        }
        for( Funcionario funcio : contratados)
        {
            System.out.println(funcio);
        }
     }
      public static void buscarFuncionario(Scanner sc,ArrayList<Funcionario> contratados)
      {
        System.out.print("CPF a ser buscado:");
        String cpf = sc.nextLine();

        for( Funcionario funcio : contratados)
        {
            if(funcio.getCpf().equals(cpf))
                System.out.println(funcio);
        }
      }

      public static void atualizarFuncionario(Scanner sc,ArrayList<Funcionario> contratados)
      {
        Funcionario funcionario=buscarCPF(sc, contratados);

        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }

        System.out.print("Novo salário: ");
        double novoSalario = sc.nextDouble();
        funcionario.setSalario(novoSalario);

        if (funcionario instanceof Vendedor) {
            System.out.print("Nova comissão: ");
            double novaComissao = sc.nextDouble();
            ((Vendedor) funcionario).setComissao(novaComissao);
        } 
        if (funcionario instanceof Diretor) {
            System.out.print("Nova bonificação: ");
            double novaBonificacao = sc.nextDouble();
            ((Diretor) funcionario).setBonus(novaBonificacao);
        }

        System.out.println("Funcionário atualizado com sucesso.");
    }


      
       public static Funcionario buscarCPF(Scanner sc,ArrayList<Funcionario> contratados)
      {
        System.out.print("CPF a ser buscado:");
        String cpf = sc.nextLine();

        for( Funcionario funcio : contratados)
        {
            if(funcio.getCpf().equals(cpf))
              { return funcio;}
        }
        return null;
      }

      public static void removerFuncionario(Scanner sc, ArrayList<Funcionario> contratados)
      {
        Funcionario funcionario=buscarCPF(sc, contratados);

        if(funcionario==null){
            System.out.println("Funcionario não encontrado!");
            return;
        }

        contratados.remove(funcionario);
        System.out.println("Funcinario removido com sucesso!");

      }

}
    

