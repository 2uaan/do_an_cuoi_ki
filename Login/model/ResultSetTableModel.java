package model;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {

    private List<Object[]> rows;
    private String[] columnNames;

    public ResultSetTableModel(ResultSet rs, String[] columnNames) throws SQLException {
        this.rows = new ArrayList<Object[]>();
        this.columnNames = columnNames;

        ResultSetMetaData metaData = rs.getMetaData();

        int columnCount = metaData.getColumnCount();

        while (rs.next()) {
            Object[] row = new Object[columnCount];

            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }

            this.rows.add(row);
        }
    }

    public int getRowCount() {
        return this.rows.size();
    }

    public int getColumnCount() {
        return this.columnNames.length;
    }

    public String getColumnName(int column) {
        return this.columnNames[column];
    }

    public Object getValueAt(int row, int column) {
        return this.rows.get(row)[column];
    }

}

