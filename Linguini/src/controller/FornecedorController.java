package controller;

import dao.FornecedorDAO;
import dao.MensagemRetorno;
import dao.SoftDelete;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Fornecedor;

/**
 *
 * @author VitinNote
 */
public class FornecedorController {

    private FornecedorDAO fornecedorDao;
    private Fornecedor fornecedorSel;

    public FornecedorController() {
        this.fornecedorDao = new FornecedorDAO();
    }

    public MensagemRetorno salvar(Fornecedor fornecedor) {
        return this.fornecedorDao.salvar(fornecedor);
    }
    
    public MensagemRetorno atualizar(Fornecedor fornecedor){
        return this.fornecedorDao.atualizar(fornecedor);
    }

    public MensagemRetorno excluir(Fornecedor fornecedor) {
        return this.fornecedorDao.excluir(fornecedor);
    }

    public MensagemRetorno pesquisarTodos() {
        return this.fornecedorDao.consultarTodos("Fornecedor");
    }

    public MensagemRetorno pesquisarPorId(int id) {
        return this.fornecedorDao.consultarPorId(id, "Fornecedor");
    }
    
    public void setForneceodrSel(Fornecedor fornecedorSel) {
        this.fornecedorSel = fornecedorSel;
   }

    public void popularTabela(JTable tabela, String criterio) {
        MensagemRetorno ms = fornecedorDao.consultarTodos("Fornecedor");

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Razão Social";
        cabecalho[3] = "CNPJ";

        // cria matriz de acordo com nº de registros da tabela
        try {

            dadosTabela = new Object[ms.getLista().size()][4];

        } catch (Exception e) {
            System.out.println("Erro ao consultar XXX: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            for (Object o : ms.getLista()) {
                Fornecedor s = (Fornecedor) o;
                dadosTabela[lin][0] = s.getId();
                dadosTabela[lin][1] = s.getNomeFantasia();
                dadosTabela[lin][2] = s.getRazaoSocial();
                dadosTabela[lin][3] = s.getCnpj();
                lin++;
            }

            // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
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
