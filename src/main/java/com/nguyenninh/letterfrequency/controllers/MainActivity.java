package com.nguyenninh.letterfrequency.controllers;

import com.nguyenninh.letterfrequency.entity.Entity;
import com.nguyenninh.letterfrequency.entity.Separation;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.*;
import java.util.stream.Collectors;

public class MainActivity {
    @FXML
    public TextArea inputText;
    @FXML
    public Button submit;
    @FXML
    public TableView<Entity> tableView;
    @FXML
    public TableColumn<Entity, Character> text;
    @FXML
    public TableColumn<Entity, Integer> price;

    //Bar
    public BarChart<String, Integer> barChart;
    public CategoryAxis xAxis;
    public NumberAxis yAxis;

    public void initialize() {
        loadData();
        submit.setOnAction(e -> {
            Separation separation = new Separation(inputText.getText());
            List<Entity> list = separation.converList(separation.separa());
            Collections.sort(list, Comparator.comparing(Entity::getText));

            tableView.setItems(FXCollections.observableArrayList(list));

            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            System.out.println(list);
            for (Entity entity : list) {
                series.getData().add(new XYChart.Data(entity.getText() + "", entity.getPrice()));
            }

            barChart.getData().add(series);
            xAxis.setCategories(FXCollections.observableArrayList(list.stream()
                    .map(entity -> entity.getText() + "")
                    .collect(Collectors.toList())));
        });

        yAxis.setLabel("(Tần suất)");
        xAxis.setLabel("(Chữ cái)");
    }


    private void loadData() {
        text.setCellValueFactory(new PropertyValueFactory<>("text"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
