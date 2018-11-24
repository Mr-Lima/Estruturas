package posto;

import conjuntos.THash;

public class Posto {
    public static THash<String, THash<Integer, Posto>> postoLista = new THash<>();
    private String nome;
    private static int count = 0;
    private int id;
    private String endereco;
    private String cidade;
    private String estado;
    private double lat, lon;
    private float preco = 0f;
    private double distancia;
    private double mediaTempo = 0;
    private double qtdTempo = 0;
    private boolean isComb;

    public Posto(String nome, String endereco, String cidade, String estado, double lat, double lon) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.lat = lat;
        this.lon = lon;
        this.id = count++;
    }

    public void setDistancia(double lat, double lon) {
        this.distancia = Math.sqrt(Math.pow((lat - this.lat), 2) + Math.pow((lon - this.lon), 2));
    }

    public double getDistancia() {
        return distancia;
    }

    public void addTempo(double tempo) {
        double soma = this.mediaTempo * qtdTempo;
        soma += tempo;
        this.mediaTempo = soma/++qtdTempo;
    }

    public double getMediaTempo() {
        return mediaTempo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }



    @Override
    public String toString() {
        return "Posto{" +
                "id=" + this.id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", isComb=" + isComb +
                ", tempo=" + mediaTempo +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public boolean isComb() {
        return isComb;
    }

    public int getId() {
        return this.id;
    }

    public void setComb(boolean comb) {
        isComb = comb;
    }
}
