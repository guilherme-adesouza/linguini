package view;

import controller.CampoOrdenavel;
import controller.Controller;
import controller.PedidoController;
import java.text.SimpleDateFormat;
import java.util.List;
import model.Pedido;

/**
 * @author vitorolavo
 */
public class jdPedidosAberto extends javax.swing.JDialog {

    private Pedido pedido;
    private PedidoController pedidoController;
    private Controller controller;
    private String in;
    private String fi;
    private SimpleDateFormat sdf1;
    private SimpleDateFormat sdf2;

    public static String nomeTela = "telaPedidosAbertos";

    public jdPedidosAberto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.btnPesquisar.setName("btnPesquisar");

        this.pedido = new Pedido();
        this.pedidoController = new PedidoController();
        this.sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        this.sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        this.in = "11/12/2018";
        this.fi = "11/12/2018";
        this.pedidoController.popularTabelaAbertos(this.tblPesquisar, "", "todos", this.in, this.fi, "");

        this.cmbFiltros.addItem("ID");
        this.cmbFiltros.addItem("Cliente");
        this.cmbFiltros.addItem("Mesa");
        this.cmbFiltros.addItem("Status");
        this.cmbFiltros.addItem("Valor");
        this.cmbFiltros.addItem("Situacao");
        this.cmbFiltros.setSelectedIndex(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        cmbFiltros = new javax.swing.JComboBox<>();
        btnPesquisar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesquisar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rbDelivery = new javax.swing.JRadioButton();
        rbComandas = new javax.swing.JRadioButton();
        rbAmbos = new javax.swing.JRadioButton();
        checkMostrarPagos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedidos");

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnFechar.setBackground(new java.awt.Color(51, 102, 255));
        btnFechar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnFechar.setForeground(new java.awt.Color(254, 254, 254));
        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-importar-48.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.setContentAreaFilled(false);
        btnFechar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFechar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 839, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnFechar)
                .addGap(0, 0, 0))
        );

        cmbFiltros.setToolTipText("");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblPesquisar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPesquisar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setText("Filtrar");

        jLabel2.setText("Ordenar por");

        buttonGroup1.add(rbDelivery);
        rbDelivery.setText("Delivery");

        buttonGroup1.add(rbComandas);
        rbComandas.setText("Comandas");

        buttonGroup1.add(rbAmbos);
        rbAmbos.setText("Todos");

        checkMostrarPagos.setText("Mostrar somente pagos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(rbDelivery)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbComandas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbAmbos)
                        .addGap(78, 78, 78)
                        .addComponent(checkMostrarPagos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(rbDelivery)
                    .addComponent(rbComandas)
                    .addComponent(rbAmbos)
                    .addComponent(checkMostrarPagos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        
        String pago = "npago";
        if (checkMostrarPagos.isSelected()) {
            pago = "pago";
        } else {
            pago = "todos";
        }
        String aux = "";
        if (rbAmbos.isSelected()) {
            this.pedidoController.popularTabelaAbertos(this.tblPesquisar, "", pago, in, fi, "");
        }
        if (rbDelivery.isSelected()) {
            this.pedidoController.popularTabelaAbertos(this.tblPesquisar, "Delivery", pago, in, fi, "");
            aux = "Delivery";
        }
        if (rbComandas.isSelected()) {
            this.pedidoController.popularTabelaAbertos(this.tblPesquisar, "mesa", pago, in, fi, "");
            aux = "mesa";
        }
        if (cmbFiltros.getSelectedIndex() == 0) {
            this.pedidoController.popularTabelaAbertos(this.tblPesquisar, aux, pago, in, fi, "ID");
        }
        if (cmbFiltros.getSelectedIndex() == 1) {
            this.pedidoController.popularTabelaAbertos(this.tblPesquisar, aux, pago, in, fi, "pessoa_id");
        }
        if (cmbFiltros.getSelectedIndex() == 2) {
            this.pedidoController.popularTabelaAbertos(this.tblPesquisar, aux, pago, in, fi, "mesa");
        }
        if (cmbFiltros.getSelectedIndex() == 3) {
            this.pedidoController.popularTabelaAbertos(this.tblPesquisar, aux, pago, in, fi, "status");
        }
        if (cmbFiltros.getSelectedIndex() == 4) {
            this.pedidoController.popularTabelaAbertos(this.tblPesquisar, aux, pago, in, fi, "valor");
        }
        if (cmbFiltros.getSelectedIndex() == 5) {
            this.pedidoController.popularTabelaAbertos(this.tblPesquisar, aux, pago, in, fi, "Situacao");
        }

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkMostrarPagos;
    private javax.swing.JComboBox<String> cmbFiltros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbAmbos;
    private javax.swing.JRadioButton rbComandas;
    private javax.swing.JRadioButton rbDelivery;
    private javax.swing.JTable tblPesquisar;
    // End of variables declaration//GEN-END:variables
}
