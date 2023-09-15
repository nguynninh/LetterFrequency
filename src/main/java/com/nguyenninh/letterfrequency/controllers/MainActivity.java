package com.nguyenninh.letterfrequency.controllers;

import com.nguyenninh.letterfrequency.entity.Entity;
import com.nguyenninh.letterfrequency.entity.Separation;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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

    public void initialize() {
        loadData();
        submit.setOnAction(e -> {
            Separation separation = new Separation(inputText.getText());
            List<Entity> list = separation.converList(separation.separa());
            Collections.sort(list, Comparator.comparing(Entity::getText));
            tableView.setItems(FXCollections.observableArrayList(list));
        });
    }

    private void loadData() {
        text.setCellValueFactory(new PropertyValueFactory<>("text"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
