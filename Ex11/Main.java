package Ex11;
import Ex11.Controller.*; 
import Ex11.Repository.GerenciarFrota;
import Ex11.View.ConsoleView;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos o "Banco de Dados" (Repository)
        GerenciarFrota repository = new GerenciarFrota();
        
        // 2. Instanciamos a Interface de Usuário (View)
        ConsoleView view = new ConsoleView();
        
        // 3. Instanciamos o Gerente passando os dois para ele (Controller)
        FrotaController controller = new FrotaController(view, repository);
        
        // 4. Damos o Play!
        controller.iniciar();
    }
}


