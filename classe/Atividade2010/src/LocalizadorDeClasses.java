import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.jar.JarEntry;
import java.util.Enumeration;
import java.util.jar.JarFile;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LocalizadorDeClasses {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java LocalizadorDeClasses <nome da classe> <dir> [-p]");
            return;
        }

        String nomeDaClasse = args[0];
        String caminhoDoDiretorio = args[1];
        boolean usarParallelStream = args.length > 2 && args[2].equals("-p");

        long startTime = System.currentTimeMillis();

        try {
            Stream<Path> streamDeArquivos = obterStreamDeArquivos(caminhoDoDiretorio, usarParallelStream);

            List<String> locaisEncontrados = new ArrayList<>();
            long quantidadeDeClasses = streamDeArquivos
                    .filter(arquivo -> arquivo.toString().endsWith(".class") || arquivo.toString().endsWith(".jar") || arquivo.toString().endsWith(".war"))
                    .flatMap(arquivo -> {
                        if (arquivo.toString().endsWith(".class")) {
                            return Stream.of(arquivo.toString());
                        } else {
                            try {
                                if (arquivo.toString().endsWith(".jar")) {
                                    return LocalizadorJar.encontrarClasseNoJar(arquivo, nomeDaClasse);
                                } else if (arquivo.toString().endsWith(".war")) {
                                    return LocalizadorWar.encontrarClasseNoWar(arquivo, nomeDaClasse);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return Stream.empty();
                    })
                    .peek(localEncontrado -> locaisEncontrados.add(localEncontrado.toString()))
                    .count();

            long endTime = System.currentTimeMillis();
            long tempoTotal = endTime - startTime;

            if (quantidadeDeClasses > 0) {
                System.out.println("Classe encontrada em:");
                locaisEncontrados.forEach(System.out::println);
            } else {
                System.out.println("Classe não encontrada em nenhum arquivo.");
            }

            System.out.println("Tempo gasto: " + tempoTotal + " milissegundos");
            System.out.println("Número de arquivos .class consultados: " + quantidadeDeClasses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Stream<Path> obterStreamDeArquivos(String caminhoDoDiretorio, boolean usarParallelStream) throws IOException {
        Stream<Path> streamDeArquivos = Files.walk(Paths.get(caminhoDoDiretorio), Integer.MAX_VALUE);

        if (usarParallelStream) {
            return streamDeArquivos.parallel();
        } else {
            return streamDeArquivos;
        }
    }
}

class LocalizadorJar {
    public static Stream<Path> encontrarClasseNoJar(Path caminhoDoJar, String nomeDaClasse) throws IOException {
        List<String> locaisEncontrados = new ArrayList<>();
        try (JarFile arquivoJar = new JarFile(caminhoDoJar.toFile())) {
            Enumeration<JarEntry> entradas = arquivoJar.entries();
            while (entradas.hasMoreElements()) {
                JarEntry entrada = entradas.nextElement();
                if (!entrada.isDirectory() && entrada.getName().endsWith(".class")) {
                    String nomeDaEntrada = entrada.getName().replace("/", ".").replaceAll(".class$", "");
                    if (nomeDaEntrada.contains(nomeDaClasse)) {
                        locaisEncontrados.add(caminhoDoJar.toString() + " - " + nomeDaEntrada);
                    }
                }
            }
        }
        return locaisEncontrados.stream().map(s -> Paths.get(s));
    }
}

class LocalizadorWar {
    public static Stream<Path> encontrarClasseNoWar(Path caminhoDoWar, String nomeDaClasse) throws IOException {
        List<String> locaisEncontrados = new ArrayList<>();
        try (ZipFile arquivoWar = new ZipFile(caminhoDoWar.toFile())) {
            Enumeration<? extends ZipEntry> entradas = arquivoWar.entries();
            while (entradas.hasMoreElements()) {
                ZipEntry entrada = entradas.nextElement();
                if (!entrada.isDirectory() && entrada.getName().endsWith(".class")) {
                    String nomeDaEntrada = entrada.getName().replace("/", ".").replaceAll(".class$", "");
                    if (nomeDaEntrada.contains(nomeDaClasse)) {
                        locaisEncontrados.add(caminhoDoWar.toString() + " - " + nomeDaEntrada);
                    }
                }
            }
        }
        return locaisEncontrados.stream().map(s -> Paths.get(s));
    }
}
