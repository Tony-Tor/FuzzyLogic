package org.astu.students.fuzzylogic;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML private LineChart fuzzyChart;
    @FXML private NumberAxis axisX;
    @FXML private TextField stockPrice;
    @FXML private Label lowPrice;
    @FXML private Label middlePrice;
    @FXML private Label highPrice;

    FuzzyVar lowFuzVar;
    FuzzyVar middleFuzVar;
    FuzzyVar highFuzVar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lowFuzVar = new FuzzyVar(100, 133, 10, "Низкая цена");
        middleFuzVar = new FuzzyVar(133, 166, 10, "Средняя цена");
        highFuzVar = new FuzzyVar(166, 200, 10, "Высокая цена");

        fuzzyChart.getData().add(lowFuzVar.getSeries());
        fuzzyChart.getData().add(middleFuzVar.getSeries());
        fuzzyChart.getData().add(highFuzVar.getSeries());

    }

    public void onMouseClicked(){
        double x = Double.parseDouble(stockPrice.getText());
        lowPrice.setText(lowFuzVar.getProbability(x)+"");
        middlePrice.setText(middleFuzVar.getProbability(x)+"");
        highPrice.setText(highFuzVar.getProbability(x)+"");
    }
}