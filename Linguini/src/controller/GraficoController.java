package controller;

import dao.MensagemRetorno;
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

    public DefaultPieDataset createPie(MensagemRetorno msg, String dataIni, String dataFin) {
        DefaultPieDataset dpd = new DefaultPieDataset();
        Date dataInicial, dataFinal;
        String strDataInicial = dataIni;
        String strDataFinal = dataFin;
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

        //msg = pedidoController.consultarTodos();
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
                        janeiro++;
                        dpd.setValue("Janeiro", janeiro);
                    }
                    if (a == 2) {
                        fevereiro++;
                        dpd.setValue("Fevereiro", fevereiro);
                    }
                    if (a == 3) {
                        marco++;
                        dpd.setValue("Março", marco);
                    }
                    if (a == 4) {
                        abril++;
                        dpd.setValue("Abril", abril);
                    }
                    if (a == 5) {
                        maio++;
                        dpd.setValue("Maio", maio);
                    }
                    if (a == 6) {
                        junho++;
                        dpd.setValue("Junho", junho);
                    }
                    if (a == 7) {
                        julho++;
                        dpd.setValue("Julho", julho);
                    }
                    if (a == 8) {
                        agosto++;
                        dpd.setValue("Agosto", agosto);
                    }
                    if (a == 9) {
                        setembro++;
                        dpd.setValue("Setembro", setembro);
                    }
                    if (a == 10) {
                        outubro++;
                        dpd.setValue("Outubro", outubro);
                    }
                    if (a == 11) {
                        novembro++;
                        dpd.setValue("Novembro", novembro);
                    }
                    if (a == 12) {
                        dezembro++;
                        dpd.setValue("Dezembro", dezembro);
                    }
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(jfGrafico.class.getName()).log(Level.SEVERE, null, ex);

        }
        return dpd;
    }

    public JFreeChart jFreeChart(DefaultPieDataset dataPie) {
        JFreeChart grafico = ChartFactory.createPieChart("Mes", dataPie, true, true, false);
        return grafico;

    }

    public ChartPanel chartPanel(MensagemRetorno msg, String dataIni, String dataFin) {
        DefaultPieDataset dpd = this.createPie(msg, dataIni, dataFin);

        JFreeChart grafico = this.jFreeChart(dpd);

        ChartPanel charPanel = new ChartPanel(grafico);
        return charPanel;
    }
}
