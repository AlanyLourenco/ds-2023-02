import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import com.colega.NewtonSquareRoot; // Substitua 'com.colega' pelo pacote correto

public class TestNewtonSquareRoot {

    private static NewtonSquareRoot newton;

    @BeforeClass
    public static void setUp() {
        // Inicialize a instância de NewtonSquareRoot antes de executar os testes
        newton = new NewtonSquareRoot();
    }

    @Test
    public void testRaizQuadradaPositiva() {
        double resultado = newton.apply(16.0);
        assertEquals(4.0, resultado, 1e-6); // Esperado: 4.0
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRaizQuadradaNegativa() {
        newton.apply(-16.0); // Isso deve lançar uma exceção IllegalArgumentException
    }
}
