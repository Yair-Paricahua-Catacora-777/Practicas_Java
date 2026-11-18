package Ejercicio_4;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AppReproductorMusica {
    private static Clip clip;
    private static long posicionPausa = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Reproductor de Música - Paricahua, Larico");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 120);
        frame.setLayout(new FlowLayout());

        cargarAudio("musica.wav");

        JButton btnReproducir = new JButton("Reproducir");
        JButton btnPausar = new JButton("Pausar");
        JButton btnReanudar = new JButton("Reanudar");

        btnReproducir.addActionListener(e -> {
            if (clip != null) {
                clip.stop();
                clip.setMicrosecondPosition(0);
                posicionPausa = 0;
                clip.start();
            }
        });

        btnPausar.addActionListener(e -> {
            if (clip != null && clip.isRunning()) {
                posicionPausa = clip.getMicrosecondPosition();
                clip.stop();
            }
        });

        btnReanudar.addActionListener(e -> {
            if (clip != null && !clip.isRunning()) {
                clip.setMicrosecondPosition(posicionPausa);
                clip.start();
            }
        });

        frame.add(btnReproducir);
        frame.add(btnPausar);
        frame.add(btnReanudar);
        frame.setVisible(true);
    }

    private static void cargarAudio(String ruta) {
        try {
            File archivo = new File(ruta);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar la pista: " + ruta);
        }
    }
}
