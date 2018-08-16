package arvores.modelo;

/**
 * @author Rafael Oliveira Vasconcelos
 */

public class NoTernario<Chave extends Comparable<Chave>, Valor> {
    NoTernario<Chave, Valor> pai;
    NoTernario<Chave, Valor> filhoEsquerdo;
    NoTernario<Chave, Valor> filhoMeio;
    NoTernario<Chave, Valor> filhoDireito;

    Chave chave;
    Valor valor;
}
