package org.example;

public class Veiculo {

    private Direcao direcao;
    private Pneu pneu;

    public Veiculo(FabricaAbstrata fabrica) {
        this.direcao = fabrica.produzirDirecao();
        this.pneu = fabrica.produzirPneu();
    }

    public String produzirDirecao() {
        return this.direcao.produzir();
    }

    public String produzirPneu() {
        return this.pneu.produzir();
    }
}