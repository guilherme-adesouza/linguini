package controller;

import dao.ItemPedidoDAO;
import dao.MensagemRetorno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.ItemPedido;
import model.Produto;

/**
 * @author guilherme-souza
 */
public class ItemPedidoController implements Controller<ItemPedido> {

    ItemPedidoDAO itemPedidoDAO;
    String tabela = "ItemPedido";

    public ItemPedidoController() {
        this.itemPedidoDAO = new ItemPedidoDAO();
    }

    @Override
    public MensagemRetorno salvar(ItemPedido itemPedido) {
        return this.itemPedidoDAO.salvar(itemPedido);
    }

    public MensagemRetorno salvarItem(ItemPedido itemPedido) {
        return this.itemPedidoDAO.salvarItem(itemPedido);
    }

    @Override
    public MensagemRetorno excluir(ItemPedido itemPedido) {
        return this.itemPedidoDAO.excluir(itemPedido);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.itemPedidoDAO.excluir(id, this.tabela);
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
//        // dados da tabela
//        Object[][] dadosTabela = null;
//
//        // cabecalho da tabela
//        String[] cabecalho = this.getCabecalho();
//
//        // cria matriz de acordo com nº de registros da tabela
//        try {
//            MensagemRetorno ms = this.produtoDao.consultarAtivosComCriterio(this.tabela, this.getCamposPesquisaveis(), criterio, ordenacao);
//            if (ms.isSucesso()) {
//                dadosTabela = new Object[ms.getLista().size()][cabecalho.length];
//            }
//        } catch (Exception e) {
//            System.out.println("Erro ao consultar " + this.tabela + ": " + e);
//            System.out.println(e);
//        }
//
//        int lin = 0;
//
//        // efetua consulta na tabela
//        try {
//            MensagemRetorno ms = this.produtoDao.consultarAtivosComCriterio(this.tabela, this.getCamposPesquisaveis(), criterio, ordenacao);
//
//            for (Object o : ms.getLista()) {
//                Produto p = (Produto) o;
//
//                dadosTabela[lin][0] = p.getId();
//                dadosTabela[lin][1] = p.getDescricao();
//                lin++;
//            }
//
//            // caso a coluna precise exibir uma imagem
////                if (resultadoQ.getBoolean("Situacao")) {
////                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
////                } else {
////                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
////                }
//        } catch (Exception e) {
//            System.out.println("problemas para popular tabela " + this.tabela + "...");
//            System.out.println(e);
//        }
//
//        // configuracoes adicionais no componente tabela
//        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
//            @Override
//            // quando retorno for FALSE, a tabela nao é editavel
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//
//            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
//            @Override
//            public Class getColumnClass(int column) {
//
//                if (column == 2) {
//                    //return ImageIcon.class;
//                }
//                return Object.class;
//            }
//        });
//
//        // permite seleção de apenas uma linha da tabela
//        tabela.setSelectionMode(0);
//
//        // redimensiona as colunas de uma tabela
//        TableColumn column = null;
//        for (int i = 0; i < tabela.getColumnCount(); i++) {
//            column = tabela.getColumnModel().getColumn(i);
//            switch (i) {
//                case 0:
//                    column.setPreferredWidth(17);
//                    break;
//                case 1:
//                    column.setPreferredWidth(140);
//                    break;
//            }
//        }
    }

    @Override
    public MensagemRetorno consultarTodos() {
        return this.itemPedidoDAO.consultarTodos(this.tabela);
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.itemPedidoDAO.consultarPorId(id, this.tabela);
    }

    //A FAZER TUDO ABAIXO
    private String[] getCabecalho() {
        String[] cabecalho = {"Código", "Nome"};
        return cabecalho;
    }

    private String[] getCamposPesquisaveis() {
        String[] campos = {"CAST(id AS text)", "descricao"};
        return campos;
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        List campos = new ArrayList();
        campos.add(new CampoOrdenavel("ID", "id"));
        campos.add(new CampoOrdenavel("Nome", "descricao"));
        return campos;

    }
}
