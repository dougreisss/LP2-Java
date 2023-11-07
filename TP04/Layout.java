import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Layout implements ActionListener {

    private JFrame jf = new JFrame();

    private JLabel lblNomePesquisa, lblNome, lblSalario, lblCargo, lblNomeF;

    private JTextField txtPesquisarNome, txtSalario, txtCargo;

    private JButton btnPesquisar, btnProximo, btnAnterior;

    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    private int contadorLayout = 0;

    public Layout() {
        super();

        JPanel p1 = new JPanel();

        p1.setLayout(new GridLayout(2, 1, 10, 10));

        lblNomePesquisa = new JLabel("Nome");
        txtPesquisarNome = new JTextField(20);
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setHorizontalAlignment(SwingConstants.CENTER);
        btnPesquisar.setVerticalAlignment(SwingConstants.CENTER);

        p1.add(lblNomePesquisa);
        p1.add(txtPesquisarNome);
        p1.add(btnPesquisar);

        btnPesquisar.addActionListener(this);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 2, 5, 5));

        lblNome = new JLabel("Nome:");
        lblNomeF = new JLabel("");

        lblSalario = new JLabel("Salario:");
        txtSalario = new JTextField(20);

        lblCargo = new JLabel("Cargo:");
        txtCargo = new JTextField(20);

        btnAnterior = new JButton("Anterior");
        btnProximo = new JButton("Proximo");

        p2.add(lblNome);
        p2.add(lblNomeF);

        p2.add(lblSalario);
        p2.add(txtSalario);

        p2.add(lblCargo);
        p2.add(txtCargo);

        p2.add(btnAnterior);
        p2.add(btnProximo);

        btnAnterior.addActionListener(this);
        btnProximo.addActionListener(this);

        jf.add(p1, BorderLayout.NORTH);
        jf.add(p2, BorderLayout.SOUTH);

        jf.setVisible(true);
        jf.setSize(400, 250);
        jf.setTitle("TRABALHO PRATICO 04");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPesquisar) {
            Funcionario listFunc = new Funcionario();

            funcionarios = listFunc.listarFuncionarios(txtPesquisarNome.getText());

            if (funcionarios.size() <= 0) {
                JOptionPane.showMessageDialog(null, "Nenhum funcionário");
                return;
            }

            contadorLayout = 0;
            exibirFuncionario(contadorLayout);
        } else if (e.getSource() == btnAnterior) {
            if (contadorLayout > 0) {
                contadorLayout--;
                exibirFuncionario(contadorLayout);
            }
        } else if (e.getSource() == btnProximo) {
            if (contadorLayout < funcionarios.size() - 1) {
                contadorLayout++;
                exibirFuncionario(contadorLayout);
            }
        }
    }

    private void exibirFuncionario(int index) {
        Funcionario funcionario = funcionarios.get(index);
        lblNomeF.setText(funcionario.getNome());
        txtSalario.setText(Double.toString(funcionario.getSalario()));
        txtCargo.setText(funcionario.getCargo());
    }

}
