
/**
* @author Douglas Reis e Lucas Aquino
*/

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FormCalculadora extends Frame implements ActionListener {

    Frame f = new Frame("Calculadora - LP2");
    TextField txtNumero;
    Button btnNumero7, btnNumero8, btnNumero9, btnDivisao, btnNumero4,
            btnNumero5, btnNumero6, btnNumeroMult, btnNumero1, btnNumero2,
            btnNumero3, btnSubtracao, btnNumero0, btnPonto, btnResultado, btnSoma, btnLimpar;

    public FormCalculadora() {
        super();

        f.setSize(500, 400);

        Color corCinzaClaro = new Color(220, 220, 220);
        f.setBackground(corCinzaClaro);

        Panel panel1 = new Panel();
        panel1.setLayout(new GridLayout(1, 1, 10, 10));
        f.addWindowListener(new FechaJanela());

        txtNumero = new TextField("0");
        txtNumero.setSize(10, 10);
        txtNumero.setBounds(10, 10, 10, 10);
        panel1.add(txtNumero);

        Panel panel2 = new Panel();

        panel2.setLayout(new GridLayout(5, 4, 10, 10));

        btnNumero7 = new Button("7");
        btnNumero7.setSize(10, 10);
        btnNumero8 = new Button("8");
        btnNumero8.setSize(10, 10);
        btnNumero9 = new Button("9");
        btnNumero9.setSize(10, 10);

        panel2.add(btnNumero7);
        panel2.add(btnNumero8);
        panel2.add(btnNumero9);

        f.setLayout(new BorderLayout(10, 10));
        f.add(panel1, BorderLayout.CENTER);
        f.add(panel2, BorderLayout.SOUTH);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}