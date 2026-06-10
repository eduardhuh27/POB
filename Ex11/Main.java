package Ex11;
import Ex11.Controller.*; 
import Ex11.Repository.GerenciarFrota;
import Ex11.View.ConsoleView;

public class Main {
    public static void main(String[] args) {
        
        GerenciarFrota repository = new GerenciarFrota();
        
        ConsoleView view = new ConsoleView();
    
        FrotaController controller = new FrotaController(view, repository);
        
        controller.iniciar();
    }
}


