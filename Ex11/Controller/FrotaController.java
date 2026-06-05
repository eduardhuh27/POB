package Ex11.Controller;

import Ex11.Model.*;
import Ex11.Repository.*;
import Ex11.View.ConsoleView;



public class FrotaController {

    private ConsoleView view;
    private GerenciarFrota  repository;

    public FrotaController(ConsoleView view,GerenciarFrota repository){
        this.view=view;
        this.repository=repository;
    }
    
    public void iniciar()
    {
        boolean rodando=true;

        while(rodando)
        {
            int opcao=view.mostrarMenu();
            
            switch(opcao)
            {
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
                    rodando=false;
                    break;
                default:
                    view.exibirMensagem("Erro: Opcao invalida!");
            }
        }
    }

    private void adicionarCarro()
    {
        try{
        String placa= view.lerPlaca();
        double custo=view.lerCustoFixo();
        int km= view.lerQuilometragem();

        Carro carro=new Carro(placa,custo,km);
        repository.adicionarVeiculo(carro);
        view.exibirMensagem("Carro adicionado com sucesso!");
        }catch(PlacaException e)
        {
            view.exibirMensagem(e.getMessage());
        }

    }

    private void adicionarCaminhao()
    {
        try{
        String placa= view.lerPlaca();
        double custo=view.lerCustoFixo();
        double carga= view.lerToneladas();

        Caminhao caminhao =new Caminhao(placa,custo,carga);
        repository.adicionarVeiculo(caminhao);
        view.exibirMensagem("caminhao adicionado com sucesso!");
        }catch(PlacaException e)
        {
            view.exibirMensagem(e.getMessage());
        }
        
    }

    private void calcularCustosTotais()
    {
        view.exibirMensagem("Custo Totais Individuais");
        
        for(Veiculo v :repository.getFrota())
        {
            double custo= v.calcCustoTotal();
            view.exibirMensagem("Custo total do carro"+v.getPlaca()+":"+ custo);
        }
    }

    private void calcularIPVATotal()
    {
        view.exibirMensagem("Valor Total Individual");
        
        for(Veiculo v :repository.getFrota())
        {
            double ipva= v.calcIPVA();
            view.exibirMensagem("Custo total do carro"+v.getPlaca()+":"+ ipva);
        }
    }

    private void salvarEExibirFrota()
    {
        repository.salvarDadosEmArquivo("frota.txt");
        view.exibirMensagem("Dados salvos no arquivo 'frota.txt'com sucesso");

        view.exibirVeiculos(repository.getFrota());

    }
}

