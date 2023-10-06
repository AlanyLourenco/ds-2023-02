

public class Student {
    private String nome;
    private String sobrenome;
    private int idade;
    private double nota;
    private double media;

    public Student(String nome, String sobrenome, int idade, double nota, double media) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.nota = nota;
        this.media = media;
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public double getNota() {
        return nota;
    }

    public double getMedia() {
        return media;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", idade=" + idade +
                ", nota=" + nota +
                ", media=" + media +
                '}';
    }
}