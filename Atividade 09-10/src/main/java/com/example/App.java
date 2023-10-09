public class Endereco {
    private final String rua;
    private final String setor;
    private final String cep;
    // Outras propriedades...

    private Endereco(String rua, String setor, String cep) {
        this.rua = rua;
        this.setor = setor;
        this.cep = cep;
        // Inicialize as outras propriedades aqui...
    }

    public String getRua() {
        return rua;
    }

    public String getSetor() {
        return setor;
    }

    public String getCep() {
        return cep;
    }

    // Outros getters para as demais propriedades...

    public static EnderecoBuilder novoBuilder() {
        return new EnderecoBuilder();
    }

    public static class EnderecoBuilder {
        private String rua;
        private String setor;
        private String cep;
        // Outras propriedades...

        public EnderecoBuilder comRua(String rua) {
            this.rua = rua;
            return this;
        }

        public EnderecoBuilder comSetor(String setor) {
            this.setor = setor;
            return this;
        }

        public EnderecoBuilder comCep(String cep) {
            this.cep = cep;
            return this;
        }

        // Métodos para as demais propriedades...

        public Endereco build() {
            return new Endereco(rua, setor, cep);
        }
    }
}
