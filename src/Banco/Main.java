package Banco;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cliente aloisio = new Cliente();
        aloisio.setNome("Aloisio");
        aloisio.setUsername("aloisio123");
        aloisio.setSenha("senhaSegura");

        IConta cc = new ContaCorrente(aloisio);
        IConta poupanca = new ContaPoupanca(aloisio);

        cc.depositar(100);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        // Autenticação de cliente
        if (aloisio.autenticar("aloisio123", "senhaSegura")) {
            System.out.println("Autenticação bem-sucedida.");
        } else {
            System.out.println("Falha na autenticação.");
        }       

        // Envio de notificação
        Notificacao notificacao = new NotificacaoEmail("aloisio@example.com");
        notificacao.enviarNotificacao("Notificacao enviada");
    }
}