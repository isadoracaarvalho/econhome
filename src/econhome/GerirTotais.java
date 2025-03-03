package econhome;

// essa classe é responsável por gerir os totais (receitas, despesas e saldo líquido)
public class GerirTotais {

	private Double totalReceita = 0.0;
	private Double totalDespesas = 0.0;

	/*
	 * esse metodo é responsável por contabilizar as transações realizadas, aqui
	 * vamos verificar qual o tipo de transação foi realizada e acumular seu valor
	 * ao montante respectivo despesa/receita
	 */
	public void contabilizaTransacoes(Transacao transacao) {
		if (transacao.getTipo()) {
			totalReceita += transacao.getValor();
		} else {
			totalDespesas += transacao.getValor();
		}
	}

	// ja esse, remove as transações
	public void removerTransacoes(Transacao transacao) {
		if (transacao.getTipo()) {
			totalReceita -= transacao.getValor();
		} else {
			totalDespesas -= transacao.getValor();
		}
	}

	public Double getTotalReceita() {
		return totalReceita;
	}

	public Double getTotalDespesas() {
		return totalDespesas;
	}

	// ja esse, retorna o saldo líquido total ao subtrair as despesas da receita
	public Double saldoLiquido() {
		return totalReceita - totalDespesas;
	}

}
