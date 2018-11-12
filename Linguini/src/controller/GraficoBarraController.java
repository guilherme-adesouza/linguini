package controller;

import dao.MensagemRetorno;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pedido;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.*;
import org.jfree.data.general.DefaultPieDataset;
import view.jfGrafico;

/**
 *
 * @author Vitor
 */
public class GraficoBarraController {

    private PedidoController pedidoController;
    private Pedido pedido;

    public CategoryDataset createDataSet(MensagemRetorno msg, String dataIni, String dataFin) {
        DefaultCategoryDataset barra = new DefaultCategoryDataset();
        Date dataInicial, dataFinal;
        String strDataInicial = dataIni;
        String strDataFinal = dataFin;
        BigDecimal janeiro = new BigDecimal(0);
        BigDecimal fevereiro = new BigDecimal(0);
        BigDecimal marco = new BigDecimal(0);
        BigDecimal abril = new BigDecimal(0);
        BigDecimal maio = new BigDecimal(0);
        BigDecimal junho = new BigDecimal(0);
        BigDecimal julho = new BigDecimal(0);
        BigDecimal agosto = new BigDecimal(0);
        BigDecimal setembro = new BigDecimal(0);
        BigDecimal outubro = new BigDecimal(0);
        BigDecimal novembro = new BigDecimal(0);
        BigDecimal dezembro = new BigDecimal(0);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        barra = new DefaultCategoryDataset();
        try {
            dataFinal = sdf1.parse(strDataFinal);
            dataInicial = sdf2.parse(strDataInicial);

            for (Object o : msg.getLista()) {
                Pedido p = (Pedido) o;

                int a = p.getDataHora().getMonth() + 1;
                System.out.println(a + " mes numero");

                if (p.getDataHora().after(dataInicial) && p.getDataHora().before(dataFinal)) {

                    if (a == 1) {
                        janeiro=p.getValor().add(janeiro);
                        barra.setValue(janeiro, "Janeiro", "");
                    }
                    if (a == 2) {
                        fevereiro=p.getValor().add(fevereiro);
                        barra.setValue(fevereiro, "Fevereiro", "");
                    }
                    if (a == 3) {
                        marco=p.getValor().add(marco);
                        barra.setValue(marco, "Março", "");
                    }
                    if (a == 4) {
                        abril=p.getValor().add(abril);
                        barra.setValue(abril, "Abril", "");
                    }
                    if (a == 5) {
                        maio=p.getValor().add(maio);
                        barra.setValue(maio, "Maio", "");
                    }
                    if (a == 6) {
                        junho=p.getValor().add(junho);
                        barra.setValue(junho, "Junho", "");
                    }
                    if (a == 7) {
                        julho=p.getValor().add(julho);
                        barra.setValue(julho, "Julho", "");
                    }
                    if (a == 8) {
                        agosto=p.getValor().add(agosto);
                        barra.setValue(agosto, "Agosto", "");
                    }
                    if (a == 9) {
                        setembro=p.getValor().add(setembro);
                        barra.setValue(setembro, "Setembro", "");
                    }
                    if (a == 10) {
                        outubro=p.getValor().add(outubro);
                        barra.setValue(outubro, "Outubro", "");
                    }
                    if (a == 11) {
                        novembro=p.getValor().add(novembro);
                        barra.setValue(novembro, "Novembro", "");
                    }
                    if (a == 12) {
                        dezembro=p.getValor().add(dezembro);
                        barra.setValue(dezembro, "Dezembro", "");
                    }
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(jfGrafico.class.getName()).log(Level.SEVERE, null, ex);

        }
        return barra;
    }

    public JFreeChart jFreeChart(CategoryDataset dataS) {
        JFreeChart grafico = ChartFactory.createBarChart("Vendas por Mês", "Mês", "R$", dataS, PlotOrientation.VERTICAL, true, true, false);
        return grafico;

    }

    public ChartPanel chartPanel(MensagemRetorno msg, String dataIni, String dataFin) {
        CategoryDataset dpd = this.createDataSet(msg, dataIni, dataFin);

        JFreeChart grafico = this.jFreeChart(dpd);

        ChartPanel charPanel = new ChartPanel(grafico);
        return charPanel;
    }
}
