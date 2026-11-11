package Ejemplos;

import java.awt.FlowLayout;
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
        super("Prueba de botones con Token");
        setLayout(new FlowLayout());

        botonJButtonSimple = new JButton("Boton simple");
        add(botonJButtonSimple);

        // Cargamos tu imagen personalizada para el botón elegante
        Icon tokenIcon = new ImageIcon(getClass().getResource("TOKEN_PRUEBA.png"));
        
        botonJButtonElegante = new JButton("Boton elegante", tokenIcon);
        add(botonJButtonElegante);

        // Registro de eventos
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