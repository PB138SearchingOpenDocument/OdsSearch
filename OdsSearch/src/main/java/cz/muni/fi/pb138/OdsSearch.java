package cz.muni.fi.pb138;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * The OdsSearch class implements an application that can configure input file of type ODS and allows
 * to search by a keyword in all sheets of such mDocument with results saved to object attribute
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

    public List<QueryItem> search(String expression) {
        List<QueryItem> result = new ArrayList<>();

        for (Table table : mDocument.getTableList()) {
            result.addAll(searchInTable(table, expression));
        }

        return result;
    }

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

    private boolean evaluate(String string1, String string2) {
        if (mCaseSensitive) {
            if (mExactMatch) {
                return string1.equals(string2);
            } else {
                return string1.contains(string2);
            }
        } else {
            if (mExactMatch) {
                return string1.equalsIgnoreCase(string2);
            } else {
                return string1.toUpperCase().contains(string2.toUpperCase());
            }
        }
    }

}
