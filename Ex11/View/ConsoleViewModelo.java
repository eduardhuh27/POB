package Ex11.View;

import Ex11.Model.Veiculo;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleViewModelo {
    private Scanner scanner;

    public ConsoleViewModelo() {
        this.scanner = new Scanner(System.in);
    }

    // --- MÉTODOS DE EXIBIÇÃO --- //
    
    public int mostrarMenu() {
        System.out.println("\n====== SISTEMA DE GERENCIAMENTO DE FROTA ======");
        System.out.println("1) Adicionar Carro");
        System.out.println("2) Adicionar Caminhão");
        System.out.println("3) Calcular Custo Total da Frota (Polimorfismo)");
        System.out.println("4) Calcular IPVA da Frota (Polimorfismo)");
        System.out.println("5) Mostrar e Salvar Frota");
        System.out.println("6) Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(">> " + mensagem);
    }

    public void exibirVeiculos(ArrayList<Veiculo> frota) {
        System.out.println("\n--- Lista de Veículos na Frota ---");
        if (frota.isEmpty()) {
            System.out.println("A frota está vazia!");
            return;
        }
        for (Veiculo v : frota) {
            System.out.println(v.toString());
        }
    }

    // --- MÉTODOS DE LEITURA (INPUT) --- //

    public String lerPlaca() {
        System.out.print("Digite a placa (7 caracteres): ");
        return scanner.next();
    }

    public double lerCustoFixo() {
        System.out.print("Digite o custo fixo: R$ ");
        return scanner.nextDouble();
    }

    public int lerQuilometragem() {
        System.out.print("Digite a quilometragem do Carro: ");
        return scanner.nextInt();
    }

    public double lerToneladas() {
        System.out.print("Digite as toneladas de carga do Caminhão: ");
        return scanner.nextDouble();
    }
}