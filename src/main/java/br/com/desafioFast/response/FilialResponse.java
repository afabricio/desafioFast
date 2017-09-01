package br.com.desafioFast.response;

import br.com.desafioFast.model.Filial;

public class FilialResponse {
	
	
	Filial filialMaisVendeu;
	
	Filial filialMaiorCrescimento;
	
	String mesMaisVendeu;
	
	Filial filialMaiorQueda;

	public Filial getFilialMaisVendeu() {
		return filialMaisVendeu;
	}

	public void setFilialMaisVendeu(Filial filialMaisVendeu) {
		this.filialMaisVendeu = filialMaisVendeu;
	}

	public Filial getFilialMaiorCrescimento() {
		return filialMaiorCrescimento;
	}

	public void setFilialMaiorCrescimento(Filial filialMaiorCrescimento) {
		this.filialMaiorCrescimento = filialMaiorCrescimento;
	}

	public String getMesMaisVendeu() {
		return mesMaisVendeu;
	}

	public void setMesMaisVendeu(String mesMaisVendeu) {
		this.mesMaisVendeu = mesMaisVendeu;
	}

	public Filial getFilialMaiorQueda() {
		return filialMaiorQueda;
	}

	public void setFilialMaiorQueda(Filial filialMaiorQueda) {
		this.filialMaiorQueda = filialMaiorQueda;
	}

	
	

}
