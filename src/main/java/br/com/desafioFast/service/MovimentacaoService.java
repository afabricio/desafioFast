package br.com.desafioFast.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.com.desafioFast.model.Filial;
import br.com.desafioFast.model.Movimentacao;

public class MovimentacaoService {

	List<Filial> filiais = new ArrayList<>();

	public List<Filial> getFiliais() {
		return filiais;
	}

	public void setFiliais(List<Filial> filiais) {
		this.filiais = filiais;
	}

	public Filial getFilialMaisVendeu() {

		double totalFilialMaisVendeu = 0;

		Filial filialMaisVendeu = null;
		for (Filial filial : filiais) {

			double totalMov = 0;
			for (Movimentacao movimentacao : filial.getMovimentacoes()) {
				totalMov += movimentacao.getValue();
			}

			if (totalMov > totalFilialMaisVendeu) {
				filialMaisVendeu = filial;
				totalFilialMaisVendeu = totalMov;
			}

			

		}

		return filialMaisVendeu;

	}

	public Filial getFilialMaiorCrescimento() {

		double valorFilialComMaiorCrescimento = 0;

		Filial filialMaiorCrescimento = null;
		for (Filial filial : filiais) {

			double crescimento = 0;

			double firstMov = filial.getMovimentacoes().get(0).getValue();
			double lastMov = filial.getMovimentacoes().get(filial.getMovimentacoes().size() - 1).getValue();

			crescimento = lastMov - firstMov;

			if (crescimento > valorFilialComMaiorCrescimento) {
				filialMaiorCrescimento = filial;
				valorFilialComMaiorCrescimento = crescimento;
			}

			

		}

		return filialMaiorCrescimento;

	}

	public Filial getFilialMaiorQuedaVendas() {

		double valorMaiorQuedaVendas = 0;

		Filial filialMaiorQuedaVendas = null;
		for (Filial filial : filiais) {

			double crescimento = 0;

			double firstMov = filial.getMovimentacoes().get(0).getValue();
			double lastMov = filial.getMovimentacoes().get(filial.getMovimentacoes().size() - 1).getValue();

			crescimento = lastMov - firstMov;

			if (crescimento < valorMaiorQuedaVendas) {
				filialMaiorQuedaVendas = filial;
				valorMaiorQuedaVendas = crescimento;
			}

			

		}

		return filialMaiorQuedaVendas;

	}

	public String getMesQueMaisVendeu() {

		Map<String, Double> totalPeriodo = new HashMap<String, Double>();

		for (Filial filial : filiais) {

			for (Movimentacao movimentacao : filial.getMovimentacoes()) {

				if (totalPeriodo.containsKey(movimentacao.getPeriodo())) {

					double sum = totalPeriodo.get(movimentacao.getPeriodo()) + movimentacao.getValue();

					totalPeriodo.put(movimentacao.getPeriodo(), sum);

				} else {

					totalPeriodo.put(movimentacao.getPeriodo(), movimentacao.getValue());
				}

			}

		}

		double valorMesQueMaisVendeu = 0;
		String mesQueMaisVendeu = null;
		for (String mes : totalPeriodo.keySet()) {

			if (totalPeriodo.get(mes) > valorMesQueMaisVendeu) {
				mesQueMaisVendeu = mes;
				valorMesQueMaisVendeu = totalPeriodo.get(mes);
			}

			
		}

		return mesQueMaisVendeu;

	}

}
