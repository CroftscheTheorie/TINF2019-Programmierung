package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.control.TextField;

public class GridGUIController {

    @FXML
    private TextField RowsTextBox;

    @FXML
    private TextField ColumnsTextBox;

    @FXML
    private SubScene SubDrawingScene;

    public void setSubDrawingScene(SubScene newSubScene){
        SubDrawingScene = newSubScene;
    }

    @FXML
    private void RenderButtonPressed(ActionEvent actionEvent){
        System.out.println(RowsTextBox.getText());
        System.out.println(ColumnsTextBox.getText());
        System.out.println("Button pressed.");
    }
}
