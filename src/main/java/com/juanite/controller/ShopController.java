package com.juanite.controller;

import com.juanite.App;
import com.juanite.model.DAO.GameDAO;
import com.juanite.model.DTO.GameDTO;
import com.juanite.model.domain.Game;
import com.juanite.util.AppData;
import com.juanite.util.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ShopController {

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
    public Button btn_profile;
    @FXML
    public Button btn_logout;
    @FXML
    public Button btn_shop;
    @FXML
    public Button btn_library;
    @FXML
    public Button btn_friends;
    @FXML
    public Button btn_search;
    @FXML
    public Label lbl_suggestions;
    @FXML
    public Label lbl_new;
    @FXML
    public TextField txtfld_search;
    @FXML
    public ContextMenu cm_searchSuggestions;
    @FXML
    public MenuItem mi_1;
    @FXML
    public TableView<GameDTO> tv_suggestions;
    @FXML
    public TableColumn<GameDTO,ImageView> tc_suggestionsLogo;
    @FXML
    public TableColumn<GameDTO,String> tc_suggestionsTitle;
    @FXML
    public TableColumn<GameDTO,String> tc_suggestionsTags;
    @FXML
    public TableColumn<GameDTO,String> tc_suggestionsDeveloper;
    @FXML
    public TableColumn<GameDTO,Double> tc_suggestionsPrice;
    @FXML
    public TableView<GameDTO> tv_new;
    @FXML
    public TableColumn<GameDTO,ImageView> tc_newLogo;
    @FXML
    public TableColumn<GameDTO,String> tc_newTitle;
    @FXML
    public TableColumn<GameDTO,String> tc_newTags;
    @FXML
    public TableColumn<GameDTO,String> tc_newDeveloper;
    @FXML
    public TableColumn<GameDTO,Double> tc_newPrice;

    @FXML
    public void initialize(){
        img_resize.setOnMousePressed(this::resizeWindow);
        AppData.setWidth(App.getStage().getWidth());
        AppData.setHeight(App.getStage().getHeight());
        btn_profile.setText(AppData.getLoggedUser().getUsername());
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
            AppData.setWidth(newWidth);
            AppData.setHeight(newHeight);
        });
    }

    @FXML
    public void lblTitleValidate() throws IOException {
        AppData.setPreviousScene("shop");
        AppData.getStage().setTitle("BOARED - Main");
        Utils.switchToScreen("main");
    }

    @FXML
    public void btnLogoutValidate() throws IOException {
        AppData.setPreviousScene("shop");
        App.setRoot("login");
        AppData.getStage().setTitle("BOARED - Log in");
        AppData.getStage().setWidth(350);
        AppData.getStage().setHeight(400);
    }

    @FXML
    public void btnProfileValidate() throws IOException {
        AppData.setPreviousScene("shop");
        AppData.getStage().setTitle("BOARED - " + AppData.getLoggedUser().getName());
        Utils.switchToScreen("profile");
    }

    @FXML
    public void btnShopValidate() throws IOException {
        AppData.setPreviousScene("shop");
        AppData.getStage().setTitle("BOARED - Shop");
        Utils.switchToScreen("shop");
    }

    @FXML
    public void btnLibraryValidate() throws IOException {
        AppData.setPreviousScene("shop");
        AppData.getStage().setTitle("BOARED - Library");
        Utils.switchToScreen("library");
    }

    @FXML
    public void btnFriendsValidate() throws IOException {
        AppData.setPreviousScene("shop");
        AppData.getStage().setTitle("BOARED - Friends");
        Utils.switchToScreen("friends");
    }

    @FXML
    public void btnSearchValidate() throws Exception {
        if(!txtfld_search.getText().equals("")) {
            AppData.setPreviousScene("games");
            try (GameDAO gdao = new GameDAO()) {
                AppData.setSearchGames(gdao.findContainingTitles(txtfld_search.getText()));
            }
        }
    }

    @FXML
    public void getRecommendedGames() {
        if(AppData.getRecommendedGames().isEmpty()) {
            AppData.getRecommendedGames().addAll();
        }else{
            AppData.getRecommendedGames().clear();
        }
    }
}