package arvores.modelo;

/**
 * @author Rafael Oliveira Vasconcelos
 */

public class NoBinario<Chave extends Comparable<Chave>, Valor> {
    NoBinario<Chave, Valor> pai;
    NoBinario<Chave, Valor> filhoEsquerdo;
    NoBinario<Chave, Valor> filhoDireito;

    Chave chave;
    Valor valor;
}
