package Ejemplos;

import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MarcoCuadroCombinado extends JFrame {
    private final JComboBox imagenesJComboBox;
    private final JLabel etiqueta;
    private static final String nombres[] = {
        "TOKEN_PRUEBA.jpeg", "SKIN_PRUEBA.png", "GUANTES.png", "PANTALLA_CARGA.png"
    };
    private final Icon[] iconos = {
        new ImageIcon("src/Ejemplos/" + nombres[0]),
        new ImageIcon("src/Ejemplos/" + nombres[1]),
        new ImageIcon("src/Ejemplos/" + nombres[2]),
        new ImageIcon("src/Ejemplos/" + nombres[3])
    };

    public MarcoCuadroCombinado() {
        super("Prueba de JComboBox - Paricahua, Larico");
        setLayout(new FlowLayout());  
        imagenesJComboBox = new JComboBox(nombres);
        imagenesJComboBox.setMaximumRowCount(3);
        
        imagenesJComboBox.addItemListener(
            new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent evento) {
                    if (evento.getStateChange() == ItemEvent.SELECTED) {
                        etiqueta.setIcon(iconos[imagenesJComboBox.getSelectedIndex()]);
                    }
                }
            }
        );
        
        add(imagenesJComboBox);
        etiqueta = new JLabel(iconos[0]);
        add(etiqueta);
    }
}