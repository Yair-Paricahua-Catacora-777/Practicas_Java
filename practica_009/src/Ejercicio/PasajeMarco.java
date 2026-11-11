package Ejercicio;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JOptionPane;
public class PasajeMarco extends JFrame {
    private final JTextField campoNombres;
    private final JTextField campoDocumento;
    private final JTextField campoFecha;
    private final JComboBox<String> comboOrigen;
    private final JComboBox<String> comboDestino;
    private final JRadioButton radioPiso1;
    private final JRadioButton radioPiso2;
    private final JCheckBox checkAudifonos;
    private final JCheckBox checkManta;
    private final JCheckBox checkRevistas;
    private final JList<String> listaCalidad;
    private final JButton botonAccion;
    public PasajeMarco() {
        super("Compra de Pasajes - Paricahua, Amaya, Alvarez, Larico, Lopez");
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        add(new JLabel("Nombres:"));
        campoNombres = new JTextField(15);
        add(campoNombres);

        add(new JLabel("Documento:"));
        campoDocumento = new JTextField(10);
        add(campoDocumento);

        add(new JLabel("Fecha de Viaje:"));
        campoFecha = new JTextField(10);
        add(campoFecha);
        String[] lugares = {"Arequipa", "Lima", "Cusco", "Puno"};
        add(new JLabel("Origen:"));
        comboOrigen = new JComboBox<>(lugares);
        add(comboOrigen);

        add(new JLabel("Destino:"));
        comboDestino = new JComboBox<>(lugares);
        add(comboDestino);
        radioPiso1 = new JRadioButton("1er Piso", true);
        radioPiso2 = new JRadioButton("2do Piso", false);
        ButtonGroup grupoPiso = new ButtonGroup();
        grupoPiso.add(radioPiso1);
        grupoPiso.add(radioPiso2);
        add(radioPiso1);
        add(radioPiso2);
        checkAudifonos = new JCheckBox("Audífonos");
        checkManta = new JCheckBox("Manta");
        checkRevistas = new JCheckBox("Revistas");
        add(checkAudifonos);
        add(checkManta);
        add(checkRevistas);
        String[] calidades = {"Económico", "Standard", "VIP"};
        listaCalidad = new JList<>(calidades);
        listaCalidad.setVisibleRowCount(3);
        listaCalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(listaCalidad));
        botonAccion = new JButton("Procesar / Limpiar");
        add(botonAccion);
        botonAccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                String resumen = String.format(
                    "Pasajero: %s\nDocumento: %s\nFecha: %s\nOrigen: %s -> Destino: %s\nPiso: %s\nCalidad: %s",
                    campoNombres.getText(), campoDocumento.getText(), campoFecha.getText(),
                    comboOrigen.getSelectedItem(), comboDestino.getSelectedItem(),
                    radioPiso1.isSelected() ? "1er Piso" : "2do Piso",
                    listaCalidad.getSelectedValue() != null ? listaCalidad.getSelectedValue() : "No elegido"
                );
                JOptionPane.showMessageDialog(PasajeMarco.this, resumen, "Resumen de Pasaje", JOptionPane.INFORMATION_MESSAGE);
                campoNombres.setText("");
                campoDocumento.setText("");
                campoFecha.setText("");
                comboOrigen.setSelectedIndex(0);
                comboDestino.setSelectedIndex(0);
                radioPiso1.setSelected(true);
                checkAudifonos.setSelected(false);
                checkManta.setSelected(false);
                checkRevistas.setSelected(false);
                listaCalidad.clearSelection();
            }
        });
    }
}