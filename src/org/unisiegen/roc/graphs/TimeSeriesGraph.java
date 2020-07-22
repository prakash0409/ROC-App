/* 

 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  Â© 2015-2016 | All right reserved for University of Siegen

 */
package org.unisiegen.roc.graphs;


import java.awt.Color;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/**
 * @author RebellionPC
 *
 */
public class TimeSeriesGraph {

	/**
	 * 
	 */
	public TimeSeriesGraph() {
	}

	 public JFreeChart createChart(HashMap<Double,Timestamp> resultSetMap,String plotTitle,String xaxis,String yaxis){
		XYDataset dataset = createDataset(resultSetMap,yaxis);
		return drawChart(dataset, plotTitle, xaxis, yaxis);
	 }
	 
	 
	 private static XYDataset createDataset(HashMap<Double,Timestamp> resultSetMap,String Legend){
		    TimeSeries s1 = new TimeSeries(Legend);
		    for (Map.Entry<Double, Timestamp> entry : resultSetMap.entrySet()) {
                s1.addOrUpdate(new Second(entry.getValue()), entry.getKey());
		    }
		    TimeSeriesCollection dataset = new TimeSeriesCollection();
		    dataset.addSeries(s1);
		    return dataset;
	}
	 
	 public JFreeChart createMultiChart(HashMap<String, HashMap<Double, Timestamp>> resultSetMap,String plotTitle,String xaxis,String yaxis){
		 XYDataset dataset = createMultiDataset(resultSetMap);
		 return drawChart(dataset, plotTitle, xaxis, yaxis);
	 }
	 
	 private static XYDataset createMultiDataset(HashMap<String, HashMap<Double, Timestamp>> resultSetMap){
		 TimeSeriesCollection dataset = new TimeSeriesCollection();   
		    for (Map.Entry<String, HashMap<Double, Timestamp>> entry : resultSetMap.entrySet()) {
			    String sensorDataType = entry.getKey();
			    HashMap<Double, Timestamp> sensorData = entry.getValue();
			    TimeSeries s1 = new TimeSeries(sensorDataType);
			    for (Map.Entry<Double, Timestamp> entry2 : sensorData.entrySet()) {
		             s1.addOrUpdate(new Second(entry2.getValue()), entry2.getKey());
				}
			    dataset.addSeries(s1);
		    }
		    return dataset;
	}
	 
	
	 private static JFreeChart drawChart(XYDataset dataset,String plotTitle,String xaxis,String yaxis){
		 JFreeChart chart = ChartFactory.createTimeSeriesChart(
			        plotTitle,  		// title
			        xaxis,             	// x-axis label
			        yaxis,   			// y-axis label
			        dataset,            // data
			        true,               // create legend?
			        true,               // generate tooltips
			        false               // generate URLs
			    );


			    XYPlot plot = (XYPlot) chart.getPlot();
			    Color color = new Color(28, 114, 12);
			    plot.getRenderer().setSeriesPaint(0, color);
			    DateAxis axis = (DateAxis) plot.getDomainAxis();
			    axis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM-dd"));
	    return chart;
	 }
	 
}
