package com.juanite.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {

    private static double xOffset = 0;
    private static double yOffset = 0;

    @FXML
    public Label lbl_titlebar;
    @FXML
    public Button btn_minimize;
    @FXML
    public Button btn_maximize;
    @FXML
    public Button btn_close;
    @FXML
    public ToolBar tb_1;
    @FXML
    public ToolBar tb_2;
    @FXML
    public ImageView img_icon;
    @FXML
    public ImageView img_resize;

    @FXML
    public void initialize(){
        img_resize.setOnMousePressed(this::resizeWindow);
    }

    @FXML
    public void btnCloseValidate(){
        Stage stage = (Stage) btn_close.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void btnMinimizeValidate(){
        Stage stage = (Stage) btn_minimize.getScene().getWindow();
        stage.setIconified(true);
    }
    @FXML
    public void btnMaximizeValidate(){
        Stage stage = (Stage) btn_maximize.getScene().getWindow();
        if(!stage.isMaximized()) {
            stage.setMaximized(true);
        }else{
            stage.setMaximized(false);
        }
    }
   @FXML
   public void tbClickValidate(MouseEvent event) {
       Stage stage = (Stage) tb_1.getScene().getWindow();
       xOffset = stage.getX() - event.getScreenX();
       yOffset = stage.getY() - event.getScreenY();
   }

    @FXML
    public void tbDragValidate(MouseEvent event) {
        Stage stage = (Stage) tb_1.getScene().getWindow();
        stage.setX(event.getScreenX() + xOffset);
        stage.setY(event.getScreenY() + yOffset);
    }

    @FXML
    public void resizeWindow(MouseEvent event) {
        Stage stage = (Stage) img_resize.getScene().getWindow();
        double offsetX = event.getSceneX();
        double offsetY = event.getSceneY();
        double width = stage.getWidth();
        double height = stage.getHeight();

        img_resize.setOnMouseDragged(e -> {
            double newWidth = width + (e.getSceneX() - offsetX);
            double newHeight = height + (e.getSceneY() - offsetY);
            stage.setWidth(newWidth);
            stage.setHeight(newHeight);
        });
    }
}
