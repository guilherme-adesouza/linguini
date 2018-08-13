/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author VitinNote
 */
public class CidadeTableModel extends AbstractTableModel {

    private List<Cidade> cidades;
    private String[] colunas = {"Id", "Nome"};

    public CidadeTableModel(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return cidades.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Cidade cidade = cidades.get(linha);
        switch (coluna) {
            case 0:
                return cidade.getId();
            case 1:
                return cidade.getNome();
        }
        return null;
    }

}
