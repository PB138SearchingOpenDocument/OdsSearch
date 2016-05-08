import org.javatuples.Pair;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Table;
import java.util.ArrayList;

/**
 * The OdsSearch class implements an application that can configure input file of type ODS and allows
 * to search by a keyword in all sheets of such document with results saved to object attribute
 *
 * @author Marek Urban (422252), Marek Abaffy (422572)
 * @version 1.0
 */

public class OdsSearch {

    private SpreadsheetDocument document;
    private ArrayList<Pair<Table, Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>>> tables = new ArrayList();
    private ArrayList<QueryItem> queryResultArray = new ArrayList();

    /**
     * Sets up document and runs table setup without searchString
     *
     * @param path
     */
    public void setup(String path) {
        try {
            document = SpreadsheetDocument.loadDocument(path);
            setTables();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * configures tables list with content boundaries for each ODS document sheet that is not empty
     */
    private void setTables() {
        int count = document.getSheetCount();
        for (int i = 0; i < count; i++) {
            Table table = document.getSheetByIndex(i);
            Pair dataInit = getDataInit(table);
            if (dataInit.getValue0() != new Integer(-1)) {
                Pair tableBoundaries = getTableBoundaries(table, dataInit);
                tables.add(new Pair(table, tableBoundaries));
            }
        }
    }

    /**
     * Finds the first occurence of data with tolerance of 10x10 grid
     *
     * @param table
     * @return top left corner coordinates for data if data is present, Pair<-1, -1> otherwise
     */
    private Pair<Integer, Integer> getDataInit(Table table) {
        for (int col = 0; col < 10; col++) {
            for (int row = 0; row < 10; row++) {
                Cell cell = table.getCellByPosition(col, row);
                if (!cell.getStringValue().equals(new String("")))
                    return new Pair(col, row);
            }
        }
        return new Pair(-1, -1);
    }

    /**
     * finds table top left and bottom right coordinates to define its boundaries
     *
     * @param table
     * @param dataInit
     * @return
     */
    private Pair getTableBoundaries(Table table, Pair<Integer, Integer> dataInit) {
        Pair topLeft = dataInit;
        int col = dataInit.getValue0();
        int row = dataInit.getValue0();
        while (!table.getCellByPosition(col + 1, row).getStringValue().equals(""))
            col++;
        while (!table.getCellByPosition(col, row + 1).getStringValue().equals(""))
            row++;
        Pair bottomRight = new Pair(col, row);
        return new Pair(topLeft, bottomRight);
    }

    /**
     * Searches for a string if string was stated alongside with configuration
     */
    public void search(String searchString) {
        if (!searchString.isEmpty()) {
            if (tables == null)
                System.out.println("No data in tables.");
            else {
                for (Pair p : tables) {
                    Table t = (Table) p.getValue0();
                    String tableName = t.getTableName();
                    Pair boundaries = (Pair) p.getValue1();
                    Pair topLeft = (Pair) boundaries.getValue0();
                    Pair bottomRight = (Pair) boundaries.getValue1();
                    for (int col = (Integer) topLeft.getValue0(); col <= (Integer) bottomRight.getValue0(); col++) {
                        String colName = t.getCellByPosition(col, (Integer) topLeft.getValue1()).getStringValue();
                        for (int row = (Integer) topLeft.getValue1(); row <= (Integer) bottomRight.getValue1(); row++) {
                            Cell cell = t.getCellByPosition(col, row);
                            String cellValue = cell.getStringValue();
                            if (cellValue.matches(".*" + searchString + ".*")) {
                                QueryItem match = new QueryItem(col, row, tableName, colName, cellValue);
                                queryResultArray.add(match);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Loops through the results and prints its content
     */
    public void printResults() {
        if (queryResultArray.isEmpty())
            System.out.println("Nothing found");
        else {
            for (QueryItem qi : queryResultArray) {
                System.out.println(qi.toString());
            }
        }
    }

    /**
     * Clears the result list
     */
    public void clearResults() {
        queryResultArray.clear();
    }
}
