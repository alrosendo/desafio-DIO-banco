package Banco;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    private static final int agenciaPadrao = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<String> historicoTransacoes;

    public Conta(Cliente cliente) {
        this.agencia = agenciaPadrao;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.historicoTransacoes = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
        historicoTransacoes.add("Saque: " + valor);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        historicoTransacoes.add("Depósito: " + valor);
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        historicoTransacoes.add("Transferência: " + valor + " para conta " + contaDestino.getNumero());
    }
    public int getAgencia() {
		return agencia;
	}
    public int getNumero() {
		return numero;
	}
    public double getSaldo() {
		return saldo;
	}
	

    public List<String> getHistoricoTransacoes() {
        return historicoTransacoes;
    }

    public void imprimirHistoricoTransacoes() {
        System.out.println("=== Histórico de Transações ===");
        for (String transacao : historicoTransacoes) {
            System.out.println(transacao);
        }
    }
    protected void extracted() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("numero: %d", this.numero));
		System.out.println(String.format("saldo: %.2f", this.saldo));
	}

  
}