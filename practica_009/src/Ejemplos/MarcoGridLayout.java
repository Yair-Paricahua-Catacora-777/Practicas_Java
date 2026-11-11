package Ejemplos;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MarcoGridLayout extends JFrame implements ActionListener {
    private final JButton[] botones;
    private static final String[] nombres = { 
        "Fila 1 - Col 1", "Fila 1 - Col 2", "Fila 1 - Col 3", 
        "Fila 2 - Col 1", "Fila 2 - Col 2", "Fila 2 - Col 3" 
    };
    private boolean alternar = true;
    private Container contenedor;
    private GridLayout cuadricula1;
    private GridLayout cuadricula2;

    public MarcoGridLayout() {
        super("Demostracion de GridLayout - Paricahua, Larico");
        cuadricula1 = new GridLayout(2, 3, 5, 5);
        cuadricula2 = new GridLayout(3, 2, 5, 5);
        contenedor = getContentPane();
        setLayout(cuadricula1);
        
        botones = new JButton[nombres.length];
        for (int cuenta = 0; cuenta < nombres.length; cuenta++) {
            botones[cuenta] = new JButton(nombres[cuenta]);
            botones[cuenta].addActionListener(this);
            add(botones[cuenta]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (alternar) {
            contenedor.setLayout(cuadricula2);
        } else {
            contenedor.setLayout(cuadricula1);
        }
        alternar = !alternar;
        contenedor.validate();
    }
}