package controller;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cidade;
import dao.CidadeDAO;
import javax.swing.JTable;
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
    private CidadeDAO cidadeDao;

    public CidadeControl() {
        cidadeDao = new CidadeDAO();
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
       // cidadeTabela.addAll(cidadeDao.pesquisar(cidadeDigitado));
    }

    

    public void excluir() {
       // cidadeDao.excluirD(cidadeDigitado);
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
    public boolean validarSelectTable(JTable table){
        if(table.getSelectedRowCount()==1){
            return true;
        }
        return false;
    }
}
