
package mydraganddropproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;

/**
 *
 * @author tikia
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ImageView imageView;
    @FXML
    private Text source;
    @FXML
    private Text target;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleDragOver(DragEvent event) {
        if(event.getDragboard().hasFiles()){
        event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void handleDrop(DragEvent event) throws FileNotFoundException {
        List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        imageView.setImage(img);
    }

    @FXML
    private void handleDragDetection(MouseEvent event) {
        Dragboard db = source.startDragAndDrop(TransferMode.ANY);
        
        ClipboardContent cb = new ClipboardContent();
        cb.putString(source.getText());
        
        db.setContent(cb);
        
        event.consume();
    }

    @FXML
    private void handleTextDragOver(DragEvent event) {
        if(event.getDragboard().hasString()){
        event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void handleTextDrop(DragEvent event) {
        String str = event.getDragboard().getString();
        target.setText(str);
    }
    
}
