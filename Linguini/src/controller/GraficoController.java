package controller;

import dao.MensagemRetorno;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pedido;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import view.jfGrafico;

/**
 *
 * @author Vitor
 */
public class GraficoController {

    private PedidoController pedidoController;
    private Pedido pedido;
    private BigDecimal valor;
    private int totalPedidos;
    
    public BigDecimal totalVenda(){
        return this.valor;
    }
    public int totalPedido(){
        return this.totalPedidos;
    }

    public DefaultPieDataset createPie(MensagemRetorno msg, String dataIni, String dataFin) {
        DefaultPieDataset dpd = new DefaultPieDataset();
        Date dataInicial, dataFinal;
        String strDataInicial = dataIni;
        String strDataFinal = dataFin;
        valor = new BigDecimal(0);
        this.totalPedidos=0;
        int janeiro = 0;
        int fevereiro = 0;
        int marco = 0;
        int abril = 0;
        int maio = 0;
        int junho = 0;
        int julho = 0;
        int agosto = 0;
        int setembro = 0;
        int outubro = 0;
        int novembro = 0;
        int dezembro = 0;
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        dpd = new DefaultPieDataset();
        try {
            dataFinal = sdf1.parse(strDataFinal);
            dataInicial = sdf2.parse(strDataInicial);

            for (Object o : msg.getLista()) {
                Pedido p = (Pedido) o;

                int a = p.getDataHora().getMonth() + 1;
                System.out.println(a + " mes numero");

                if (p.getDataHora().after(dataInicial) && p.getDataHora().before(dataFinal)) {

                    if (a == 1) {
                        this.totalPedidos++;
                        janeiro++;
                        dpd.setValue("Janeiro", janeiro);
                        valor = p.getValor().add(valor);
                    }
                    if (a == 2) {
                        this.totalPedidos++;
                        fevereiro++;
                        dpd.setValue("Fevereiro", fevereiro);
                        valor = p.getValor().add(valor);
                    }
                    if (a == 3) {
                        this.totalPedidos++;
                        marco++;
                        dpd.setValue("Março", marco);
                        valor = p.getValor().add(valor);
                    }
                    if (a == 4) {
                        this.totalPedidos++;
                        abril++;
                        dpd.setValue("Abril", abril);
                        valor = p.getValor().add(valor);
                    }
                    if (a == 5) {
                        this.totalPedidos++;
                        maio++;
                        dpd.setValue("Maio", maio);
                        valor = p.getValor().add(valor);
                    }
                    if (a == 6) {
                        this.totalPedidos++;
                        junho++;
                        dpd.setValue("Junho", junho);
                        valor = p.getValor().add(valor);
                    }
                    if (a == 7) {
                        this.totalPedidos++;
                        julho++;
                        dpd.setValue("Julho", julho);
                        valor = p.getValor().add(valor);
                    }
                    if (a == 8) {
                        this.totalPedidos++;
                        agosto++;
                        dpd.setValue("Agosto", agosto);
                        valor = p.getValor().add(valor);
                    }
                    if (a == 9) {
                        this.totalPedidos++;
                        setembro++;
                        dpd.setValue("Setembro", setembro);
                        valor = p.getValor().add(valor);
                    }
                    if (a == 10) {
                        this.totalPedidos++;
                        outubro++;
                        dpd.setValue("Outubro", outubro);
                        valor = p.getValor().add(valor);
                    }
                    if (a == 11) {
                        this.totalPedidos++;
                        novembro++;
                        dpd.setValue("Novembro", novembro);
                        valor = p.getValor().add(valor);
                    }
                    if (a == 12) {
                        this.totalPedidos++;
                        dezembro++;
                        dpd.setValue("Dezembro", dezembro);
                        valor = p.getValor().add(valor);;
                    }
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(jfGrafico.class.getName()).log(Level.SEVERE, null, ex);

        }
        return dpd;
    }

    public JFreeChart jFreeChart(DefaultPieDataset dataPie) {
        JFreeChart grafico = ChartFactory.createPieChart("Pedido por Mês", dataPie, true, true, false);
        return grafico;

    }

    public ChartPanel chartPanel(MensagemRetorno msg, String dataIni, String dataFin) {
        DefaultPieDataset dpd = this.createPie(msg, dataIni, dataFin);

        JFreeChart grafico = this.jFreeChart(dpd);

        ChartPanel charPanel = new ChartPanel(grafico);
        return charPanel;
    }
}
