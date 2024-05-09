package br.com.fiap.bean;

import br.com.fiap.Funcionario;

public class VigiaNoturno implements Funcionario{
	
	private String nome;
	private float valorHoraTrabalho, adicionalNoturno;
	
	public VigiaNoturno() {}
	
	public VigiaNoturno(String nome, float valorHoraTrabalho, float adicionalNoturno){
		this.nome = nome;
		this.valorHoraTrabalho = valorHoraTrabalho;
		this.adicionalNoturno = adicionalNoturno;
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

	public float getAdicionalNoturno() {
		return adicionalNoturno;
	}

	public void setAdicionalNoturno(float adicionalNoturno) {
		this.adicionalNoturno = adicionalNoturno;
	}


	public float calcularSalario() {
		float salario = ((valorHoraTrabalho * 40) * 4 + adicionalNoturno);
		return salario;
	};

}