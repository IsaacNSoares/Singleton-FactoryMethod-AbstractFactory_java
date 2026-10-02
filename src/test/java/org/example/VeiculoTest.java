package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VeiculoTest {

    @Test
    void deveRetornarMesmaInstanciaDaFabrica() {
        FabricaPeca instancia1 = FabricaPeca.getInstance();
        FabricaPeca instancia2 = FabricaPeca.getInstance();
        assertSame(instancia1, instancia2);
    }

    @Test
    void deveProduzirDirecaoNoVeiculo() {
        FabricaAbstrata fabrica = FabricaPeca.getInstance();
        Veiculo veiculo = new Veiculo(fabrica);
        assertEquals("Direção produzida", veiculo.produzirDirecao());
    }

    @Test
    void deveProduzirPneuNoVeiculo() {
        FabricaAbstrata fabrica = FabricaPeca.getInstance();
        Veiculo veiculo = new Veiculo(fabrica);
        assertEquals("Pneu produzido", veiculo.produzirPneu());
    }

    @Test
    void deveLancarExcecaoParaPecaInexistente() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            FabricaPeca.produzirPeca("MotorV8");
        });
        assertEquals("Peça inexistente", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoAoCriarVeiculoComFabricaNula() {
        assertThrows(NullPointerException.class, () -> {
            new Veiculo(null);
        });
    }
}