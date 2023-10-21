import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class CsvProcessor {
    public static void main(String[] args) {
        String inputFile = "caminho/do/seu/arquivo.csv";
        String outputFile = "caminho/do/seu/arquivo_saida.csv";

        try {
            processCsv(inputFile, outputFile);
            System.out.println("Processamento concluído. Arquivo de saída gerado em: " + outputFile);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao processar o arquivo CSV: " + e.getMessage());
        }
    }

    private static void processCsv(String inputFile, String outputFile) throws IOException {
        try (Reader fileReader = new FileReader(inputFile);
             Writer fileWriter = new FileWriter(outputFile)) {

            CSVParser csvParser = CSVFormat.DEFAULT.withHeader().parse(fileReader);
            List<String[]> outputData = new ArrayList<>();

            for (CSVRecord record : csvParser) {
                String col1 = record.get("coluna1"); // Substitua "coluna1" pelo nome da primeira coluna
                String col2 = record.get("coluna2"); // Substitua "coluna2" pelo nome da segunda coluna

                int sum = Integer.parseInt(col1) + Integer.parseInt(col2);

                // Adiciona a soma como uma coluna adicional
                String[] outputRecord = {col1, col2, String.valueOf(sum)};
                outputData.add(outputRecord);
            }

            try (CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader("coluna1", "coluna2", "soma"))) {
                for (String[] record : outputData) {
                    csvPrinter.printRecord(record);
                }
            }
        }
    }
}
