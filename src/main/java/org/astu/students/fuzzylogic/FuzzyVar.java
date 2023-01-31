package org.astu.students.fuzzylogic;

import javafx.scene.chart.XYChart;

public class FuzzyVar {
    private final float from;
    private final float to;
    private final float l;
    private final String name;

    public FuzzyVar(float from, float to, float l, String name) {
        this.from = from;
        this.to = to;
        this.l = l;
        this.name = name;
    }

    public XYChart.Series getSeries(){
        XYChart.Series series = new XYChart.Series();
        series.setName(name);

        series.getData().add(new XYChart.Data(50f, 0));
        series.getData().add(new XYChart.Data(from - (l/2), 0));
        series.getData().add(new XYChart.Data(from + (l/2), 1));
        series.getData().add(new XYChart.Data(to - (l/2), 1));
        series.getData().add(new XYChart.Data(to + (l/2), 0));
        series.getData().add(new XYChart.Data(250f, 0));
        return series;
    }

    public double getProbability(double x){
        if((x > from + (l/2)) && (x <= to - (l/2))) return 1;
        else if((x > from - (l/2)) && (x <= from + (l/2))) {
            return lineFromTwoPoints(from - (l/2), 0, from + (l/2), 1, x);
        }
        else  if((x > to - (l/2)) && (x <= to + (l/2))) {
            return lineFromTwoPoints(to - (l/2), 1, to + (l/2), 0, x);
        }
        return 0;
    }

    private double lineFromTwoPoints(double px1, double py1, double px2, double py2, double x) {
        double k = (py1-py2)/(px1-px2);
        double c = py2 - k * px2;
        return k * x + c;
    }
}
