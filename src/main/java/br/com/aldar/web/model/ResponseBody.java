package br.com.aldar.web.model;

public class ResponseBody {
    private String mensagem;

    private ResponseBody(String mensagem) {
        this.mensagem = mensagem;
    }

    public static ResponseBody build(String message) {
        return new ResponseBody(message);
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
