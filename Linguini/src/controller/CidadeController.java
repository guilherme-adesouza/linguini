package controller;

import dao.CidadeDAO;
import dao.EstadoDAO;
import dao.MensagemRetorno;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Cidade;
import model.Estado;

/**
 *
 * @author VitinNote
 */
public class CidadeController {

    CidadeDAO cidadeDao;
    private final EstadoDAO estadoDao;

    public CidadeController() {
        this.cidadeDao = new CidadeDAO();
        this.estadoDao = new EstadoDAO();
    }

    public MensagemRetorno salvar(Cidade cidade) {
        return cidadeDao.salvar(cidade);
    }

    public MensagemRetorno excluir(Cidade cidade) {
        return cidadeDao.excluir(cidade);
    }

    public MensagemRetorno pesquisarCCriterio(String valor) {
        return cidadeDao.consultarComCriterio("Cidade", "nome", valor);
    }

    public MensagemRetorno pesquisarPorId(int valor) {
        return cidadeDao.consultarPorId(valor, "Cidade");
    }

    public String obterEstado(Cidade cidade) {
        // MensagemRetorno msg = estadoDao.consultarPorId(cidade.getEstadoCodEstado() , "Estado");
        //Estado estado = (Estado) msg.getObjeto();
        return cidade.getNome() + " " + cidade.getEstadoCodEstado().getSigla();
    }

    public MensagemRetorno pesquisarTodos() {
        return this.cidadeDao.consultarTodos("Cidade");
    }

    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";

        // cria matriz de acordo com nº de registros da tabela
        try {
            MensagemRetorno ms = cidadeDao.consultarTodos("Cidade");
            ms.getLista().size();
            System.out.println(ms.getLista().size());

            dadosTabela = new Object[ms.getLista().size()][2];

        } catch (Exception e) {
            System.out.println("Erro ao consultar XXX: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            MensagemRetorno ms = cidadeDao.consultarTodos("Cidade");
            System.out.println(ms.getLista().size());
            for (Object o : ms.getLista()) {
                Cidade s = (Cidade) o;
                dadosTabela[lin][0] = s.getCodCidade();
                dadosTabela[lin][1] = s.getNome();
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
