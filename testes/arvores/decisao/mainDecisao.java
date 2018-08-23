package arvores.decisao;

import arvores.generica.ArvoreG;

import java.util.Scanner;

public class mainDecisao {

    public static void main(String[] args) {
        ArvoreG condicao = new ArvoreG("Aspecto");
        ArvoreG.No pai = condicao.obterRaiz();
        condicao.inserir("Sol", pai);
        condicao.inserir("Nuvens", pai);
        condicao.inserir("Chuva", pai);
        /*
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
*/
        Scanner input = new Scanner(System.in);
        ArvoreG.No current = pai;
        while (!current.getValor().equals("Sim") | !current.getValor().equals("Nao")) {
            System.out.println(current.getValor() + ": ");
            String escolha = input.next();
            for (Object x :
                    current.getNos()) {
                if (x.equals(escolha)) {
                    current = (ArvoreG.No) x;
                }
            }
        }
        System.out.println(current.getValor());
    }
}
