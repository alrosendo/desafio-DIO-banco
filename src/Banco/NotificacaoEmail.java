package Banco;

public class NotificacaoEmail implements Notificacao {
    private String email;

    public NotificacaoEmail(String email) {
        this.email = email;
    }

    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("Enviando email para " + email + ": " + mensagem);
    }
}