package service;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;

import javax.sql.RowSetEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoAcademiaService {

    public List<Aluno> listarAluno() {

        List<Aluno> alunos = new ArrayList<Aluno>();

        try {

            Connection con = new Conexao().getConexao();

            String queryString = "select Id, Nome, Idade, Peso, Altura, Objetivo from dbo.AlunoAcademia with (nolock)";

            PreparedStatement smt = con.prepareStatement(queryString);

            ResultSet rs = smt.executeQuery();

            while (rs.next()) {

                Aluno aluno = new Aluno();

                aluno.setId(rs.getInt("Id"));
                aluno.setNome(rs.getString("Nome"));
                aluno.setPeso(rs.getFloat("Peso"));
                aluno.setAltura(rs.getFloat("Altura"));
                aluno.setObjetivo(rs.getString("Objetivo"));
                aluno.setIdade(rs.getInt("Idade"));

                alunos.add(aluno);
            }

            rs.close();
            smt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return alunos;
    }

    public boolean incluirAluno(Aluno aluno) {

        boolean rowInserted = false;

        try {
            Connection con = new Conexao().getConexao();

            String queryString = "insert into AlunoAcademia (Nome, Idade, Peso, Altura, Objetivo) values ('"
                    + aluno.getNome() + "', " + aluno.getIdade() + ", " + aluno.getPeso() + ", " + aluno.getAltura()
                    + ", '"
                    + aluno.getObjetivo() + "')";

            PreparedStatement smt = con.prepareStatement(queryString);

            smt.execute();

            con.close();

            rowInserted = true;

        } catch (SQLException e) {
            rowInserted = false;
            throw new RuntimeException(e);
        }

        return rowInserted;
    }
}
