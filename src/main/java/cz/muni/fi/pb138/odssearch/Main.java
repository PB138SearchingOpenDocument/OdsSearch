package cz.muni.fi.pb138.odssearch;

import org.odftoolkit.simple.SpreadsheetDocument;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Marek Abaffy (422572), Marek Urban (422252)
 */

public class Main {

    public static void main(String[] args) {

        String filePath = "products_small.ods";

        try {
            SpreadsheetDocument document = SpreadsheetDocument.loadDocument(filePath);
            OdsSearch ods = new OdsSearch(document, true, true, true);

            String input = getInput();

            if (input != null) {
                for (QueryItem a : ods.search(input)) {
                    System.out.println(a.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
