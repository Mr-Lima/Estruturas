package arvores.binaria.buscaBinaria;

import java.security.InvalidParameterException;
import java.util.*;

public class ABB<K extends Comparable<K>, V> implements Iterable<V> {
    private No raiz;
    private int tamanho;
    private ArrayList<No> vetorArvore;

    public ABB() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public V buscar(K chave) {
        No atual = this.raiz;
        while (atual != null) {
            if (chave.compareTo(atual.chave) < 0)
                atual = atual.esquerdo;
            else if (chave.compareTo(atual.chave) > 0)
                atual = atual.direito;
            else
                return atual.valor;
        }
        throw new NoSuchElementException("Elemento nao existe");
    }

    private No buscarNo(K chave) {
        No atual = this.raiz;
        while (atual != null) {
            if (chave.compareTo(atual.chave) < 0)
                atual = atual.esquerdo;
            else if (chave.compareTo(atual.chave) > 0)
                atual = atual.direito;
            else
                return atual;
        }
        return null;
    }

    public V inserir(K chave, V valor) {
        No novo = new No(chave, valor);
        No atual = this.raiz;


        while (true) {
            if (this.raiz == null) {
                this.raiz = novo;
                this.tamanho++;
                return this.raiz.valor;
            } else {
                if ((novo.chave.compareTo(atual.chave)) >= 1) {
                    if (atual.direito != null) {
                        atual = atual.direito;
                        //inserir(chave, valor);
                        continue;
                    } else {
                        novo.pai = atual;
                        atual.direito = novo;
                        this.tamanho++;
                        return atual.direito.valor;
                    }
                } else if ((novo.chave.compareTo(atual.chave)) <= -1) {
                        if (atual.esquerdo != null) {
                            atual = atual.esquerdo;
                            //inserir(chave, valor);
                            continue;
                        } else {
                            novo.pai = atual;
                            atual.esquerdo = novo;
                            this.tamanho++;
                            return atual.esquerdo.valor;
                        }
                } else if ((novo.chave.compareTo(atual.chave)) == 0) {
                        atual.valor = novo.valor;
                        return atual.valor;
                }
            }
        }
    }

    public V remover(No aux) {
        No travesso = null;

        if (!aux.valor.equals(aux.chave))
            throw new InvalidParameterException("Chave nao existe");

        //sem sem arvore
        if (aux.direito == null && aux.esquerdo == null) {
            if (aux.equals(this.raiz))
                this.raiz = null;
            else if (aux.pai.chave.compareTo(aux.chave) < 0) {
                travesso = aux.pai.direito;
                aux.pai.direito = null;
            } else {
                travesso = aux.pai.esquerdo;
                aux.pai.esquerdo = null;
            }
            this.tamanho--;
            return travesso.valor;
        }
        //duas sub arvores
        else if (aux.esquerdo != null && aux.direito != null) {
            V valor = aux.valor;
            No sucessor = buscarSucessor(aux);
            aux.chave = sucessor.chave;
            aux.valor = sucessor.valor;
            //sucessor.esquerdo = aux.esquerdo;
            //sucessor.esquerdo.pai = sucessor;
            remover(sucessor);


            //se o sucessor tiver o filho direito, o avo do pai é seu novo pai
            if (sucessor.direito != null) {
                sucessor.direito.pai = sucessor.pai;
                sucessor.pai.esquerdo = sucessor.direito;
                sucessor.direito = aux.direito;
                sucessor.direito.pai = sucessor;
            }
            if (aux.equals(this.raiz)) {
                travesso = sucessor.pai;
                sucessor.pai = null;
                this.raiz = sucessor;
                this.tamanho--;
                return travesso.valor;
            }

            //Se nao estiver deletando a raiz
            else {
                //sucessor.direito = aux.direito;
                //sucessor.direito.pai = sucessor;
                sucessor.pai = aux.pai;
                //aux = sucessor;

                //associando o novo no para ser filho direito ou esquerdo
                if (aux.pai.chave.compareTo(aux.chave) < 0) {
                    travesso = aux.pai.direito;
                    aux.pai.direito = sucessor;
                } else {
                    travesso = aux.pai.esquerdo;
                    aux.pai.esquerdo = sucessor;
                }
                this.tamanho++;
                return valor;
            }
        }
        //Um filho
        else {
            //para um filho na direita
            if (aux.direito != null) {
                if (aux.equals(this.raiz)) {
                    travesso = this.raiz;
                    this.raiz = aux.direito;
                    this.tamanho++;
                    return travesso.valor;
                }
                aux.direito.pai = aux.pai;
                //atribuir aux para filho esquerdo ou direito
                if (aux.chave.compareTo(aux.pai.chave) < 0) {
                    travesso = aux.pai.esquerdo;
                    aux.pai.esquerdo = aux.direito;
                } else {
                    travesso = aux.pai.direito;
                    aux.pai.direito = aux.direito;
                }
                this.tamanho++;
                return travesso.valor;
            }
            //para um filho na esquerda
            else {
                if (aux.equals(this.raiz)) {
                    travesso = this.raiz;
                    this.raiz = aux.esquerdo;
                    this.tamanho++;
                    return travesso.valor;
                }
                aux.esquerdo.pai = aux.pai;
                //atribuir aux para filho esquerdo ou direito
                if (aux.chave.compareTo(aux.pai.chave) < 0) {
                    travesso = aux.pai.esquerdo;
                    aux.pai.esquerdo = aux.esquerdo;
                } else {
                    travesso = aux.pai.direito;
                    aux.pai.direito = aux.esquerdo;
                }
                this.tamanho++;
                return travesso.valor;

            }
        }
    }

    public V remover(K chave) {
        No aux = buscarNo(chave);
        return remover(aux);
    }

    private No buscarSucessor(No no) {
        if (no.direito == null)
            return no;
        No atual = no.direito;
        No pai = no.direito;
        while (atual != null) {
            pai = atual;
            atual = atual.esquerdo;
        }
        return pai;
    }

    public void showNo(K chave) {
        No aux = buscarNo(chave);
        System.out.println(aux.toString());
    }

    public void limpar() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public void listar() {
        Queue<No> fila = new ArrayDeque<>();
        if (this.raiz == null) {
            System.out.println("Arvore vazia");
            return;
        }
        fila.add(this.raiz);
        while (!fila.isEmpty()) {
            No temp = fila.peek();
            System.out.println(fila.poll().triade() + "\n");
            if (temp.esquerdo != null)
                fila.add(temp.esquerdo);
            if (temp.direito != null)
                fila.add(temp.direito);
        }
    }

    public int tamanho() {
        return this.tamanho;
    }

    private ArrayList<No> getVetorArvore() {
        Queue<No> noQueue = new ArrayDeque<>();
        ArrayList<No> noArrayList = new ArrayList<>();

        No inicio = this.getRaiz();
        noQueue.add(inicio);
        while (!noQueue.isEmpty()) {
            No temp = noQueue.peek();
            noArrayList.add(noQueue.poll());
            if (temp.esquerdo != null)
                noQueue.add(temp.esquerdo);
            if (temp.direito != null)
                noQueue.add(temp.direito);
        }
        return noArrayList;
    }

    private No getRaiz() {
        return raiz;
    }

    @Override
    public String toString() {
        ArrayList<No> tree = this.getVetorArvore();
        //No[] tree = (No[]) nos.toArray();

        String output = "";
        int depth = 0;
        int arraySpots = tree.size();

        while (arraySpots > 0) {
            arraySpots /= 2;
            ++depth;
        }

        int maxWidth = (int) (Math.pow(2, depth));
        int charWidth = 4 * maxWidth;
        int idx = 0;
        for (int i = 0; i < depth; ++i) {
            int level = (int) Math.pow(2, i);
            for (int j = 0; j < level; ++j) {
                int preSpace = (int) ((charWidth / (Math.pow(2, (i + 1))) - 1));

                for (int k = 0; k < preSpace; ++k) {
                    output += " ";
                }


                output += tree.get(idx);
                ++idx;
                if (idx >= this.tamanho) {
                    output += "\n";
                    break;
                }
                for (int k = 0; k < preSpace; ++k) {
                    output += " ";
                }
            }
            output += "\n\n";
        }
        return output;


    }

    @Override
    public Iterator<V> iterator() {
        return new IteratorABB(this.raiz);
    }

    private class No {
        K chave;
        V valor;
        No esquerdo, direito, pai;

        public No(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return chave.toString();
        }

        public String triade() {
            if (esquerdo == null && direito == null) {
                return "null" + " " + chave.toString() + " " + "null";
            } else if (direito == null) {
                return esquerdo.chave.toString() + " " + chave.toString() + " " + "null";
            } else if (esquerdo == null) {
                return "null" + " " + chave.toString() + " " + direito.chave.toString();
            } else
                return esquerdo.chave.toString() + " " + chave.toString() + " " + direito.chave.toString();
        }
    }

    private class IteratorABB implements Iterator<V> {
        Stack<No> noQueue;

        public IteratorABB(No raiz) {
            noQueue = new Stack<>();
            while (raiz != null) {
                noQueue.push(raiz);
                raiz = raiz.esquerdo;
            }
        }

        @Override
        public boolean hasNext() {
            return !noQueue.isEmpty();
        }

        @Override
        public V next() {
            No no = noQueue.pop();
            V result = no.valor;
            if (no.direito != null) {
                no = no.direito;
                while (no != null) {
                    noQueue.push(no);
                    no = no.esquerdo;
                }
            }
            return result;
        }
    }
}
