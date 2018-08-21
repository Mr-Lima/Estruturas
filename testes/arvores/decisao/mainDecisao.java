package arvores.decisao;

import arvores.generica.ArvoreG;

public class mainDecisao {

    public static void main(String[] args) {
        ArvoreG condicao = new ArvoreG("Aspecto");
        ArvoreG.No pai = condicao.obterRaiz();
        condicao.inserir("Sol", pai);
        condicao.inserir("Nuvens", pai);
        condicao.inserir("Chuva", pai);
    }
}
