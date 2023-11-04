class Negrito implements Markdown {
    private Markdown componente;

    public Negrito(Markdown componente) {
        this.componente = componente;
    }

    @Override
    public void exibe() {
        System.out.print("**");
        componente.exibe();
        System.out.print("**");
    }
}
