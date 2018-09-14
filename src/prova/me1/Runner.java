package prova.me1;

import arvores.binaria.buscaBinaria.ABB;

import java.security.spec.InvalidParameterSpecException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Runner {
    Scanner input = new Scanner(System.in);
    ABB<String, Pessoa> pessoas = new ABB<>();

    public static void main(String[] args) throws InvalidParameterSpecException {
        Runner m = new Runner();
        m.Menu();
    }

    private void Menu() {
        int opc = -1;
        while (opc != 0) {
            System.out.println("======="
                    + "1-Cadastrar pessoa\n"
                    + "2-Adicionar amigo\n"
                    + "3-Fazer postagem\n"
                    + "4-Listar amigos\n"
                    + "5-Listar postagens\n"
                    + "0-Sair\n\n");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    cadPessoa();
                    break;
                case 2:
                    adcAmigo();
                    break;
                case 3:
                    fzrPost();
                    break;
                case 4:
                    listarAmigos();
                    break;
                case 5:
                    listarPosts();
                    break;
                default:
                    break;
            }
        }
    }

    private void cadPessoa() {
        System.out.println("Nome: ");
        String nome = input.next();
        pessoas.inserir(nome, new Pessoa(nome));
    }

    private void adcAmigo() {
        System.out.println("Seu nome: ");
        String login = input.next();
        System.out.println("Nome do amigo: ");
        String amigo = input.next();
        try {
            pessoas.buscar(login).getAmigos().inserir(amigo, pessoas.buscar(amigo));
            System.out.println(pessoas.buscar(login).getAmigos().buscar(amigo).toString() + " foi adicionado.");
        } catch (NoSuchElementException e) {
            System.out.println("Error 404");
        }
    }

    private void fzrPost() {
        ArrayList<Pessoa> marcados = new ArrayList<>();
        System.out.println("Seu nome: ");
        String login = input.next();
        System.out.println("Seu post: ");
        String post = input.next();
        System.out.println("Deseja marcar alguem? (Y/N)");
        String decisao = input.next();
        try {
            switch (decisao.toUpperCase()) {
                case "Y":
                    String aux = "coisa";
                    while (!aux.equalsIgnoreCase("n")) {
                        System.out.println("Nome do amigo: ");
                        marcados.add(pessoas.buscar(input.next()));
                        System.out.println("Outro? (Y/N)");
                        aux = input.next();
                    }
                default:
                    pessoas.buscar(login).getPostagens().add(new Postagem(post, marcados));
                    pessoas.buscar(login).getPostagens().toString();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error 404!");
        }
    }

    private void listarAmigos() {
        ArrayList<Pessoa> auxiliar = new ArrayList<>();
        System.out.println("Seu nome: ");
        String login = input.next();
        for (Pessoa x : pessoas.buscar(login).getAmigos()) {
            auxiliar.add(x);
        }
        Collections.sort(auxiliar);
        System.out.println(auxiliar.toString());
    }

    private void listarPosts() {
        System.out.println("Seu nome: ");
        String login = input.next();
        System.out.println(pessoas.buscar(login).getPostagens().toString());
    }
}
