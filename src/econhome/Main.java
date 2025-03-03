package econhome;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		List<Pessoas> pessoa = new ArrayList<>();
		GerirTotais gerirtotais = new GerirTotais();

		// ate que o usuario escolha sair do programa, o sistema ira funcionar
		while (true) {
			String[] opcoes = { "Cadastrar Pessoa", "Cadastrar Transação", "Consulta de Totais", "Deletar Pessoa",
					"Sair" };
			int op = JOptionPane.showOptionDialog(null, "Escolha uma opção", "ECONHOME", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

			switch (op) {

			// cadastro de novo morador
			case 0:
				String nome = JOptionPane.showInputDialog("Nome: ");
				Integer idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));

				Pessoas pessoas = new Pessoas(nome, idade);
				pessoa.add(pessoas);
				JOptionPane.showMessageDialog(null, "cadastro realizado");
				break;

			// cadastro de nova transação
			case 1:
				String descricao = JOptionPane.showInputDialog("Descrição: ");

				/*
				 * aqui nós vamos selecionar a pessoa que esta realizando a transação, para isso
				 * criamos uma lista que vai receber o nome des todas as pessoas cadastradas -
				 * essas vão aparecer nas opções para o usuário selecionar
				 */
				Object[] nomePessoas = new Object[pessoa.size()];
				for (int i = 0; i < pessoa.size(); i++) {
					nomePessoas[i] = pessoa.get(i).getNome();
				}

				Object valorSelecionado = JOptionPane.showInputDialog(null, "Selecionar pessoa", "Nova transação",
						JOptionPane.INFORMATION_MESSAGE, null, nomePessoas, nomePessoas[0]);

				/*
				 * aqui, vou buscar a pessoa que foi selecionada e armazenar seu nome e idade, a
				 * idade é importante para filtrar qual o tipo de transação que a pessoa pode
				 * fazer
				 */
				Pessoas pessoaSelecionada = null;
				String nomeSelecionado = null;
				Integer idadeSelecionada = 0;

				for (Pessoas p : pessoa) {
					if (p.getNome().equals(valorSelecionado)) {
						pessoaSelecionada = p;
						nomeSelecionado = p.getNome();
						idadeSelecionada = p.getIdade();
					}
				}

				/*
				 * nesse bloco de código, eu crio o seletor de qual o tipo de transação a ser
				 * realizada e filtro para que pessoas com menos de 18 anos possam apenas
				 * cadastrar uma "despesa"
				 */

				Object[] tipoTransacao = { "Despesa", "Receita" };

				Object[] opMenorIdade = { "Despesa" };

				Object tipoSelecionado;

				if (idadeSelecionada >= 18) {
					tipoSelecionado = JOptionPane.showInputDialog(null, "Tipo de transação", "Nova transação",
							JOptionPane.INFORMATION_MESSAGE, null, tipoTransacao, tipoTransacao[0]);
				} else {
					tipoSelecionado = JOptionPane.showInputDialog(null, "Tipo de transação", "Nova transação",
							JOptionPane.INFORMATION_MESSAGE, null, opMenorIdade, opMenorIdade[0]);
				}

				Boolean tipo = tipoSelecionado.equals("Receita"); // passa o valor para boolean, onde receita é true

				Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor: "));

				// aqui eu crio uma nova transação, adciono ela a pessoa selecionada, e
				// contabilizo nos totais
				Transacao transacao = new Transacao(descricao, valor, tipo);
				pessoaSelecionada.addTransacao(transacao);
				gerirtotais.contabilizaTransacoes(transacao);

				JOptionPane.showMessageDialog(null, "Transação cadastrada");

				break;

			// consulta de totais
			case 2:
				/*
				 * aqui nós vamos percorrer todas as pessoas para listar suas informações e
				 * transações, em seguida, apresentar o total de despesas, o total de receitas e
				 * saldo líquido total
				 */
				for (Pessoas p : pessoa) {
					JOptionPane.showMessageDialog(null, p.toString());
				}

				JOptionPane.showMessageDialog(null, "Despesas: " + gerirtotais.getTotalDespesas() + "\nReceitas: "
						+ gerirtotais.getTotalReceita() + "\nSaldo Líquido: " + gerirtotais.saldoLiquido());
				break;

			// deletar pessoas do sistemas
			case 3:
				// aqui, vou criar novavente, um seletor com todas as pessoas cadastradas
				nomePessoas = new Object[pessoa.size()];
				for (int i = 0; i < pessoa.size(); i++) {
					nomePessoas[i] = pessoa.get(i).getNome();
				}

				valorSelecionado = JOptionPane.showInputDialog(null, "Selecionar pessoa", "Pessoa para ser deletada",
						JOptionPane.INFORMATION_MESSAGE, null, nomePessoas, nomePessoas[0]);

				// aqui, vou armazenar a pessoa selecionada que devera ser deletada

				Pessoas pessoaDeletar = null;

				for (Pessoas p : pessoa) {
					if (p.getNome().equals(valorSelecionado)) {
						pessoaDeletar = p;
					}
				}

				// essa parte do código é responsável por remover a pessoa e as transações que
				// ela realizou do sistema

				for (Transacao t : pessoaDeletar.getTransacoes()) {
					gerirtotais.removerTransacoes(t);
				}

				pessoa.remove(pessoaDeletar);

				JOptionPane.showMessageDialog(null, "Pessoa deletada");
				break;

			// sair do sistema
			case 4:
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}
}
