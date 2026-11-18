package Actividades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppBinding {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Binding de Datos - Auto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 220);

        Auto auto = new Auto("Toyota", 2022, "Rojo");

        JTextField marcaField = new JTextField(auto.getMarca(), 15);
        JTextField anioField = new JTextField(String.valueOf(auto.getAnio()), 15);
        JTextField colorField = new JTextField(auto.getColor(), 15);
        JButton button = new JButton("Actualizar Modelo");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auto.setMarca(marcaField.getText());
                try {
                    int anio = Integer.parseInt(anioField.getText());
                    auto.setAnio(anio);
                    auto.setColor(colorField.getText());

                    System.out.println("Modelo actualizado:");
                    System.out.println("Marca: " + auto.getMarca());
                    System.out.println("Año: " + auto.getAnio());
                    System.out.println("Color: " + auto.getColor());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese un año válido.");
                }
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Marca:"));
        frame.add(marcaField);
        frame.add(new JLabel("Año:"));
        frame.add(anioField);
        frame.add(new JLabel("Color:"));
        frame.add(colorField);
        frame.add(button);
        frame.setVisible(true);
    }
}

class Auto {
    private String marca;
    private int anio;
    private String color;

    public Auto(String marca, int anio, String color) {
        this.marca = marca;
        this.anio = anio;
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}