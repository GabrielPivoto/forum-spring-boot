package br.com.alura.forum.config.validacao;

/**
 * @author Gabriel Pivoto
 *
 * DTO que representa o erro de algum campo
 */
public class ErroDeFormularioDto {

    private String campo;
    private String erro;

    public ErroDeFormularioDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
