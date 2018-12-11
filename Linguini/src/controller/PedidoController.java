package controller;

import dao.MensagemRetorno;
import dao.PedidoDAO;
import java.awt.Checkbox;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.ItemPedido;
import model.Pedido;
import utils.view.Calendario;

/**
 * @author guilherme-souza
 */
public class PedidoController implements Controller<Pedido> {

    PedidoDAO pedidoDAO;
    String tabela = "Pedido";
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    Calendario calen = new Calendario();
    
    public static final char ADICIONADO = 'C';
    public static final char FINALIZADO = 'D';
    
    public PedidoController() {
        this.pedidoDAO = new PedidoDAO();
    }
    
    public String produtos(Pedido p){
        String produtos = "";
        for (ItemPedido itemPedido : p.getItemPedidoList()) {
            produtos += "("+itemPedido.getQuantidade()+")"+" "+""+itemPedido.getProdutoId().getDescricao();
            produtos += " + ";
        }
        return produtos;
    }
    
    public MensagemRetorno consultarPorStatus(char status){
        return pedidoDAO.consultarPorStatus(status);
    }
    
    public MensagemRetorno atualizarStatus(int idPedido, char status){
        MensagemRetorno msg = this.consultarPorID(idPedido);
        if(msg.isSucesso()){
            Pedido p = (Pedido) msg.getObjeto();
            p.setStatus(status);
            msg = this.salvar(p);
        }
        return msg;
    }

    @Override
    public MensagemRetorno salvar(Pedido pedido) {
        return this.pedidoDAO.salvar(pedido);
    }

    @Override
    public MensagemRetorno excluir(Pedido pedido) {
        return this.pedidoDAO.excluir(pedido);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.pedidoDAO.excluirDesativar(id, this.tabela);
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
// dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        String[] cabecalho = this.getCabecalho();

        // cria matriz de acordo com nº de registros da tabela
        try {
            MensagemRetorno ms = this.pedidoDAO.consultarAtivosComCriterio(this.tabela, this.getCamposPesquisaveis(), criterio, ordenacao);
            if (ms.isSucesso()) {
                dadosTabela = new Object[ms.getLista().size()][cabecalho.length];
            }
            dadosTabela = new Object[ms.getLista().size()][7];

        } catch (Exception e) {
            System.out.println("Erro ao consultar Fornecedor: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            MensagemRetorno ms = this.pedidoDAO.consultarAtivosComCriterio(this.tabela, this.getCamposPesquisaveis(), criterio, ordenacao);

            for (Object o : ms.getLista()) {
                Pedido p = (Pedido) o;
                dadosTabela[lin][0] = p.getId();
                dadosTabela[lin][1] = p.getValor();
                dadosTabela[lin][2] = calen.getDataHoraDeDate(p.getDataHora());
                dadosTabela[lin][3] = "Venda direta";
                if (p.getMesa() != null) {
                    dadosTabela[lin][3] = "Comanda n. " + p.getMesa();
                }
                if (p.getStatus() == 'A') {
                    dadosTabela[lin][4] = "Em preparo";
                    dadosTabela[lin][3] = "Delivery";
                }
                if (p.getStatus() == 'I') {
                    dadosTabela[lin][4] = "Enviado";
                    dadosTabela[lin][3] = "Delivery";
                }
                if (p.getStatus() == 'S') {
                    dadosTabela[lin][4] = "Saiu para entregar";
                    dadosTabela[lin][3] = "Delivery";
                }
                if (p.getStatus() == 'F') {
                    dadosTabela[lin][4] = "Finalizado";
                    dadosTabela[lin][3] = "Delivery";
                }
                if (p.getStatus() == 'O') {
                    dadosTabela[lin][4] = "Finalizado";
                    dadosTabela[lin][3] = "Delivery";
                }
                if (p.getStatus() == 'P') {
                    dadosTabela[lin][4] = "Pendente";
                }
                if (p.getStatus() == 'C') {
                    dadosTabela[lin][4] = "Em Preparo";
                }
                if (p.getStatus() == 'B') {
                    dadosTabela[lin][4] = "Aguardando";
                }
                if (p.getStatus() == 'D') {
                    dadosTabela[lin][4] = "Servido";
                }

                if (p.getPessoaId() != null) {
                    dadosTabela[lin][5] = p.getPessoaId().getNome();
                }
                if (p.getPessoaId() != null) {
                    dadosTabela[lin][5] = p.getPessoaId().getNome();
                }
                if (p.getDataHoraFechado() == null) {
                    dadosTabela[lin][6] = "Em aberto";
                }
                if (p.getDataHoraFechado() != null) {
                    dadosTabela[lin][6] = "Pago";
                }

                lin++;
            }

            // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela PedidoController...");
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
            public Class
                    getColumnClass(int column) {

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

    public void popularTabelaAbertos(JTable tabela, String criterio, String pago, String ordenacao) {
// dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        String[] cabecalho = this.getCabecalho();

        // cria matriz de acordo com nº de registros da tabela
        try {
            MensagemRetorno ms = this.pedidoDAO.consultarAtivosComCriterioAberto(this.tabela, this.getCamposPesquisaveis(), criterio, pago, ordenacao);
            if (ms.isSucesso()) {
                dadosTabela = new Object[ms.getLista().size()][cabecalho.length];
            }
            dadosTabela = new Object[ms.getLista().size()][7];

        } catch (Exception e) {
            System.out.println("Erro ao consultar Fornecedor: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            MensagemRetorno ms = this.pedidoDAO.consultarAtivosComCriterioAberto(this.tabela, this.getCamposPesquisaveis(), criterio, pago, ordenacao);

            for (Object o : ms.getLista()) {
                Pedido p = (Pedido) o;

                dadosTabela[lin][0] = p.getId();
                dadosTabela[lin][1] = p.getValor();
                dadosTabela[lin][2] = calen.getDataHoraDeDate(p.getDataHora());
                dadosTabela[lin][3] = "Venda direta";
                if (p.getMesa() != null) {
                    dadosTabela[lin][3] = "Comanda n. " + p.getMesa();
                }
                if (p.getStatus() == 'A') {
                    dadosTabela[lin][4] = "Em preparo";
                    dadosTabela[lin][3] = "Delivery";
                }
                if (p.getStatus() == 'I') {
                    dadosTabela[lin][4] = "Enviado";
                    dadosTabela[lin][3] = "Delivery";
                }
                if (p.getStatus() == 'S') {
                    dadosTabela[lin][4] = "Saiu para entregar";
                    dadosTabela[lin][3] = "Delivery";
                }
                if (p.getStatus() == 'F') {
                    dadosTabela[lin][4] = "Finalizado";
                    dadosTabela[lin][3] = "Delivery";
                }
                if (p.getStatus() == 'O') {
                    dadosTabela[lin][4] = "Finalizado";
                    dadosTabela[lin][3] = "Delivery";
                }
                if (p.getStatus() == 'P') {
                    dadosTabela[lin][4] = "Pendente";
                }
                if (p.getStatus() == 'C') {
                    dadosTabela[lin][4] = "Em Preparo";
                }
                if (p.getStatus() == 'B') {
                    dadosTabela[lin][4] = "Aguardando";
                }
                if (p.getStatus() == 'D') {
                    dadosTabela[lin][4] = "Servido";
                }

                if (p.getPessoaId() != null) {
                    dadosTabela[lin][5] = p.getPessoaId().getNome();
                }
                if (p.getPessoaId() != null) {
                    dadosTabela[lin][5] = p.getPessoaId().getNome();
                }
                if (p.getDataHoraFechado() == null) {
                    dadosTabela[lin][6] = "Em aberto";
                }
                if (p.getDataHoraFechado() != null) {
                    dadosTabela[lin][6] = "Pago";
                }

                lin++;
            }

            // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela PedidoController...");
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
            public Class
                    getColumnClass(int column) {

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
        return this.pedidoDAO.consultarTodos(this.tabela);
    }

//    public MensagemRetorno consultarComanda() {
//        MensagemRetorno ms = this.pedidoDAO.consultarComandas();
//        Checkbox check = new Checkbox();
//         for (Object o : ms.getLista()) {
//                Pedido p = (Pedido) o;
//                check.add(p.getMesa());
//                dadosTabela[lin][1] = p.getValor();
//                lin++;
//            }
//        for Object p : 
//    }
    public void popularCombo(JComboBox combo) {
        this.pedidoDAO.popularCombo("Pedido", combo);
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.pedidoDAO.consultarPorId(id, this.tabela);
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        List campos = new ArrayList();
        campos.add(new CampoOrdenavel("ID", "id"));
        campos.add(new CampoOrdenavel("Valor Total", "valor"));
        campos.add(new CampoOrdenavel("Data", "data_hora"));
        campos.add(new CampoOrdenavel("Mesa / Pedido", "mesa"));
        campos.add(new CampoOrdenavel("Status", "status"));
        campos.add(new CampoOrdenavel("Cliente", "pessoa_id"));
        campos.add(new CampoOrdenavel("Situação", "data_hora_fechado"));
        return campos;
    }

    private String[] getCabecalho() {
        String[] cabecalho = {"Código", "Valor Total", "Data", "Mesa", "Status", "Cliente", "Situação"};
        return cabecalho;
    }

    private String[] getCamposPesquisaveis() {
        String[] campos = {"CAST(id AS text)", "bairro"};
        return campos;
    }

}
