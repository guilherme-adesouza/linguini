/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import utils.Giba;

/**
 * @author VitinNote
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Hello
     */
    public Home() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.jMenuBar1.requestFocus();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnCaixa = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnDelivery = new javax.swing.JButton();
        btnPedido = new javax.swing.JButton();
        btnComandas = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnHistorico = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiPessoas = new javax.swing.JMenuItem();
        jmiTelefones = new javax.swing.JMenuItem();
        menuFornecedor = new javax.swing.JMenuItem();
        jmiConfiguracoes = new javax.swing.JMenuItem();
        jmiUsuario = new javax.swing.JMenuItem();
        jmiGrupo = new javax.swing.JMenuItem();
        jmiTela = new javax.swing.JMenuItem();
        jmiBotao = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Linguini");

        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 800));

        btnCaixa.setBackground(new java.awt.Color(153, 153, 153));
        btnCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-fluxo-de-caixa-48.png"))); // NOI18N
        btnCaixa.setText("Caixa");
        btnCaixa.setBorderPainted(false);
        btnCaixa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCaixa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCaixaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCaixaMouseExited(evt);
            }
        });
        btnCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaixaActionPerformed(evt);
            }
        });

        btnProduto.setBackground(new java.awt.Color(153, 153, 153));
        btnProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-lancheira-48.png"))); // NOI18N
        btnProduto.setText("Produtos");
        btnProduto.setBorderPainted(false);
        btnProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProdutoMouseExited(evt);
            }
        });
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        btnDelivery.setBackground(new java.awt.Color(153, 153, 153));
        btnDelivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-entrega-de-comida-48.png"))); // NOI18N
        btnDelivery.setText("Novo Delivery");
        btnDelivery.setBorderPainted(false);
        btnDelivery.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelivery.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelivery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeliveryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeliveryMouseExited(evt);
            }
        });
        btnDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveryActionPerformed(evt);
            }
        });

        btnPedido.setBackground(new java.awt.Color(153, 153, 153));
        btnPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-comprar-48.png"))); // NOI18N
        btnPedido.setText("Novo Pedido");
        btnPedido.setBorderPainted(false);
        btnPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPedido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPedidoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPedidoMouseExited(evt);
            }
        });
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });

        btnComandas.setBackground(new java.awt.Color(153, 153, 153));
        btnComandas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-lista-de-verificação-48.png"))); // NOI18N
        btnComandas.setText("Comandas");
        btnComandas.setBorderPainted(false);
        btnComandas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnComandas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnComandas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnComandasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnComandasMouseExited(evt);
            }
        });
        btnComandas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComandasActionPerformed(evt);
            }
        });

        btnCliente.setBackground(new java.awt.Color(153, 153, 153));
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-grupos-de-usuários-48.png"))); // NOI18N
        btnCliente.setText("Clientes");
        btnCliente.setBorderPainted(false);
        btnCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClienteMouseExited(evt);
            }
        });
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnHistorico.setBackground(new java.awt.Color(153, 153, 153));
        btnHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-propriedade-de-tempo-48.png"))); // NOI18N
        btnHistorico.setText("Histórico de Pedidos");
        btnHistorico.setBorderPainted(false);
        btnHistorico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHistorico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHistoricoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHistoricoMouseExited(evt);
            }
        });
        btnHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(153, 153, 153));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-exportar-48.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setBorderPainted(false);
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSairMouseExited(evt);
            }
        });
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCaixa)
                .addGap(43, 43, 43)
                .addComponent(btnDelivery)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnComandas)
                .addGap(44, 44, 44)
                .addComponent(btnProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistorico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCaixa)
                    .addComponent(btnProduto)
                    .addComponent(btnDelivery)
                    .addComponent(btnPedido)
                    .addComponent(btnComandas)
                    .addComponent(btnCliente)
                    .addComponent(btnHistorico)
                    .addComponent(btnSair))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Olá User");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(209, 210, 210));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );

        jDesktopPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuBar1.setPreferredSize(new java.awt.Dimension(267, 28));

        jMenu1.setText("Gerencial");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jmiPessoas.setText("Pessoa");
        jmiPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPessoasActionPerformed(evt);
            }
        });
        jMenu1.add(jmiPessoas);

        jmiTelefones.setText("Classificação");
        jmiTelefones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTelefonesActionPerformed(evt);
            }
        });
        jMenu1.add(jmiTelefones);

        menuFornecedor.setText("Fornecedor");
        menuFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFornecedorActionPerformed(evt);
            }
        });
        jMenu1.add(menuFornecedor);

        jmiConfiguracoes.setText("Configurações");
        jmiConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConfiguracoesActionPerformed(evt);
            }
        });
        jMenu1.add(jmiConfiguracoes);

        jmiUsuario.setText("Usuário");
        jmiUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jmiUsuario);

        jmiGrupo.setText("Grupo");
        jmiGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGrupoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiGrupo);

        jmiTela.setText("Tela");
        jmiTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTelaActionPerformed(evt);
            }
        });
        jMenu1.add(jmiTela);

        jmiBotao.setText("Botão");
        jmiBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBotaoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiBotao);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Vendas");
        jMenuBar1.add(jMenu2);

        jMenu4.setText("Caixa");

        jMenuItem1.setText("Abrir e Fechar Caixa");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Financeiro");
        jMenuBar1.add(jMenu3);

        jMenu5.setText("Relatório");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jdCaixa telaCaixa = new jdCaixa(this, true);
        telaCaixa.setLocationRelativeTo(telaCaixa);
        telaCaixa.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmiTelefonesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiTelefonesActionPerformed
    {//GEN-HEADEREND:event_jmiTelefonesActionPerformed
        jdClassificacao telaClassificacao = new jdClassificacao(this, true);
        telaClassificacao.setLocationRelativeTo(telaClassificacao);
        telaClassificacao.setVisible(true);
    }//GEN-LAST:event_jmiTelefonesActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenu1ActionPerformed
    {//GEN-HEADEREND:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jmiPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPessoasActionPerformed
        jdPessoa telaPessoa = new jdPessoa(this, true);
        telaPessoa.setLocationRelativeTo(telaPessoa);
        telaPessoa.setVisible(true);
    }//GEN-LAST:event_jmiPessoasActionPerformed

    private void menuFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFornecedorActionPerformed
        jdFornecedor telaFornecedor = new jdFornecedor(this, true);
        telaFornecedor.setLocationRelativeTo(telaFornecedor);
        telaFornecedor.setVisible(true);
    }//GEN-LAST:event_menuFornecedorActionPerformed

    private void jmiConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConfiguracoesActionPerformed
        jdConfiguracoes telaConfiguracoes = new jdConfiguracoes(this, true);
        telaConfiguracoes.setLocationRelativeTo(telaConfiguracoes);
        telaConfiguracoes.setVisible(true);
    }//GEN-LAST:event_jmiConfiguracoesActionPerformed

    private void jmiUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUsuarioActionPerformed
        jdUsuario telaUsuario = new jdUsuario(this, true);
        telaUsuario.setLocationRelativeTo(telaUsuario);
        telaUsuario.setVisible(true);
    }//GEN-LAST:event_jmiUsuarioActionPerformed

    private void btnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaixaActionPerformed
        jdCaixa telaCaixa = new jdCaixa(this, true);
        telaCaixa.setLocationRelativeTo(telaCaixa);
        telaCaixa.setVisible(true);
    }//GEN-LAST:event_btnCaixaActionPerformed

    private void btnCaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaixaMouseEntered
        this.btnCaixa.setBorderPainted(true);
    }//GEN-LAST:event_btnCaixaMouseEntered

    private void btnCaixaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaixaMouseExited
        this.btnCaixa.setBorderPainted(false);
    }//GEN-LAST:event_btnCaixaMouseExited

    private void btnProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdutoMouseEntered
        this.btnProduto.setBorderPainted(true);
    }//GEN-LAST:event_btnProdutoMouseEntered

    private void btnProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdutoMouseExited
        this.btnProduto.setBorderPainted(false);
    }//GEN-LAST:event_btnProdutoMouseExited

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
//        jdProduto telaProduto = new jdProduto(this, true);
//        if(!Giba.bloquear(telaProduto.nomeTela, telaProduto)){
//            telaProduto.setLocationRelativeTo(telaProduto);
//            telaProduto.setVisible(true);
//        }
//        else {
//            telaProduto.dispose();
//        }

        jdProduto telaProduto = new jdProduto(this, true);
        telaProduto.setLocationRelativeTo(telaProduto);
        telaProduto.setVisible(true);
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnDeliveryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeliveryMouseEntered
        this.btnDelivery.setBorderPainted(true);
    }//GEN-LAST:event_btnDeliveryMouseEntered

    private void btnDeliveryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeliveryMouseExited
        this.btnDelivery.setBorderPainted(false);
    }//GEN-LAST:event_btnDeliveryMouseExited

    private void btnDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeliveryActionPerformed

    private void btnPedidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidoMouseEntered
        this.btnPedido.setBorderPainted(true);
    }//GEN-LAST:event_btnPedidoMouseEntered

    private void btnPedidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidoMouseExited
        this.btnPedido.setBorderPainted(false);
    }//GEN-LAST:event_btnPedidoMouseExited

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        jdPedido telaPedido = new jdPedido(this, true);
        telaPedido.setLocationRelativeTo(telaPedido);
        telaPedido.setVisible(true);
    }//GEN-LAST:event_btnPedidoActionPerformed

    private void btnComandasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComandasMouseEntered
        this.btnComandas.setBorderPainted(true);
    }//GEN-LAST:event_btnComandasMouseEntered

    private void btnComandasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComandasMouseExited
        this.btnComandas.setBorderPainted(false);
    }//GEN-LAST:event_btnComandasMouseExited

    private void btnComandasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComandasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnComandasActionPerformed

    private void btnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseEntered
        this.btnCliente.setBorderPainted(true);
    }//GEN-LAST:event_btnClienteMouseEntered

    private void btnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseExited
        this.btnCliente.setBorderPainted(false);
    }//GEN-LAST:event_btnClienteMouseExited

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnHistoricoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistoricoMouseEntered
        this.btnHistorico.setBorderPainted(true);
    }//GEN-LAST:event_btnHistoricoMouseEntered

    private void btnHistoricoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistoricoMouseExited
        this.btnHistorico.setBorderPainted(false);
    }//GEN-LAST:event_btnHistoricoMouseExited

    private void btnHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistoricoActionPerformed

    private void btnSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseEntered
        this.btnSair.setBorderPainted(true);
    }//GEN-LAST:event_btnSairMouseEntered

    private void btnSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseExited
        this.btnSair.setBorderPainted(false);
    }//GEN-LAST:event_btnSairMouseExited

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void jmiGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGrupoActionPerformed
        jdGrupo telaProduto = new jdGrupo(this, true);
        telaProduto.setLocationRelativeTo(telaProduto);
        telaProduto.setVisible(true);
    }//GEN-LAST:event_jmiGrupoActionPerformed

    private void jmiBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBotaoActionPerformed
        jdBotao telaBotao = new jdBotao(this, true);
        telaBotao.setLocationRelativeTo(telaBotao);
        telaBotao.setVisible(true);
    }//GEN-LAST:event_jmiBotaoActionPerformed

    private void jmiTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTelaActionPerformed
        jdTela telaTela = new jdTela(this, true);
        telaTela.setLocationRelativeTo(telaTela);
        telaTela.setVisible(true);
    }//GEN-LAST:event_jmiTelaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCaixa;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnComandas;
    private javax.swing.JButton btnDelivery;
    private javax.swing.JButton btnHistorico;
    private javax.swing.JButton btnPedido;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnSair;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenuItem jmiBotao;
    private javax.swing.JMenuItem jmiConfiguracoes;
    private javax.swing.JMenuItem jmiGrupo;
    private javax.swing.JMenuItem jmiPessoas;
    private javax.swing.JMenuItem jmiTela;
    private javax.swing.JMenuItem jmiTelefones;
    private javax.swing.JMenuItem jmiUsuario;
    private javax.swing.JMenuItem menuFornecedor;
    // End of variables declaration//GEN-END:variables
}
