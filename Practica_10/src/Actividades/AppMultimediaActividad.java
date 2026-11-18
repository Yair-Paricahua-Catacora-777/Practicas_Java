package Actividades;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class AppMultimediaActividad {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Actividad Multimedia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JButton btnPlay = new JButton("Reproducir Sonido");
        btnPlay.addActionListener(e -> reproducir("sonido.wav"));

        frame.add(btnPlay);
        frame.setVisible(true);
    }

    public static void reproducir(String ruta) {
        try {
            File archivo = new File(ruta);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar el audio: " + ruta);
        }
    }
}