
/**
* @author Douglas Reis e Lucas Aquino
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormCalculadora extends JFrame implements ActionListener {

    private JTextField txtNumber;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, multButton, divButton, eqButton, clrButton;
    private JPanel panel1, panel2;

    private double firstNumber, secondNumber, result;

    private char operator;

    public FormCalculadora() {
        setTitle("Calculadora");
        setSize(200, 200);

        txtNumber = new JTextField();
        txtNumber.setPreferredSize(new Dimension(40, 40));
        txtNumber.setEditable(false);

        numberButtons = new JButton[10];

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        functionButtons = new JButton[6];
        addButton = new JButton("+");
        subButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multButton;
        functionButtons[3] = divButton;
        functionButtons[4] = eqButton;
        functionButtons[5] = clrButton;

        for (int i = 0; i < 6; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setPreferredSize(new Dimension(20, 20));
        }

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 1));
        panel1.add(txtNumber);

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4, 4));

        for (int i = 1; i < 10; i++) {
            panel2.add(numberButtons[i]);
        }

        panel2.add(numberButtons[0]);

        for (int i = 0; i < 6; i++) {
            panel2.add(functionButtons[i]);
        }

        setLayout(new BorderLayout());
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                txtNumber.setText(txtNumber.getText() + i);
            }
        }

        if (e.getSource() == addButton) {
            firstNumber = Double.parseDouble(txtNumber.getText());
            operator = '+';
            txtNumber.setText("");
        }

        if (e.getSource() == subButton) {
            firstNumber = Double.parseDouble(txtNumber.getText());
            operator = '-';
            txtNumber.setText("");
        }

        if (e.getSource() == multButton) {
            firstNumber = Double.parseDouble(txtNumber.getText());
            operator = '*';
            txtNumber.setText("");
        }

        if (e.getSource() == divButton) {
            firstNumber = Double.parseDouble(txtNumber.getText());
            operator = '/';
            txtNumber.setText("");
        }

        if (e.getSource() == eqButton) {

            try {

                secondNumber = Double.parseDouble(txtNumber.getText());

                switch (operator) {
                    case '+':
                        result = firstNumber + secondNumber;
                        break;
                    case '-':
                        result = firstNumber - secondNumber;
                        break;
                    case '*':
                        result = firstNumber * secondNumber;
                        break;
                    case '/':
                        if (secondNumber != 0) {
                            result = firstNumber / secondNumber;
                        } else {
                            txtNumber.setText("Erro");
                            return;
                        }
                        break;
                }

                txtNumber.setText(String.valueOf(result));

            } catch (Exception ex) {
                txtNumber.setText(ex.getMessage());
            }

        }

        if (e.getSource() == clrButton) {
            txtNumber.setText("");
        }
    }

}
