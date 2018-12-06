package view;

import utils.view.ComboItens;
import utils.view.Pesquisavel;
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
import javax.swing.JTextField;
import model.Cidade;
import model.Entregador;
import model.ItemPedido;
import model.Pedido;
import model.Pessoa;
import model.Produto;
import model.Usuario;
import utils.view.Calendario;
import utils.view.ControlarEntradaNumero;
import utils.view.Formatacao;
import utils.controller.Sessao;
import utils.controller.Validacao;

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

    //Carregar cidade no delivery, carregar telefone no delivery
    //Status : P = PENDENDE / C = COMANDA / O = PAGODELIVERY / U = PAGONORMAL
    //I = INICIDO DELIVERY / A = AGUARDADNO DELIVERY
    //S = SAIU PARA ENTREGAR DELIVERY / F = FINALIZADO DELIVERY
    private int cli_ent_ped;//cli = 1 / ped = 0 / ent = 2 / cidade = 3 / deli = 4

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
            this.pedido.setValor(this.tfdPrecoTotal.getValue());
        } else {
            this.tfdPrecoTotal.setValue(this.tfdPrecoSubTotal.getValue());
            this.pedido.setValor(this.tfdPrecoTotal.getValue());
        }
    }

    private void atualizaGrupoBotoes() {
        if (d_labStatusIniciado.isSelected()) {
            this.pedido.setStatus('I');
        }
        if (d_labStatusAguardando.isSelected()) {
            this.pedido.setStatus('A');
        }
        if (d_labStatusSaiu.isSelected()) {
            this.pedido.setStatus('S');
        }
        if (d_labStatusFinalizado.isSelected()) {
            this.pedido.setStatus('F');
        }
        System.out.println("Grupo " + this.pedido.getStatus());
    }

    private void carregarPedidoOk() {
        this.btnSalvar.setEnabled(true);
        this.tfdCliente.setEnabled(true);
        comboNumComanda.setEnabled(true);
        comboNumComanda.setEditable(true);
        //this.checkDelivery.setEnabled(true);
        //this.checkComanda.setEnabled(true);
        this.tfdNumeroPedido.setText(this.pedido.getId() + "");
        this.painelCaixa.setBackground(Color.red);
        this.tfdCaixaLivre.setText("CAIXA OCUPADO");
    }

    /**
     * Creates new form jdPedido
     */
    public jdPedido(java.awt.Frame parent, boolean modal, boolean Delivery) {
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
        this.entregadorController.popularCombo(this.cmbEntregador);

        Formatacao.formatarTelefone(this.d_tffTelefone);
        d_tfdNumero.setDocument(new ControlarEntradaNumero(5));

        if (!Delivery) {
            this.jPanel5.setVisible(false);
        } else {
            this.jPanel5.setVisible(true);
            this.checkDelivery.setSelected(true);
        }

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
        btn_removerCliente = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
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
        tfdPrecoUnitario = new utils.view.MoedaFormatada();
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
        d_btnAdicionar = new javax.swing.JButton();
        tfdPrecoSubTotal = new utils.view.MoedaFormatada();
        tfdPrecoDesconto = new utils.view.MoedaFormatada();
        tfdPrecoTotal = new utils.view.MoedaFormatada();

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

        tfdObservacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdObservacaoFocusLost(evt);
            }
        });

        tfdAtendente.setEditable(false);
        tfdAtendente.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfdAtendenteCaretUpdate(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cliente");

        tfdCliente.setEditable(false);
        tfdCliente.setEnabled(false);
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
        comboNumComanda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboNumComandaItemStateChanged(evt);
            }
        });
        comboNumComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNumComandaActionPerformed(evt);
            }
        });

        btn_removerCliente.setText("-");
        btn_removerCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removerClienteActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tornar Comanda");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Mesa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                            .addComponent(tfdObservacao))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboNumComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(checkDelivery)
                                    .addComponent(jLabel10)))
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_removerCliente))
                            .addComponent(jLabel14))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_removerCliente))
                .addGap(52, 52, 52)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboNumComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(33, 33, 33)
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
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscaFocusLost(evt);
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
                                .addGap(18, 18, 18)
                                .addComponent(tfdPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        btnSalvar.setText("Salvar");
        btnSalvar.setBorderPainted(false);
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.setEnabled(false);
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

        d_labCliente.setText("Telefone*");
        d_labCliente.setEnabled(false);

        d_tfdCliente.setEditable(false);
        d_tfdCliente.setText("Não informado");
        d_tfdCliente.setEnabled(false);
        d_tfdCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                d_tfdClienteFocusLost(evt);
            }
        });
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

        d_labTelefone.setText("Cliente*");
        d_labTelefone.setEnabled(false);

        buttonGroup1.add(d_labStatusIniciado);
        d_labStatusIniciado.setText("Iniciado");
        d_labStatusIniciado.setEnabled(false);
        d_labStatusIniciado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                d_labStatusIniciadoItemStateChanged(evt);
            }
        });
        d_labStatusIniciado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                d_labStatusIniciadoStateChanged(evt);
            }
        });

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

        d_labRua.setText("Rua*");
        d_labRua.setEnabled(false);

        d_labBairro.setText("Bairro*");
        d_labBairro.setEnabled(false);

        d_labNumero.setText("Número*");
        d_labNumero.setEnabled(false);

        d_tfdRua.setEnabled(false);
        d_tfdRua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                d_tfdRuaFocusLost(evt);
            }
        });
        d_tfdRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_tfdRuaActionPerformed(evt);
            }
        });

        d_labCidade.setText("Cidade*");
        d_labCidade.setEnabled(false);

        d_labEntregador.setText("Entregador*");
        d_labEntregador.setEnabled(false);

        d_tfdBairro.setEnabled(false);
        d_tfdBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                d_tfdBairroFocusLost(evt);
            }
        });
        d_tfdBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_tfdBairroActionPerformed(evt);
            }
        });

        d_tfdNumero.setEnabled(false);
        d_tfdNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                d_tfdNumeroFocusLost(evt);
            }
        });
        d_tfdNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_tfdNumeroActionPerformed(evt);
            }
        });

        d_tffTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                d_tffTelefoneFocusLost(evt);
            }
        });

        cmbEntregador.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEntregadorItemStateChanged(evt);
            }
        });

        d_tfdCidade.setEditable(false);
        d_tfdCidade.setText("Não informado");
        d_tfdCidade.setEnabled(false);
        d_tfdCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                d_tfdCidadeFocusLost(evt);
            }
        });
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

        d_btnAdicionar.setText("+");
        d_btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_btnAdicionarActionPerformed(evt);
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
                                    .addComponent(d_tfdNumero, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbEntregador, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(d_tfdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(d_tfdRua, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                        .addComponent(d_tfdBairro))
                                    .addComponent(d_tffTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(d_tfdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(d_btnAdicionar)))
                                .addGap(0, 0, Short.MAX_VALUE))))
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
                    .addComponent(d_tfdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d_btnAdicionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d_labCliente)
                    .addComponent(d_tffTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdPrecoSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdPrecoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfdPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        if (this.pedido.getId() == null) {
            this.limparCampos(0);
        } else {
            this.limparCampos(this.pedido.getId().intValue());
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        this.pedidoController.salvar(this.pedido);
        if (checkDelivery.isSelected() && Validacao.camposPreenchidos(camposObrigatorios()) && validarClienteDelivery()
                && validarCidadeDelivery() && validarTelefoneDelivery()) {
            this.pedido.setBairro(this.d_tfdBairro.getText());
            this.pedido.setLogradouro(this.d_tfdRua.getText());
            this.pedido.setNumero(Integer.parseInt(this.d_tfdNumero.getText()));
            this.pedido.setEntregadorPessoaId(this.entregador);
            //this.pedido.setTempoDeslocamento(Integer.parseInt(Formatacao.removerFormatacao(this.d_tffTelefone.getText())));
            //this.pedido.setDataHora();
            //this.pedido.setDataHoraFechado(null);
            this.pedido.setMesa(null);
            this.pedido.setPessoaId(this.cliente);
            this.pedido.setSituacao(true);
            this.pedido.setComplemento(this.d_tfdCidade.getText());

            //Atualiza/Salva status do pedido
            atualizaGrupoBotoes();
            MensagemRetorno ms = this.pedidoController.salvar(this.pedido);
            if (ms.isSucesso() && !d_labStatusFinalizado.isSelected()) {
                this.cliente.setTelefone1(this.d_tffTelefone.getText());
                this.cliente.setCidadeId(this.cidade);
                this.clienteController.salvar(this.cliente);
                JOptionPane.showMessageDialog(this, "Esta venda ficará disponível em Delivery!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else if (ms.isSucesso() && d_labStatusFinalizado.isSelected()) {
                jdPagamento telaFormaPagamento = new jdPagamento((Frame) this.getParent(), true, this.pedido);
                telaFormaPagamento.setLocationRelativeTo(telaFormaPagamento);
                telaFormaPagamento.setVisible(true);
                if (telaFormaPagamento.retornoPagamento()) {
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao salvar delivery", "Aviso", JOptionPane.INFORMATION_MESSAGE);

            }

//        } else {
//            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        if (!this.checkDelivery.isSelected()) {

            jdPagamento telaFormaPagamento = new jdPagamento((Frame) this.getParent(), true, this.pedido);
            telaFormaPagamento.setLocationRelativeTo(telaFormaPagamento);
            telaFormaPagamento.setVisible(true);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        this.cli_ent_ped = 0;
        this.comboNumComanda.setEnabled(false);
        this.comboNumComanda.removeAllItems();
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
                this.pedido.setStatus('P');
                this.pedido.setAtendenteId(Sessao.getUsuario());
                this.pedido.setCaixaId(Sessao.getUsuario()); //SAI DEPOIS, TIRA NOT NULL DO CAIXA

                ok = this.pedidoController.salvar(this.pedido);
            }
            //Preenche os campos e torna caixa ocupado
            if (ok.isSucesso()) {
                this.checkDelivery.setEnabled(true);
                carregarPedidoOk();
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
                    + "Mensagem técnica: " + "Nenhum item selecionado");
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
        this.cli_ent_ped = 4;
        jdPesquisa pesquisa = new jdPesquisa((Frame) this.getParent(), this, true, this.clienteController);
        pesquisa.setLocationRelativeTo(pesquisa);
        pesquisa.setVisible(true);
    }//GEN-LAST:event_d_tfdClienteMouseClicked

    private void comboNumComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNumComandaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboNumComandaActionPerformed

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
            this.d_labStatusIniciado.setSelected(true);
            this.jPanel5.setVisible(true);

            this.comboNumComanda.setEnabled(false);
            this.pedido.setMesa(null);
//            if (!d_labStatusFinalizado.isSelected()) {
//                this.btnSalvar.setEnabled(false);
//            }
        } else if (!checkDelivery.isSelected()) {
            this.jPanel5.setVisible(false);
            this.comboNumComanda.setEnabled(true);

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
                //this.entregador.(Entregador) entregadorController.consultarPorID(cod).getObjeto();
                this.cliente.setEntregador((Entregador) entregadorController.consultarPorID(cod).getObjeto());
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

    private void d_btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_btnAdicionarActionPerformed
        jdPessoa telaPessoa = new jdPessoa((Frame) this.getParent(), true);
        telaPessoa.setLocationRelativeTo(telaPessoa);
        telaPessoa.setVisible(true);
    }//GEN-LAST:event_d_btnAdicionarActionPerformed

    private void btn_removerClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerClienteActionPerformed
        this.tfdCliente.setText("Não Informado");
        this.pedido.setPessoaId(null);
    }//GEN-LAST:event_btn_removerClienteActionPerformed

    private void comboNumComandaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboNumComandaItemStateChanged
        //if (comboNumComanda.getSelectedIndex() == 0) {
        //this.pedido.setMesa(null);
        //} else 
        if (this.comboNumComanda.isEnabled()) {
            this.pedido.setMesa(Integer.parseInt(comboNumComanda.getSelectedItem().toString()));
            this.pedido.setStatus('C');
            this.pedido.setSituacao(true);
            this.pedidoController.salvar(this.pedido);
            JOptionPane.showMessageDialog(null, "Esta venda ficará disponível em Comandas!");
            dispose();

        }
    }//GEN-LAST:event_comboNumComandaItemStateChanged

    private void tfdPrecoTotalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfdPrecoTotalCaretUpdate

    }//GEN-LAST:event_tfdPrecoTotalCaretUpdate

    private void tfdPrecoTotalCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tfdPrecoTotalCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdPrecoTotalCaretPositionChanged

    private void tfdObservacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdObservacaoFocusLost
        this.pedido.setObservacao(this.tfdObservacao.getText());
    }//GEN-LAST:event_tfdObservacaoFocusLost

    private void d_labStatusIniciadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_d_labStatusIniciadoStateChanged

    }//GEN-LAST:event_d_labStatusIniciadoStateChanged

    private void d_labStatusIniciadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_d_labStatusIniciadoItemStateChanged

    }//GEN-LAST:event_d_labStatusIniciadoItemStateChanged

    private void d_tfdClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_d_tfdClienteFocusLost

    }//GEN-LAST:event_d_tfdClienteFocusLost

    private void d_tffTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_d_tffTelefoneFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_d_tffTelefoneFocusLost

    private void d_tfdRuaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_d_tfdRuaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_d_tfdRuaFocusLost

    private void d_tfdBairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_d_tfdBairroFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_d_tfdBairroFocusLost

    private void d_tfdNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_d_tfdNumeroFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_d_tfdNumeroFocusLost

    private void d_tfdCidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_d_tfdCidadeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_d_tfdCidadeFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemoverItem;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btn_removerCliente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkDelivery;
    private javax.swing.JComboBox<String> cmbEntregador;
    private javax.swing.JComboBox<String> comboNumComanda;
    private javax.swing.JButton d_btnAdicionar;
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private utils.view.MoedaFormatada tfdPrecoDesconto;
    private utils.view.MoedaFormatada tfdPrecoSubTotal;
    private utils.view.MoedaFormatada tfdPrecoTotal;
    private utils.view.MoedaFormatada tfdPrecoUnitario;
    private javax.swing.JTextField tfdQuantidade;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables

    public boolean validarClienteDelivery() {
        if (d_tfdCliente.getText().equals("Não informado") || this.cliente == null || this.cliente.equals(null)) {
            //JOptionPane.showMessageDialog(null, "Favor preencher todos campos obrigatórios.");
            d_tfdCliente.setBackground(Color.yellow);
            return false;
        } else {
            return true;
        }
    }

    public boolean validarCidadeDelivery() {
        if (d_tfdCidade.getText().equals("Não informado") || this.cidade == null || this.cidade.equals(null)) {
            d_tfdCidade.setBackground(Color.yellow);
            return false;
        } else {
            return true;
        }
    }

    public boolean validarTelefoneDelivery() {
        String cont = Formatacao.removerFormatacao(d_tffTelefone.getText());
        String replace = cont.replace(' ', 'a');
        System.out.println(cont + " aaaataa" + cont.length() + " " + replace);
        if (replace.charAt(0) != 'a') {
            return true;
        } else {
            d_tffTelefone.setBackground(Color.yellow);
            return false;
        }
    }

    private JTextField[] camposObrigatorios() {
        validarClienteDelivery();
        validarCidadeDelivery();
        validarTelefoneDelivery();
        JTextField[] campos = {this.d_tfdBairro, this.d_tfdNumero, this.d_tfdRua};
        return campos;
    }

    @Override
    public void carregar(int codigo) {
        //carrega pedido
        if (this.cli_ent_ped == 0) {
            MensagemRetorno retorno = this.pedidoController.consultarPorID(codigo);
            this.pedido = (Pedido) retorno.getObjeto();
            System.out.println(this.pedido.getStatus() + " STATUS RECEBIDO 1");
            this.tfdNumeroPedido.setVisible(true);
            this.tfdNumeroPedido.setText(this.pedido.getId() + "");
            if (this.pedido.getAtendenteId() != null) {
                this.tfdAtendente.setText(this.pedido.getAtendenteId().getNome() + "");
            }
            if (this.pedido.getCaixaId() != null) {
                this.tfdCaixa.setText(this.pedido.getCaixaId().getNome() + "");
            }
            if (this.pedido.getPessoaId() != null) {
                this.cliente = this.pedido.getPessoaId();
                this.tfdCliente.setText(this.pedido.getPessoaId().getNome() + "");
            } else {
                this.tfdCliente.setText("");
                this.cliente = null;
            }

            this.comboNumComanda.removeAllItems();
            this.pedidoController.popularCombo(this.comboNumComanda);
            this.tfdNumeroComanda.setVisible(true);
            if (this.pedido.getMesa() != null) {
                this.tfdNumeroComanda.setText(this.pedido.getMesa() + "");
                this.comboNumComanda.addItem(this.pedido.getMesa() + "");
                this.comboNumComanda.setEnabled(true);
                this.checkDelivery.setEnabled(false);
            } else {
                this.tfdNumeroComanda.setText("");
                this.comboNumComanda.setEnabled(true);
                this.checkDelivery.setEnabled(true);
            }
            //se a venda resgatada for delivery
            if (this.pedido.getStatus() == 'O' || this.pedido.getStatus() == 'I' || this.pedido.getStatus() == 'A' || this.pedido.getStatus() == 'S' || this.pedido.getStatus() == 'F') {
                this.d_tfdCliente.setText(this.pedido.getPessoaId().getNome() + "");
                this.d_tffTelefone.setText(this.pedido.getPessoaId().getTelefone1() + "");
                if (this.pedido.getPessoaId().getCidadeId() != null) {
                    this.d_tfdCidade.setText(this.pedido.getPessoaId().getCidadeId().getNome() + "");
                    this.cidade = this.pedido.getPessoaId().getCidadeId();
                }
                this.d_tfdBairro.setText(this.pedido.getBairro() + "");
                this.d_tfdRua.setText(this.pedido.getLogradouro() + "");
                this.d_tfdNumero.setText(this.pedido.getNumero() + "");
//                
                this.checkDelivery.setSelected(true);
                this.jPanel5.setVisible(true);
                this.comboNumComanda.setEnabled(false);
                System.out.println(this.pedido.getStatus() + " STATUS RECEBIDO 2");
                if (this.pedido.getStatus() == 'I') {
                    this.d_labStatusIniciado.setSelected(true);
                }
                if (this.pedido.getStatus() == 'A') {
                    this.d_labStatusAguardando.setSelected(true);
                }
                if (this.pedido.getStatus() == 'S') {
                    this.d_labStatusSaiu.setSelected(true);
                }
                if (this.pedido.getStatus() == 'F' || this.pedido.getStatus() == 'O') {
                    this.d_labStatusFinalizado.setSelected(true);
                }
            } else {
                this.jPanel5.setVisible(false);
            }

            this.tfdObservacao.setText(this.pedido.getObservacao());
            atualizarTabela();
            carregarPedidoOk();
        }
        //carrega pessoa delivery
        if (this.cli_ent_ped == 4) {
            MensagemRetorno retorno = this.clienteController.consultarPorID(codigo);
            this.cliente = (Pessoa) retorno.getObjeto();
            if (this.cliente.getNome() != null) {
                this.pedido.setPessoaId(this.cliente);
                this.d_tfdCliente.setText(this.cliente.getNome() + "");
                this.d_tfdBairro.setText(this.cliente.getBairro() + "");
                this.d_tfdRua.setText(this.cliente.getLogradouro() + "");
                this.d_tfdNumero.setText(this.cliente.getNumero() + "");
                this.d_tffTelefone.setText(this.cliente.getTelefone1() + "");
                if (this.cliente.getCidadeId() != null) {
                    this.d_tfdCidade.setText(this.cliente.getCidadeId().getNome() + "");
                    this.cidade = this.cliente.getCidadeId();
                }
            }

        }
        if (this.cli_ent_ped == 1) {
            MensagemRetorno retorno = this.clienteController.consultarPorID(codigo);
            this.cliente = (Pessoa) retorno.getObjeto();
            if (this.cliente.getNome() != null) {
                this.tfdCliente.setText(this.cliente.getNome() + "");
                this.pedido.setPessoaId(this.cliente);
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
        if (this.pedido.getId() == null || this.pedido.getId() == codigo) {
            //limpar campos da tela
            this.pedido = new Pedido();
            this.painelCaixa.setBackground(Color.GREEN);
            this.tfdCaixaLivre.setText("CAIXA LIVRE");
            this.itemPedidoController.popularTabelaItens(this.tblPesquisar, 0);
            this.tfdCliente.setText("");
            this.tfdNumeroComanda.setText("");
            this.tfdNumeroPedido.setText("");
            this.tfdObservacao.setText("");
            this.tfdPrecoDesconto.setText("");
            this.tfdPrecoSubTotal.setText("");
            this.tfdPrecoTotal.setText("");
            this.tfdPrecoUnitario.setText("");
            this.tfdQuantidade.setText("1");
            this.checkDelivery.setSelected(false);
            this.checkDelivery.setEnabled(false);
            this.btnPesquisar.setEnabled(true);
            this.comboNumComanda.setEnabled(false);
            this.jPanel5.setVisible(false);
            this.btnSalvar.setEnabled(false);
        }
    }

    public void limpaCamposItemPedido() {
        this.txtBusca.setText("");
        this.tfdQuantidade.setText("1");
        this.listaProdutos.removeAll();
        this.itemPedido = new ItemPedido();
    }
}
