package econhome;

// essa classe é responsável pelos métodos que irão realizar as transações
public class Transacao {

	private static Integer cont = 1;
	private Integer idtransacao;
	private String descricao;
	private Double valor;
	private Boolean tipo; // onde true == receita e false == despesa

	public Transacao(String descricao, Double valor, Boolean tipo) {
		this.idtransacao = cont++;
		this.descricao = descricao;
		this.valor = valor;
		this.tipo = tipo;
	}

	public Integer getIdtransacao() {
		return idtransacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getValor() {
		return valor;
	}

	public Boolean getTipo() {
		return tipo;
	}

	// esse método retorna qual foi o tipo de transação realizada
	public String determinaTipo() {
		if (tipo) {
			return "Receita";
		} else {
			return "Despesa";
		}
	}

	@Override
	public String toString() {
		return "[Id=" + idtransacao + ", descricao=" + descricao + ", valor=" + valor + ", tipo=" + tipo + "]";
	}

}
