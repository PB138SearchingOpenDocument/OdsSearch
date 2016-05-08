import org.odftoolkit.odfdom.doc.OdfSpreadsheetDocument;
import org.odftoolkit.odfdom.doc.table.OdfTable;
import org.odftoolkit.odfdom.doc.table.OdfTableCell;

import java.util.List;

/**
 * @author Marek Abaffy (422572)
 */
public class Main {

    public static void main(String[] args) {

        if (args.length != 2) {
            throw new IllegalArgumentException("Two arguments (file path, searched word) are required.");
        }

        try {
            OdfSpreadsheetDocument ods = OdfSpreadsheetDocument.loadDocument(args[0]);
            List<OdfTable> tableList = ods.getTableList();
            for (OdfTable odfTable : tableList) {
                OdfTableCell result = searchInTable(odfTable, args[1]);
                if (result != null) {
                    System.out.println(String.format("Sheet [%s] Position [%d,%d]", odfTable.getTableName(), result.getColumnIndex(), result.getRowIndex()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method searches expression in given table.
     *
     * @param table      Table to search expression in.
     * @param expression Expression to be search.
     * @return TableCell containing search expression.
     */
    private static OdfTableCell searchInTable(OdfTable table, String expression) {
        for (int i = 0; i < table.getColumnCount(); i++) {
            OdfTableCell cell = table.getCellByPosition(i, 0);

            if (cell.getStringValue().isEmpty()) {
                return null;
            }

            for (int j = 0; j < table.getRowList().size(); j++) {

                cell = table.getCellByPosition(i, j);
                if (cell.getStringValue().isEmpty()) {
                    break;
                }

                if (table.getCellByPosition(i, j).getStringValue().equals(expression)) {
                    return table.getCellByPosition(i, j);
                }
            }
        }
        return null;
    }
}
