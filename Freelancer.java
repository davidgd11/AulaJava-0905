package br.com.fiap.bean;

import br.com.fiap.Funcionario;

public class Freelancer implements Funcionario{
	
	private String nome;
	private float valorHoraTrabalho;
	private long CNPJ;
	
	public Freelancer() {}
	
	public Freelancer (String nome, float valorHoraTrabalho, long CNPJ) {
		this.nome = nome;
		this.valorHoraTrabalho = valorHoraTrabalho;
		this.CNPJ = CNPJ;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValorHoraTrabalho() {
		return valorHoraTrabalho;
	}

	public void setValorHoraTrabalho(float valorHoraTrabalho) {
		this.valorHoraTrabalho = valorHoraTrabalho;
	}

	public long getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(long cNPJ) {
		CNPJ = cNPJ;
	}
	

	public float calcularSalario() {
		float salario = ((valorHoraTrabalho * 40) * 4) * 1.5f;
		return salario;
	};

}