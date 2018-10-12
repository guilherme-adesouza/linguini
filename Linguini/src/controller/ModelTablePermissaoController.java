package controller;

import dao.PermissaoBotaoDAO;
import javax.swing.table.AbstractTableModel;

/**
 * @author guilherme-souza
 */
public class ModelTablePermissaoController extends AbstractTableModel {

    private String[] columnNames;
    private Object[][] data;
    private PermissaoBotaoDAO permissaoBotaoDAO;
    
    public ModelTablePermissaoController(String[] columnNames, Object[][] data, PermissaoBotaoDAO permissaoBotaoDAO){
        this.columnNames = columnNames;
        this.data = data;
        this.permissaoBotaoDAO = permissaoBotaoDAO;
    }
    
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    
    @Override
    public Class getColumnClass(int column) {
        if (column == 2) {
            return Boolean.class;
        }
        return Object.class;
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 2;
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        int permissaoId = (int) this.getValueAt(row, 0);
        new PermissaoBotaoDAO().atualizarPorTabela(permissaoId, (Boolean) value);
        this.data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
