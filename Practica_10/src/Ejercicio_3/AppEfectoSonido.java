package Ejercicio_3;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AppEfectoSonido {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Efectos de Sonido - Paricahua, Larico");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 120);
        frame.setLayout(new FlowLayout());

        JButton btnAplausos = new JButton("Aplausos");
        JButton btnCampana = new JButton("Campana");
        JButton btnExplosion = new JButton("Explosión");

        btnAplausos.addActionListener(e -> reproducirSonido("aplausos.wav"));
        btnCampana.addActionListener(e -> reproducirSonido("campana.wav"));
        btnExplosion.addActionListener(e -> reproducirSonido("explosion.wav"));

        frame.add(btnAplausos);
        frame.add(btnCampana);
        frame.add(btnExplosion);
        frame.setVisible(true);
    }

    public static void reproducirSonido(String archivoRuta) {
        try {
            File archivo = new File(archivoRuta);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo: " + archivoRuta);
        }
    }
}