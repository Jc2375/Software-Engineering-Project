package com.example.vam1994.speedbytedemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;

import java.util.ArrayList;

/**
 * The type Manager profits.
 */
public class ManagerProfits extends AppCompatActivity {

    private BarChart chart;
    /**
     * The Bar width.
     */
    float barWidth = 0.3f;
    /**
     * The Bar space.
     */
    float barSpace = 0f;
    /**
     * The Group space.
     */
    float groupSpace = 0.4f;


    /**
     * Create graph for restaurant profits
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_profits);

        chart = (BarChart)findViewById(R.id.barChart);
        chart.setDescription(null);
        chart.setPinchZoom(false);
        chart.setScaleEnabled(false);
        chart.setDrawBarShadow(false);
        chart.setDrawGridBackground(false);

        int total = 9;

        ArrayList<String> xValues = new ArrayList<>();
        xValues.add("4:00");
        xValues.add("5:00");
        xValues.add("6:00");
        xValues.add("7:00");
        xValues.add("8:00");
        xValues.add("9:00");
        xValues.add("10:00");
        xValues.add("11:00");
        xValues.add("12:00");

        ArrayList<BarEntry> yValues = new ArrayList<>();
        yValues.add(new BarEntry(1, 100));
        yValues.add(new BarEntry(2, 220));
        yValues.add(new BarEntry(3, 590));
        yValues.add(new BarEntry(4, 690));
        yValues.add(new BarEntry(5, 990));
        yValues.add(new BarEntry(6, 390));
        yValues.add(new BarEntry(7, 290));
        yValues.add(new BarEntry(8, 190));
        yValues.add(new BarEntry(9, 90));

        BarDataSet barDataSet = new BarDataSet(yValues, "Income");
        barDataSet.setValueTextColor(Color.YELLOW);
        //barDataSet.setColor(Color.YELLOW);
        BarData barData = new BarData(barDataSet);


        barData.setValueFormatter(new LargeValueFormatter());
        chart.setData(barData);
        chart.getBarData().setBarWidth(barWidth);
        chart.getData().setHighlightEnabled(false);
        chart.getAxisRight().setEnabled(false);
        chart.invalidate();


        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(true);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(true);
        xAxis.setAxisMaximum(barData.getXMax() + 0.25f);
        xAxis.setAxisMinimum(barData.getXMin() - 0.23f);
        xAxis.setLabelCount(9);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xValues));
        xAxis.setTextColor(Color.WHITE);

        YAxis yAxis = chart.getAxisLeft();
        yAxis.setValueFormatter(new LargeValueFormatter());
        yAxis.setDrawGridLines(true);
        yAxis.setAxisMaximum(1200);
        yAxis.setAxisMinimum(0);
        yAxis.setTextColor(Color.WHITE);
        yAxis.setXOffset(2f);
    }
}
