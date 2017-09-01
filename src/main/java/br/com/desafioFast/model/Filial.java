package br.com.desafioFast.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Filial {
	
	String name;
	List<Movimentacao> movimentacoes;

	public Filial() {
		movimentacoes = new ArrayList<Movimentacao>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addMovimentacao(Movimentacao movimentacao) {
		movimentacoes.add(movimentacao);

	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	

	
	

}
