import java.util.List;

public class Ordenador {
    public static void ordenarPorNome(List<Student> students) {
        for (int i = 1; i < students.size(); i++) {
            Student chave = students.get(i);
            int j = i - 1;
            while (j >= 0 && students.get(j).getNome().compareTo(chave.getNome()) > 0) {
                students.set(j + 1, students.get(j));
                j--;
            }
            students.set(j + 1, chave);
        }
    }

    public static void ordenarPorSobrenome(List<Student> students) {
        for (int i = 1; i < students.size(); i++) {
            Student chave = students.get(i);
            int j = i - 1;
            while (j >= 0 && students.get(j).getSobrenome().compareTo(chave.getSobrenome()) > 0) {
                students.set(j + 1, students.get(j));
                j--;
            }
            students.set(j + 1, chave);
        }
    }

    public static void ordenarPorIdade(List<Student> students) {
        for (int i = 1; i < students.size(); i++) {
            Student chave = students.get(i);
            int j = i - 1;
            while (j >= 0 && students.get(j).getIdade() > chave.getIdade()) {
                students.set(j + 1, students.get(j));
                j--;
            }
            students.set(j + 1, chave);
        }
    }

    public static void ordenarPorNota(List<Student> students) {
        for (int i = 1; i < students.size(); i++) {
            Student chave = students.get(i);
            int j = i - 1;
            while (j >= 0 && students.get(j).getNota() > chave.getNota()) {
                students.set(j + 1, students.get(j));
                j--;
            }
            students.set(j + 1, chave);
        }
    }

    public static void ordenarPorMedia(List<Student> students) {
        for (int i = 1; i < students.size(); i++) {
            Student chave = students.get(i);
            int j = i - 1;
            while (j >= 0 && students.get(j).getMedia() > chave.getMedia()) {
                students.set(j + 1, students.get(j));
                j--;
            }
            students.set(j + 1, chave);
        }
    }
}