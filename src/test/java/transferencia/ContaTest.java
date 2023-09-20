package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    //criando objetos para serem globais, declarando eles dentro da classe, não dentro do método
    Cliente sany;
    Cliente marco;
    Conta contaSany;
    Conta contaMarco;

    @BeforeEach
    void setUp() {
        sany = new Cliente("Sany", "3216549852", "59723584");
        marco = new Cliente("Marco Garcia", "00982563214", "43659821");

        contaSany = new Conta("0025", "2254", 2500.00, sany);
        contaMarco = new Conta("0026", "2251", 3500.00, marco);
    }

    @Test //assim que transformamos o método em um teste
    public void realizarTransacao() { // método

        contaSany.realizarTransferencia(1000.00, contaMarco);

        assertEquals(1500.00, contaSany.getSaldo());
        assertEquals(4500.00, contaMarco.getSaldo());
    }

    @Test
    public void realizarTransferenciaInvalida(){

        boolean resultado = contaSany.realizarTransferencia(3500.00, contaMarco);
        assertFalse(resultado);
    }

    @Test
    public void validarAgencia(){
        assertEquals("0025", contaSany.getAgencia());
    }
}