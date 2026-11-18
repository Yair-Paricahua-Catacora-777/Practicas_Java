package Actividades;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class AppGraficosActividad extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRoundRect(30, 30, 120, 70, 20, 20);

        g2d.setColor(Color.RED);
        g2d.fillOval(180, 30, 70, 70);

        AffineTransform original = g2d.getTransform();
        g2d.translate(100, 160);
        g2d.rotate(Math.toRadians(30));
        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, 0, 100, 40);
        g2d.setTransform(original);

        g2d.setColor(Color.BLACK);
        g2d.drawString("Gráficos 2D en Swing", 30, 250);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Actividad Gráficos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 320);
        frame.add(new AppGraficosActividad());
        frame.setVisible(true);
    }
}