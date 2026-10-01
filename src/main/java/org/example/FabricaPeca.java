package org.example;

public class FabricaPeca implements FabricaAbstrata {

    private FabricaPeca() {};
    private static FabricaPeca instance = new FabricaPeca();
    public static FabricaPeca getInstance() {
        return instance;
    }

    public static IPeca produzirPeca(String peca) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("org.example." + peca);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Peça inexistente");
        }
        return (IPeca) objeto;
    }
    @Override
    public Direcao produzirDirecao() {
        return (Direcao) produzirPeca("Direcao");
    }

    @Override
    public Pneu produzirPneu() {
        return (Pneu) produzirPeca("Pneu");
    }

}