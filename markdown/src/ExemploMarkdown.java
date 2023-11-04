public class ExemploMarkdown {
    public static void main(String[] args) {
        Markdown titulo = new Titulo("Título 01");
        Markdown texto = new Texto("Uma simples linha, com : ");
        Markdown negrito = new Negrito(new Texto("negrito01"));
        Markdown italico = new Italico(new Texto("itálico01"));
        Markdown item = new Item("Primeiro item da linha com _itálico_.01");

        Markdown linha = new Concatena(texto, new Concatena(negrito, italico));

         
        System.out.println();
        titulo.exibe();
        System.out.println();
        linha.exibe();
        System.out.println();
        item.exibe();
    }
}

