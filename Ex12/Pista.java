

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pista {

    // Paleta de cores equivalente ao antigo style.css
    private static final Color COR_FUNDO = new Color(0x2b, 0x2b, 0x36);
    private static final Color COR_PISTA_FUNDO = new Color(0x1a, 0x1a, 0x24);
    private static final Color COR_DOURADO = new Color(0xe5, 0xb0, 0x22);
    private static final Color COR_BOTAO_TOPO = new Color(0x00, 0xd2, 0xff);
    private static final Color COR_BOTAO_BASE = new Color(0x3a, 0x7b, 0xd5);

    private JFrame frame;
    private JPanel layout;

    public Pista() {
        frame = new JFrame("Corrida de Carros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Título
        JPanel boxTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        boxTitulo.setBackground(COR_FUNDO);
        JLabel titulo = criarLabelTexto("Bem vindo a corrida de carros", 24);
        boxTitulo.add(titulo);
        boxTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Pódio
        JPanel posicao = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        posicao.setBackground(COR_FUNDO);

        JLabel primeiro = criarLabelTexto("1º", 24);
        JLabel imgPrimeiro = new JLabel();
        imgPrimeiro.setPreferredSize(new Dimension(50, 50));
        imgPrimeiro.setHorizontalAlignment(JLabel.CENTER);
        imgPrimeiro.setVerticalAlignment(JLabel.CENTER);

        JLabel segundo = criarLabelTexto("2º", 24);
        JLabel imgSegundo = new JLabel();
        imgSegundo.setPreferredSize(new Dimension(50, 50));
        imgSegundo.setHorizontalAlignment(JLabel.CENTER);
        imgSegundo.setVerticalAlignment(JLabel.CENTER);

        JLabel terceiro = criarLabelTexto("3º", 24);
        JLabel imgTerceiro = new JLabel();
        imgTerceiro.setPreferredSize(new Dimension(50, 50));
        imgTerceiro.setHorizontalAlignment(JLabel.CENTER);
        imgTerceiro.setVerticalAlignment(JLabel.CENTER);

        Carro.setPodiumImages(imgPrimeiro, imgSegundo, imgTerceiro);

        posicao.add(primeiro);
        posicao.add(imgPrimeiro);
        posicao.add(segundo);
        posicao.add(imgSegundo);
        posicao.add(terceiro);
        posicao.add(imgTerceiro);
        posicao.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Pista (layout absoluto para posicionar os carros livremente)
        JPanel pista = new JPanel(null);
        pista.setPreferredSize(new Dimension(600, 300));
        pista.setMaximumSize(new Dimension(600, 300));
        pista.setBackground(COR_PISTA_FUNDO);
        pista.setBorder(BorderFactory.createLineBorder(COR_DOURADO, 4));
        pista.setAlignmentX(Component.CENTER_ALIGNMENT);

        java.net.URL pistaUrl = getClass().getResource("/images/pista.jpg");
        if (pistaUrl == null) {
            throw new RuntimeException(
                "Imagem não encontrada em /images/pista.jpg no classpath. "
                + "Verifique se a pasta 'images' está dentro da pasta 'src' "
                + "(ou de 'src/main/resources', se usar Maven) e se foi copiada "
                + "para o diretório de saída da compilação."
            );
        }
        ImageIcon pistaIcon = new ImageIcon(pistaUrl);
        Image pistaImagemEscalada = pistaIcon.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);
        JLabel pistaImageLabel = new JLabel(new ImageIcon(pistaImagemEscalada));
        pistaImageLabel.setBounds(0, 0, 600, 300);
        pista.add(pistaImageLabel);

        Carro carro1 = new Carro("carro1", 30, 40);
        Carro carro2 = new Carro("carro2", 30, 100);
        Carro carro3 = new Carro("carro3", 30, 160);
        Carro.addCarro(carro1, carro2, carro3);

        pista.add(carro1);
        pista.add(carro2);
        pista.add(carro3);
        pista.setComponentZOrder(pistaImageLabel, pista.getComponentCount() - 1);

        // Botão
        JPanel botaoBox = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botaoBox.setBackground(COR_FUNDO);
        JButton botao = criarBotaoGradiente("Iniciar Corrida");
        botao.addActionListener(e -> Carro.iniciarCorrida());
        botaoBox.add(botao);
        botaoBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Layout principal
        layout = new JPanel();
        layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
        layout.setBackground(COR_FUNDO);
        layout.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        layout.add(boxTitulo);
        layout.add(Box.createVerticalStrut(10));
        layout.add(posicao);
        layout.add(Box.createVerticalStrut(10));
        layout.add(pista);
        layout.add(Box.createVerticalStrut(10));
        layout.add(botaoBox);

        frame.setContentPane(layout);
        frame.setSize(640, 520);
        frame.setLocationRelativeTo(null);
    }

    private JLabel criarLabelTexto(String texto, int tamanhoFonte) {
        JLabel label = new JLabel(texto);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.ROMAN_BASELINE, tamanhoFonte));
        return label;
    }

    private JButton criarBotaoGradiente(String texto) {
        JButton botao = new JButton(texto) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                GradientPaint gradiente = new GradientPaint(0, 0, COR_BOTAO_TOPO, 0, getHeight(), COR_BOTAO_BASE);
                g2.setPaint(gradiente);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 18));
        botao.setFocusPainted(false);
        botao.setContentAreaFilled(false);
        botao.setBorderPainted(false);
        botao.setOpaque(false);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao.setPreferredSize(new Dimension(220, 50));
        return botao;
    }

    public void exibirTela() {
        frame.setVisible(true);
    }
}