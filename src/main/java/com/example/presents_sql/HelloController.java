package com.example.presents_sql;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelloController {

    public Label label1;
    public Label label;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private ComboBox<String> comboBox1;
    @FXML
    Label label2;
    private final List<Maker> list = new ArrayList<>();
    Integer numberOfManufacturer = 0;

    Maker man = new Maker();

    String card = "No";

    String delivery = "No";

    @FXML
    private void initialize() {
        updateData();
        comboData();
    }

    private void updateData() {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            while (in.hasNextLine()) {
                Maker present = new Maker();
                present.manufacturer = in.nextLine();
                present.n = in.nextInt();
                in.nextLine();
                for (int i = 0; i < present.n; i++) {
                    present.present.add(in.nextLine());
                    present.price.add(Double.parseDouble(in.nextLine()));
                }
                list.add(present);
                numberOfManufacturer++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("No such files: " + e.getMessage());
        }
    }

    private void comboData() {
        for (Maker s : list) {
            comboBox.getItems().add(s.manufacturer);
        }
    }

    private void comboData1() {
        comboBox1.getItems().clear();
        String selectedManufacturer = comboBox.getValue();
        for (int i = 0; i < numberOfManufacturer; i++) {
            if (selectedManufacturer.equals(list.get(i).manufacturer)) {
                man = list.get(i);
                for (int j = 0; j < list.get(i).n; j++) {
                    comboBox1.getItems().add(list.get(i).present.get(j));
                }
            }
        }
    }

    @FXML
    private void selPres() {
        comboData1();
        comboBox1.setValue("Choose the present");
    }

    @FXML
    private void card() {
        if (!card.equals("Yes")) {
            card = "Yes";
        } else
            card = "No";
    }

    @FXML
    private void calcPrice() {
        String selectedPresent = comboBox1.getValue();
        if (selectedPresent == null) {
            System.out.println("Please choose a present.");
            return;
        }

        Double price = 0.0;
        for (int i = 0; i < man.n; i++) {
            if (man.present.get(i).equals(selectedPresent)) {
                price = man.price.get(i);
                if ("Yes".equals(card)) {
                    price *= 0.9;
                }
                if ("Yes".equals(delivery)) {
                    price += 100;
                }
            }
        }
        label2.setText("The final price: " + price);
    }


    @FXML
    private void delivery() {
        if (!delivery.equals("Yes")) {
            delivery = "Yes";
        } else
            delivery = "No";
    }
}