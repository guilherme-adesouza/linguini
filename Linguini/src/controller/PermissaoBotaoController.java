package controller;

import dao.MensagemRetorno;
import dao.PermissaoBotaoDAO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.PermissaoBotao;

/**
 * @author guilherme-souza
 */
public class PermissaoBotaoController implements Controller<PermissaoBotao> {

    PermissaoBotaoDAO permissaoBotaoDAO;
    String tabela = "PermissaoBotao";
    
    public PermissaoBotaoController(){
        this.permissaoBotaoDAO = new PermissaoBotaoDAO();
    }
    
    @Override
    public MensagemRetorno salvar(PermissaoBotao permissaoBotao) {
        return this.permissaoBotaoDAO.salvar(permissaoBotao);
    }

    @Override
    public MensagemRetorno excluir(PermissaoBotao permissaoBotao) {
        return this.permissaoBotaoDAO.excluir(permissaoBotao);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.permissaoBotaoDAO.excluir(id, this.tabela);
    }
    
    public void popularTabelaEditavel(JTable tabela, int idTela, int idGrupo) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        String[] cabecalho = this.getCabecalho();

        // cria matriz de acordo com nº de registros da tabela
        try {
            MensagemRetorno ms = this.consultarPorGrupoTela(idGrupo, idTela);
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
            MensagemRetorno ms = this.consultarPorGrupoTela(idGrupo, idTela);
            
            for (Object o : ms.getLista()) {
                PermissaoBotao pb = (PermissaoBotao) o;

                dadosTabela[lin][0] = pb.getId();
                dadosTabela[lin][1] = pb.getBotoesId().getNome();
                dadosTabela[lin][2] = pb.getVisivel();
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
        tabela.setModel(new ModelTablePermissaoController(getCabecalho(), dadosTabela, this.permissaoBotaoDAO));


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
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        
    }

    @Override
    public MensagemRetorno consultarTodos() {
        return this.permissaoBotaoDAO.consultarTodos(this.tabela);
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.permissaoBotaoDAO.consultarPorId(id, this.tabela);
    }
    
    private String[] getCabecalho(){
        String[] cabecalho = {"Código", "Botão", "Permissão"};
        return cabecalho;
    }
    
    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public MensagemRetorno consultarPorGrupoTela(int idGrupo, int idTela){
        return this.permissaoBotaoDAO.consultarPorGrupoTela(idGrupo, idTela, this.tabela);
    }
}
