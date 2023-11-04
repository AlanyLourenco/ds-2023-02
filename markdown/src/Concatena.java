class Concatena implements Markdown {
    private Markdown componente1;
    private Markdown componente2;

    public Concatena(Markdown componente1, Markdown componente2) {
        this.componente1 = componente1;
        this.componente2 = componente2;
    }

    @Override
    public void exibe() {
        componente1.exibe();
        componente2.exibe();
    }
}
