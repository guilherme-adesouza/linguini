package controller;

import dao.GrupoDAO;
import dao.MensagemRetorno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Botoes;
import model.Grupo;
import model.Permissao;
import model.PermissaoBotao;
import model.Telas;
import utils.view.ComboItens;

/**
 * @author guilherme-souza
 */
public class GrupoController implements Controller<Grupo> {

    private GrupoDAO grupoDAO;
    private String tabela = "Grupo";
    
    public GrupoController(){
        this.grupoDAO = new GrupoDAO();
    }
    
    @Override
    public MensagemRetorno salvar(Grupo grupo) {
        return this.grupoDAO.salvar(grupo);
    }

    @Override
    public MensagemRetorno excluir(Grupo grupo) {
        return this.grupoDAO.excluir(grupo);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.grupoDAO.excluir(id, this.tabela);
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        String[] cabecalho = this.getCabecalho();

        // cria matriz de acordo com nº de registros da tabela
        try {
            MensagemRetorno ms = this.grupoDAO.consultarComCriterio(this.tabela, this.getCamposPesquisaveis(), criterio, ordenacao);
            if(ms.isSucesso()) {
                dadosTabela = new Object[ms.getLista().size()][cabecalho.length];
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar "+this.tabela+": " + e);
            System.out.println(e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            MensagemRetorno ms = this.grupoDAO.consultarComCriterio(this.tabela, this.getCamposPesquisaveis(), criterio, ordenacao);
            
            for (Object o : ms.getLista()) {
                Grupo g = (Grupo) o;

                dadosTabela[lin][0] = g.getId();
                dadosTabela[lin][1] = g.getNome();
                lin++;
            }

            // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela "+this.tabela+"...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
                    //return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }
    }

    @Override
    public MensagemRetorno consultarTodos() {
        return this.grupoDAO.consultarTodos(this.tabela);
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.grupoDAO.consultarPorId(id, this.tabela);
    }
    
    private String[] getCabecalho(){
        String[] cabecalho = {"Código", "Nome"};
        return cabecalho;
    }
    
    private String[] getCamposPesquisaveis(){
        String[] campos = {"CAST(id AS text)", "nome"};
        return campos;
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        List campos = new ArrayList();
        campos.add(new CampoOrdenavel("ID", "id"));
        campos.add(new CampoOrdenavel("Nome", "nome"));
        return campos;
    }
    
    public void popularCombo(JComboBox combo){
        this.grupoDAO.popularCombo("Telas", combo);
    }
    
    public void definirItemCombo(JComboBox combo, ComboItens comboItens){
        this.grupoDAO.definirItemCombo(combo, comboItens);
    }
    
    public void popularPermissoes(){
        for(Object grupo : this.consultarTodos().getLista()){
            Grupo g = (Grupo) grupo;
            //Telas
            for(Object telas : new TelaController().consultarTodos().getLista()){
                Permissao permissao = new Permissao();
                permissao.setGrupoId(g);
                permissao.setTelasId((Telas) telas);
                permissao.setVisivel(false);
                new PermissaoController().salvar(permissao);
            }
            //Botoes
            for(Object botoes : new BotaoController().consultarTodos().getLista()){
                PermissaoBotao permissaoBotao = new PermissaoBotao();
                permissaoBotao.setGrupoId(g);
                permissaoBotao.setBotoesId((Botoes) botoes);
                permissaoBotao.setVisivel(false);
                new PermissaoBotaoController().salvar(permissaoBotao);
            }
        }
    }
}
