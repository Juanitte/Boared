package com.juanite.controller;

import com.juanite.App;
import com.juanite.model.DAO.UserDAO;
import com.juanite.model.domain.User;
import com.juanite.util.AppData;
import com.juanite.util.Utils;
import com.juanite.util.Validator;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

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
    public Label lbl_email;
    @FXML
    public Label lbl_password;
    @FXML
    public TextField txtfld_email;
    @FXML
    public PasswordField txtfld_password;
    @FXML
    public Button btn_login;
    @FXML
    public Button btn_signup;
    @FXML
    public Label lbl_slogan1;
    @FXML
    public Label lbl_slogan2;
    @FXML
    public Label lbl_slogan3;

    @FXML
    public void initialize(){
        img_resize.setOnMousePressed(this::resizeWindow);
    }

    @FXML
    public void btnCloseValidate(){
        AppData.getStage().close();
    }
    @FXML
    public void btnMinimizeValidate(){
        AppData.getStage().setIconified(true);
    }
    @FXML
    public void btnMaximizeValidate(){
        AppData.getStage().setMaximized(!AppData.getStage().isMaximized());
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
    public void resizeWindow(MouseEvent event) {
        double offsetX = event.getSceneX();
        double offsetY = event.getSceneY();
        double width = AppData.getStage().getWidth();
        double height = AppData.getStage().getHeight();

        img_resize.setOnMouseDragged(e -> {
            double newWidth = width + (e.getSceneX() - offsetX);
            double newHeight = height + (e.getSceneY() - offsetY);
            AppData.getStage().setWidth(newWidth);
            AppData.getStage().setHeight(newHeight);
        });
    }

    @FXML
    public void btnLoginValidate() throws Exception {
        AppData.setPreviousScene("login");
        try (UserDAO udao = new UserDAO()) {
            if(Validator.validateEmail(txtfld_email.getText()) || Validator.validateUsername(txtfld_email.getText())) {
                if(Validator.validatePassword(txtfld_password.getText())) {
                    User user = udao.find(txtfld_email.getText());
                    if(user != null) {
                        if (AppData.getPa().authenticate(txtfld_password.getText(), user.getPassword())) {
                            AppData.setLoggedUser(user);
                            if (AppData.getLoggedUser() != null) {
                                AppData.getStage().setWidth(800);
                                AppData.getStage().setHeight(600);
                                App.setRoot("main");
                                AppData.getStage().setTitle("BOARED - Main");
                            }
                        }else{
                            Utils.switchToErrorScreen("Wrong password.");
                        }
                    }else{
                        Utils.switchToErrorScreen("Wrong email/username.");
                    }
                }else{
                    Utils.switchToErrorScreen("Password must include a lowercase letter,\nan uppercase letter and a number,\nand have 8 characters at least.");
                }
            }else{
                Utils.switchToErrorScreen("Email must be from our company (@boared.com)\nUsername can include letters and numbers only,\nand must have between 3 and 25 characters.");
            }
        }
    }

    @FXML
    public void btnSignupValidate() throws IOException {
        AppData.setPreviousScene("login");
        App.setRoot("signup");
        AppData.getStage().setTitle("BOARED - Sign up");
        AppData.getStage().setWidth(800);
        AppData.getStage().setHeight(600);
    }
}