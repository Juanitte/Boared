package com.juanite.controller;

import com.juanite.util.AppData;
import com.juanite.util.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ConfirmationController {

    private static double xOffset = 0;
    private static double yOffset = 0;

    @FXML
    public Label lbl_titlebar;
    @FXML
    public ToolBar tb_1;
    @FXML
    public ToolBar tb_2;
    @FXML
    public ImageView img_icon;
    @FXML
    public ImageView img_resize;
    @FXML
    public Label lbl_errorMsg;
    @FXML
    public Button btn_yes;
    @FXML
    public Button btn_no;

    @FXML
    public void initialize(){

    }
    @FXML
    public void tbClickValidate(MouseEvent event) {
        xOffset = AppData.getStage().getX() - event.getScreenX();
        yOffset = AppData.getStage().getY() - event.getScreenY();
    }

    @FXML
    public void tbDragValidate(MouseEvent event) {
        AppData.getStage().setX(event.getScreenX() + xOffset);
        AppData.getStage().setY(event.getScreenY() + yOffset);
    }

    @FXML
    public void btnYesValidate() throws Exception {
        if(AppData.getConfirmationType().equals("delete")){
            if(AppData.getPreviousScene().equals("games")){
                AppData.getGame().remove();
                if(AppData.getGame() == null) {
                    Utils.switchToPreviousScreen();
                }else{
                    Utils.switchToErrorScreen("Deletion failed.");
                }
            }else if(AppData.getPreviousScene().equals("devs")) {
                AppData.getDeveloper().remove();
                if (AppData.getDeveloper() == null) {
                    Utils.switchToPreviousScreen();
                } else {
                    Utils.switchToErrorScreen("Deletion failed.");
                }
            }else if(AppData.getPreviousScene().equals("users")) {
                AppData.getUser().remove();
                if(AppData.getUser() == null) {
                    Utils.switchToPreviousScreen();
                } else {
                    Utils.switchToErrorScreen("Deletion failed.");
                }
            }
        }
    }

    @FXML
    public void btnNoValidate() throws IOException {
        Utils.switchToPreviousScreen();
    }
}
