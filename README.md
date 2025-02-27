# **ECONHOME - Sistema de Gerenciamento Financeiro Familiar**

## **Descrição**

O **ECONHOME** é um sistema de gerenciamento financeiro simples e intuitivo, desenvolvido em Java. Ele foi criado com o objetivo de praticar conceitos de orientação a objetos, utilizando uma interface gráfica para a interação com o usuário. O sistema permite que o usuário cadastre pessoas, registre transações financeiras (despesas e receitas), consulte totais e gerencie os dados de cada pessoa cadastrada.

### **Funcionalidades**

- **Cadastro de Pessoa**: Adicione pessoas no sistema, associando um nome e idade.
- **Cadastro de Transação**: Registre transações financeiras, associando uma pessoa, uma descrição e o tipo de transação (despesa ou receita).
- **Consulta de Totais**: Exiba as transações registradas, o total de receitas, despesas e o saldo líquido.
- **Deletar Pessoa**: Remova uma pessoa do sistema junto com todas as transações associadas a ela.

## **Tecnologias Utilizadas**

- **Java**: Linguagem de programação utilizada para desenvolver o sistema.
- **Swing**: Biblioteca gráfica usada para criar a interface de interação com o usuário.

## **Estrutura do Código**

O projeto é dividido nas seguintes classes:

- **Main**: Controla o fluxo principal do programa, onde o usuário interage com o sistema.
- **Pessoas**: Representa as pessoas cadastradas no sistema, contendo informações como nome, idade e transações associadas.
- **Transacao**: Representa uma transação financeira, seja uma despesa ou uma receita.
- **GerirTotais**: Realiza o gerenciamento dos totais de despesas e receitas, calculando o saldo líquido.

## **Instalação**

Para rodar o projeto localmente, siga os seguintes passos:

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/econhome.git

## **Exemplo de Uso**

1. Cadastrar Pessoa: O sistema solicita o nome e idade de uma pessoa.
2. Cadastrar Transação: O usuário escolhe a pessoa e registra uma transação, informando o valor e o tipo (despesa ou receita).
3. Consulta de Totais: O sistema exibe o total de despesas, receitas e o saldo líquido de todas as pessoas cadastradas.
4. Deletar Pessoa: Se necessário, o usuário pode remover uma pessoa e todas as suas transações.
