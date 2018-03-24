import java.net.URL;
import java.io.File;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class Controller implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
    
    @FXML
    private void handleDragOver(DragEvent event) {
        Dragboard board = event.getDragboard();
        if (board.hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY);
        }
        event.consume();
    }
    
    @FXML
    private void handleDropped(DragEvent event) {
        Dragboard board = event.getDragboard();
        if (board.hasFiles()) {
            List<File> list = board.getFiles();
            /*board.getFiles().stream().forEach((f)->{
                System.out.println(f.getPath());
            });*/
            System.out.println(list);
            event.setDropCompleted(true);
        }else {
            event.setDropCompleted(false);
        }
        
    }
}
