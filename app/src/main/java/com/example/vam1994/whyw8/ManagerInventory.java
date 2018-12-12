package com.example.vam1994.whyw8;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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

    /**
     * Refresh Button.
     */
    static Button refresh;
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

        final ArrayList<BarEntry> yValues = new ArrayList<>();
        yValues.add(new BarEntry(1, 64));
        yValues.add(new BarEntry(2, 58));
        yValues.add(new BarEntry(3, 45));
        yValues.add(new BarEntry(4, 83));
        yValues.add(new BarEntry(5, 38));
        yValues.add(new BarEntry(6, 74));
        yValues.add(new BarEntry(7, 38));

        setBarData(yValues);

        refresh = (Button)findViewById(R.id.refreshButton);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yValues.get(0).getY() != 62) {
                    yValues.set(0, new BarEntry(1, 62));
                    yValues.set(1, new BarEntry(2, 56));
                    yValues.set(2, new BarEntry(3, 41));
                }
                else
                    yValues.set(3, new BarEntry(4,81));
                setBarData(yValues);
            }
        });
    }

    private void setBarData(ArrayList<BarEntry> yValues){
        ArrayList<String> xValues = new ArrayList<>();
        xValues.add("Pepper");
        xValues.add("Burger");
        xValues.add("Chicken");
        xValues.add("Fries");
        xValues.add("IceCream");
        xValues.add("Meat");
        xValues.add("Pizza");
        xValues.add("Steak");

        BarDataSet barDataSet = new BarDataSet(yValues, "Item");
        barDataSet.setValueTextColor(Color.YELLOW);
        barDataSet.setValueTextSize(20);
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
        yAxis.setAxisMaximum(100);
        yAxis.setAxisMinimum(0);
        yAxis.setTextColor(Color.WHITE);
        yAxis.setXOffset(2f);
    }
}