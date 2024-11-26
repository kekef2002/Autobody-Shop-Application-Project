package edu.farmingdale.autobodyshopapplicationproject;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class GalleryController {

    @FXML
    ImageView zoomInImage;

    @FXML
    StackPane blurPane;

    @FXML
    private void onImageViewClicked(MouseEvent event){
        System.out.println("It works");
        ImageView clickedImageView = (ImageView) event.getSource();
        Image image = clickedImageView.getImage();
        zoomInImage.setImage(image);
        zoomInImage.setOpacity(1);
        blurPane.setMouseTransparent(false);
        blurPane.setOpacity(.5);
    }

    @FXML
    private void onClickOutsideZoom(MouseEvent event){
        System.out.println("It works part 2");
        zoomInImage.setOpacity(0);
        blurPane.setOpacity(0);
        blurPane.setMouseTransparent(true);
    }
}
