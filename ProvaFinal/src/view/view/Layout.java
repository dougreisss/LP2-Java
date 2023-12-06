package view;

import com.google.gson.Gson;

import model.Aluno;
import service.AlunoAcademiaService;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Layout extends JFrame implements ActionListener{

    private JFrame lc = new JFrame();
    private JLabel lblNome, lblIdade, lblPeso, lblAltura, lblObjetivo;
    private JTextField txtNome, txtIdade, txtPeso, txtAltura, txtObjetivo;
    private JButton btnApresentarDados, btnIncluir, btnSair, btnLimpar ;
    
    Gson gson = new Gson();
    String aux = "";

    public Layout() {
        // Configurações da janela
        setTitle("Cadastro de Aluno");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Layout
        //criando painel 1 
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(5,2,10,10));
        //__________________________________________________
        lblNome = new JLabel("Nome");
        txtNome = new JTextField(20);
        //__________________________________________________
        lblIdade = new JLabel("Idade");
        txtIdade = new JTextField(20);
        //__________________________________________________
        lblPeso = new JLabel("Peso");
        txtPeso = new JTextField(20);
        //__________________________________________________
        lblAltura = new JLabel("Altura");
        txtAltura = new JTextField(20);
        //__________________________________________________
        lblObjetivo = new JLabel("Objetivo");
        txtObjetivo = new JTextField(10);
        //adicionando txt e lbl ao layout
        p1.add(lblNome);
        p1.add(txtNome);

        p1.add(lblIdade);
        p1.add(txtIdade);

        p1.add(lblPeso);
        p1.add(txtPeso);

        p1.add(lblAltura);
        p1.add(txtAltura);

        p1.add(lblAltura);
        p1.add(txtAltura);

        p1.add(lblObjetivo);
        p1.add(txtObjetivo);
        //__________________________________________________
        //criando um novo painel 
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        //criando botoes 
        btnApresentarDados = new JButton("Mostrar Dados");
        btnIncluir = new JButton("Incluiur");
        btnLimpar = new JButton("Limpar");
        btnSair = new JButton("Sair");

        //adicionando eles ao painel
        btnApresentarDados.addActionListener(this);
        btnIncluir.addActionListener(this);
        btnSair.addActionListener(this);
        btnLimpar.addActionListener(this);

        p2.add(btnIncluir);
        p2.add(btnApresentarDados);
        p2.add(btnLimpar);
        p2.add(btnSair);

        lc.add(p1, "North");
        lc.add(p2, "South");

        lc.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
       if(e.getSource() == btnIncluir){
            JOptionPane showBox = new JOptionPane();

            AlunoAcademiaService alunoAcademiaService = new AlunoAcademiaService();
            Aluno aluno = new Aluno();

            aluno.setNome(txtNome.getText());
            aluno.setIdade(Integer.parseInt(txtIdade.getText()));
            aluno.setPeso(Float.parseFloat(txtPeso.getText()));
            aluno.setAltura(Float.parseFloat(txtAltura.getText()));
            aluno.setObjetivo(txtObjetivo.getText());

        if (alunoAcademiaService.incluirAluno(aluno)) {
            showBox.showMessageDialog(lc, "Aluno incluido com sucesso");
        } else {
            showBox.showMessageDialog(lc, "Aluno não foi incluido");

        }
            aux = gson.toJson(aluno);
        }else if (e.getSource() == btnLimpar) {
            txtNome.setText("");
            txtIdade.setText("");
            txtPeso.setText("");
            txtAltura.setText("");
            txtObjetivo.setText("");
        }else if (e.getSource() == btnSair ) {
            System.exit(0);
        }else if (e.getSource()== btnApresentarDados) {
            JOptionPane showBox = new JOptionPane();

            Aluno aluno = gson.fromJson(aux, Aluno.class);

            String msg = "Nome: " + aluno.getNome() + " Idade: " + aluno.getIdade() + " Peso: " + aluno.getPeso()
                    + " Altura: " + aluno.getAltura() + " Objetivo: " + aluno.getObjetivo();

            showBox.showMessageDialog(lc, msg);
        }


       }
    }


        




       