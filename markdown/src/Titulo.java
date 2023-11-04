class Titulo implements Markdown {
    private String texto;

    public Titulo(String texto) {
        this.texto = texto;
    }

    @Override
    public void exibe() {
        System.out.println("# " + texto);
    }
}

