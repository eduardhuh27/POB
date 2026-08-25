

import javax.swing.SwingUtilities;

/**
 * Swing App
 */
public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Pista pista = new Pista();
            pista.exibirTela();
        });
    }
}
