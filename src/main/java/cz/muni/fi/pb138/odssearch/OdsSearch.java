package cz.muni.fi.pb138.odssearch;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * The OdsSearch class allows searching selected expressions in Open Spreadsheet Document files.
 *
 * @author Marek Urban (422252), Marek Abaffy (422572)
 * @version 1.0
 */

public class OdsSearch {

    private boolean mCaseSensitive = false;
    private boolean mExactMatch = false;
    private SpreadsheetDocument mDocument;

    public OdsSearch(SpreadsheetDocument document) {
        this.mDocument = document;
    }

    public OdsSearch(SpreadsheetDocument document, boolean mCaseSensitive, boolean mExactMatch) {
        this.mDocument = document;
        this.mCaseSensitive = mCaseSensitive;
        this.mExactMatch = mExactMatch;
    }

    /**
     * Method searches expression in open spreadsheet document file.
     *
     * @param expression Expression to be searched.
     * @return List of query items.
     */
    public List<QueryItem> search(String expression) {

        if (mDocument == null) {
            throw new IllegalArgumentException("Document not initialized.");
        }

        List<QueryItem> result = new ArrayList<>();

        for (Table table : mDocument.getTableList()) {
            result.addAll(searchInTable(table, expression));
        }

        return result;
    }

    /**
     * Method searches expression in open spreadsheet document table.
     *
     * @param table      Table to search expression in.
     * @param expression Expression to be searched.
     * @return List of query items.
     */
    private List<QueryItem> searchInTable(Table table, String expression) {

        List<QueryItem> result = new ArrayList<>();
        QueryItem item;
        for (int i = 0; i < table.getColumnCount(); i++) {
            Cell cell = table.getCellByPosition(i, 0);

            if (i != 0 && cell.getStringValue().isEmpty()) {
                return result;
            }

            for (int j = 0; j < table.getRowCount(); j++) {
                cell = table.getCellByPosition(i, j);
                if (!(i == 0 && j == 0) && cell.getStringValue().isEmpty()) {
                    break;
                }

                if (evaluate(table.getCellByPosition(i, j).getStringValue(), expression)) {
                    item = new QueryItem(i, j, table.getTableName(),
                            table.getCellByPosition(i, 0).getStringValue(), cell.getStringValue());
                    result.add(item);
                }
            }
        }
        return result;
    }

    /**
     * Method compares two strings. Can distinct case sensitive strings and sub-strings.
     *
     * @param s1 Original string.
     * @param s2 String to be compared.
     * @return True if strings fulfill conditions. False otherwise.
     */
    private boolean evaluate(String s1, String s2) {
        if (mCaseSensitive) {
            if (mExactMatch) {
                return s1.equals(s2);
            } else {
                return s1.contains(s2);
            }
        } else {
            if (mExactMatch) {
                return s1.equalsIgnoreCase(s2);
            } else {
                return s1.toUpperCase().contains(s2.toUpperCase());
            }
        }
    }

}
