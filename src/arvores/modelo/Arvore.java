package arvores.modelo;

/**
 * @author Rafael Oliveira Vasconcelos
 */
public interface Arvore {
    //A �rvore pode ser gen�rica (iArvoreG<T>)
    //Coloquei assim para facilitar.
    //Como a �rvore n�o � gen�rica, ou seja, n�o existe o tipo T,
    //O tipo do valor tem que ser um 'Object' para n�o ficar fixo a apenas um tipo
    NoBinario inserir(Object valor, NoBinario pai, Lado lado);

    NoBinario obterRaiz();

    NoBinario obterFilho(NoBinario pai, Lado lado);

    NoBinario removerNo(NoBinario no);

    NoBinario removerFilho(NoBinario pai, Lado lado);
}
