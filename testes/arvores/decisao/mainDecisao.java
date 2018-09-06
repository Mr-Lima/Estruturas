package arvores.decisao;

import arvores.generica.ArvoreG;

import java.util.Scanner;

public class mainDecisao {

    public static void main(String[] args) {
        ArvoreG<String> condicao = new ArvoreG<>("Aspecto");
        ArvoreG<String>.No pai = condicao.obterRaiz();
        condicao.inserir("Sol", pai);
        condicao.inserir("Nuvens", pai);
        condicao.inserir("Chuva", pai);
        condicao.inserir("Humidade", "Sol");
        condicao.inserir("Elevada", "Humidade");
        condicao.inserir("Normal", "Humidade");
        condicao.inserir("Nao", "Elevada");
        condicao.inserir("Sim", "Normal");
        condicao.inserir("Sim", "Nuvens");
        condicao.inserir("Vento", "Chuva");
        condicao.inserir("Fraco", "Vento");
        condicao.inserir("Forte", "Vento");
        condicao.inserir("Sim", "Forte");
        condicao.inserir("Nao", "Nao");
        Scanner input = new Scanner(System.in);
        ArvoreG<String>.No current = pai;
        while (!current.getValor().equals("Sim") | !current.getValor().equals("Nao")) {
            System.out.println(current.getValor() + ": ");
            String escolha = input.next();
            for (ArvoreG.No x : current.getNos()) {
                if (x.getValor().equals(escolha)) {
                    current = x;
                    break;
                }
            }
        }
        System.out.println(current.getNos().get(0));
    }
}
