/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.org.apache.xml.internal.serializer.utils.MsgKey;
import controller.GraficoController;
import controller.PedidoController;
import dao.MensagemRetorno;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Pedido;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import utils.Calendario;
import utils.Formatacao;

/**
 *
 * @author Vitor
 */
public class jfGrafico extends javax.swing.JFrame {

    private Pedido pedido;
    private PedidoController pedidoController;
    private GraficoController graficoController;

    /**
     * Creates new form jffGrafico
     */
    public jfGrafico() throws Exception {
        initComponents();
        this.pedido = new Pedido();
        this.pedidoController = new PedidoController();
        this.graficoController = new GraficoController();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpGrafico = new javax.swing.JPanel();
        btnPedidosMes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dataInicial = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        dataFinal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gráfico de Vendas");

        jpGrafico.setLayout(new java.awt.BorderLayout());

        btnPedidosMes.setText("Gerar");
        btnPedidosMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosMesActionPerformed(evt);
            }
        });

        jLabel1.setText("Pedidos de ");

        jLabel2.setText("até");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36)
                        .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(btnPedidosMes)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dataInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPedidosMes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPedidosMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosMesActionPerformed
        jpGrafico.removeAll();
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String in="1-1-2018 00:01";
        String fi="31-12-2018 23:59";
        if (!this.dataInicial.isValid()) {
            in = sdf1.format(this.dataInicial.getDate());
            System.out.println(in + "dataaa in");
        }
        if(!this.dataFinal.isValid()){
            fi = sdf1.format(this.dataFinal.getDate());
            System.out.println(fi+"dataaa fi");
        }

        MensagemRetorno msg = pedidoController.consultarTodos();
        GraficoController graficocoo = new GraficoController();

        jpGrafico.add(graficocoo.chartPanel(msg, in, fi));

        jpGrafico.validate();


    }//GEN-LAST:event_btnPedidosMesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfGrafico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfGrafico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfGrafico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfGrafico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jfGrafico().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(jfGrafico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPedidosMes;
    private com.toedter.calendar.JDateChooser dataFinal;
    private com.toedter.calendar.JDateChooser dataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jpGrafico;
    // End of variables declaration//GEN-END:variables
}
