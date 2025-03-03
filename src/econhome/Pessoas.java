package econhome;

import java.util.ArrayList;
import java.util.List;

// essa classe vai gerar pessoas
public class Pessoas {

	private static Integer cont = 1;
	private Integer idPessoa;
	private String nome;
	private Integer idade;
	private List<Transacao> transacoes;

	public Pessoas(String nome, Integer idade) {
		this.idPessoa = cont++; // idPessa recebe um número exclusivo
		this.nome = nome;
		this.idade = idade;
		this.transacoes = new ArrayList<>();
	}

	// esse metodo adiciona em um arraylist as transações realizadas pela pessoa
	public void addTransacao(Transacao transacao) {
		this.transacoes.add(transacao);
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public List<Transacao> getTransacoes() {
		return this.transacoes;
	}

	/*
	 * essa função possui um acumulador soma, para calcular o montante de todas as
	 * transações realizadas
	 */

	public Double exibeMontante() {
		Double montante = 0.0;

		for (int i = 0; i < transacoes.size(); i++) {
			if (transacoes.get(i).getTipo()) {
				montante += transacoes.get(i).getValor();
			} else {
				montante -= transacoes.get(i).getValor();
			}
		}

		return montante;

	}

	@Override
	public String toString() {
		return "Pessoas \nId=" + idPessoa + "\nnome=" + nome + "\nidade=" + idade + "\ntransacoes=" + transacoes
				+ "\nMontante=" + exibeMontante();
	}

}
