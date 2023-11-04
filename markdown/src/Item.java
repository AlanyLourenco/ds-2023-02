class Item implements Markdown {
    private String texto;

    public Item(String texto) {
        this.texto = texto;
    }

    @Override
    public void exibe() {
        System.out.print("* " + texto);
    }
}
