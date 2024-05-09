package br.com.fiap.bean;

import br.com.fiap.Funcionario;

public class Vendedor implements Funcionario{
	
	private String nome;
	private float valorHoraTrabalho, comissao;
	
	public Vendedor() {}
	
	public Vendedor(String nome, float valorHoraTrabalho, float comissao) {
		this.nome = nome;
		this.valorHoraTrabalho = valorHoraTrabalho;
		this.comissao = comissao;
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

	public float getComissao() {
		return comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = comissao;
	}
	
	public float calcularSalario() {
		float salario = (((valorHoraTrabalho * 40) * 4) * (1 + comissao/100));
		return salario;
	};

}