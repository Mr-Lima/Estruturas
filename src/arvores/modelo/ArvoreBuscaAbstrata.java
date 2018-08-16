package arvores.modelo;

import java.util.Collection;

/**
 * @author Rafael Oliveira Vasconcelos
 */
public abstract class ArvoreBuscaAbstrata<Chave extends Comparable<Chave>, Valor> {
    public ArvoreBuscaAbstrata() {

    }

    abstract public boolean inserir(Chave chave, Valor valor);

    abstract public Valor remover(Chave chave);

    abstract public Valor buscar(Chave chave);

    abstract public void limpar();

    abstract public boolean ehVazia();

    abstract public int tamanho();

    abstract public Collection<Valor> obterTodos();

    abstract public Collection<Valor> obterTodosPreOrdem();

    abstract public Collection<Valor> obterTodosPosOrdem();

    abstract public Collection<Valor> obterTodosEmOrdem();
}
