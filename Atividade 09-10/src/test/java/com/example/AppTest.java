import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnderecoTest {

    @Test
    public void testConstrucaoEndereco() {
        Endereco endereco = Endereco.novoBuilder()
                .comRua("Rua A")
                .comSetor("Setor B")
                .comCep("12345-678")
                // Configure outras propriedades, se necessário...
                .build();

        assertEquals("Rua A", endereco.getRua());
        assertEquals("Setor B", endereco.getSetor());
        assertEquals("12345-678", endereco.getCep());
        // Verifique outras propriedades, se necessário...
    }
}
