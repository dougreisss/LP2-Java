package model;

public class Aluno {
    private int Id;
    private String Nome;
    private int Idade;
    private float Peso;
    private float Altura;
    private String Objetivo;

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getIdade() {
        return this.Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    public float getPeso() {
        return this.Peso;
    }

    public void setPeso(float Peso) {
        this.Peso = Peso;
    }

    public float getAltura() {
        return this.Altura;
    }

    public void setAltura(float Altura) {
        this.Altura = Altura;
    }

    public String getObjetivo() {
        return this.Objetivo;
    }

    public void setObjetivo(String Obj) {
        this.Objetivo = Obj;
    }
}