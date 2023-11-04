class Italico implements Markdown {
    private Markdown componente;

    public Italico(Markdown componente) {
        this.componente = componente;
    }

    @Override
    public void exibe() {
        System.out.print("_");
        componente.exibe();
        System.out.print("_");
    }
}
