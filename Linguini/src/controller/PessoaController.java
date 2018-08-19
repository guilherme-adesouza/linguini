package controller;

import dao.MensagemRetorno;
import dao.PessoaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Pessoa;

/**
 * @author guilherme-souza
 */
public class PessoaController implements Controller<Pessoa>{
    private PessoaDAO pessoaDAO;
    private String tabela = "Pessoa";
    
    public PessoaController(){
        this.pessoaDAO = new PessoaDAO();
    }
    
    @Override
    public MensagemRetorno salvar(Pessoa pessoa){
        return pessoaDAO.salvar(pessoa);
    }

    @Override
    public MensagemRetorno excluir(Pessoa objeto) {
        return pessoaDAO.excluir(objeto);
    }
    
    @Override
    public MensagemRetorno excluir(int id) {
        return pessoaDAO.excluir(id);
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        String[] cabecalho = this.getCabecalho();

        // cria matriz de acordo com nº de registros da tabela
        try {
            MensagemRetorno ms = this.pessoaDAO.consultarAtivosComCriterio(this.tabela, this.getCamposPesquisaveis(), criterio, ordenacao);
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
            MensagemRetorno ms = this.pessoaDAO.consultarAtivosComCriterio(this.tabela, this.getCamposPesquisaveis(), criterio, ordenacao);
            
            for (Object o : ms.getLista()) {
                Pessoa p = (Pessoa) o;

                dadosTabela[lin][0] = p.getId();
                dadosTabela[lin][1] = p.getNome();
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
        //consultar apenas ativos
        return this.pessoaDAO.consultarComCriterio(this.tabela, "situacao", "true");
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.pessoaDAO.consultarPorId(id, this.tabela);
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
        campos.add(new CampoOrdenavel("Rua", "logradouro"));
        return campos;
    }
}
