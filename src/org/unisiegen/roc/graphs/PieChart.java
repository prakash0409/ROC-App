/*
 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  © 2015-2016 | All right reserved for University of Siegen
 */
package org.unisiegen.roc.graphs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 * @author RebellionPC
 *
 */
public class PieChart {

    /**
     *
     */
    public PieChart() {
    }

    public JFreeChart createChart(HashMap<String, Long> resultSetMap, String plotTitle) {
        DefaultPieDataset dataset = createDataset(resultSetMap);
        return drawChart(dataset, plotTitle);
    }

    private static DefaultPieDataset createDataset(HashMap<String, Long> resultSetMap) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<String, Long> entry : resultSetMap.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        return dataset;
    }

    private static JFreeChart drawChart(DefaultPieDataset dataset, String plotTitle) {
        JFreeChart chart = ChartFactory.createPieChart(plotTitle, dataset, true, true, false);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessagePaint(Color.WHITE);
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);        
        plot.setLabelGap(0.02);
        return chart;
    }

}
