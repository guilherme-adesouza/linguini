package controller;

import dao.ItemPedidoDAO;
import dao.MensagemRetorno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.ItemPedido;
import model.Pedido;
import model.Produto;

/**
 * @author vitor-olavo
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

    public MensagemRetorno consultarPedidoProduto(Pedido pedido, Produto produto) {
        return this.itemPedidoDAO.consultarPedidoProduto(this.tabela, pedido.getId().intValue(), produto.getId().intValue());
    }

    public MensagemRetorno atualizar(ItemPedido itemPedido) {
        return this.itemPedidoDAO.atualizar(itemPedido);
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
        campos.add(new CampoOrdenavel("Nome", "produto_id"));
        return campos;

    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void popularTabelaItens(JTable tabela, int pedido_id) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Quantidade";
        cabecalho[3] = "Valor Unitário";
        cabecalho[4] = "Valor Total";

        // cria matriz de acordo com nº de registros da tabela
        try {
            MensagemRetorno ms = this.itemPedidoDAO.consultarPorIdTodos(this.tabela, pedido_id);
            ms.getLista().size();
            System.out.println(ms.getLista().size());

            dadosTabela = new Object[ms.getLista().size()][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar " + this.tabela + ": " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            MensagemRetorno ms = this.itemPedidoDAO.consultarPorIdTodos(this.tabela, pedido_id);
            System.out.println(ms.getLista().size());
            for (Object o : ms.getLista()) {
                ItemPedido s = (ItemPedido) o;
                dadosTabela[lin][0] = s.getId();
                dadosTabela[lin][1] = s.getProdutoId().getDescricao();
                dadosTabela[lin][2] = s.getQuantidade();
                dadosTabela[lin][3] = s.getValor();
                dadosTabela[lin][4] = s.getValor().doubleValue()*s.getQuantidade();
                lin++;
            }

            // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela " + this.tabela);
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
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
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }
        // renderizacao das linhas da tabela = mudar a cor
//        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    setBackground(Color.GREEN);
//                } else {
//                    setBackground(Color.LIGHT_GRAY);
//                }
//                return this;
//            }
//        });
    }
}
