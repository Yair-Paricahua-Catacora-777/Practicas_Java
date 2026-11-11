package Ejemplos;

import javax.swing.JFrame;

public class PruebaCuadroCombinado {
    public static void main(String[] args) {
        MarcoCuadroCombinado marcoCuadroCombinado = new MarcoCuadroCombinado();
        marcoCuadroCombinado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoCuadroCombinado.pack(); 
        marcoCuadroCombinado.setLocationRelativeTo(null); 
        marcoCuadroCombinado.setVisible(true);
    }
}