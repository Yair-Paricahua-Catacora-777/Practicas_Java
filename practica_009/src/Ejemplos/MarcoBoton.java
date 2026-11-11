package Ejemplos;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MarcoBoton extends JFrame {
    private final JButton botonJButtonSimple; 
    private final JButton botonJButtonElegante; 
    public MarcoBoton() {
        super("Prueba de botones con Token Paricahua - Larico");
        setLayout(new FlowLayout());
        botonJButtonSimple = new JButton("Boton simple");
        add(botonJButtonSimple);
        String nombreImagen = "TOKEN_PRUEBA.png";
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(nombreImagen));
        Image imagen = iconoOriginal.getImage();
        Image imagenEscalada = imagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
        Icon tokenIconPeque = new ImageIcon(imagenEscalada);
        botonJButtonElegante = new JButton("Boton elegante", tokenIconPeque);
        add(botonJButtonElegante);
        ManejadorBoton manejador = new ManejadorBoton();
        botonJButtonElegante.addActionListener(manejador);
        botonJButtonSimple.addActionListener(manejador);
    }
    private class ManejadorBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento) {
            JOptionPane.showMessageDialog(MarcoBoton.this,
                    String.format("Usted oprimio: %s", evento.getActionCommand()));
        }
    }
}