package controller;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cidade;
import dao.CidadeDao;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author VitinNote
 */
public class CidadeControl {

  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private Cidade cidadeDigitado;
    private Cidade cidadeSelecionado;
    private List<Cidade> cidadeTabela;
    private CidadeDao cidadeDao;

    public CidadeControl() {
        cidadeDao = new CidadeDao();
        cidadeTabela = ObservableCollections.observableList(new ArrayList<Cidade>());
        novo();
        //atenção ao usar em telas separas
        pesquisar();
    }

    public void novo() {
        setCidadeDigitado(new Cidade());
    }

    public void pesquisar() {
        cidadeTabela.clear();
        //atenção ao usar em telas separas
        cidadeTabela.addAll(cidadeDao.pesquisar(cidadeDigitado));
    }

    public void salvar() {
        cidadeDao.salvarAtualizar(cidadeDigitado);
        novo();
        pesquisar();
    }

    public void excluir() {
        cidadeDao.excluir(cidadeDigitado);
        novo();
        pesquisar();
    }

    public Cidade getCidadeDigitado() {
        return cidadeDigitado;
    }

    public void setCidadeDigitado(Cidade cidadeDigitado) {
        Cidade oldCidadeDigitado = this.cidadeDigitado;
        this.cidadeDigitado = cidadeDigitado;
        propertyChangeSupport.firePropertyChange("cidadeDigitado", oldCidadeDigitado, cidadeDigitado);
    }

    public Cidade getCidadeSelecionado() {
        return cidadeSelecionado;
    }
//Quando clicar no cliente na tela mostrar ele nos campos

    public void setCidadeSelecionado(Cidade cidadeSelecionado) {
        this.cidadeSelecionado = cidadeSelecionado;
        if (this.cidadeSelecionado != null) {
            setCidadeDigitado(cidadeSelecionado);

        }
    }

    public List<Cidade> getCidadeTabela() {
        return cidadeTabela;
    }

    public void setCidadeTabela(List<Cidade> cidadeTabela) {
        this.cidadeTabela = cidadeTabela;
    }

    public void addPropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.addPropertyChangeListener(e);
    }

    public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }
    class MyTableModel extends AbstractTableModel {
	String[] column = {"Name", "Email" };
	ArrayList<Cidade> data = new ArrayList<Cidade>();	
	@Override
	public int getColumnCount() {
		return column.length;
	}
	@Override
	public int getRowCount() {
		return data.size();
	}
	public String getColumnName(int columnIndex) {
		return column[columnIndex];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cidade user = data.get(rowIndex);
		if(columnIndex == 0)
			return user.getId();		
		else if(columnIndex == 1) 
			return user.getNome();
		else 
			return null;		
	}
	public void addRow(Cidade user) {
		data.add( user );
	}
	public Cidade getRow (int rowIndex) {
		return data.get(rowIndex);
	}
}

}
