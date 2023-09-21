/**
* @author Douglas Reis e Lucas Aquino
*/;


public class Pessoa 
{
	private static int kp;
	private String nome;
	private char sexo ;
	private int idade;
	
	public Pessoa()
	{
	
	}
	public Pessoa(String nome, char sexo, int idade)
	{
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.kp++;
	}
	public void setKp()
	{
		this.kp++;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public void setIdade(int idade)
	{
		this.idade = idade;
	}
	public void setSexo(char sexo)
	{
		this.sexo = sexo;
	}
	public int getKp()
	{
		return  this.kp;
	}
	public String getNome()
	{
		return this.nome;
	}
	public char getSexo()
	{
		return  this.sexo;
	}
	public int getIdade()
	{
		return  this.idade;
	}
}