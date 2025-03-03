package econhome;

public class GerirTotais {

	private Double totalReceita = 0.0;
	private Double totalDespesas = 0.0;

	public void contabilizaTransacoes(Transacao transacao) {
		if (transacao.getTipo()) {
			totalReceita += transacao.getValor();
		} else {
			totalDespesas += transacao.getValor();
		}
	}

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

	public Double saldoLiquido() {
		return totalReceita - totalDespesas;
	}

}
