/**
 * @author Marek Urban (422252)
 */

public class QueryItem {
    public int col;
    public int row;
    public String tableName;
    public String columnName;
    public String cellValue;

    public QueryItem(int col, int row, String tableName, String columnName, String cellValue) {
        this.col = col;
        this.row = row;
        this.tableName = tableName;
        this.columnName = columnName;
        this.cellValue = cellValue;
    }

    @Override
    public String toString() {
        return new String(
                "Found \"" + cellValue
                        + "\" in table \"" + tableName
                        + "\" at row: " + Integer.toString(row+1)
                        + ", column: " + Integer.toString(col+1)
                        + " (" + columnName + ")");

    }
}
