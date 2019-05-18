public enum  Constantes {

    BOM("bom"),
    OTIMO("otimo"),
    PENSE("Pense em um prato que gosta"),
    ISMASSA("O prato que você pensou é massa?"),
    QUESTION_SUGGESTED("O prato que você pensou é "),
    I_GOT_IT("Acertei de novo! "),
    WHAT_PLATE("Qual prato você pensou? "),
    PLAY_AGAIN("Deseja jogar novamente? "),
    ;

    private final String texto;

    Constantes(final String texto) {
        this.texto = texto;
    }

    public String gettexto() {
        return texto;
    }
}