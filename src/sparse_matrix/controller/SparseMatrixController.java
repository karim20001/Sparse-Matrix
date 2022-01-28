package sparse_matrix.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import sparse_matrix.model.Sparsing;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.Double.MAX_VALUE;

public class SparseMatrixController implements Initializable {

    @FXML
    private Line Line1;

    @FXML
    private Line downLine1;

    @FXML
    private Line topLine2;

    @FXML
    private Line downLine2;

    @FXML
    private Line Line2;

    @FXML
    private Button calculate1;

    @FXML
    private Button BT1;

    @FXML
    private Button BT2;

    @FXML
    private Button BT3;

    @FXML
    private Button BTPlus;

    @FXML
    private TextField TP1;

    @FXML
    private TextField TP2;

    @FXML
    private GridPane girdPane1;

    @FXML
    private AnchorPane anchorPane1;

    @FXML
    private TextField TF211;

    @FXML
    private TextField TF212;

    @FXML
    private TextField TF221;

    @FXML
    private TextField TF222;

    @FXML
    private GridPane girdPane22;

    @FXML
    private GridPane girdPane2;

    @FXML
    private Line topLine11;

    @FXML
    private Line Line11;

    @FXML
    private Line downLine11;

    @FXML
    private Label LBR;

    @FXML
    private Line topLine21;

    @FXML
    private Line Line21;

    @FXML
    private Line downLine21;

    @FXML
    private Line topLine111;

    @FXML
    private Line Line111;

    @FXML
    private Line downLine111;

    @FXML
    private Line topLine211;

    @FXML
    private Line Line211;

    @FXML
    private Line downLine211;

    @FXML
    private Line topLine1;

    @FXML
    private ScrollPane sp1;

    @FXML
    private ScrollPane sp2;

    @FXML
    private Label ma1;

    @FXML
    private Label ma2;

    @FXML
    private Label ma3;

    @FXML
    private Label matrix2;

    @FXML
    private AnchorPane anchorPane2;

    @FXML
    private AnchorPane anchorPane3;

    @FXML
    private Button BTMulti;

    @FXML
    private Label empty1;

    @FXML
    private Label Error;

    @FXML
    private Button BTBack;

    @FXML
    private Line Line2111;

    @FXML
    private Line Line1111;

    @FXML
    private Line downLine2111;

    @FXML
    private Line downLine1111;

    @FXML
    private Line topLine2111;

    @FXML
    private Line topLine1111;

    @FXML
    private GridPane girdPane3;

    @FXML
    private Label empty112;

    @FXML
    private Label labelB;

    @FXML
    private Label labelR;

    @FXML
    private Label labelA;

    @FXML
    private HBox hBox;

    @FXML
    private GridPane gp31;

    @FXML
    private GridPane gp32;

    @FXML
    private GridPane gp33;

    @FXML
    private ScrollPane sp33;

    @FXML
    private ScrollPane SPDown;

    @FXML
    private AnchorPane APUp;

    @FXML
    private Button BTmin;

    @FXML
    private Label empty11;

    @FXML
    private Label empty111;

    ArrayList<TextField> textFields = new ArrayList<>();
    ArrayList<TextField> textFields21 = new ArrayList<>();
    ArrayList<TextField> textFields22 = new ArrayList<>();

    private int checkButton = 1;
    private boolean checkBack = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TP1.textProperty().addListener(e -> createMatrix());
        TP2.textProperty().addListener(e -> createMatrix());
        TF211.textProperty().addListener(e -> createMatrix2());
        TF212.textProperty().addListener(e -> createMatrix2());
        TF221.textProperty().addListener(e -> createMatrix3());
        TF222.textProperty().addListener(e -> createMatrix3());
        BTPlus.setOnAction(e -> {
            if (Integer.parseInt(TF211.getText()) == Integer.parseInt(TF221.getText()) && Integer.parseInt(TF212.getText()) == Integer.parseInt(TF222.getText())){
                adding_subtracting(1);
                hBox.setVisible(true);
                labelA.setVisible(true);
                SPDown.setVisible(true);
            }
            else {
                labelA.setVisible(false);
                labelB.setVisible(false);
                labelR.setVisible(false);
                SPDown.setVisible(false);
                hBox.setVisible(false);
                Error.setVisible(true);
                Error.setText("Cannot be added!" + "\uD83D\uDCA9");
            }
            checkBack = false;
            setCheckButton(3);
            girdPane1.getChildren().clear();
            TP1.clear();
            TP2.clear();
            BT3.setStyle("-fx-background-color: #2F2D2DFF");
            BT2.setStyle("-fx-background-color: black");
            anchorPane2.setVisible(false);
            anchorPane3.setVisible(true);


        });
        BTPlus.setOnMouseEntered(e -> BTPlus.setStyle("-fx-background-color: #5f636e"));
        BTPlus.setOnMouseExited(e -> BTPlus.setStyle("-fx-background-color: #2F2D2DFF"));
        BTmin.setOnAction(e -> {
            if (Integer.parseInt(TF211.getText()) == Integer.parseInt(TF221.getText()) && Integer.parseInt(TF212.getText()) == Integer.parseInt(TF222.getText())){
                adding_subtracting(-1);
                hBox.setVisible(true);
                labelA.setVisible(true);
                SPDown.setVisible(true);
            }
            else {
                labelA.setVisible(false);
                labelB.setVisible(false);
                labelR.setVisible(false);
                SPDown.setVisible(false);
                hBox.setVisible(false);
                Error.setVisible(true);
                Error.setText("Cannot be subtracted!" + "\uD83D\uDCA9");
            }
            checkBack = false;
            setCheckButton(3);
            girdPane1.getChildren().clear();
            TP1.clear();
            TP2.clear();
            BT3.setStyle("-fx-background-color: #2F2D2DFF");
            BT2.setStyle("-fx-background-color: black");
            anchorPane2.setVisible(false);
            anchorPane3.setVisible(true);
        });
        BTmin.setOnMouseEntered(e -> BTmin.setStyle("-fx-background-color: #5f636e"));
        BTmin.setOnMouseExited(e -> BTmin.setStyle("-fx-background-color: #2F2D2DFF"));
        BTMulti.setOnMouseEntered(e -> BTMulti.setStyle("-fx-background-color: #5f636e"));
        BTMulti.setOnMouseExited(e -> BTMulti.setStyle("-fx-background-color: #2F2D2DFF"));
        BTMulti.setOnAction(e -> {
            if (Integer.parseInt(TF212.getText()) == Integer.parseInt(TF221.getText())){
                multiply();
                hBox.setVisible(true);
                labelA.setVisible(true);
                SPDown.setVisible(true);
            }
            else {
                labelA.setVisible(false);
                labelB.setVisible(false);
                labelR.setVisible(false);
                SPDown.setVisible(false);
                hBox.setVisible(false);
                Error.setVisible(true);
                Error.setText("Cannot be multiplied!" + "\uD83D\uDCA9");
            }
            setCheckButton(3);
            TP2.clear();
            TP1.clear();
            girdPane1.getChildren().clear();
            checkBack = false;
            BT3.setStyle("-fx-background-color: #2F2D2DFF");
            BT2.setStyle("-fx-background-color: black");
            anchorPane2.setVisible(false);
            anchorPane3.setVisible(true);
        });
        BTBack.setText("\u2190");
        BTBack.setOnMouseEntered(e -> BTBack.setStyle("-fx-background-color: #5f636e"));
        BTBack.setOnMouseExited(e -> BTBack.setStyle("-fx-background-color: #2F2D2DFF"));
        BTBack.setOnAction(e -> {
            if (checkBack){
                anchorPane1.setVisible(true);
                BT1.setStyle("-fx-background-color: #2F2D2DFF");
                checkButton = 1;
            }
            else {
                anchorPane2.setVisible(true);
                BT2.setStyle("-fx-background-color: #2F2D2DFF");
                checkButton = 2;
            }
            anchorPane3.setVisible(false);
            BT3.setStyle("-fx-background-color: Black");
        });

        anchorPane2.heightProperty().addListener((obs, oldVal, newVal)-> {
            if (oldVal.doubleValue() != 0.0) {
                sp1.setPrefHeight(sp1.getPrefHeight() + (newVal.doubleValue() - oldVal.doubleValue()) / 2);
                sp2.setPrefHeight(sp2.getPrefHeight() + (newVal.doubleValue() - oldVal.doubleValue()) / 2);
                matrix2.setLayoutY(matrix2.getLayoutY() + (newVal.doubleValue() - oldVal.doubleValue()) / 2);
                ma1.setLayoutY(ma1.getLayoutY() + (newVal.doubleValue() - oldVal.doubleValue()) / 2);
                TF221.setLayoutY(TF221.getLayoutY() + (newVal.doubleValue() - oldVal.doubleValue()) / 2);
                TF222.setLayoutY(TF222.getLayoutY() + (newVal.doubleValue() - oldVal.doubleValue()) / 2);
                ma2.setLayoutY(ma2.getLayoutY() + (newVal.doubleValue() - oldVal.doubleValue()) / 2);
                ma3.setLayoutY(ma3.getLayoutY() + (newVal.doubleValue() - oldVal.doubleValue()) / 2);
            }
        });
        anchorPane3.heightProperty().addListener((obs, oldVal, newVal)-> {
            if (oldVal.doubleValue() != 0.0) {
                SPDown.setPrefHeight(SPDown.getPrefHeight() + (newVal.doubleValue() - oldVal.doubleValue()) / 2);
                APUp.setPrefHeight(APUp.getPrefHeight() + (newVal.doubleValue() - oldVal.doubleValue()) / 2);
            }
        });
        anchorPane3.widthProperty().addListener((obs, oldVal, newVal) -> {
            if (oldVal.doubleValue() != 0.0) {
                labelA.setLayoutX(labelA.getLayoutX() + (newVal.doubleValue() - oldVal.doubleValue()) / 6);
                labelB.setLayoutX(labelB.getLayoutX() + (newVal.doubleValue() - oldVal.doubleValue()) / 2);
                labelR.setLayoutX(labelR.getLayoutX() + (newVal.doubleValue() - oldVal.doubleValue()) / 1.21);
                gp31.setPrefWidth(gp31.getPrefWidth() + (newVal.doubleValue() - oldVal.doubleValue()) / 3);
                gp32.setPrefWidth(gp32.getPrefWidth() + (newVal.doubleValue() - oldVal.doubleValue()) / 3);
                gp33.setPrefWidth(gp33.getPrefWidth() + (newVal.doubleValue() - oldVal.doubleValue()) / 3);
            }
        });

        // button 1 matrix

        BT1.setOnMouseEntered(e -> {
            if (checkButton != 1)
                BT1.setStyle("-fx-background-color: #3d5379");
        });
        BT1.setOnMouseExited(e -> {
            if (checkButton != 1)
                BT1.setStyle("-fx-background-color: black");
        });
        BT1.setOnAction(e -> {
            if (checkButton != 1) {
                BT1.setStyle("-fx-background-color: #2F2D2DFF");
                BT3.setStyle("-fx-background-color: Black");
                BT2.setStyle("-fx-background-color: Black");
                anchorPane1.setVisible(true);
                anchorPane2.setVisible(false);
                anchorPane3.setVisible(false);
                checkButton = 1;
            }
        });

        //-----------------------------------------------------------------------
        //button 2 matrix
        BT2.setOnMouseEntered(e -> {
            if (checkButton != 2)
                BT2.setStyle("-fx-background-color: #3d5379");
        });
        BT2.setOnMouseExited(e -> {
            if (checkButton != 2)
                BT2.setStyle("-fx-background-color: black");
        });
        BT2.setOnAction(e -> {
            if (checkButton != 2) {
                BT2.setStyle("-fx-background-color: #2F2D2DFF");
                BT1.setStyle("-fx-background-color: black");
                BT3.setStyle("-fx-background-color: black");
                anchorPane2.setVisible(true);
                anchorPane1.setVisible(false);
                anchorPane3.setVisible(false);
                checkButton = 2;

            }
        });
        //--------------------------------------------------------------------------
        //button result
        BT3.setOnMouseEntered(e -> {
            if (checkButton != 3)
                BT3.setStyle("-fx-background-color: #3d5379");
        });
        BT3.setOnMouseExited(e -> {
            if (checkButton != 3)
                BT3.setStyle("-fx-background-color: black");
        });
        BT3.setOnAction(e -> {
            if (checkButton != 3) {
                BT3.setStyle("-fx-background-color: #2F2D2DFF");
                BT1.setStyle("-fx-background-color: black");
                BT2.setStyle("-fx-background-color: black");
                anchorPane3.setVisible(true);
                anchorPane2.setVisible(false);
                anchorPane1.setVisible(false);
                checkButton = 3;
            }
        });

        //-----------------------------------------------------------------------------
        //button calculate

        calculate1.setOnMouseEntered(e -> calculate1.setStyle("-fx-background-color: #5f636e"));
        calculate1.setOnMouseExited(e -> calculate1.setStyle("-fx-background-color: #2F2D2DFF"));
        calculate1.setOnAction(e -> {
            BT3.setStyle("-fx-background-color: #2F2D2DFF");
            BT1.setStyle("-fx-background-color: black");
            setCheckButton(3);
            checkBack = true;
            transpose();
            anchorPane1.setVisible(false);
            anchorPane3.setVisible(true);
            labelA.setVisible(true);
            hBox.setVisible(true);
            TF222.clear();
            TF221.clear();
            TF212.clear();
            TF211.clear();
            girdPane2.getChildren().clear();
            girdPane22.getChildren().clear();
        });
    }


    public void createMatrix (){

        girdPane1.setPrefWidth(27);

        girdPane1.getChildren().clear();

        Line1.setVisible(false);
        downLine1.setVisible(false);
        downLine2.setVisible(false);

        Line2.setVisible(false);
        topLine1.setVisible(false);
        topLine2.setVisible(false);

        Line1.setStartY(-160);
        Line2.setStartY(-160);
        Line2.setLayoutX(180);

        downLine1.setLayoutY(66);
        downLine2.setLayoutY(66);
        downLine2.setLayoutX(158);
        empty1.setLayoutX(90);

        topLine2.setLayoutX(159);
        textFields.clear();

        int tp1;
        int tp2;

        if ( TP1.getText().equals("") || TP2.getText().equals(""))
            return;
        else {
            tp1 = Integer.parseInt(TP1.getText());
            tp2 = Integer.parseInt(TP2.getText());
        }
        if (tp1 == 0 || tp2 == 0)
            return;

        girdPane1.setVisible(true);
        topLine1.setVisible(true);
        Line1.setVisible(true);
        downLine1.setVisible(true);
        Line2.setVisible(true);
        downLine2.setVisible(true);
        topLine2.setVisible(true);

        if (tp1 > 1) {
            Line1.setStartY(Line1.getStartY() + 35 * (tp1 - 1));
            Line2.setStartY(Line2.getStartY() + 35 * (tp1 - 1));
            downLine1.setLayoutY(downLine1.getLayoutY() + 35 * (tp1 - 1));
            downLine2.setLayoutY(downLine2.getLayoutY() + 35 * (tp1 - 1));
        }

        if (tp2 > 1) {
            empty1.setLayoutX(empty1.getLayoutX() + 41 * (tp2 - 1));
            girdPane1.setPrefWidth(girdPane1.getPrefWidth() + 41 * (tp2 - 1));
            Line2.setLayoutX(Line2.getLayoutX() + 41 * (tp2 - 1));
            downLine2.setLayoutX(downLine2.getLayoutX() + 41 * (tp2 - 1));
            topLine2.setLayoutX(topLine2.getLayoutX() + 41 * (tp2 - 1));
        }

        int row = 0, column = 0;

        for (int i = 0; i < tp1 * tp2; i++, column += 2){

            Label spring = new Label();
            spring.minWidthProperty().setValue(15);

            if (row > 1) {
                spring.minHeightProperty().setValue(10);
            }else {
                spring.minHeightProperty().setValue(20);
            }

            TextField textfield = new TextField();
            textfield.setStyle("-fx-background-color: #8f8d8d; -fx-text-fill: white");
            textfield.setPromptText("0");
            textFields.add(textfield);

            girdPane1.add(textfield, column, row);

            if (column == 2 * (tp2 - 1)) {
                column = -2;
                girdPane1.add(spring, 0, row + 1);
                row+=2;
            }else
                girdPane1.add(spring, column + 1, row);

        }

    }

    public void setCheckButton(int a){
        checkButton = a;
        //System.out.println(checkButton);
    }

    public void createMatrix2 (){

        girdPane2.setPrefWidth(27);

        girdPane2.getChildren().clear();

        Line11.setVisible(false);
        downLine11.setVisible(false);
        topLine11.setVisible(false);

        Line21.setVisible(false);
        downLine21.setVisible(false);
        topLine21.setVisible(false);

        Line11.setStartY(-160);
        Line21.setStartY(-160);
        Line21.setLayoutX(178);

        downLine11.setLayoutY(72);
        downLine21.setLayoutY(72);
        downLine21.setLayoutX(157);
        empty111.setLayoutX(87);

        topLine21.setLayoutX(157);
        textFields21.clear();

        int tp1, tp2;

        if (TF211.getText().equals("") || TF212.getText().equals(""))
            return;
        else {
            tp1 = Integer.parseInt(TF211.getText());
            tp2 = Integer.parseInt(TF212.getText());
        }
        if (tp1 <= 0 || tp2 <= 0)
            return;

        girdPane2.setVisible(true);

        Line11.setVisible(true);
        downLine11.setVisible(true);
        topLine11.setVisible(true);

        Line21.setVisible(true);
        downLine21.setVisible(true);
        topLine21.setVisible(true);

        if (tp1 > 1) {
            Line11.setStartY(Line11.getStartY() + 35 * (tp1 - 1));
            Line21.setStartY(Line21.getStartY() + 35 * (tp1 - 1));
            downLine11.setLayoutY(downLine11.getLayoutY() + 35 * (tp1 - 1));
            downLine21.setLayoutY(downLine21.getLayoutY() + 35 * (tp1 - 1));
        }

        if (tp2 > 1) {
            empty111.setLayoutX(empty111.getLayoutX() + 41 * (tp2 - 1));
            girdPane2.setPrefWidth(girdPane2.getPrefWidth() + 41 * (tp2 - 1));
            Line21.setLayoutX(Line21.getLayoutX() + 41 * (tp2 - 1));
            downLine21.setLayoutX(downLine21.getLayoutX() + 41 * (tp2 - 1));
            topLine21.setLayoutX(topLine21.getLayoutX() + 41 * (tp2 - 1));
        }

        int row = 0, column = 0;

        for (int i = 0; i < tp1 * tp2; i++, column += 2){

            Label spring = new Label();
            spring.minWidthProperty().setValue(15);

            if (row > 1) {
                spring.minHeightProperty().setValue(10);
            }else {
                spring.minHeightProperty().setValue(20);
            }

            TextField textField = new TextField();
            textField.setStyle("-fx-background-color: #8f8d8d; -fx-text-fill: white");
            textField.setPromptText("0");
            textFields21.add(textField);

            girdPane2.add(textField, column, row);

            if (column == 2 * (tp2 - 1)){
                column = -2;
                girdPane2.add(spring, 0, row + 1);
                row += 2;
            }else
                girdPane2.add(spring, column + 1, row);

        }


    }

    public void createMatrix3(){
        girdPane22.setPrefWidth(27);
        girdPane22.getChildren().clear();

        Line111.setVisible(false);
        downLine111.setVisible(false);
        topLine111.setVisible(false);

        Line211.setVisible(false);
        downLine211.setVisible(false);
        topLine211.setVisible(false);

        Line111.setStartY(-160);
        Line211.setStartY(-160);
        Line211.setLayoutX(178);

        downLine111.setLayoutY(72);
        downLine211.setLayoutY(72);
        downLine211.setLayoutX(157);
        empty11.setLayoutX(87);

        topLine211.setLayoutX(157);
        textFields22.clear();

        int tp1, tp2;

        if (TF221.getText().equals("") || TF222.getText().equals(""))
            return;
        else {
            tp1 = Integer.parseInt(TF221.getText());
            tp2 = Integer.parseInt(TF222.getText());
        }
        if (tp1 <= 0 || tp2 <= 0)
            return;

        girdPane22.setVisible(true);

        Line111.setVisible(true);
        downLine111.setVisible(true);
        topLine111.setVisible(true);

        Line211.setVisible(true);
        downLine211.setVisible(true);
        topLine211.setVisible(true);

        if (tp1 > 1) {
            Line111.setStartY(Line111.getStartY() + 35 * (tp1 - 1));
            Line211.setStartY(Line211.getStartY() + 35 * (tp1 - 1));
            downLine111.setLayoutY(downLine111.getLayoutY() + 35 * (tp1 - 1));
            downLine211.setLayoutY(downLine211.getLayoutY() + 35 * (tp1 - 1));
        }

        if (tp2 > 1) {
            empty11.setLayoutX(empty11.getLayoutX() + 41 * (tp2 - 1));
            girdPane22.setPrefWidth(girdPane22.getPrefWidth() + 41 * (tp2 - 1));
            Line211.setLayoutX(Line211.getLayoutX() + 41 * (tp2 - 1));
            downLine211.setLayoutX(downLine211.getLayoutX() + 41 * (tp2 - 1));
            topLine211.setLayoutX(topLine211.getLayoutX() + 41 * (tp2 - 1));
        }

        int row = 0, column = 0;

        for (int i = 0; i < tp1 * tp2; i++, column += 2){

            Label spring = new Label();
            spring.minWidthProperty().setValue(15);

            if (row > 1) {
                spring.minHeightProperty().setValue(10);
            }else {
                spring.minHeightProperty().setValue(20);
            }

            TextField textField = new TextField();
            textField.setStyle("-fx-background-color: #8f8d8d; -fx-text-fill: white");
            textField.setPromptText("0");
            textFields22.add(textField);

            girdPane22.add(textField, column, row);

            if (column == 2 * (tp2 - 1)){
                column = -2;
                girdPane22.add(spring, 0, row + 1);
                row += 2;
            }else
                girdPane22.add(spring, column + 1, row);

        }
    }

    public void adding_subtracting(int z){
        Sparsing sMatrix = new Sparsing();
        sMatrix.sparsing('A', Integer.parseInt(TF212.getText()), textFields21);
        sMatrix.sparsing('B', Integer.parseInt(TF222.getText()), textFields22);
        sMatrix.adding_subtracting(z);
        ArrayList<int[]> tempA = sMatrix.getA();
        ArrayList<int[]> tempB = sMatrix.getB();
        ArrayList<int[]> tempR = sMatrix.getResult();
        show(false, Integer.parseInt(TF211.getText()), Integer.parseInt(TF212.getText()), tempA, tempB, tempR);
        sMatrix.reset();
    }

    public void multiply (){
        Sparsing sMatrix = new Sparsing();
        sMatrix.sparsing('A', Integer.parseInt(TF212.getText()), textFields21);
        sMatrix.sparsing('B', Integer.parseInt(TF222.getText()), textFields22);
        sMatrix.multiply(Integer.parseInt(TF211.getText()), Integer.parseInt(TF222.getText()));
        ArrayList<int[]> tempA = sMatrix.getA();
        ArrayList<int[]> tempB = sMatrix.getB();
        ArrayList<int[]> tempR = sMatrix.getResult();
        show(false, Integer.parseInt(TF211.getText()), Integer.parseInt(TF222.getText()), tempA, tempB, tempR);
        sMatrix.reset();
    }

    public void transpose (){
        Sparsing sMatrix = new Sparsing();
        sMatrix.sparsing('A', Integer.parseInt(TP2.getText()), textFields);
        sMatrix.transpose();
        ArrayList<int[]> temp;
        temp = sMatrix.getA();
        ArrayList<int[]> tempR;
        tempR = sMatrix.getResult();
        show(true, Integer.parseInt(TP1.getText()), Integer.parseInt(TP2.getText()), temp, null, tempR);
        sMatrix.reset();
    }

    public void show (boolean trs, int tp1, int tp2, ArrayList<int[]> tempA, ArrayList<int[]> tempB, ArrayList<int[]> tempR){

        girdPane3.setPrefWidth(27);
        girdPane3.getChildren().clear();

        gp31.getChildren().clear();
        gp32.getChildren().clear();
        gp33.getChildren().clear();

        Line1111.setVisible(false);
        downLine1111.setVisible(false);
        topLine1111.setVisible(false);

        Line2111.setVisible(false);
        downLine2111.setVisible(false);
        topLine2111.setVisible(false);

        Line1111.setStartY(-160);
        Line2111.setStartY(-160);
        Line2111.setLayoutX(178);

        downLine1111.setLayoutY(75);
        downLine2111.setLayoutY(75);
        downLine2111.setLayoutX(157);
        empty112.setLayoutX(80);

        topLine2111.setLayoutX(157);

        girdPane3.setVisible(true);

        Line1111.setVisible(true);
        downLine1111.setVisible(true);
        topLine1111.setVisible(true);

        labelR.setVisible(true);
        LBR.setVisible(true);
        labelA.setVisible(true);
        labelB.setVisible(true);
        //hBox.setVisible(true);

        Line2111.setVisible(true);
        downLine2111.setVisible(true);
        topLine2111.setVisible(true);


        firstRow(gp31);
        firstRow(gp32);

        int r = 1;
        for (int[] ints : tempA){
            rows(ints, gp31, r);
            r++;
        }

        if (tempB != null){
            labelB.setText("B");
            labelR.setVisible(true);
            sp33.setVisible(true);
            firstRow(gp33);
            r = 1;
            for (int[] ints : tempB){
                rows(ints, gp32, r);
                r++;
            }
            r = 1;
            for (int[] ints : tempR){
                rows(ints, gp33, r);
                r++;
            }
        }
        else {
            labelB.setText("Result");
            labelR.setVisible(false);
            sp33.setVisible(false);
            r = 1;
            for (int[] ints : tempR){
                rows(ints, gp32, r);
                r++;
            }
        }

        if (trs){
            int n = tp1;
            tp1 = tp2;
            tp2 = n;
        }

        if (tp1 > 1) {
            Line1111.setStartY(Line1111.getStartY() + 35 * (tp1 - 1));
            Line2111.setStartY(Line2111.getStartY() + 35 * (tp1 - 1));
            downLine1111.setLayoutY(downLine1111.getLayoutY() + 35 * (tp1 - 1));
            downLine2111.setLayoutY(downLine2111.getLayoutY() + 35 * (tp1 - 1));
        }

        if (tp2 > 1) {
            empty112.setLayoutX(empty112.getLayoutX() + 61 * (tp2 - 1));
            girdPane3.setPrefWidth(girdPane3.getPrefWidth() + 61 * (tp2 - 1));
            Line2111.setLayoutX(Line2111.getLayoutX() + 61 * (tp2 - 1));
            downLine2111.setLayoutX(downLine2111.getLayoutX() + 61 * (tp2 - 1));
            topLine2111.setLayoutX(topLine2111.getLayoutX() + 61 * (tp2 - 1));
        }

        int row = 0, column = 0, j = 0, k = 0, counter = 0;
        for (int i = 0; i < tp1 * tp2; i++, column += 2, j++){

            Label spring = new Label();
            spring.minWidthProperty().setValue(15);

            if (row > 1) {
                spring.minHeightProperty().setValue(10);
            }else {
                spring.minHeightProperty().setValue(20);
            }

            TextField label = new TextField();
            label.setStyle("-fx-background-color: #8f8d8d; -fx-text-fill: white");
            label.setEditable(false);
            label.setMinWidth(40);

            boolean empty = true;
            if (counter < tempR.size()) {
                int[] temp = tempR.get(counter);
                if (temp[0] == k && temp[1] == j) {
                    label.setText(Integer.toString(temp[2]));
                    counter++;
                    empty = false;
                }
            }
            if (empty)
                label.setText("0");

            girdPane3.add(label, column, row);

            if (column == 2 * (tp2 - 1)){
                column = -2;
                j = -1;
                k ++;
                girdPane3.add(spring, 0, row + 1);
                row += 2;
            }else
                girdPane3.add(spring, column + 1, row);
        }
    }
    public void firstRow(GridPane gp){
        Label ll = new Label("Row");
        ll.setMaxWidth(MAX_VALUE);
        ll.setAlignment(Pos.CENTER);
        ll.setStyle("-fx-border-color: black");
        ll.setMinHeight(60);
        ll.setMaxHeight(100);
        gp.add(ll, 0, 0);

        ll = new Label("Column");
        ll.setMaxWidth(MAX_VALUE);
        ll.setAlignment(Pos.CENTER);
        ll.setStyle("-fx-border-color: black");
        ll.setMinHeight(60);
        ll.setMaxHeight(100);
        gp.add(ll, 1, 0);

        ll = new Label("Value");
        ll.setMaxWidth(MAX_VALUE);
        ll.setAlignment(Pos.CENTER);
        ll.setStyle("-fx-border-color: black");
        ll.setMinHeight(60);
        ll.setMaxHeight(100);
        gp.add(ll, 2, 0);
    }

    public void rows (int[] ints, GridPane gp, int r){
        Label label = new Label();
        label.setMaxHeight(MAX_VALUE);
        label.setMaxWidth(MAX_VALUE);
        label.setMinHeight(50);
        label.setText(Integer.toString(ints[0]));
        label.setStyle("-fx-font-size: 13; -fx-border-color: black");
        label.setAlignment(Pos.CENTER);
        gp.add(label, 0, r);
        Label l1 = new Label(Integer.toString(ints[1]));
        l1.setMaxHeight(MAX_VALUE);
        l1.setMaxWidth(MAX_VALUE);
        l1.setAlignment(Pos.CENTER);
        l1.setStyle("-fx-font-size: 13; -fx-border-color: black");
        gp.add(l1, 1, r);
        Label l3 = new Label(Integer.toString(ints[2]));
        l3 .setAlignment(Pos.CENTER);
        l3.setMaxWidth(MAX_VALUE);
        l3.setStyle("-fx-font-size: 13; -fx-border-color: black");
        l3.setMaxHeight(80);
        l3.setMinHeight(50);
        gp.add(l3, 2, r);
    }
}
