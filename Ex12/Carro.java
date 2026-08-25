
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Carro extends JLabel implements Runnable {
    private String carro;
    private int posicaox;
    private int posicaoy;
    private int posicaoInicialX; // Salva a posição inicial para o restart
    private volatile boolean rodando; // Flag para controlar se o carro deve continuar rodando
    private Thread carroThread;
    private static JLabel primeiroLugarImg;
    private static JLabel segundoLugarImg;
    private static JLabel terceiroLugarImg;
    private static ArrayList<Carro> carros = new ArrayList<>();
    private ImageIcon iconePodio; // Versão reduzida (50x50) usada apenas no pódio

    public Carro(String carro, int posicaox, int posicaoy) {
        this.carro = carro;
        this.posicaox = posicaox;
        this.posicaoy = posicaoy;
        this.posicaoInicialX = posicaox;

        // Como Carro herda de JLabel, definimos o ícone e as dimensões nele mesmo
        java.net.URL carroUrl = getClass().getResource("/images/" + carro + ".png");
        if (carroUrl == null) {
            throw new RuntimeException(
                "Imagem não encontrada em /images/" + carro + ".png no classpath. "
                + "Verifique se a pasta 'images' está dentro da pasta 'src' "
                + "(ou de 'src/main/resources', se usar Maven) e se foi copiada "
                + "para o diretório de saída da compilação."
            );
        }
        ImageIcon icon = new ImageIcon(carroUrl);
        Image imagemEscalada = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(imagemEscalada));
        this.setSize(100, 100);
        this.setLocation(posicaox, posicaoy);

        // Versão reduzida da mesma imagem, usada apenas nos ícones do pódio
        Image imagemPodio = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        this.iconePodio = new ImageIcon(imagemPodio);

        this.carroThread = new Thread(this);
    }

    public Carro() {

    };

    public void run() {
        while (posicaox < 450 && rodando) {
            try {
                // Sorteia um tempo de pausa para o carro andar em velocidades diferentes
                Thread.sleep(new Random().nextInt(5) * 100 + 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Aumenta a posição do carro
            posicaox += new Random().nextInt(3) * 20 + 10;

            if (posicaox > 450) {
                posicaox = 450; // Chegou na linha de chegada
            }

            // Precisamos usar o SwingUtilities.invokeLater para enviar a atualização
            // para a Thread Principal (Event Dispatch Thread).
            SwingUtilities.invokeLater(() -> {
                this.setLocation(posicaox, this.posicaoy);
                Carro.atualizarPosicoes(Carro.getCarros());
            });
        }
    }

    static void setPodiumImages(JLabel primeiro, JLabel segundo, JLabel terceiro) {
        primeiroLugarImg = primeiro;
        segundoLugarImg = segundo;
        terceiroLugarImg = terceiro;
    }

    static void addCarro(Carro... carro) {
        carros.addAll(Arrays.asList(carro));
    }

    static ArrayList<Carro> getCarros() {
        return carros;
    }

    static void atualizarPosicoes(ArrayList<Carro> carros) {
        carros.sort((c1, c2) -> Integer.compare(c2.posicaox, c1.posicaox));
        for (int i = 0; i < carros.size(); i++) {
            Carro carro = carros.get(i);
            switch (i) {
                case 0:
                    if (primeiroLugarImg != null) primeiroLugarImg.setIcon(carro.iconePodio);
                    break;
                case 1:
                    if (segundoLugarImg != null) segundoLugarImg.setIcon(carro.iconePodio);
                    break;
                case 2:
                    if (terceiroLugarImg != null) terceiroLugarImg.setIcon(carro.iconePodio);
                    break;
            }
        }
    }

    static void iniciarCorrida() {
        if (carros.isEmpty()) return;

        // Avisa todas as threads antigas para pararem
        for (Carro carro : carros) {
            carro.rodando = false;
        }

        // Reseta a posição e recria as threads (Threads no Java só podem dar
        // .start() uma única vez na vida)
        for (Carro carro : carros) {
            carro.posicaox = carro.posicaoInicialX; // Reseta a posição
            carro.setLocation(carro.posicaoInicialX, carro.posicaoy); // Move de volta para o início
            carro.rodando = true; // Permite rodar

            carro.carroThread = new Thread(carro);
            carro.carroThread.start();
        }
    }
}