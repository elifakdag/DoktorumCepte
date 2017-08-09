package com.doktorumcepte.doktorumcepte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.doktorumcepte.doktorumcepte.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.BaseSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.series.*;
import com.jjoe64.graphview.ValueDependentColor;
import android.graphics.Color;


public class data_pressure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pressure);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(-1, 0),
                new DataPoint(0, 120),
                new DataPoint(1, 140),
                new DataPoint(2, 123),
                new DataPoint(3, 130),
                new DataPoint(4, 139)
        });
        graph.addSeries(series);

        BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 80),
                new DataPoint(1, 70),
                new DataPoint(2, 87),
                new DataPoint(3, 82),
                new DataPoint(4, 89)
        });
        graph.addSeries(series2);

// styling
        series2.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb(20, 100, 10);
            }
        });

        series.setSpacing(50);

// draw values on top
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);
//series.setValuesOnTopSize(50);

        series2.setSpacing(50);

// draw values on top
        series2.setDrawValuesOnTop(true);
        series2.setValuesOnTopColor(Color.RED);
    }
}
