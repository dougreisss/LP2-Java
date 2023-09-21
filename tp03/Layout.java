import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Layout extends Frame implements ActionListener {
    Button btnOk, btnLimpar, btnMostrar, btnSair;
    ArrayList<Pessoa> pessoas = new ArrayList<>();
    TextField txtNumero, txtNome, txtSexo, txtIdade;
    Frame f = new Frame("TP02 - LP214");

    public Layout() {
        super();

        f.setSize(400, 180);

        Color corCinzaClaro = new Color(220, 220, 220);
        f.setBackground(corCinzaClaro);

        // criando painel 1
        Panel panel1 = new Panel();
        panel1.setLayout(new GridLayout(4, 2, 10, 10));
 	f.addWindowListener(new FechaJanela());
        txtNumero = new TextField("");
	txtNumero.setEditable(false);
        txtNome = new TextField("");
        txtSexo = new TextField("");
        txtIdade = new TextField("");
        panel1.add(new Label("Numero"));
        panel1.add(txtNumero);
        panel1.add(new Label("Nome"));
        panel1.add(txtNome);
        panel1.add(new Label("Sexo"));
        panel1.add(txtSexo);
        panel1.add(new Label("Idade"));
        panel1.add(txtIdade);

        // criando painel 2
        Panel panel2 = new Panel();
        panel2.setLayout(new GridLayout(1, 4, 10, 10));

        btnOk = new Button("OK");
        btnLimpar = new Button("Limpar");
        btnMostrar = new Button("Mostrar");
        btnSair = new Button("Sair");

        panel2.add(btnOk);
        panel2.add(btnLimpar);
        panel2.add(btnMostrar);
        panel2.add(btnSair);

        btnOk.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnMostrar.addActionListener(this);
        btnSair.addActionListener(this);

        // organizando os painéis na janela
        f.setLayout(new BorderLayout(10, 10));
        f.add(panel1, BorderLayout.CENTER);
        f.add(panel2, BorderLayout.SOUTH);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOk) {
            String nome = txtNome.getText();
            String sexo = txtSexo.getText();
            String idadeStr = txtIdade.getText();

            if (nome.isEmpty() || sexo.isEmpty() || idadeStr.isEmpty()) {
                // Exibir uma mensagem de erro informando que todos os campos são obrigatórios.
                System.out.println("Todos os campos são obrigatórios.");
            } else {
                int idade = Integer.parseInt(idadeStr);
                if (sexo.equals("M") || sexo.equals("F")) {
                    // Criar uma nova instância de Pessoa
                    Pessoa pessoa = new Pessoa(nome, sexo.charAt(0), idade);

                    // Adicionar a pessoa à lista de pessoas
                    pessoas.add(pessoa);

                    // Limpar os campos
                    txtNome.setText("");
                    txtSexo.setText("");
                    txtIdade.setText("");
                    System.out.println("Dados transferidos para Pessoa.");
                } else {
                    System.out.println("O campo 'Sexo' só deve aceitar 'M' ou 'F'.");
                }
            }
        } else if (e.getSource() == btnMostrar) {
            // Exibir informações em uma janela pop-up usando JOptionPane
            StringBuilder info = new StringBuilder();
            for (Pessoa pessoa : pessoas) {
                info.append("Nome: ").append(pessoa.getNome()).append("\n");
                info.append("Sexo: ").append(pessoa.getSexo()).append("\n");
                info.append("Idade: ").append(pessoa.getIdade()).append("\n\n");
            }

            if (pessoas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não há pessoas na lista.");
            } else {
		 info.append("Valor de kp: ").append(pessoas.get(0).getKp());
                JOptionPane.showMessageDialog(this, info.toString(), "Informações das Pessoas", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}


