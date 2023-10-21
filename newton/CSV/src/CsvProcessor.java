import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CsvProcessor {
    public static void main(String[] args) {
        try {
            // Abrir o arquivo de entrada CSV
            CSVReader reader = new CSVReader(new FileReader("input.csv"));
            List<String[]> rows = reader.readAll();
            reader.close();

            // Calcular a soma das duas primeiras colunas e adicionar uma coluna de soma
            for (String[] row : rows) {
                if (row.length >= 2) {
                    double col1 = Double.parseDouble(row[0]);
                    double col2 = Double.parseDouble(row[1]);
                    double sum = col1 + col2;
                    row = appendToRow(row, String.valueOf(sum));
                }
            }

            // Gerar o arquivo de saída CSV
            CSVWriter writer = new CSVWriter(new FileWriter("output.csv"));
            writer.writeAll(rows);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] appendToRow(String[] row, String value) {
        String[] newRow = new String[row.length + 1];
        System.arraycopy(row, 0, newRow, 0, row.length);
        newRow[row.length] = value;
        return newRow;
    }
}
