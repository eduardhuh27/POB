package Ex11.View;

import Ex11.Model.Veiculo;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView {
    private Scanner sc;

    public ConsoleView()
    {
        this.sc=new Scanner(System.in);
    }

    public int mostrarMenu()
    {
           System.out.println("\n====== SISTEMA DE GERENCIAMENTO DE FROTA ======");
        System.out.println("1) Adicionar Carro");
        System.out.println("2) Adicionar Caminhão");
        System.out.println("3) Calcular Custo Total da Frota (Polimorfismo)");
        System.out.println("4) Calcular IPVA da Frota (Polimorfismo)");
        System.out.println("5) Mostrar e Salvar Frota");
        System.out.println("6) Sair");
        System.out.print("Escolha uma opção: ");
        return sc.nextInt();
    }

    public void exibirMensagem(String mensagem)
    {
        System.out.println(">>"+mensagem);
    }

    public void exibirVeiculos(ArrayList<Veiculo> frota)
    {
        System.out.println("\n Lista de Veiculos na frota");
        if(frota.isEmpty())
        {
            System.out.println("Frota vazia!");
        }
        for(Veiculo v:frota)
        {
            System.out.println(v.toString());
        }
    }

    public String lerPlaca()
    {
        System.out.print("Digite a placa (Exatamente 7 caracteres):");
        return sc.next();
    }
    
    public Double lerCustoFixo()
    {
        System.out.print("Digite o Custo Fixo: R$");
        return sc.nextDouble();
    }

    public int lerQuilometragem()
    {
        System.out.print("Digite a quilometragem do carro:");
        return sc.nextInt();
    }
    
    public Double lerToneladas()
    {
        System.out.print("Digite as toneladas da carga do caminhão:");
        return sc.nextDouble();
    }
}
