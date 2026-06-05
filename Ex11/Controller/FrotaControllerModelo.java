package Ex11.Controller;

import Ex11.Model.Caminhao;
import Ex11.Model.Carro;
import Ex11.Model.PlacaException;
import Ex11.Model.Veiculo;
import Ex11.Repository.GerenciarFrota;
import Ex11.View.ConsoleViewModelo;

public class FrotaControllerModelo {
    
    private ConsoleViewModelo view;
    private GerenciarFrota repository;

    // O Controller recebe a View e o Repository "injetados" nele
    public FrotaControllerModelo(ConsoleViewModelo view, GerenciarFrota repository) {
        this.view = view;
        this.repository = repository;
    }

    public void iniciar() {
        boolean rodando = true;

        while (rodando) {
            int opcao = view.mostrarMenu();

            switch (opcao) {
                case 1:
                    adicionarCarro();
                    break;
                case 2:
                    adicionarCaminhao();
                    break;
                case 3:
                    calcularCustosTotais();
                    break;
                case 4:
                    calcularIPVATotal();
                    break;
                case 5:
                    salvarEExibirFrota();
                    break;
                case 6:
                    view.exibirMensagem("Encerrando o sistema. Até logo!");
                    rodando = false;
                    break;
                default:
                    view.exibirMensagem("Erro: Opção inválida!");
            }
        }
    }

    // --- LÓGICAS DE CONTROLE --- //

    private void adicionarCarro() {
        try {
            String placa = view.lerPlaca();
            double custo = view.lerCustoFixo();
            int km = view.lerQuilometragem();

            Carro novoCarro = new Carro(placa, custo, km);
            repository.adicionarVeiculo(novoCarro);
            view.exibirMensagem("Carro adicionado com sucesso!");

        } catch (PlacaException e) {
            view.exibirMensagem(e.getMessage()); // Captura o erro do Model e mostra na View
        }
    }

    private void adicionarCaminhao() {
        try {
            String placa = view.lerPlaca();
            double custo = view.lerCustoFixo();
            double toneladas = view.lerToneladas();

            Caminhao novoCaminhao = new Caminhao(placa, custo, toneladas);
            repository.adicionarVeiculo(novoCaminhao);
            view.exibirMensagem("Caminhão adicionado com sucesso!");

        } catch (PlacaException e) {
            view.exibirMensagem(e.getMessage());
        }
    }

    private void calcularCustosTotais() {
        view.exibirMensagem("--- Custos Totais Individuais ---");
        // POLIMORFISMO EM AÇÃO: O Controller não quer saber se é carro ou caminhão!
        for (Veiculo v : repository.getFrota()) {
            double custo = v.calcCustoTotal();
            view.exibirMensagem("Veículo placa " + v.getPlaca() + " | Custo Total: R$ " + custo);
        }
    }

    private void calcularIPVATotal() {
        view.exibirMensagem("--- Valores de IPVA Individuais ---");
        // POLIMORFISMO DE INTERFACE: Todos são "Tribiutaveis"
        for (Veiculo v : repository.getFrota()) {
            double ipva = v.calcIPVA(); // Como Veiculo herda isso lá no seu código
            view.exibirMensagem("Veículo placa " + v.getPlaca() + " | IPVA: R$ " + ipva);
        }
    }

    private void salvarEExibirFrota() {
        repository.salvarDadosEmArquivo("frota.txt");
        view.exibirMensagem("Dados salvos no arquivo 'frota.txt' com sucesso!");
        
        // Passa a lista de veículos para a View desenhar na tela
        view.exibirVeiculos(repository.getFrota());
    }
} 