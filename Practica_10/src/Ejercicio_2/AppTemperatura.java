package Ejercicio_2;
import javax.swing.*;
import java.awt.*;

public class AppTemperatura extends JFrame {
    private JTextField[] camposDias;
    private String[] dias = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};
    private double[] temperaturas = {20, 22, 19, 24, 25, 21, 23};
    private PanelGraficoLineas panelGrafico;

    public AppTemperatura() {
        super("Temperatura Semanal - Paricahua Larico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 420);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new FlowLayout());
        camposDias = new JTextField[7];

        for (int i = 0; i < 7; i++) {
            panelSuperior.add(new JLabel(dias[i] + ":"));
            camposDias[i] = new JTextField(String.valueOf(temperaturas[i]), 3);
            panelSuperior.add(camposDias[i]);
        }

        JButton btnMostrar = new JButton("Mostrar Gráfico");
        panelSuperior.add(btnMostrar);

        panelGrafico = new PanelGraficoLineas();

        btnMostrar.addActionListener(e -> {
            try {
                for (int i = 0; i < 7; i++) {
                    temperaturas[i] = Double.parseDouble(camposDias[i].getText());
                }
                panelGrafico.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese solo números válidos.");
            }
        });

        add(panelSuperior, BorderLayout.NORTH);
        add(panelGrafico, BorderLayout.CENTER);
    }

    private class PanelGraficoLineas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int margen = 50;
            int anchoUtil = getWidth() - 2 * margen;
            int altoUtil = getHeight() - 2 * margen;

            g2d.drawLine(margen, getHeight() - margen, getWidth() - margen, getHeight() - margen);
            g2d.drawLine(margen, margen, margen, getHeight() - margen);

            double maxTemp = 1;
            for (double t : temperaturas) {
                if (t > maxTemp) maxTemp = t;
            }

            int pasoX = anchoUtil / 6;
            int[] puntosX = new int[7];
            int[] puntosY = new int[7];

            for (int i = 0; i < 7; i++) {
                puntosX[i] = margen + i * pasoX;
                puntosY[i] = (getHeight() - margen) - (int) ((temperaturas[i] / maxTemp) * (altoUtil - 20));
            }

            g2d.setColor(Color.BLUE);
            g2d.setStroke(new BasicStroke(2));
            for (int i = 0; i < 6; i++) {
                g2d.drawLine(puntosX[i], puntosY[i], puntosX[i + 1], puntosY[i + 1]);
            }

            for (int i = 0; i < 7; i++) {
                g2d.setColor(Color.RED);
                g2d.fillOval(puntosX[i] - 4, puntosY[i] - 4, 8, 8);
                g2d.setColor(Color.BLACK);
                g2d.drawString(String.valueOf(temperaturas[i]) + "°", puntosX[i] - 10, puntosY[i] - 10);
                g2d.drawString(dias[i], puntosX[i] - 10, getHeight() - margen + 20);
            }
        }
    }

    public static void main(String[] args) {
        new AppTemperatura().setVisible(true);
    }
}