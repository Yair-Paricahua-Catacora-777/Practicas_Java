package Ejemplos;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class MarcoCasillaVerificacion extends JFrame {
    private JTextField campoTexto;
    private JCheckBox negritaJCheckBox; 
    private JCheckBox cursivaJCheckBox; 
    private JCheckBox fuenteGrandeJCheckBox; 
    public MarcoCasillaVerificacion() {
        super("Prueba de JCheckBox con Tres Opciones - Paricahua, Larico");
        setLayout(new FlowLayout());
        campoTexto = new JTextField("Observe como cambia el estilo de tipo de letra", 20);
        campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
        add(campoTexto);

        negritaJCheckBox = new JCheckBox("Negrita");
        cursivaJCheckBox = new JCheckBox("Cursiva");
        fuenteGrandeJCheckBox = new JCheckBox("Grande"); 
        
        add(negritaJCheckBox); 
        add(cursivaJCheckBox); 
        add(fuenteGrandeJCheckBox); 
        ManejadorCheckBox manejador = new ManejadorCheckBox();
        negritaJCheckBox.addItemListener(manejador);
        cursivaJCheckBox.addItemListener(manejador);
        fuenteGrandeJCheckBox.addItemListener(manejador); 
    }
    private class ManejadorCheckBox implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent evento) {
            Font tipoletra = null; 
            int estilo = Font.PLAIN;
            int tamano = 14;

            if (negritaJCheckBox.isSelected()) {
                estilo += Font.BOLD;
            }
            if (cursivaJCheckBox.isSelected()) {
                estilo += Font.ITALIC;
            }
            if (fuenteGrandeJCheckBox.isSelected()) {
                tamano = 18; 
            }
            tipoletra = new Font("Serif", estilo, tamano);
            campoTexto.setFont(tipoletra);
        }
    }
} 