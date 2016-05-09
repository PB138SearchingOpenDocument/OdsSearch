package cz.muni.fi.pb138.odssearch;

/**
 * @author Marek Urban (422252)
 */

public class QueryItem {

    private int col;
    private int row;
    private String tableName;
    private String columnName;
    private String cellValue;

    public QueryItem(int col, int row, String tableName, String columnName, String cellValue) {
        this.col = col;
        this.row = row;
        this.tableName = tableName;
        this.columnName = columnName;
        this.cellValue = cellValue;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getCellValue() {
        return cellValue;
    }

    public void setCellValue(String cellValue) {
        this.cellValue = cellValue;
    }

    @Override
    public String toString() {
        return "Found \"" + cellValue
                + "\" in table \"" + tableName
                + "\" at row: " + Integer.toString(row + 1)
                + ", column: " + Integer.toString(col + 1)
                + " (" + columnName + ")";

    }
}
