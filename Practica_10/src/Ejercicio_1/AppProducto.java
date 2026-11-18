package Ejercicio_1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppProducto {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Producto - Paricahua, Larico");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320, 320);
        frame.setLayout(new FlowLayout());

        Producto producto = new Producto("", 0.0, 0, "");

        JTextField txtNombre = new JTextField(18);
        JTextField txtPrecio = new JTextField(18);
        JTextField txtStock = new JTextField(18);
        JTextField txtCategoria = new JTextField(18);
        JButton btnActualizar = new JButton("Actualizar Producto");
        JLabel lblResultado = new JLabel("<html><i>Sin datos registrados</i></html>");

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    producto.setNombre(txtNombre.getText());
                    producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
                    producto.setCantidadStock(Integer.parseInt(txtStock.getText()));
                    producto.setCategoria(txtCategoria.getText());

                    String info = String.format(
                        "<html><b>Producto Actualizado:</b><br>Nombre: %s<br>Precio: S/ %.2f<br>Stock: %d<br>Categoría: %s</html>",
                        producto.getNombre(), producto.getPrecio(), producto.getCantidadStock(), producto.getCategoria()
                    );
                    lblResultado.setText(info);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese valores numéricos válidos en Precio y Stock.");
                }
            }
        });

        frame.add(new JLabel("Nombre:"));
        frame.add(txtNombre);
        frame.add(new JLabel("Precio:"));
        frame.add(txtPrecio);
        frame.add(new JLabel("Stock:"));
        frame.add(txtStock);
        frame.add(new JLabel("Categoría:"));
        frame.add(txtCategoria);
        frame.add(btnActualizar);
        frame.add(lblResultado);

        frame.setVisible(true);
    }
}

class Producto {
    private String nombre;
    private double precio;
    private int cantidadStock;
    private String categoria;

    public Producto(String nombre, double precio, int cantidadStock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}