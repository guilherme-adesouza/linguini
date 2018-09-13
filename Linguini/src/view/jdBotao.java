/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BotaoController;
import controller.TelaController;
import dao.MensagemRetorno;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Botoes;
import model.Telas;
import utils.Validacao;

/**
 *
 * @author vitorolavo
 */
public class jdBotao extends javax.swing.JDialog implements Pesquisavel{

    private BotaoController botaoController;
    private TelaController telaController;
    private Botoes botao;

    /**
     * Creates new form jdTelefone
     */
    public jdBotao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.botao = new Botoes();
        this.botaoController = new BotaoController();
        this.telaController = new TelaController();
        
        this.telaController.popularCombo(this.cmbTela);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        tfdCodigo = new javax.swing.JTextField();
        tfdClassificacao = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbTela = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Classificações");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCodigo.setText("Código");

        tfdCodigo.setEnabled(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${cidadeControl.cidadeDigitado.id}"), tfdCodigo, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        tfdCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdCodigoActionPerformed(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${cidadeControl.cidadeDigitado.nome}"), tfdClassificacao, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        tfdClassificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdClassificacaoActionPerformed(evt);
            }
        });

        lblNome.setText("Botão *");

        jLabel1.setText("Tela *");

        cmbTela.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTelaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigo)
                            .addComponent(lblNome)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTela, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(tfdClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNovo.setBackground(new java.awt.Color(51, 102, 255));
        btnNovo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(254, 254, 254));
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
        btnSalvar.setForeground(new java.awt.Color(254, 254, 254));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-salvar-48.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorderPainted(false);
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(51, 102, 255));
        btnExcluir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(254, 254, 254));
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

        btnFechar.setBackground(new java.awt.Color(51, 102, 255));
        btnFechar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnFechar.setForeground(new java.awt.Color(254, 254, 254));
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
        btnPesquisar.setForeground(new java.awt.Color(254, 254, 254));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnFechar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfdCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdCodigoActionPerformed

    private void tfdClassificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdClassificacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdClassificacaoActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.limparCampos(Integer.parseInt(this.botao.getId().toString()));
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(Validacao.camposPreenchidos(this.getCamposObrigatorios())){
            this.botao.setNome(this.tfdClassificacao.getText());
            MensagemRetorno msg = this.botaoController.salvar(this.botao);
            if(msg.isSucesso()){
                JOptionPane.showMessageDialog(this, msg.getMensagem());
            }
            else {
                JOptionPane.showMessageDialog(this, msg.getMensagem(), "ERRO!", JOptionPane.WARNING_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(this,"Preencha todos os campos obrigatórios" ,"Aviso",JOptionPane.INFORMATION_MESSAGE);        
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este botão", "Excluir Botão", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            MensagemRetorno msg = this.botaoController.excluir(this.botao);
            if(msg.isSucesso()){
                JOptionPane.showMessageDialog(this, msg.getMensagem());
            }
            else {
                JOptionPane.showMessageDialog(this, msg.getMensagem(), "ERRO!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        jdPesquisa telaPesquisa = new jdPesquisa(new Frame(), this, true, this.botaoController);
        telaPesquisa.setVisible(true);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void cmbTelaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTelaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int cod = ((ComboItens) cmbTela.getSelectedItem()).getCodigo();
            if (cod != 0) {
                this.botao.setTelasId((Telas) this.telaController.consultarPorID(cod).getObjeto());
            }
        }
    }//GEN-LAST:event_cmbTelaItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbTela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField tfdClassificacao;
    private javax.swing.JTextField tfdCodigo;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public void carregar(int codigo) {
        MensagemRetorno msg = this.botaoController.consultarPorID(codigo);
        this.botao = (Botoes) msg.getObjeto();
        this.tfdCodigo.setText(this.botao.getId()+"");
        this.tfdClassificacao.setText(this.botao.getNome());
    }

    @Override
    public void limparCampos(int codigo) {
        if(this.botao.getId() == codigo){
            this.botao = new Botoes();
            this.tfdCodigo.setText(this.botao.getId()+"");
            this.tfdClassificacao.setText(this.botao.getNome());
        }
    }

    private JTextField[] getCamposObrigatorios() {
        JTextField[] campos = {this.tfdClassificacao};
        return campos;
    }
}
