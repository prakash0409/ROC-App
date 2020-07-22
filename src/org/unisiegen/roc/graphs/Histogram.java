/* 
 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  © 2015-2016 | All right reserved for University of Siegen
 */
package org.unisiegen.roc.graphs;

import java.awt.BasicStroke;
import java.awt.Color;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

/**
 * @author RebellionPC
 *
 */
public class Histogram {

    public Histogram() {

    }

    public JFreeChart createChart(HashMap<Double, Timestamp> resultSetMap, String plotTitle, String xaxis, String yaxis) {
        HistogramDataset dataset = createDataset(resultSetMap, xaxis);
        return drawChart(dataset, plotTitle, xaxis, yaxis);
    }

    private static HistogramDataset createDataset(HashMap<Double, Timestamp> resultSetMap, String xaxisLegend) {
        double[] key = new double[resultSetMap.size()];
        int i = 0;
        HistogramDataset dataset = new HistogramDataset();
        for (Map.Entry<Double, Timestamp> entry : resultSetMap.entrySet()) {
            key[i] = entry.getKey();
            i++;
        }
        int numberOfBins = 10;
        dataset.setType(HistogramType.FREQUENCY);
        dataset.addSeries(xaxisLegend, key, numberOfBins);
        return dataset;
    }

    public JFreeChart createMultiChart(HashMap<String, HashMap<Double, Timestamp>> resultSetMap, String plotTitle, String xaxis, String yaxis) {
        HistogramDataset dataset = createMultiDataset(resultSetMap);
        return drawChart(dataset, plotTitle, xaxis, yaxis);

    }

    private static HistogramDataset createMultiDataset(HashMap<String, HashMap<Double, Timestamp>> resultSetMap) {
        int numberOfBins = 10;
        HistogramDataset dataset = new HistogramDataset();
        for (Map.Entry<String, HashMap<Double, Timestamp>> entry : resultSetMap.entrySet()) {
            String sensorDataType = entry.getKey();
            HashMap<Double, Timestamp> sensorData = entry.getValue();
            double[] key = new double[sensorData.size()];
            int i = 0;
            for (Map.Entry<Double, Timestamp> entry2 : sensorData.entrySet()) {
                key[i] = entry2.getKey();
                i++;
            }
            dataset.setType(HistogramType.FREQUENCY);
            dataset.addSeries(sensorDataType, key, numberOfBins);
        }
        return dataset;
    }

    private static JFreeChart drawChart(HistogramDataset dataset, String plotTitle, String xaxis, String yaxis) {
        PlotOrientation orientation = PlotOrientation.VERTICAL;
        JFreeChart chart = ChartFactory.createHistogram(plotTitle, xaxis, yaxis,
                dataset, orientation, true, true, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.lightGray);
        plot.setRangeGridlineStroke(new BasicStroke(1.0f));
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(true); //draw bar outlines
        renderer.setBarPainter(new StandardXYBarPainter()); //make bars flat paint
        renderer.setShadowVisible(false); //turn off shadowing
        Color color = new Color(28, 114, 12);
        renderer.setSeriesPaint(0, color);
        return chart;
    }
}
