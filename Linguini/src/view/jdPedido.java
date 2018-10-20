package view;

import controller.CidadeController;
import controller.EntregadorController;
import controller.ItemPedidoController;
import controller.PedidoController;
import controller.PessoaController;
import controller.ProdutoController;
import controller.UsuarioController;
import dao.MensagemRetorno;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Cidade;
import model.Entregador;
import model.ItemPedido;
import model.Pedido;
import model.Pessoa;
import model.Produto;
import model.Usuario;
import utils.Calendario;
import utils.ControlarEntradaNumero;
import utils.Formatacao;
import utils.Sessao;

/**
 *
 * @author vitor-olavo
 */
public class jdPedido extends javax.swing.JDialog implements Pesquisavel {

    private Produto produto;
    private ProdutoController produtoController;
    private ItemPedido itemPedido;
    private ItemPedidoController itemPedidoController;
    private Pedido pedido;
    private PedidoController pedidoController;
    private Calendario calendario;
    private Usuario usuario;
    private UsuarioController usuarioController;
    private Pessoa cliente;
    private PessoaController clienteController;
    private EntregadorController entregadorController;
    private Entregador entregador;
    private CidadeController cidadeController;
    private Cidade cidade;

    private int cli_ent_ped;//cli = 1 / ped = 0 / ent = 2 / cidade = 3

    public static String nomeTela = "telaPedido";

    private void quantidade() {
        if (this.tfdQuantidade.getText().equals("")) {
            this.tfdQuantidade.setText("1");
        }
    }

    private void atualizarTabela() {
        if (this.pedido.getId() != null) {
            this.itemPedidoController.popularTabelaItens(this.tblPesquisar, this.pedido.getId().intValue());
            this.tfdPrecoSubTotal.setText(itemPedidoController.obterSubTotal(this.pedido.getId().intValue()) + "");
            atualizarTotal();
        }
    }

    private void atualizarTotal() {
        if (this.tfdPrecoDesconto.isFocusable()) {
            this.tfdPrecoTotal.setValue(this.tfdPrecoSubTotal.getValue().subtract(this.tfdPrecoDesconto.getValue()));
        } else {
            this.tfdPrecoTotal.setValue(this.tfdPrecoSubTotal.getValue());
        }
    }
    
    private void atualizaGrupoBotoes(){
        if(buttonGroup1.getSelection()==this.d_labStatusIniciado);
        this.pedido.setStatus('I');
        if(buttonGroup1.getSelection()==this.d_labStatusAguardando);
        this.pedido.setStatus('A');
        if(buttonGroup1.getSelection()==this.d_labStatusSaiu);
        this.pedido.setStatus('S');
        if(buttonGroup1.getSelection()==this.d_labStatusFinalizado);
        this.pedido.setStatus('F');
    }

    /**
     * Creates new form jdPedido
     */
    public jdPedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.calendario = new Calendario();
        this.produto = new Produto();
        this.produtoController = new ProdutoController();
        this.itemPedido = new ItemPedido();
        this.itemPedidoController = new ItemPedidoController();
        this.pedido = new Pedido();
        this.pedidoController = new PedidoController();
        this.usuario = itemPedidoController.obterUser();
        this.usuarioController = new UsuarioController();
        this.cliente = new Pessoa();
        this.clienteController = new PessoaController();
        this.entregadorController = new EntregadorController();
        this.cidadeController = new CidadeController();
        this.cidade = new Cidade();

        atualizarTabela();
        this.listaProdutos.setVisible(false);
        this.tfdNumeroPedido.setText("");
        this.tfdNumeroComanda.setText("");;
        quantidade();

        this.tfdCaixa.setText(this.usuario.getNome());
        this.cli_ent_ped = 0;

        this.pedidoController.popularCombo(this.comboNumComanda);

        Formatacao.formatarTelefone(this.d_tffTelefone);
        d_tfdNumero.setDocument(new ControlarEntradaNumero(5));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        painelCaixa = new javax.swing.JPanel();
        tfdCaixaLivre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfdObservacao = new javax.swing.JTextField();
        tfdAtendente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfdCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfdCaixa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfdNumeroPedido = new javax.swing.JLabel();
        checkDelivery = new javax.swing.JCheckBox();
        labComandaNumero = new javax.swing.JLabel();
        tfdNumeroComanda = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        comboNumComanda = new javax.swing.JComboBox<>();
        checkComanda = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        listaProdutos = new javax.swing.JList<>();
        jLabel24 = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesquisar = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        tfdQuantidade = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnRemoverItem = new javax.swing.JButton();
        tfdPrecoUnitario = new apoio.MoedaFormatada();
        jPanel2 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        d_labCliente = new javax.swing.JLabel();
        d_tfdCliente = new javax.swing.JTextField();
        d_labTelefone = new javax.swing.JLabel();
        d_labStatusIniciado = new javax.swing.JRadioButton();
        d_labStatus = new javax.swing.JLabel();
        d_labStatusAguardando = new javax.swing.JRadioButton();
        d_labStatusSaiu = new javax.swing.JRadioButton();
        d_labStatusFinalizado = new javax.swing.JRadioButton();
        d_labRua = new javax.swing.JLabel();
        d_labBairro = new javax.swing.JLabel();
        d_labNumero = new javax.swing.JLabel();
        d_tfdRua = new javax.swing.JTextField();
        d_labCidade = new javax.swing.JLabel();
        d_labEntregador = new javax.swing.JLabel();
        d_tfdBairro = new javax.swing.JTextField();
        d_tfdNumero = new javax.swing.JTextField();
        d_tffTelefone = new javax.swing.JFormattedTextField();
        cmbEntregador = new javax.swing.JComboBox<>();
        d_tfdCidade = new javax.swing.JTextField();
        tfdPrecoSubTotal = new apoio.MoedaFormatada();
        tfdPrecoDesconto = new apoio.MoedaFormatada();
        tfdPrecoTotal = new apoio.MoedaFormatada();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedido");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        painelCaixa.setBackground(new java.awt.Color(0, 204, 51));

        tfdCaixaLivre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tfdCaixaLivre.setForeground(new java.awt.Color(255, 255, 255));
        tfdCaixaLivre.setText("CAIXA LIVRE");

        javax.swing.GroupLayout painelCaixaLayout = new javax.swing.GroupLayout(painelCaixa);
        painelCaixa.setLayout(painelCaixaLayout);
        painelCaixaLayout.setHorizontalGroup(
            painelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCaixaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(tfdCaixaLivre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelCaixaLayout.setVerticalGroup(
            painelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCaixaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfdCaixaLivre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Atendente");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Observação");

        tfdAtendente.setEditable(false);
        tfdAtendente.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfdAtendenteCaretUpdate(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cliente");

        tfdCliente.setEditable(false);
        tfdCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfdClienteFocusGained(evt);
            }
        });
        tfdCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfdClienteMouseClicked(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Caixa");

        tfdCaixa.setEditable(false);
        tfdCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdCaixaActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pedido Número");

        tfdNumeroPedido.setForeground(new java.awt.Color(255, 255, 255));
        tfdNumeroPedido.setText("1");

        checkDelivery.setText("Delivery");
        checkDelivery.setEnabled(false);
        checkDelivery.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkDeliveryStateChanged(evt);
            }
        });
        checkDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDeliveryActionPerformed(evt);
            }
        });

        labComandaNumero.setForeground(new java.awt.Color(255, 255, 255));
        labComandaNumero.setText("Comanda Número");

        tfdNumeroComanda.setForeground(new java.awt.Color(255, 255, 255));
        tfdNumeroComanda.setText("1");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Mais Opções");

        comboNumComanda.setEnabled(false);
        comboNumComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNumComandaActionPerformed(evt);
            }
        });

        checkComanda.setText("Tornar Comanda");
        checkComanda.setEnabled(false);
        checkComanda.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkComandaStateChanged(evt);
            }
        });
        checkComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkComandaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labComandaNumero)
                                .addGap(18, 18, 18)
                                .addComponent(tfdNumeroComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(tfdNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdCaixa)
                            .addComponent(tfdAtendente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfdObservacao)
                            .addComponent(tfdCliente)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkDelivery)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(checkComanda)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboNumComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(painelCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfdNumeroPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labComandaNumero)
                    .addComponent(tfdNumeroComanda))
                .addGap(51, 51, 51)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkComanda)
                    .addComponent(comboNumComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkDelivery)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        listaProdutos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listaProdutos.setOpaque(false);
        listaProdutos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaProdutosValueChanged(evt);
            }
        });

        jLayeredPane2.setLayer(listaProdutos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listaProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addGap(90, 90, 90))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addComponent(listaProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jLabel24.setText("Busca");

        txtBusca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscaFocusLost(evt);
            }
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscaFocusGained(evt);
            }
        });
        txtBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscatxtBuscaActionPerformed(evt);
            }
        });
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscatxtBuscaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscatxtBuscaKeyReleased(evt);
            }
        });

        tblPesquisar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPesquisar);

        jLabel25.setText("Quantidade");

        tfdQuantidade.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfdQuantidadeCaretUpdate(evt);
            }
        });
        tfdQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdQuantidadeFocusLost(evt);
            }
        });
        tfdQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdQuantidadeActionPerformed(evt);
            }
        });
        tfdQuantidade.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tfdQuantidadePropertyChange(evt);
            }
        });

        jLabel26.setText("Preço");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarbtnAdicionarActionPerformed(evt);
            }
        });

        btnRemoverItem.setText("Remover Item");
        btnRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverItembtnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnAdicionar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemoverItem)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(tfdQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(btnAdicionar)
                    .addComponent(tfdPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addComponent(btnRemoverItem))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNovo.setBackground(new java.awt.Color(51, 102, 255));
        btnNovo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-mais-48.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setBorderPainted(false);
        btnNovo.setContentAreaFilled(false);
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(51, 102, 255));
        btnSalvar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-salvar-48.png"))); // NOI18N
        btnSalvar.setText("Finalizar");
        btnSalvar.setBorderPainted(false);
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnFechar.setBackground(new java.awt.Color(51, 102, 255));
        btnFechar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-importar-48.png"))); // NOI18N
        btnFechar.setText("Sair");
        btnFechar.setBorderPainted(false);
        btnFechar.setContentAreaFilled(false);
        btnFechar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFechar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnPesquisar.setBackground(new java.awt.Color(51, 102, 255));
        btnPesquisar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-pesquisar-48.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setBorderPainted(false);
        btnPesquisar.setContentAreaFilled(false);
        btnPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesquisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(51, 102, 255));
        btnExcluir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-excluir-48.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorderPainted(false);
        btnExcluir.setContentAreaFilled(false);
        btnExcluir.setEnabled(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnSalvar)
                .addGap(50, 50, 50)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnFechar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel15.setText("SubTotal");

        jLabel17.setText("Desconto");

        jLabel19.setText("Total");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("DELIVERY"));

        d_labCliente.setText("Cliente");
        d_labCliente.setEnabled(false);

        d_tfdCliente.setText("Não informado");
        d_tfdCliente.setEnabled(false);
        d_tfdCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d_tfdClienteMouseClicked(evt);
            }
        });
        d_tfdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_tfdClienteActionPerformed(evt);
            }
        });

        d_labTelefone.setText("Telefone");
        d_labTelefone.setEnabled(false);

        buttonGroup1.add(d_labStatusIniciado);
        d_labStatusIniciado.setText("Iniciado");
        d_labStatusIniciado.setEnabled(false);

        d_labStatus.setText("Status");
        d_labStatus.setEnabled(false);

        buttonGroup1.add(d_labStatusAguardando);
        d_labStatusAguardando.setText("Aguardando / Em espera");
        d_labStatusAguardando.setEnabled(false);
        d_labStatusAguardando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_labStatusAguardandoActionPerformed(evt);
            }
        });

        buttonGroup1.add(d_labStatusSaiu);
        d_labStatusSaiu.setText("Saiu para Entrega");
        d_labStatusSaiu.setEnabled(false);
        d_labStatusSaiu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_labStatusSaiuActionPerformed(evt);
            }
        });

        buttonGroup1.add(d_labStatusFinalizado);
        d_labStatusFinalizado.setText("Finalizado / Entregue");
        d_labStatusFinalizado.setEnabled(false);

        d_labRua.setText("Rua");
        d_labRua.setEnabled(false);

        d_labBairro.setText("Bairro");
        d_labBairro.setEnabled(false);

        d_labNumero.setText("Número");
        d_labNumero.setEnabled(false);

        d_tfdRua.setEnabled(false);
        d_tfdRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_tfdRuaActionPerformed(evt);
            }
        });

        d_labCidade.setText("Cidade");
        d_labCidade.setEnabled(false);

        d_labEntregador.setText("Entregador");
        d_labEntregador.setEnabled(false);

        d_tfdBairro.setEnabled(false);
        d_tfdBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_tfdBairroActionPerformed(evt);
            }
        });

        d_tfdNumero.setEnabled(false);
        d_tfdNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_tfdNumeroActionPerformed(evt);
            }
        });

        cmbEntregador.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEntregadorItemStateChanged(evt);
            }
        });

        d_tfdCidade.setText("Não informado");
        d_tfdCidade.setEnabled(false);
        d_tfdCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d_tfdCidadeMouseClicked(evt);
            }
        });
        d_tfdCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_tfdCidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(d_labCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(d_labTelefone, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(d_labRua, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(d_labBairro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(d_labNumero, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(d_labCidade, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(d_labEntregador, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(d_tfdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(39, 39, 39))
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(d_tfdRua)
                                            .addComponent(d_tfdBairro)))
                                    .addComponent(d_tffTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 4, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(d_tfdNumero, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbEntregador, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(d_tfdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(d_labStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(d_labStatusAguardando)
                            .addComponent(d_labStatusIniciado)
                            .addComponent(d_labStatusSaiu)
                            .addComponent(d_labStatusFinalizado))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_labTelefone)
                    .addComponent(d_tffTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_tfdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d_labCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_labRua)
                    .addComponent(d_tfdRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_labBairro)
                    .addComponent(d_tfdBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_labNumero)
                    .addComponent(d_tfdNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_labCidade)
                    .addComponent(d_tfdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_labEntregador)
                    .addComponent(cmbEntregador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_labStatusIniciado)
                    .addComponent(d_labStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(d_labStatusAguardando)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(d_labStatusSaiu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(d_labStatusFinalizado)
                .addGap(23, 23, 23))
        );

        tfdPrecoDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdPrecoDescontoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdPrecoSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdPrecoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfdPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19)
                            .addComponent(tfdPrecoSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdPrecoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        //Fazer para carregar ou cadastrar cliente
        this.pedidoController.salvar(this.pedido);
        if (checkDelivery.isSelected()) {
            this.pedido.setBairro(this.d_tfdBairro.getText());
            this.pedido.setLogradouro(this.d_tfdRua.getText());
            this.pedido.setEntregadorPessoaId(this.entregador);
            //this.pedido.setDataHora();
            //this.pedido.setDataHoraFechado(null);
            this.pedido.setMesa(null);
            this.pedido.setNumero(Integer.parseInt(d_tfdNumero.getText()));
            this.pedido.setPessoaId(this.cliente);
            this.pedido.setSituacao(true);
            this.pedido.setComplemento(this.cidade.getNome());
            //this.pedido.setTempoDeslocamento();
            //this.pedido.setValor();
            //Atualiza status do pedido
            atualizaGrupoBotoes();
            this.pedidoController.salvar(this.pedido);
        }

        jdPagamento telaFormaPagamento = new jdPagamento((Frame) this.getParent(), true, this.pedido);
        telaFormaPagamento.setLocationRelativeTo(telaFormaPagamento);
        telaFormaPagamento.setVisible(true);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        this.cli_ent_ped = 0;
        jdPesquisa pesquisa = new jdPesquisa((Frame) this.getParent(), this, true, this.pedidoController);
        pesquisa.setLocationRelativeTo(pesquisa);
        pesquisa.setVisible(true);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tfdCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdCaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdCaixaActionPerformed

    private void checkDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDeliveryActionPerformed

    }//GEN-LAST:event_checkDeliveryActionPerformed

    private void d_tfdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_tfdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d_tfdClienteActionPerformed

    private void d_labStatusAguardandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_labStatusAguardandoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d_labStatusAguardandoActionPerformed

    private void txtBuscatxtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscatxtBuscaActionPerformed

    }//GEN-LAST:event_txtBuscatxtBuscaActionPerformed

    private void txtBuscatxtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscatxtBuscaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscatxtBuscaKeyPressed

    private void txtBuscatxtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscatxtBuscaKeyReleased
        DefaultListModel listModel = new DefaultListModel();
        MensagemRetorno msg = this.produtoController.consultarPorCriterio(this.txtBusca.getText());
        for (Object percorrer : msg.getLista()) {
            Produto p = (Produto) percorrer;
            listModel.addElement(p.getDescricao());
        }
        this.listaProdutos.setModel(listModel);

        if (this.listaProdutos.getModel().getSize() > 0 && this.txtBusca.getText().length() > 0) {
            this.listaProdutos.setVisible(true);
            this.listaProdutos.setSelectedIndex(0);
        } else {
            this.listaProdutos.setVisible(false);
        }
    }//GEN-LAST:event_txtBuscatxtBuscaKeyReleased

    private void listaProdutosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaProdutosValueChanged
        MensagemRetorno msg = this.produtoController.consultarPorNome(this.listaProdutos.getSelectedValue());
        this.produto = (Produto) msg.getObjeto();
        if (this.listaProdutos.getSelectedValue() != null) {
            this.tfdPrecoUnitario.setText(this.produto.getValorVenda() + "");
        } else {
            this.tfdPrecoUnitario.setText("");
        }
    }//GEN-LAST:event_listaProdutosValueChanged

    private void tfdQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdQuantidadeActionPerformed

    private void tfdQuantidadePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tfdQuantidadePropertyChange

    }//GEN-LAST:event_tfdQuantidadePropertyChange

    private void tfdQuantidadeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfdQuantidadeCaretUpdate

    }//GEN-LAST:event_tfdQuantidadeCaretUpdate

    private void tfdQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdQuantidadeFocusLost
        quantidade();
    }//GEN-LAST:event_tfdQuantidadeFocusLost

    private void btnAdicionarbtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarbtnAdicionarActionPerformed
        //Cria o pedido caso ele não exista
        MensagemRetorno ok = new MensagemRetorno();
        if (!listaProdutos.isSelectionEmpty()) {

            if (this.pedido.getId() == null) {
                this.pedido.setDataHora(new Date());
                this.pedido.setValor(this.tfdPrecoTotal.getValue());
                this.pedido.setAtendenteId(Sessao.getUsuario());
                this.pedido.setCaixaId(Sessao.getUsuario()); //SAI DEPOIS, TIRA NOT NULL DO CAIXA

                ok = this.pedidoController.salvar(this.pedido);
            }
            //Preenche os campos e torna caixa ocupado
            if (ok.isSucesso()) {
                this.checkDelivery.setEnabled(true);
                this.checkComanda.setEnabled(true);
                this.tfdNumeroPedido.setText(this.pedido.getId() + "");
                this.painelCaixa.setBackground(Color.red);
                this.tfdCaixaLivre.setText("CAIXA OCUPADO");
            }
            //Preenche itempedido
            if (this.pedido.getId() != null) {
                this.itemPedido.setPedidoId(this.pedido);
                this.itemPedido.setProdutoId(this.produto);
                this.itemPedido.setDesconto(this.tfdPrecoDesconto.getValue());
                this.itemPedido.setQuantidade(Integer.parseInt(this.tfdQuantidade.getText()));
                this.itemPedido.setValor(this.tfdPrecoUnitario.getValue());

                //Compara se é para add o item ou atualizar
                MensagemRetorno msg = this.itemPedidoController.salvar(this.itemPedido);
                if (msg.isSucesso()) {
                    atualizarTabela();
                    this.limpaCamposItemPedido();
                } else {
                    System.out.println("ERROU! " + msg.getMensagem());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Problemas ao adicionar Item!\n"
                    + "Mensagem técnica: " + ok.getMensagem());
        }
    }//GEN-LAST:event_btnAdicionarbtnAdicionarActionPerformed

    private void btnRemoverItembtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverItembtnAdicionarActionPerformed
        if (tblPesquisar.getSelectedRowCount() == 1) {
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente remover este item?") == JOptionPane.YES_OPTION) {
                String valor = String.valueOf(tblPesquisar.getValueAt(tblPesquisar.getSelectedRow(), 0));
                MensagemRetorno msg = this.itemPedidoController.excluir(Integer.parseInt(valor));
                if (msg.isSucesso()) {
                    JOptionPane.showMessageDialog(null, "Item removido com sucesso!");
                    atualizarTabela();
                    //cuidado para nao salvar venda com 0 itens

                } else {
                    JOptionPane.showMessageDialog(null, "Problemas ao remover Item!\n"
                            + "Mensagem técnica: " + msg.getMensagem());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item para remover!");
        }
    }//GEN-LAST:event_btnRemoverItembtnAdicionarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtBuscaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscaFocusLost
        this.txtBusca.setText(this.listaProdutos.getSelectedValue());
        this.listaProdutos.setVisible(false);
    }//GEN-LAST:event_txtBuscaFocusLost

    private void txtBuscaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscaFocusGained
        this.listaProdutos.setVisible(true);
    }//GEN-LAST:event_txtBuscaFocusGained

    private void tfdClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdClienteFocusGained

    }//GEN-LAST:event_tfdClienteFocusGained

    private void tfdClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfdClienteMouseClicked
        this.cli_ent_ped = 1;
        jdPesquisa pesquisa = new jdPesquisa((Frame) this.getParent(), this, true, this.clienteController);
        pesquisa.setLocationRelativeTo(pesquisa);
        pesquisa.setVisible(true);

    }//GEN-LAST:event_tfdClienteMouseClicked

    private void tfdPrecoDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdPrecoDescontoFocusLost
        atualizarTotal();
    }//GEN-LAST:event_tfdPrecoDescontoFocusLost

    private void d_tfdRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_tfdRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d_tfdRuaActionPerformed

    private void d_tfdBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_tfdBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d_tfdBairroActionPerformed

    private void d_tfdNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_tfdNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d_tfdNumeroActionPerformed

    private void d_labStatusSaiuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_labStatusSaiuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d_labStatusSaiuActionPerformed

    private void d_tfdClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d_tfdClienteMouseClicked
        this.cli_ent_ped = 1;
        jdPesquisa pesquisa = new jdPesquisa((Frame) this.getParent(), this, true, this.clienteController);
        pesquisa.setLocationRelativeTo(pesquisa);
        pesquisa.setVisible(true);
    }//GEN-LAST:event_d_tfdClienteMouseClicked

    private void checkComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkComandaActionPerformed

    }//GEN-LAST:event_checkComandaActionPerformed

    private void comboNumComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNumComandaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboNumComandaActionPerformed

    private void checkComandaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkComandaStateChanged
        if (checkComanda.isSelected()) {
            checkDelivery.setSelected(false);
            checkDelivery.setEnabled(false);
            comboNumComanda.setEnabled(true);
            this.pedido.setMesa(Integer.parseInt(comboNumComanda.getSelectedItem().toString()));
        } else if (!checkComanda.isSelected()) {
            checkDelivery.setEnabled(true);
            comboNumComanda.setEnabled(false);
            this.pedido.setMesa(null);
        }
    }//GEN-LAST:event_checkComandaStateChanged

    private void checkDeliveryStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkDeliveryStateChanged
        if (checkDelivery.isSelected()) {
            this.d_labBairro.setEnabled(true);
            this.d_labRua.setEnabled(true);
            this.d_labNumero.setEnabled(true);
            this.d_labTelefone.setEnabled(true);
            this.d_labCliente.setEnabled(true);
            this.d_labCidade.setEnabled(true);
            this.d_labEntregador.setEnabled(true);
            this.d_labStatus.setEnabled(true);

            this.d_tfdBairro.setEnabled(true);
            this.d_tfdCliente.setEnabled(true);
            this.d_tffTelefone.setEnabled(true);
            this.d_tfdRua.setEnabled(true);
            this.d_tfdNumero.setEnabled(true);
            this.d_tfdCidade.setEnabled(true);
            this.cmbEntregador.setEnabled(true);

            this.d_labStatusAguardando.setEnabled(true);
            this.d_labStatusFinalizado.setEnabled(true);
            this.d_labStatusSaiu.setEnabled(true);
            this.d_labStatusIniciado.setEnabled(true);

            this.checkComanda.setEnabled(false);
            this.comboNumComanda.setEnabled(false);
            this.pedido.setMesa(null);
        } else if (!checkDelivery.isSelected()) {
            this.checkComanda.setEnabled(true);

            this.d_labBairro.setEnabled(false);
            this.d_labRua.setEnabled(false);
            this.d_labNumero.setEnabled(false);
            this.d_labTelefone.setEnabled(false);
            this.d_labCliente.setEnabled(false);
            this.d_labCidade.setEnabled(false);
            this.d_labEntregador.setEnabled(false);
            this.d_labStatus.setEnabled(false);

            this.d_tfdBairro.setEnabled(false);
            this.d_tfdCliente.setEnabled(false);
            this.d_tffTelefone.setEnabled(false);
            this.d_tfdRua.setEnabled(false);
            this.d_tfdNumero.setEnabled(false);
            this.d_tfdCidade.setEnabled(false);
            this.cmbEntregador.setEnabled(false);

            this.d_labStatusAguardando.setEnabled(false);
            this.d_labStatusFinalizado.setEnabled(false);
            this.d_labStatusSaiu.setEnabled(false);
            this.d_labStatusIniciado.setEnabled(false);
        }


    }//GEN-LAST:event_checkDeliveryStateChanged

    private void tfdAtendenteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfdAtendenteCaretUpdate
//        if(!tfdAtendente.equals(null)){
//            this.pedido.setAtendenteId(this.usuario);
//        }
    }//GEN-LAST:event_tfdAtendenteCaretUpdate

    private void cmbEntregadorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEntregadorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int cod = ((ComboItens) cmbEntregador.getSelectedItem()).getCodigo();
            if (cod != 0) {
                this.entregador = (Entregador) entregadorController.consultarPorID(cod).getObjeto();
            }
        }
    }//GEN-LAST:event_cmbEntregadorItemStateChanged

    private void d_tfdCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d_tfdCidadeMouseClicked
        this.cli_ent_ped = 3;
        jdPesquisa pesquisa = new jdPesquisa((Frame) this.getParent(), this, true, this.cidadeController);
        pesquisa.setLocationRelativeTo(pesquisa);
        pesquisa.setVisible(true);
    }//GEN-LAST:event_d_tfdCidadeMouseClicked

    private void d_tfdCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_tfdCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d_tfdCidadeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemoverItem;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkComanda;
    private javax.swing.JCheckBox checkDelivery;
    private javax.swing.JComboBox<String> cmbEntregador;
    private javax.swing.JComboBox<String> comboNumComanda;
    private javax.swing.JLabel d_labBairro;
    private javax.swing.JLabel d_labCidade;
    private javax.swing.JLabel d_labCliente;
    private javax.swing.JLabel d_labEntregador;
    private javax.swing.JLabel d_labNumero;
    private javax.swing.JLabel d_labRua;
    private javax.swing.JLabel d_labStatus;
    private javax.swing.JRadioButton d_labStatusAguardando;
    private javax.swing.JRadioButton d_labStatusFinalizado;
    private javax.swing.JRadioButton d_labStatusIniciado;
    private javax.swing.JRadioButton d_labStatusSaiu;
    private javax.swing.JLabel d_labTelefone;
    private javax.swing.JTextField d_tfdBairro;
    private javax.swing.JTextField d_tfdCidade;
    private javax.swing.JTextField d_tfdCliente;
    private javax.swing.JTextField d_tfdNumero;
    private javax.swing.JTextField d_tfdRua;
    private javax.swing.JFormattedTextField d_tffTelefone;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labComandaNumero;
    private javax.swing.JList<String> listaProdutos;
    private javax.swing.JPanel painelCaixa;
    private javax.swing.JTable tblPesquisar;
    private javax.swing.JTextField tfdAtendente;
    private javax.swing.JTextField tfdCaixa;
    private javax.swing.JLabel tfdCaixaLivre;
    private javax.swing.JTextField tfdCliente;
    private javax.swing.JLabel tfdNumeroComanda;
    private javax.swing.JLabel tfdNumeroPedido;
    private javax.swing.JTextField tfdObservacao;
    private apoio.MoedaFormatada tfdPrecoDesconto;
    private apoio.MoedaFormatada tfdPrecoSubTotal;
    private apoio.MoedaFormatada tfdPrecoTotal;
    private apoio.MoedaFormatada tfdPrecoUnitario;
    private javax.swing.JTextField tfdQuantidade;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables

    @Override
    public void carregar(int codigo) {
        tfdAtendente.requestFocus();
        if (this.cli_ent_ped == 0) {
            MensagemRetorno retorno = this.pedidoController.consultarPorID(codigo);
            this.pedido = (Pedido) retorno.getObjeto();
            atualizarTabela();
        }
        if (this.cli_ent_ped == 1) {
            MensagemRetorno retorno = this.clienteController.consultarPorID(codigo);
            this.cliente = (Pessoa) retorno.getObjeto();
            if (this.cliente.getNome() != null) {
                this.tfdCliente.setText(this.cliente.getNome() + "");
                this.d_tfdCliente.setText(this.cliente.getNome() + "");
            }

        }
        if (this.cli_ent_ped == 2) {
            MensagemRetorno retorno = this.entregadorController.consultarPorID(codigo);
            this.cliente = (Pessoa) retorno.getObjeto();
            if (this.cliente.getNome() != null) {
                this.d_labEntregador.setText(this.cliente.getNome() + "");
            }
        }
        
        if (this.cli_ent_ped == 3) {
            MensagemRetorno retorno = this.cidadeController.pesquisarPorId(codigo);
            this.cidade = (Cidade) retorno.getObjeto();
            if (this.cidade.getNome() != null) {
                this.d_tfdCidade.setText(this.cidade.getNome() + "");
            }
        }

    }

    @Override
    public void limparCampos(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void limpaCamposItemPedido() {
        this.txtBusca.setText("");
        this.tfdQuantidade.setText("1");
        this.listaProdutos.removeAll();
        this.itemPedido = new ItemPedido();
    }
}
