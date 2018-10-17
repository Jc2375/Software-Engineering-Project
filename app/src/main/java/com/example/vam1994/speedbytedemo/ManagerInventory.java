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
 * The type Manager inventory.
 */
public class ManagerInventory extends AppCompatActivity {

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
    float groupSpace = 0.8f;

    /**
     * Creates graph for restaurant inventory
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_inventory);

        chart = (BarChart) findViewById(R.id.barChart2);
        chart.setDescription(null);
        chart.setPinchZoom(false);
        chart.setScaleEnabled(false);
        chart.setDrawBarShadow(false);
        chart.setDrawGridBackground(false);

        int total = 7;

        ArrayList<String> xValues = new ArrayList<>();
        xValues.add("Tomato");
        xValues.add("Onions");
        xValues.add("Pickles");
        xValues.add("Beef");
        xValues.add("Fries");
        xValues.add("Beans");
        xValues.add("Chicken");

        ArrayList<BarEntry> yValues = new ArrayList<>();
        yValues.add(new BarEntry(1, 30));
        yValues.add(new BarEntry(2, 18));
        yValues.add(new BarEntry(3, 8));
        yValues.add(new BarEntry(4, 99));
        yValues.add(new BarEntry(5, 38));
        yValues.add(new BarEntry(6, 20));
        yValues.add(new BarEntry(7, 38));

        BarDataSet barDataSet = new BarDataSet(yValues, "Item");
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
        xAxis.setDrawLabels(true);
        xAxis.setDrawGridLines(true);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(true);
        xAxis.setAxisMaximum(barData.getXMax() + 0.25f);
        xAxis.setAxisMinimum(barData.getXMin() - 0.23f);
        xAxis.setLabelCount(7);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xValues));
        xAxis.setTextColor(Color.WHITE);
        xAxis.setCenterAxisLabels(false);
        //xAxis.setAvoidFirstLastClipping(true);
        //xAxis.setSpaceMin(20f);

        YAxis yAxis = chart.getAxisLeft();
        yAxis.setValueFormatter(new LargeValueFormatter());
        yAxis.setDrawGridLines(true);
        yAxis.setAxisMaximum(120);
        yAxis.setAxisMinimum(0);
        yAxis.setTextColor(Color.WHITE);
        yAxis.setXOffset(2f);
    }
}
